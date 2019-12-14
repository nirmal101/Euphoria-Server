package lk.ac.cmb.ucsc.euphoria.repository;

import lk.ac.cmb.ucsc.euphoria.model.Password;
import org.springframework.data.repository.CrudRepository;

public interface PasswordDAO extends CrudRepository<Password,String> {
}
