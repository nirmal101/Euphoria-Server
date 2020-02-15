package lk.ac.cmb.ucsc.euphoria.repository;

import lk.ac.cmb.ucsc.euphoria.model.CounselorRequest;
import lk.ac.cmb.ucsc.euphoria.model.CounselorRequestIdentity;
import org.springframework.data.repository.CrudRepository;

public interface CounselorRequestRepository extends CrudRepository<CounselorRequest, CounselorRequestIdentity> {
}
