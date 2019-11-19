package lk.ac.cmb.ucsc.euphoria.repositories;

import lk.ac.cmb.ucsc.euphoria.entities.custom.Person;
import lk.ac.cmb.ucsc.euphoria.entities.custom.impl.Customer;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository<T extends Person> extends CrudRepository<T, Long> {
    T findByUsername(String username);

    T findByEmail(String email);
}
