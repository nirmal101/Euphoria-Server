package lk.ac.cmb.ucsc.euphoria.repository;

import lk.ac.cmb.ucsc.euphoria.model.Post;
import lk.ac.cmb.ucsc.euphoria.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {
//    @Query(value = "select User from User where email=:user_email",nativeQuery = true)
//    public List<User> find(@Param("user_email") String user_email);

      public List<User> findByEmail(String email);


      //Admin methods
      @Query(value="SELECT* FROM User WHERE Account_Type=?1", nativeQuery=true)
      public List<User> findByAccountType(String type);

      public List<User> findByStatus(String status);

      @Modifying(clearAutomatically = true)
      @Transactional
      @Query(value="UPDATE User SET deleted=true WHERE uid=?1",nativeQuery = true)
      public void deleteUser(long id);

}
