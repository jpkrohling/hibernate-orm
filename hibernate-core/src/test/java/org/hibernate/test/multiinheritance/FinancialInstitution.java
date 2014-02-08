package org.hibernate.test.multiinheritance;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * User: jpkroehling
 * Date: 2014-01-24
 * Time: 7:33 PM
 */
@Entity
public class FinancialInstitution {
    @Id
    private String id = UUID.randomUUID().toString();

    private String bic;

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getId() {
        return id;
    }
}
