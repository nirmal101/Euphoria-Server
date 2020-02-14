package lk.ac.cmb.ucsc.euphoria.repository;

import lk.ac.cmb.ucsc.euphoria.model.counselor.Counselor;
import lk.ac.cmb.ucsc.euphoria.model.common.LoginCredentials;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CounselorRepository extends CrudRepository<Counselor,Long> {
    public List<LoginCredentials> findByName(String username);
}
