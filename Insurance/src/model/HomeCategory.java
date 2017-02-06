package model;

import javax.persistence.Entity;

@Entity
public class HomeCategory extends AbstractContractKind {
    protected Long maxCost;
    protected String address;

    public Long getMaxCost() {
        return maxCost;
    }

    public void setMaxCost(Long maxCost) {
        this.maxCost = maxCost;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
