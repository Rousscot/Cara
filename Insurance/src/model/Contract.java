package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    protected Long fee;


    protected InsuredUser insuredUser;
    protected AbstractContractKind contractKind;

    public AbstractContractKind getContractKind() {
        return contractKind;
    }

    public void setContractKind(AbstractContractKind contractKind) {
        this.contractKind = contractKind;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public InsuredUser getInsuredUser() {
        return insuredUser;
    }

    public void setInsuredUser(InsuredUser insuredUser) {
        this.insuredUser = insuredUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
