package lk.ac.cmb.ucsc.euphoria.model;

import javax.persistence.*;

@Entity
public class Counselor {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long doctor_id;
    private String doctor_name;
    @Column(length = 500)
    private String description;
    private String specialty;
    private String hospital;
    private String city;
    private String picName;

    public Counselor() {
    }

    public Counselor(String doctor_name, String description, String specialty, String city, String picName) {
        this.doctor_name = doctor_name;
        this.description = description;
        this.specialty = specialty;
        this.city = city;
        this.picName = picName;
    }

    public String getHospital() {
        return hospital;
    }

    public Counselor(String hospital) {
        this.hospital = hospital;
    }

    public long getDoctor_id() {
        return doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public String getDescription() {
        return description;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getCity() {
        return city;
    }

    public String getPicName() {
        return picName;
    }
}
