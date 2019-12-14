package lk.ac.cmb.ucsc.euphoria.repository;

import lk.ac.cmb.ucsc.euphoria.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<Post,Long> {

}
