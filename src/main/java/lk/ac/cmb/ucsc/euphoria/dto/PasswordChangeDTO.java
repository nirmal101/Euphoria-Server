package lk.ac.cmb.ucsc.euphoria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PasswordChangeDTO {
    private String email;
    private String oldPassword;
    private String newPassword;
    private String newPassConfirmation;

    public PasswordChangeDTO(
           @JsonProperty("email") String email,
           @JsonProperty("oldpassword") String oldPassword,
           @JsonProperty("newpassword") String newPassword,
           @JsonProperty("newpassconfirmation") String newPassConfirmation) {
        this.email = email;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.newPassConfirmation = newPassConfirmation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassConfirmation() {
        return newPassConfirmation;
    }

    public void setNewPassConfirmation(String newPassConfirmation) {
        this.newPassConfirmation = newPassConfirmation;
    }
}
