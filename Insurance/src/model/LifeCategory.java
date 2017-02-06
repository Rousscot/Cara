package model;

import javax.persistence.Entity;

@Entity
public class LifeCategory extends AbstractContractKind  {
    protected Long cost;
    protected Integer maxDuration;

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }
}
