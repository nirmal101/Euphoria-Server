package lk.ac.cmb.ucsc.euphoria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Password {
    @Id
    private String email;
    private String password;
    private String user_type;//counselor or patient
    public Password() {
    }

    public Password(@JsonProperty("email") String email,
                    @JsonProperty("password") String password,
                    @JsonProperty("user_type") String user_type) {
        this.user_type=user_type;
        this.email = email;
        this.password = password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
