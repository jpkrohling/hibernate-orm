package org.hibernate.test.multiinheritance;

import org.hibernate.Session;
import org.hibernate.testing.junit4.BaseCoreFunctionalTestCase;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * User: jpkroehling
 * Date: 2014-01-24
 * Time: 7:20 PM
 */
public class MultiInheritanceTest extends BaseCoreFunctionalTestCase {

    @Override
    protected Class<?>[] getAnnotatedClasses() {
        return new Class<?>[] {
                Account.class,
                FinancialInstitution.class,
                MutualFund.class,
                MutualFundAccount.class,
                SavingsAccount.class,
                Transaction.class,
        };
    }

    @Test
    public void testRetrieveRecord() {
        Session session = openSession();

        session.getTransaction().begin();

        FinancialInstitution financialInstitution = new FinancialInstitution();
        financialInstitution.setBic("123");

        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setFinancialInstitution(financialInstitution);

        Transaction transaction = new Transaction();
        transaction.setAccount(savingsAccount);
        transaction.setAmount(new BigDecimal(100.0));

        session.persist(financialInstitution);
        session.persist(savingsAccount);
        session.persist(transaction);

        String id = transaction.getId();

        session.getTransaction().commit();

        session.clear();

        session.getTransaction().begin();
//        this works, and when I issue this one first, the second also works (as the entity is already in the session)
//        Transaction t0 = (Transaction) session.load(Transaction.class, id);
//        assertEquals(id, t0.getId());

        // this doesn't
        String hql = "from Transaction t where t.id = :id";
        Transaction t1 = (Transaction) session.createQuery(hql)
                .setParameter("id", id)
                .uniqueResult();
        assertEquals(id, t1.getId());

        session.getTransaction().commit();
    }

}
