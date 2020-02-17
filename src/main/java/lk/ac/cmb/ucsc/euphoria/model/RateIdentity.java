package lk.ac.cmb.ucsc.euphoria.model;

import lk.ac.cmb.ucsc.euphoria.model.counselor.Counselor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RateIdentity  implements Serializable {


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private Counselor counselor_id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private User user_id;



    public RateIdentity() {
    }

    public RateIdentity( Counselor counselor_id,User user_id) {
        this.counselor_id = counselor_id;
        this.user_id = user_id;
    }


    public Counselor getCounselor_id() {
        return counselor_id;
    }

    public void setCounselor_id(Counselor counselor_id) {
        this.counselor_id = counselor_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RateIdentity)) return false;
        RateIdentity that = (RateIdentity) o;
        return Objects.equals(getCounselor_id(), that.getCounselor_id()) &&
                Objects.equals(getUser_id(), that.getUser_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCounselor_id(), getUser_id());
    }
}
