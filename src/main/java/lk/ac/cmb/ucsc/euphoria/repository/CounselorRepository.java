package lk.ac.cmb.ucsc.euphoria.repository;

import lk.ac.cmb.ucsc.euphoria.model.counselor.Counselor;
import lk.ac.cmb.ucsc.euphoria.model.common.LoginCredentials;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CounselorRepository extends CrudRepository<Counselor,Long> {
    public List<Counselor> findByName(String name);

    public Optional<Counselor> findByLoginCredentials(LoginCredentials credential);

    public Optional<Counselor> findByLoginCredentials_Username(String username);

    List<Counselor> findAllByLoginCredentials_UsernameIn(List<String> allActive);
}
