package lk.ac.cmb.ucsc.euphoria.controller;

import lk.ac.cmb.ucsc.euphoria.model.Admin;
import lk.ac.cmb.ucsc.euphoria.model.User;
import lk.ac.cmb.ucsc.euphoria.model.counselor.Counselor;
import lk.ac.cmb.ucsc.euphoria.service.AdminService;
import lk.ac.cmb.ucsc.euphoria.service.CounselorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/admin")
@RestController
public class AdminController {
    @Autowired
    private final AdminService adminService;

    @Autowired
    private final CounselorService counselorService;

    private static final Logger LOGGER= LoggerFactory.getLogger(AdminController.class);

    public AdminController(AdminService adminService, CounselorService counselorService) {
        this.adminService = adminService;
        this.counselorService=counselorService;
    }

    //***********************************************************ADMINS***********************************************************
    @GetMapping(path="/getActiveAdmins", produces = "application/json")
    @CrossOrigin
    public List<Admin> getAdmins(){
        return adminService.getActiveAdmins();
    }

    @CrossOrigin
    @DeleteMapping(path="/deleteAdmin")
    public void deleteAdmin(@RequestParam String id){
        LOGGER.debug("Delete Admin Id: "+id);
        adminService.deleteAdmin(Long.parseLong(id));
    }

    @CrossOrigin
    @PostMapping(path="/addAdmin", consumes="application/json")
    public void addAdmin(@RequestBody @NotNull Admin admin){
        System.out.println("came to the server");
        System.out.println(admin.getAdminUsername());
        adminService.addAdmin(admin);
    }

    @GetMapping(path="/viewAdmin/{id}")
    @CrossOrigin
    public Optional<Admin> viewAdmin(@PathVariable("id") long adminID){
        return adminService.viewAdmin(adminID);
    }

    @CrossOrigin
    @PostMapping(path="/updateAdmin", consumes="application/json")
    public void updateAdmin(@RequestBody Admin admin){
        adminService.updateAdmin(admin);
    }

    @GetMapping(path="/getOnlineCounselors")
    @CrossOrigin
    public String getOnlineCounselors(){
        List<Counselor> onlineCounselors = counselorService.getActiveCounselors();
        long count = onlineCounselors.size();
        return Long.toString(count);
    }

    //*********************************************************USERS*********************************************************
    @GetMapping(path="/getFormalUsers", produces = "application/json")
    @CrossOrigin
    public List<User> getFormalUsers(){
        return adminService.getFormalUsers();
    }

    @GetMapping(path="/getQuickUsers", produces = "application/json")
    @CrossOrigin
    public List<User> getQuickUsers(){
        return adminService.getQuickUsers();
    }


    @GetMapping(path="/getRegisteredUsers")
    @CrossOrigin
    public String getRegisteredUsers(){
        return adminService.getRegisteredUsers();
    }

    @GetMapping(path="/getOnlineUsers")
    @CrossOrigin
    public String getOnlineUsers(){
        return adminService.getOnlineUsers();
    }

    @CrossOrigin
    @DeleteMapping(path="/deleteUser")
    public void deleteUser(@RequestParam long id){
        adminService.deleteUser(id);
    }

    //*****************************************************COUNSELORS*****************************************************
    @GetMapping(path="/getCounselors", produces = "application/json")
    @CrossOrigin
    public List<Counselor> getCounselors(){

        return adminService.getCounselors();
    }

    @GetMapping(path="/getRegisteredCounselors")
    @CrossOrigin
    public String getRegisteredCounselors(){
        return adminService.getRegisteredCounselors();
    }
    @PostMapping(path="/activatecounselor/{id}")
    @CrossOrigin
    public Counselor activateCounselor(@PathVariable("id") long id){
        return adminService.activateCounselor(id);
    }
}
