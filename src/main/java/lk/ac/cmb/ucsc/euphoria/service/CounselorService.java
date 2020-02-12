package lk.ac.cmb.ucsc.euphoria.service;


//import com.google.common.collect.Lists;

import com.google.common.collect.Lists;
import lk.ac.cmb.ucsc.euphoria.model.Appointment;
import lk.ac.cmb.ucsc.euphoria.model.Counselor;
import lk.ac.cmb.ucsc.euphoria.model.PatientRecords;
import lk.ac.cmb.ucsc.euphoria.model.common.LoginCredentials;
import lk.ac.cmb.ucsc.euphoria.repository.AppointmentRepository;
import lk.ac.cmb.ucsc.euphoria.repository.CounselorRepository;
import lk.ac.cmb.ucsc.euphoria.repository.PatientRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CounselorService {
    @Autowired
    private CounselorRepository counselorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRecordsRepository patientRecordsRepository;

    public LoginCredentials signIn(LoginCredentials loginCredentials) {
        return isExistCounselor(loginCredentials);
    }

    public LoginCredentials isExistCounselor(LoginCredentials loginCredentials) {
        List<LoginCredentials> existCounselorName = counselorRepository.isExistCounselorName(loginCredentials.getUsername());
        for (LoginCredentials l : existCounselorName) {
            return (l.getUsername().equalsIgnoreCase(loginCredentials.getUsername()) && l.getPassword().equalsIgnoreCase(loginCredentials.getPassword())) ?
                    l : null;
        }
        return null;
    }

    public Counselor signUp(Counselor counselor) {
        return counselorRepository.save(counselor);
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
