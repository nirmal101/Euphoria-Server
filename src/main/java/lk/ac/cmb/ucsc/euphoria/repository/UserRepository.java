package lk.ac.cmb.ucsc.euphoria.repository;

import lk.ac.cmb.ucsc.euphoria.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Post,Long> {

}
