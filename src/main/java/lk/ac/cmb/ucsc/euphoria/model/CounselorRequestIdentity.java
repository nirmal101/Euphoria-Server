package lk.ac.cmb.ucsc.euphoria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class CounselorRequestIdentity  implements Serializable {


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private  Counselor counselor_id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private User user_id;
    private  Date timestamp;



    public CounselorRequestIdentity() {
        this.timestamp = new Date();
    }

    public CounselorRequestIdentity( Counselor counselor_id,User user_id) {
        this.counselor_id = counselor_id;
        this.user_id = user_id;
        this.timestamp = new Date();
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
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
        if (!(o instanceof CounselorRequestIdentity)) return false;
        CounselorRequestIdentity that = (CounselorRequestIdentity) o;
        return getCounselor_id().equals(that.getCounselor_id()) &&
                getUser_id().equals(that.getUser_id()) &&
                getTimestamp().equals(that.getTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCounselor_id(), getUser_id(), getTimestamp());
    }
}
