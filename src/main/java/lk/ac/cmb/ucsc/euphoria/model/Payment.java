package lk.ac.cmb.ucsc.euphoria.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Payment {
    @EmbeddedId
    private  RateIdentity id;
    private String paymentStatus;

    public Payment() {
    }

    public Payment(RateIdentity id){
        this.id = id;
        paymentStatus="unpaid";
    }

    public Payment(RateIdentity id,String paymentStatus){
        this.id = id;
        this.paymentStatus = paymentStatus;
    }

    public RateIdentity getId() {
        return id;
    }

    public void setId(RateIdentity id) {
        this.id = id;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
