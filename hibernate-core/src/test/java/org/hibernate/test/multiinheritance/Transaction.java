package org.hibernate.test.multiinheritance;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * User: jpkroehling
 * Date: 2014-01-24
 * Time: 7:08 PM
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Transaction {
    @Id
    private String id = UUID.randomUUID().toString();

    @NotNull
    private BigDecimal amount;

    @ManyToOne
    @NotNull
    private Account account;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getId() {
        return id;
    }
}
