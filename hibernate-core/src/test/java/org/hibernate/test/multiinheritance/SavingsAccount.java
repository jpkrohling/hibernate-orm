package org.hibernate.test.multiinheritance;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * User: jpkroehling
 * Date: 2014-01-24
 * Time: 7:10 PM
 */
@Entity
public class SavingsAccount extends Account {

    @ManyToOne(optional = false)
    @NotNull
    public FinancialInstitution financialInstitution;

    public FinancialInstitution getFinancialInstitution() {
        return financialInstitution;
    }

    public void setFinancialInstitution(FinancialInstitution financialInstitution) {
        this.financialInstitution = financialInstitution;
    }

}
