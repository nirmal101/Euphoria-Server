package lk.ac.cmb.ucsc.euphoria.api;

import lk.ac.cmb.ucsc.euphoria.dto.RequestDTO;
import lk.ac.cmb.ucsc.euphoria.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("api/counselor")
@RestController
public class CounselorController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping(path = "/appointments/{doc_id}")
    @CrossOrigin
    public @ResponseBody ArrayList<RequestDTO> getAppointments(@PathVariable(value = "doc_id") String doc_id){
        Long doctor_id = Long.valueOf(doc_id);
        ArrayList<RequestDTO> req = appointmentService.getRequestsOf(doctor_id);
        return req;
    }

    @GetMapping(path = "/app/{doc_id}")
    @CrossOrigin
    public @ResponseBody String getApp(@PathVariable(value = "doc_id") String doc_id){
        Long doctor_id = Long.valueOf(doc_id);
//        ArrayList<RequestDTO> req = appointmentService.getRequestsOf(doctor_id);
        return "req";
    }
}
