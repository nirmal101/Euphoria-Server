package lk.ac.cmb.ucsc.euphoria.entities.custom.impl;

import lk.ac.cmb.ucsc.euphoria.entities.custom.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "CUSTOMER_SEQ",allocationSize = 1)
public class Customer extends Person {

}



