package lk.ac.cmb.ucsc.euphoria.model.common;

import javax.persistence.*;

@Entity
public class LoginCredentials extends SuperEntity{

    @Column
    String username;

    @Column
    String password;

    public LoginCredentials() {
    }

    public LoginCredentials(Long id, String username, String password) {
        super(id);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
