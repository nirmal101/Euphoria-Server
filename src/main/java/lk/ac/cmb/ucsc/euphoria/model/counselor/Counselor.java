package lk.ac.cmb.ucsc.euphoria.model.counselor;

import lk.ac.cmb.ucsc.euphoria.model.common.LoginCredentials;
import lk.ac.cmb.ucsc.euphoria.model.common.SuperEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Counselor extends SuperEntity {

    private String name;

    private String slmcNumber;

    @Column(length = 500)
    private String description;

    private String specialty;

    private String hospital;

    private String city;

    private String picName;
    private float rating;
    private int ratedTimes;
    private String enabled;

    @OneToOne(cascade = CascadeType.ALL)
    private LoginCredentials loginCredentials;


    public Counselor() {
    }

    public Counselor(String name, String description, String specialty, String hospital, String city, String picName, String slmcNumber) {
        this.name = name;
        this.description = description;
        this.specialty = specialty;
        this.hospital = hospital;
        this.city = city;
        this.picName = picName;
        this.slmcNumber = slmcNumber;
    }

    public Counselor(String name, String description, String specialty, String hospital, String city, String picName, String slmcNumber,
                     LoginCredentials loginCredentials) {
        this.name = name;
        this.description = description;
        this.specialty = specialty;
        this.hospital = hospital;
        this.city = city;
        this.picName = picName;
        this.slmcNumber = slmcNumber;
        this.loginCredentials = loginCredentials;
    }

    public Counselor(String name, String description, String specialty, String hospital, String city, String picName, String slmcNumber,
                     String email, String username, String password) {
        this.name = name;
        this.description = description;
        this.specialty = specialty;
        this.hospital = hospital;
        this.city = city;
        this.picName = picName;
        this.slmcNumber = slmcNumber;
        this.loginCredentials = new LoginCredentials(username,password,email);
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getRatedTimes() {
        return ratedTimes;
    }

    public void setRatedTimes(int ratedTimes) {
        this.ratedTimes = ratedTimes;
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

    public String getPicName() {
        return picName;
    }

    public void setPicName(String photoUrl) {
        this.picName = photoUrl;
    }

    public String getSlmcNumber() {
        return slmcNumber;
    }

    public void setSlmcNumber(String slmcNumber) {
        this.slmcNumber = slmcNumber;
    }

    public LoginCredentials getLoginCredentials() {
        return loginCredentials;
    }

    public void setLoginCredentials(LoginCredentials loginCredentials) {
        this.loginCredentials = loginCredentials;
    }

}
