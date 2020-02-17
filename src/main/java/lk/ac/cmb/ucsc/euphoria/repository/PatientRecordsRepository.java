package lk.ac.cmb.ucsc.euphoria.repository;

import lk.ac.cmb.ucsc.euphoria.model.PatientRecords;
import lk.ac.cmb.ucsc.euphoria.model.User;
import lk.ac.cmb.ucsc.euphoria.model.counselor.Counselor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRecordsRepository extends CrudRepository<PatientRecords, Long> {
    public List<PatientRecords> findByUserAndCounselor(User user, Counselor counselor);
}
