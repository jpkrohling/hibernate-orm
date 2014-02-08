package org.hibernate.test.multiinheritance;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * User: jpkroehling
 * Date: 2014-01-24
 * Time: 7:11 PM
 */
@Entity
public class MutualFundAccount extends Account {

    @ManyToOne(optional = false)
    @NotNull
    private MutualFund mutualFund;

    public MutualFund getMutualFund() {
        return mutualFund;
    }

    public void setMutualFund(MutualFund mutualFund) {
        this.mutualFund = mutualFund;
    }
}
