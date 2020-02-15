package lk.ac.cmb.ucsc.euphoria.repository;

import lk.ac.cmb.ucsc.euphoria.model.common.LoginCredentials;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LoginCredentialRepository extends CrudRepository<LoginCredentials,Long> {
    public Optional<LoginCredentials> findByUsername(String username);
}
