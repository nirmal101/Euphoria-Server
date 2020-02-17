package lk.ac.cmb.ucsc.euphoria.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uid;


    private String firstname;
    private String lastname;
    private String gender;
    @NotBlank
    private String email;

    @Transient
    private String password;
    private int contactNumber;
    private String dob;
    private String nic;
    private String city;
    private String district;

    private String status;//whether online or not_online
    private String account_type;//quick or formal
    private String activated;//initial activation upon registration
    private boolean deleted;//whether the account is deleted or not
    /******/
    private Date timestamp = new Date();

    private String pic_name;


    public User() {
    }

    public User(

            String gender,
            String firstname,
            String lastname,
            String email,
            String password,
            int contactNumber,
            String dob,
            String nic,
            String city,
            String district,
            String account_type,
            String pic_name,
            String activated,
            Boolean deleted,
            String status


    ) {


        this.gender = gender;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.contactNumber = contactNumber;
        this.dob = dob;
        this.nic = nic;
        this.city = city;
        this.district = district;
        this.status = status;
        this.account_type = account_type;
        this.pic_name = pic_name;
        this.activated = activated;
        this.deleted = deleted;
        this.timestamp = new Date();
    }

    public User(
            String gender,
            String firstName,
            String lastName,
            String email,
            String password,
            int contactNumber,
            String dob,
            String nic,
            String city,
            String district,
            String account_type
    ) {
        this.gender = gender;
        this.firstname = firstName;
        this.lastname = lastName;
        this.email = email;
        this.password = password;
        this.contactNumber = contactNumber;
        this.dob = dob;
        this.nic = nic;
        this.city = city;
        this.district = district;
        this.account_type = account_type;
        this.timestamp = new Date();
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getActivated() {
        return activated;
    }

    public void setActivated(String activated) {
        this.activated = activated;
    }

    public String getPic_name() {
        return pic_name;
    }

    public long getUid() {
        return uid;
    }

    public String getGender() {
        return gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public String getDob() {
        return dob;
    }

    public String getNic() {
        return nic;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getStatus() {
        return status;
    }

    public String getAccount_type() {
        return account_type;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setPic_name(String pic_name) {
        this.pic_name = pic_name;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }
}
