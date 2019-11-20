package lk.ac.cmb.ucsc.euphoria.dto;

import java.time.LocalDateTime;

public class RequestDTO {
    private  long doctor_id;
    private  String doctor_name;
    private  long user_id;
    private  String user_name;
    private LocalDateTime localDateTime;

    public RequestDTO() {
    }

    public RequestDTO(long doctor_id, String doctor_name, long user_id, String user_name) {
        this.doctor_id = doctor_id;
        this.doctor_name = doctor_name;
        this.user_id = user_id;
        this.user_name = user_name;
        this.localDateTime = LocalDateTime.now();
    }

    public long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(long doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
