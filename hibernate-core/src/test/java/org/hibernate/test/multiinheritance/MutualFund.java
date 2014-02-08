package org.hibernate.test.multiinheritance;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * User: jpkroehling
 * Date: 2014-01-24
 * Time: 7:30 PM
 */
@Entity
public class MutualFund {

    @Id
    private String id = UUID.randomUUID().toString();

    private String isin;

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getId() {
        return id;
    }
}
