package lk.ac.cmb.ucsc.euphoria.service;

import lk.ac.cmb.ucsc.euphoria.model.Admin;
import lk.ac.cmb.ucsc.euphoria.model.Counselor;
import lk.ac.cmb.ucsc.euphoria.model.User;
import lk.ac.cmb.ucsc.euphoria.repository.AdminRepository;
import lk.ac.cmb.ucsc.euphoria.repository.CounselorRepository;
import lk.ac.cmb.ucsc.euphoria.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CounselorRepository counselorRepository;

    //*************************************************Admin Repository*************************************************
    public List<Admin> getActiveAdmins(){
        Iterable<Admin> all = adminRepository.findByActiveStatus("Active");
        List<Admin> adminList = new ArrayList<Admin>();
        all.forEach(adminList::add);
        return adminList;
    }

    public void deleteAdmin(@PathVariable Long id){
        adminRepository.deleteAdmin(id);
    }

    public void addAdmin(
            @PathVariable String firstName,
            @PathVariable String lastName,
            @PathVariable String email,
            @PathVariable String username,
            @PathVariable String password,
            @PathVariable String activeStatus
    ){
        adminRepository.addAdmin(firstName,lastName,email,username,password,activeStatus);
    }

    //**************************************************User Repository*************************************************
    public List<User> getFormalUsers(){
        Iterable<User> all = userRepository.findByAccountType("formal");
        List<User> formalUserList = new ArrayList<User>();
        all.forEach(formalUserList::add);
        return formalUserList;
    }

    public List<User> getQuickUsers(){
        Iterable<User> all = userRepository.findByAccountType("quick");
        List<User> quickUserList = new ArrayList<User>();
        all.forEach(quickUserList::add);
        return quickUserList;
    }

    //***********************************************Counselor Repository***********************************************
    public List<Counselor> getCounselors() {
        Iterable<Counselor> all = counselorRepository.findAll();
        List<Counselor> counselorList = new ArrayList<Counselor>();
        all.forEach(counselorList::add);
        return counselorList;
    }
}
