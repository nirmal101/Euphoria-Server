package lk.ac.cmb.ucsc.euphoria.repository;

import lk.ac.cmb.ucsc.euphoria.model.Payment;
import lk.ac.cmb.ucsc.euphoria.model.RateIdentity;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, RateIdentity> {
}
