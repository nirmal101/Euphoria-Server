package lk.ac.cmb.ucsc.euphoria.repository;

import lk.ac.cmb.ucsc.euphoria.model.Counselor;
import lk.ac.cmb.ucsc.euphoria.model.common.LoginCredentials;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CounselorRepository extends CrudRepository<Counselor,Long> {
    public List<LoginCredentials> isExistCounselorName(String username);
}
