package lk.ac.cmb.ucsc.euphoria.repository;

import lk.ac.cmb.ucsc.euphoria.model.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
