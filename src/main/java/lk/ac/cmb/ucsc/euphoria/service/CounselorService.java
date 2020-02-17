package lk.ac.cmb.ucsc.euphoria.service;


//import com.google.common.collect.Lists;

import com.google.common.collect.Lists;
import lk.ac.cmb.ucsc.euphoria.constants.AppointmentStatus;
import lk.ac.cmb.ucsc.euphoria.model.AppointmentRequest;
import lk.ac.cmb.ucsc.euphoria.model.PatientRecords;
import lk.ac.cmb.ucsc.euphoria.model.User;
import lk.ac.cmb.ucsc.euphoria.model.counselor.Counselor;
import lk.ac.cmb.ucsc.euphoria.repository.AppointmentRequestRepository;
import lk.ac.cmb.ucsc.euphoria.repository.CounselorRepository;
import lk.ac.cmb.ucsc.euphoria.repository.PatientRecordsRepository;
import lk.ac.cmb.ucsc.euphoria.repository.UserRepository;
import lk.ac.cmb.ucsc.euphoria.util.ActiveUsersUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CounselorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CounselorService.class);

    @Autowired
    private CounselorRepository counselorRepository;

    @Autowired
    private AppointmentRequestRepository appointmentRequestRepository;

    @Autowired
    private PatientRecordsRepository patientRecordsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActiveUsersUtil activeUsersUtil;

    private Counselor getAuthenticatedCounselor() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = (String) principal;
        }

        Optional<Counselor> counselor = counselorRepository.findByLoginCredentials_Username(username);
        counselor.orElseThrow(() -> new BadCredentialsException("Invalid logged in user detected"));
        return counselor.get();
    }

    public List<AppointmentRequest> getAppointments(String status) {
        ArrayList<AppointmentRequest> appointmentsList = null;
        AppointmentStatus appointmentStatus = AppointmentStatus.valueOf(status);
        Counselor authenticatedCounselor = getAuthenticatedCounselor();

        switch (appointmentStatus) {
            case PENDING:
            case ONGOING:
            case COMPLETED: {
                appointmentsList = Lists.newArrayList(appointmentRequestRepository.findByStatusAndId_Counselor_id(appointmentStatus, authenticatedCounselor.getId()));
                break;
            }
            default:
                appointmentsList = Lists.newArrayList(appointmentRequestRepository.findById_Counselor_id(authenticatedCounselor.getId()));
        }

        return appointmentsList;
    }

    public List<PatientRecords> getAllPatientRecords() {
        return Lists.newArrayList(patientRecordsRepository.findAll());
    }

    public List<PatientRecords> getPatientRecords(long patient) throws IllegalArgumentException,EntityNotFoundException{
        Optional<User> user = userRepository.findById(patient);
        user.orElseThrow(() -> new EntityNotFoundException("No such user with ID: " + patient));
        return Lists.newArrayList(patientRecordsRepository.findByUserAndCounselor(user.get(), getAuthenticatedCounselor()));
    }

    public boolean newPatientRecord(PatientRecords record) throws IllegalArgumentException{
        patientRecordsRepository.save(record);
        return true;
    }

//    public boolean
    public List<Counselor> getActiveCounselors(){
        List<String> allActive = activeUsersUtil.getStore();
        return counselorRepository.findAllByLoginCredentials_UsernameIn(allActive);
    }

    public boolean signUp(Counselor counselor) throws IllegalArgumentException{
        counselorRepository.save(counselor);
        return true;
    }
}
