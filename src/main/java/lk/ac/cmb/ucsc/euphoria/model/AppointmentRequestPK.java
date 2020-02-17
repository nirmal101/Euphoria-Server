package lk.ac.cmb.ucsc.euphoria.model;

import lk.ac.cmb.ucsc.euphoria.model.counselor.Counselor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class AppointmentRequestPK implements Serializable {


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private Counselor counselor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private User user;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public AppointmentRequestPK() {}

    public AppointmentRequestPK(Counselor counselor, User user_id) {
        this.counselor = counselor;
        this.user = user_id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime timestamp) {
        this.createdAt = timestamp;
    }

    public Counselor getCounselor() {
        return counselor;
    }

    public void setCounselor(Counselor counselor_id) {
        this.counselor = counselor_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user_id) {
        this.user = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppointmentRequestPK)) return false;
        AppointmentRequestPK that = (AppointmentRequestPK) o;
        return getCounselor().equals(that.getCounselor()) &&
                getUser().equals(that.getUser()) &&
                getCreatedAt().equals(that.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCounselor(), getUser(), getCreatedAt());
    }
}
