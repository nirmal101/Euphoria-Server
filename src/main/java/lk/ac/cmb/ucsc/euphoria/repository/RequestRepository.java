package lk.ac.cmb.ucsc.euphoria.repository;

import lk.ac.cmb.ucsc.euphoria.model.Request;
import org.springframework.data.repository.CrudRepository;

public interface RequestDAO extends CrudRepository<Request,Long> {
}
