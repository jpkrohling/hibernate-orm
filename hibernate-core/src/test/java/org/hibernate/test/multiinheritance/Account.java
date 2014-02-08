package org.hibernate.test.multiinheritance;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * User: jpkroehling
 * Date: 2014-01-24
 * Time: 7:09 PM
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {

    @Id
    private String id = UUID.randomUUID().toString();

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected List<Transaction> transactions = new ArrayList<Transaction>();

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public String getId() {
        return id;
    }
}
