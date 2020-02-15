package lk.ac.cmb.ucsc.euphoria.repository;

import lk.ac.cmb.ucsc.euphoria.model.Admin;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//CrudRepository <EntityName, PrimaryKeyType>
public interface AdminRepository extends CrudRepository<Admin, Long> {

    public List<Admin> findByActiveStatus(String status);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value="UPDATE Admin SET active_Status='Inactive' WHERE adminID=?1", nativeQuery = true)
    public void deleteAdmin(Long id);

    @Modifying(clearAutomatically = true)
    @Query(value="INSERT INTO Admin(firstName,lastName,email,adminUsername,adminPassword,activeStatus) VALUES('?1','?2','?3','?4','?5','?6')", nativeQuery = true)
    public void addAdmin(String fName, String lName, String email, String username, String password, String activeStatus);
}
