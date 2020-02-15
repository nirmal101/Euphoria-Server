package lk.ac.cmb.ucsc.euphoria.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    private String request_desc;

    @Convert(converter = AppointmentStatusConverter.class)
    private AppointmentStatus status;

    private LocalDateTime appointmentTime;

    public AppointmentRequest() {
    }

    public AppointmentRequest(@JsonProperty("user_counselor") AppointmentRequestPK id, @JsonProperty("request_description") String request_desc) {
        this.id = id;
        this.request_desc = request_desc;
    }

    public AppointmentRequestPK getId() {
        return id;
    }

    public String getRequest_desc() {
        return request_desc;
    }

    public void setId(AppointmentRequestPK id) {
        this.id = id;
    }

    public void setRequest_desc(String request_desc) {
        this.request_desc = request_desc;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
