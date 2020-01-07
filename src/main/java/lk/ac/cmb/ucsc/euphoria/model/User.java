package lk.ac.cmb.ucsc.euphoria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long uid;

    private final String title;
    private String first_name;
    private String last_name;
    @NotBlank
    private String email;
    @NotBlank
    @Transient
    private String password;
    private int contact_number;
    private String date_of_birth;
    private String nic;
    private String city;
    private String district;

    private String status;//whether online or not
    private String account_type;//quick or formal
    /******/
    private String date;

    public User(

                @JsonProperty("title") String title,
                @JsonProperty("firstname") String first_name,
                @JsonProperty("lastname") String last_name,
                @JsonProperty("email") @NotBlank String email,
                @JsonProperty("password") @NotBlank String password,
                @JsonProperty("contactNumber") int contact_number,
                @JsonProperty("dob") String date_of_birth,
                @JsonProperty("nic") String nic,
                @JsonProperty("city") String city,
                @JsonProperty("district") String district,
                @JsonProperty("accountType") String account_type ) {
        this.title = title;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.contact_number = contact_number;
        this.date_of_birth = date_of_birth;
        this.nic = nic;
        this.city = city;
        this.district = district;
        this.status = status;
        this.account_type = account_type;
    }

    public long getUid() {
        return uid;
    }

    public String getTitle() {
        return title;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getContact_number() {
        return contact_number;
    }

    public String getDate_of_birth() {
        return date_of_birth;
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


}
