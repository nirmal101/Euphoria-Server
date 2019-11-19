package lk.ac.cmb.ucsc.euphoria.dao;

import lk.ac.cmb.ucsc.euphoria.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<Post,Long> {

}
