package lk.ac.cmb.ucsc.euphoria.controller;

import lk.ac.cmb.ucsc.euphoria.model.Appointment;
import lk.ac.cmb.ucsc.euphoria.model.Counselor;
import lk.ac.cmb.ucsc.euphoria.model.PatientRecords;
import lk.ac.cmb.ucsc.euphoria.model.common.LoginCredentials;
import lk.ac.cmb.ucsc.euphoria.service.CounselorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/counselor")
@RestController
public class CounselorController {

    @Autowired
    private CounselorService counselorService;

    @CrossOrigin
    @PostMapping(path = "/sign-in", consumes = "application/json", produces = "application/json")
    public LoginCredentials counselorSignIn(@RequestBody LoginCredentials loginCredentials) {
        return counselorService.signIn(loginCredentials);
    }

    @CrossOrigin
    @PostMapping(path = "/sign-up", consumes = "application/json", produces = "application/json")
    public Counselor counselorSignUp(@RequestBody Counselor counselor) {
        return counselorService.signUp(counselor);
    }

    @CrossOrigin
    @PostMapping(path = "/reset-password", consumes = "application/json", produces = "application/json")
    public LoginCredentials resetPassword(@RequestBody LoginCredentials loginCredentials) {
        return counselorService.resetPassword(loginCredentials);
    }

    @CrossOrigin
    @GetMapping(path = "/get-appointments", produces = "application/json")
    public List<Appointment> getAppointments() {
        return counselorService.getAppointments();
    }

    @CrossOrigin
    @GetMapping(path = "/get-all-patient-records", produces = "application/json")
    public List<PatientRecords> getAllPatientRecords() {
        return counselorService.getAllPatientRecords();
    }

//    @CrossOrigin
//    @GetMapping
//    public PatientRecords getSinglePatientRecords(Long patient){
//        return counselorService.getSinglePatientRecords(patient);
//    }

}
