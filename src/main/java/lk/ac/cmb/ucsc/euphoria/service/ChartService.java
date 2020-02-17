package lk.ac.cmb.ucsc.euphoria.service;

import lk.ac.cmb.ucsc.euphoria.dto.DistrictCountDTO;
import lk.ac.cmb.ucsc.euphoria.dto.EmotionCountDTO;
import lk.ac.cmb.ucsc.euphoria.dto.GenderCountDTO;
import lk.ac.cmb.ucsc.euphoria.dto.YearCountDTO;
import lk.ac.cmb.ucsc.euphoria.model.Post;
import lk.ac.cmb.ucsc.euphoria.model.User;
import lk.ac.cmb.ucsc.euphoria.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
public class ChartService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private PasswordRepository passwordRepository;
    @Autowired
    private CounselorRepository counselorRepository;
    @Autowired
    private AppointmentRequestRepository appointmentRequestRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private EmailService emailService;

    public List<DistrictCountDTO> getDistrictCount(){
        System.out.println("service");
        List<User> users= (List<User>) userRepository.findAll();
        List<DistrictCountDTO> stats=new ArrayList<>();
        users.forEach((u)->{
            System.out.println(u.getAccount_type()+" "+u.getActivated());
             if(!u.getAccount_type().equals("quick") && u.getActivated().equals("yes")){
                 System.out.println("inside "+u.getDistrict());

                DistrictCountDTO new_object=new DistrictCountDTO(u.getDistrict(),1);
                if(stats.contains(new_object)){
                    int index=stats.indexOf(new_object);
                    DistrictCountDTO prev_object=stats.get(index);
                    prev_object.increment();
                    stats.set(index,prev_object);
                }else{
                    stats.add(new_object);
                }
             }
        });
        stats.forEach(v->{
            System.out.println(v.getDistrict()+" "+v.getCount());
        });

        return stats;

    }

    public List<GenderCountDTO> getGenderCount(){
        List<User> users= (List<User>) userRepository.findAll();
        List<GenderCountDTO> stats=new ArrayList<>();
        users.forEach((u)->{
             System.out.println(u.getAccount_type()+" "+u.getActivated());
             if(!u.getAccount_type().equals("quick") && u.getActivated().equals("yes")){
                 System.out.println("inside "+u.getGender());

                 GenderCountDTO new_object=new GenderCountDTO(u.getGender(),1);
                if(stats.contains(new_object)){
                    int index=stats.indexOf(new_object);
                    GenderCountDTO prev_object=stats.get(index);
                    prev_object.increment();
                    stats.set(index,prev_object);
                }else{
                    System.out.println("new object");
                    stats.add(new_object);
                }
             }
        });
        stats.forEach(v->{
            System.out.println(v.getGender()+" "+v.getCount());
        });

        return stats;
    }
    public List<YearCountDTO> getYearCount(){
        List<Post> posts= (List<Post>) postRepository.findAll();
        List<YearCountDTO> stats=new ArrayList<>();

        posts.forEach(p -> {

                YearCountDTO new_object=new YearCountDTO(p.getTimestamp().getYear()+1900,1);
                if(stats.contains(new_object)){
                    int index=stats.indexOf(new_object);
                    YearCountDTO prev_object=stats.get(index);
                    prev_object.increment();
                    stats.set(index,prev_object);
                }else{
                    stats.add(new_object);
                }
        });
        return stats;
    }
    public List<EmotionCountDTO> getEmotionCount(){
        List<Post> posts= (List<Post>) postRepository.findAll();
        List<EmotionCountDTO> stats=new ArrayList<>();

        posts.forEach(p -> {
            p.getEmotion_tags().forEach(e->{
                EmotionCountDTO new_object=new EmotionCountDTO(e.getEmotion_tag(),1);
                if(stats.contains(new_object)){
                    int index=stats.indexOf(new_object);
                    EmotionCountDTO prev_object=stats.get(index);
                    prev_object.increment();
                    stats.set(index,prev_object);
                }else{
                    stats.add(new_object);
                }

            });

        });
        return stats;
    }
}
