package lk.ac.cmb.ucsc.euphoria.entities.custom.impl;

import lk.ac.cmb.ucsc.euphoria.entities.custom.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "COUNSELOR_SEQ",allocationSize = 1)
public class Counselor extends Person {

    @Column
    private String registeredAt;

    @Column
    private String registration;

    public String getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(String registeredAt) {
        this.registeredAt = registeredAt;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
}
