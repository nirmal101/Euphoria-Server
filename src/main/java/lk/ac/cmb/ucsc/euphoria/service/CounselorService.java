package lk.ac.cmb.ucsc.euphoria.service;


//import com.google.common.collect.Lists;

import com.google.common.collect.Lists;
import lk.ac.cmb.ucsc.euphoria.EuphoriaApplication;
import lk.ac.cmb.ucsc.euphoria.dto.CounselorDTO;
import lk.ac.cmb.ucsc.euphoria.model.Appointment;
import lk.ac.cmb.ucsc.euphoria.model.counselor.Counselor;
import lk.ac.cmb.ucsc.euphoria.model.PatientRecords;
import lk.ac.cmb.ucsc.euphoria.model.common.LoginCredentials;
import lk.ac.cmb.ucsc.euphoria.repository.AppointmentRepository;
import lk.ac.cmb.ucsc.euphoria.repository.CounselorRepository;
import lk.ac.cmb.ucsc.euphoria.repository.PatientRecordsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CounselorService {
    private static final Logger LOGGER= LoggerFactory.getLogger(CounselorService.class);

    @Autowired
    private CounselorRepository counselorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRecordsRepository patientRecordsRepository;

    public LoginCredentials signIn(LoginCredentials loginCredentials) {
        LOGGER.info(loginCredentials.getUsername()+" "+loginCredentials.getPassword());
        return isExistCounselor(loginCredentials);
    }

    private LoginCredentials isExistCounselor(LoginCredentials loginCredentials) {
        List<Counselor> existCounselorName = counselorRepository.findByName( loginCredentials.getUsername());

        return null;
    }

    public Counselor signUp(CounselorDTO counselorDTO) {
        System.out.println(counselorDTO);
        return null;
//        return counselorRepository.save(counselor);
    }


    public LoginCredentials forgetPassword(LoginCredentials loginCredentials) {
        return isExistCounselor(loginCredentials);
    }

    public LoginCredentials resetPassword(LoginCredentials loginCredentials) {
        return isExistCounselor(loginCredentials);
    }

    public List<Appointment> getAppointments() {
        ArrayList<Appointment> appointmentsList = Lists.newArrayList(appointmentRepository.findAll());
        return appointmentsList;
    }

    public List<PatientRecords> getAllPatientRecords() {
        return Lists.newArrayList(patientRecordsRepository.findAll());
    }

}
