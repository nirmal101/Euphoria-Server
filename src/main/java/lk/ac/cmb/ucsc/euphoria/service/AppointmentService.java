package lk.ac.cmb.ucsc.euphoria.service;

import lk.ac.cmb.ucsc.euphoria.dto.RequestDTO;
import lk.ac.cmb.ucsc.euphoria.model.Request;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class AppointmentService {
    private static Map<Long, ArrayList<RequestDTO>> requests = new HashMap<>();

    public void newRequest(Request request){
        Long doc=request.getDoctor_id();
        ArrayList<RequestDTO> dtos=requests.get(doc);
        if (dtos == null)
            dtos = new ArrayList<>();
        dtos.add(new RequestDTO(request.getDoctor_id(),request.getDoctor_name(),request.getUser_id(),request.getUser_name()));
        requests.put(doc,dtos);
    }

    public ArrayList<RequestDTO> getRequestsOf(Long doctor_id){
        ArrayList<RequestDTO> dtos=requests.get(doctor_id);
        return dtos;
    }
}
