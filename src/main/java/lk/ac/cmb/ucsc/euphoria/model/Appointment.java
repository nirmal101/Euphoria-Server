package lk.ac.cmb.ucsc.euphoria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
public class Appointment {
    @Id
    private long appointment_id;
    private String userName;
    private String tagName;
    private Date scheduleDate;
    private Date scheduleTime;
    
    private enum status{PENDING, ONGOING, COMPLETED};

    public Appointment() {
    }

    public long getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(long appointment_id) {
        this.appointment_id = appointment_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Date getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }
}
