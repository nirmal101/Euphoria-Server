package lk.ac.cmb.ucsc.euphoria.model;

import lk.ac.cmb.ucsc.euphoria.model.common.SuperEntity;
import lk.ac.cmb.ucsc.euphoria.model.counselor.Counselor;
import net.minidev.json.JSONObject;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PatientRecords extends SuperEntity {

    private String title;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Counselor counselor;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private User user;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private JSONObject description;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private JSONObject prescription;

    public PatientRecords() { }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Counselor getCounselor() {
        return counselor;
    }

    public void setCounselor(Counselor counselor) {
        this.counselor = counselor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public JSONObject getDescription() {
        return description;
    }

    public void setDescription(JSONObject description) {
        this.description = description;
    }

    public JSONObject getPrescription() {
        return prescription;
    }

    public void setPrescription(JSONObject prescription) {
        this.prescription = prescription;
    }
}
