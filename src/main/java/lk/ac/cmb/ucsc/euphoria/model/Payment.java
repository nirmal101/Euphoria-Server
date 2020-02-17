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
