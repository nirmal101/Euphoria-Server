package lk.ac.cmb.ucsc.euphoria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Request {
    @Id
    private  long id;
    private  String name;
    private  String specialty;
    private  String picName;

    public Request() {
    }

    public Request(@JsonProperty("id") long id,
                   @JsonProperty("name") String name,
                   @JsonProperty("specialty") String specialty,
                   @JsonProperty("picName") String picName) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.picName = picName;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getPicName() {
        return picName;
    }

}
