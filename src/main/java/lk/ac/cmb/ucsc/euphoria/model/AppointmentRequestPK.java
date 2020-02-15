package lk.ac.cmb.ucsc.euphoria.model;

import lk.ac.cmb.ucsc.euphoria.model.counselor.Counselor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class AppointmentRequestPK implements Serializable {


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private Counselor counselor_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private User user_id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public AppointmentRequestPK() {}

    public AppointmentRequestPK(Counselor counselor_id, User user_id) {
        this.counselor_id = counselor_id;
        this.user_id = user_id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime timestamp) {
        this.createdAt = timestamp;
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
        if (!(o instanceof AppointmentRequestPK)) return false;
        AppointmentRequestPK that = (AppointmentRequestPK) o;
        return getCounselor_id().equals(that.getCounselor_id()) &&
                getUser_id().equals(that.getUser_id()) &&
                getCreatedAt().equals(that.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCounselor_id(), getUser_id(), getCreatedAt());
    }
}
