package lk.ac.cmb.ucsc.euphoria.model;

import lk.ac.cmb.ucsc.euphoria.model.common.LoginCredentials;
import lk.ac.cmb.ucsc.euphoria.model.common.SuperEntity;

import javax.persistence.*;

@Entity
public class Counselor extends SuperEntity {

    private String name;

    @Column(length = 500)
    private String description;

    private String specialty;

    private String hospital;

    private String city;

    private String photoUrl;

    @OneToOne
    private LoginCredentials loginCredentials;

    public Counselor() {}

    public Counselor(String name, String description, String specialty, String hospital, String city, String photoUrl) {
        this.name = name;
        this.description = description;
        this.specialty = specialty;
        this.hospital = hospital;
        this.city = city;
        this.photoUrl = photoUrl;
    }

    public Counselor(Long id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
