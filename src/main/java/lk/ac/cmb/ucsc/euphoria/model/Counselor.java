package lk.ac.cmb.ucsc.euphoria.model;

import javax.persistence.*;

@Entity
public class Counselor {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  long counselor_id;
    private String counselor_name;
    @Column(length = 500)
    private String description;
    private String specialty;
    private String hospital;
    private String city;
    private String picName;

    public Counselor() {
    }

    public Counselor(long counselor_id, String counselor_name, String description, String specialty, String city, String picName) {
        this.counselor_id = counselor_id;
        this.counselor_name = counselor_name;
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

    public long getCounselor_id() {
        return counselor_id;
    }

    public String getCounselor_name() {
        return counselor_name;
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

    public void setCounselor_id(long counselor_id) {
        this.counselor_id = counselor_id;
    }
}
