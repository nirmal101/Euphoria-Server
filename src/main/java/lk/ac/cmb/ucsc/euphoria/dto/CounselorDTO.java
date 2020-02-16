package lk.ac.cmb.ucsc.euphoria.dto;

public class CounselorDTO {
    private String name;
    private String description;
    private String specialty;
    private String hospital;
    private String city;
    private String photoUrl;
    private String password;
    private String email;


    public CounselorDTO() {
    }

    public CounselorDTO(String name, String description, String specialty, String hospital, String city, String photoUrl, String password, String email) {
        this.name = name;
        this.description = description;
        this.specialty = specialty;
        this.hospital = hospital;
        this.city = city;
        this.photoUrl = photoUrl;
        this.password = password;
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CounselorDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", specialty='" + specialty + '\'' +
                ", hospital='" + hospital + '\'' +
                ", city='" + city + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
