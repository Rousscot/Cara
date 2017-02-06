package model;

import javax.persistence.Entity;

@Entity
public class AutoCategory extends AbstractContractKind {
    protected String model;
    protected String plateNumber;
    protected String mainDriver;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
