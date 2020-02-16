package lk.ac.cmb.ucsc.euphoria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class CounselorRequest {
        @EmbeddedId
        private  CounselorRequestIdentity id;
        private String request_desc;
        private String appointmentStatus;

        public CounselorRequest() {
        }

        public CounselorRequest(
                @JsonProperty("user_counselor") CounselorRequestIdentity id,
                @JsonProperty("request_description") String request_desc
        ) {
                this.id = id;
                this.request_desc = request_desc;
        }

        public CounselorRequestIdentity getId() {
                return id;
        }

        public String getRequest_desc() {
                return request_desc;
        }

        public String getAppointmentStatus() {
                return appointmentStatus;
        }

        public void setAppointmentStatus(String appointmentStatus) {
                this.appointmentStatus = appointmentStatus;
        }
}
