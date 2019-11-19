package lk.ac.cmb.ucsc.euphoria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Request {
    @Id
    private  long doctor_id;
    private  String doctor_name;
    private  long user_id;
    private  String user_name;
    private  String specialty;
    private  String picName;

    public Request() {
    }

    public Request(@JsonProperty("doctor_id") long doctor_id,
                   @JsonProperty("doctor_name") String doctor_name,
                   @JsonProperty("user_id") long user_id,
                   @JsonProperty("user_name") String user_name,
                   @JsonProperty("specialty") String specialty,
                   @JsonProperty("picName") String picName) {
        this.user_id = user_id;
        this.doctor_id = doctor_id;
        this.user_name = user_name;
        this.doctor_name = doctor_name;
        this.specialty = specialty;
        this.picName = picName;
    }

    public long getDoctor_id() {
        return doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public long getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getPicName() {
        return picName;
    }

}
