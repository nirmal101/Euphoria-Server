package lk.ac.cmb.ucsc.euphoria.repository;

import lk.ac.cmb.ucsc.euphoria.model.RateIdentity;
import lk.ac.cmb.ucsc.euphoria.model.Rated;
import org.springframework.data.repository.CrudRepository;

public interface RatedRepository extends CrudRepository<Rated, RateIdentity> {
}
