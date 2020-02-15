package lk.ac.cmb.ucsc.euphoria.controller;

import lk.ac.cmb.ucsc.euphoria.model.Admin;
import lk.ac.cmb.ucsc.euphoria.model.Counselor;
import lk.ac.cmb.ucsc.euphoria.model.User;
import lk.ac.cmb.ucsc.euphoria.service.AdminService;
import org.hibernate.validator.constraints.pl.REGON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("api/admin")
@RestController
public class AdminController {
    @Autowired
    private final AdminService adminService;

    private static final Logger LOGGER= LoggerFactory.getLogger(AdminController.class);

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
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
    public void addAdmin(@RequestBody @NotNull Admin admin   ){
        System.out.println("came to the server");
        System.out.println(admin.getAdminUsername());
        adminService.addAdmin(admin);

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

    //*****************************************************COUNSELORS*****************************************************
    @GetMapping(path="/getCounselors", produces = "application/json")
    @CrossOrigin
    public List<Counselor> getCounselors(){

        return adminService.getCounselors();
    }
}
