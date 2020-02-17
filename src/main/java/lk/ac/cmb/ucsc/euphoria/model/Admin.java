package lk.ac.cmb.ucsc.euphoria.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.mail.imap.IdleManager;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long adminID;

    @NotBlank
    private String adminUsername;
    private String email;
    private String firstName;
    private String lastName;
    private String activeStatus; //active - active account inactive - deleted account


    @Transient
    private String adminPassword;

    public Admin() {
    }

    public Admin(
            @JsonProperty("adminUsername") String Username,
            @JsonProperty("email") String Email,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("adminPassword") String Password,
            @JsonProperty("activeStatus") String Status
    ) {
        this.adminUsername = Username;
        this.email = Email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adminPassword = Password;
        this.activeStatus = "Active";
    }

    public long getAdminID() {
        return adminID;
    }

    public void setAdminID(Long adminID) {
        this.adminID = adminID;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { lastName = lastName; }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
