package lk.ac.cmb.ucsc.euphoria.model;

import lk.ac.cmb.ucsc.euphoria.constants.AppointmentStatus;
import lk.ac.cmb.ucsc.euphoria.util.AppointmentStatusConverter;

import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class AppointmentRequest {
    @EmbeddedId
    private AppointmentRequestPK id;

    private String description;

    @Convert(converter = AppointmentStatusConverter.class)
    private AppointmentStatus status;

    private LocalDateTime apntmntTime;

    public AppointmentRequest() {
    }

    public AppointmentRequest(AppointmentRequestPK id, String description) {
        this.id = id;
        this.description = description;
        this.status = AppointmentStatus.PENDING;
    }

    public AppointmentRequest(AppointmentRequestPK id,LocalDateTime apntmntTime) {
        this.id = id;
        this.apntmntTime = apntmntTime;
        this.status = AppointmentStatus.ACCEPTED;
    }

    public AppointmentRequestPK getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setId(AppointmentRequestPK id) {
        this.id = id;
    }

    public void setDescription(String request_desc) {
        this.description = request_desc;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public LocalDateTime getApntmntTime() {
        return apntmntTime;
    }

    public void setApntmntTime(LocalDateTime appointmentTime) {
        this.apntmntTime = appointmentTime;
    }
}
