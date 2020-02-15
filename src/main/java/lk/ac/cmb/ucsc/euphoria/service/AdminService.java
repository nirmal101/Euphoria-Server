package lk.ac.cmb.ucsc.euphoria.service;

import lk.ac.cmb.ucsc.euphoria.model.Admin;
import lk.ac.cmb.ucsc.euphoria.model.Counselor;
import lk.ac.cmb.ucsc.euphoria.model.Password;
import lk.ac.cmb.ucsc.euphoria.model.User;
import lk.ac.cmb.ucsc.euphoria.repository.AdminRepository;
import lk.ac.cmb.ucsc.euphoria.repository.CounselorRepository;
import lk.ac.cmb.ucsc.euphoria.repository.PasswordRepository;
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

    @Autowired
    private PasswordRepository passwordRepository;

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

    public void addAdmin(Admin admin){
        Password pw=new Password();
        pw.setEmail(admin.getEmail());
        pw.setPassword(admin.getAdminPassword());
        pw.setUser_type("Admin");
        adminRepository.save(admin);
        passwordRepository.save(pw);
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
