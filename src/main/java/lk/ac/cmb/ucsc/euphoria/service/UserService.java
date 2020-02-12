package lk.ac.cmb.ucsc.euphoria.service;


import lk.ac.cmb.ucsc.euphoria.dto.CounselorRequestDTO;
import lk.ac.cmb.ucsc.euphoria.model.*;
import lk.ac.cmb.ucsc.euphoria.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import lk.ac.cmb.ucsc.euphoria.repository.PasswordRepository;
import lk.ac.cmb.ucsc.euphoria.repository.RequestRepository;
import lk.ac.cmb.ucsc.euphoria.repository.UserRepository;
import lk.ac.cmb.ucsc.euphoria.model.Password;
import lk.ac.cmb.ucsc.euphoria.model.Post;
import lk.ac.cmb.ucsc.euphoria.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private PasswordRepository passwordRepository;

    @Autowired
    private CounselorRepository counselorRepository;
    @Autowired
    private CounselorRequestRepository counselorRequestRepository;



    public void addPost(Post post) {

    }
    public void addRequest(Request request){
        requestRepository.save(request);
    }


    public List<User> signIn(Password password) {
        String email=password.getEmail();

        Optional<Password> existing= passwordRepository.findById(email);

        if(!existing.isEmpty()){
            Password temp=existing.get();
            if(temp.getPassword().equals(password.getPassword())){
               List<User> list=userRepository.findByEmail(email);
                return list;
            }else{
                return null;
            }

        }else{
            return null;
        }
    }

    public boolean quickSignUp(User user) {
        Optional<Password> existing= passwordRepository.findById(user.getEmail());
        if(existing.isEmpty()){

            Password temp=new Password(user.getEmail(),user.getPassword());
            Password pw=passwordRepository.save(temp);
            User us=userRepository.save(user);
            if (pw == null & us==null) {
                return false;

            }else{
                return true;
            }



        }else{
            return false;
        }
    }

    //can use this later when the user decides to  fill in the formal data
    public boolean formalSignUp(User user) {
        Optional<Password> existing= passwordRepository.findById(user.getEmail());
        if(existing.isEmpty()){
            Password temp=new Password(user.getEmail(),user.getPassword());
            Password pw=passwordRepository.save(temp);
            User us=userRepository.save(user);
            if (pw == null & us==null) {
                return false;

            }else{
                return true;
            }




        }else{
            return false;
        }
    }


    public List<Counselor> getCounselors() {
        Iterable<Counselor> all = counselorRepository.findAll();
        List<Counselor> counselorList=new ArrayList<Counselor>();
        all.forEach(counselorList::add );
        return counselorList;
    }

    public ResponseEntity<Boolean> requestCounselor(@Valid CounselorRequestDTO counselorRequest) {

        Counselor counselor=new Counselor();
        counselor.setId(counselorRequest.getCounselor_id());

        User user=new User();
        user.setUid(counselorRequest.getUser_id());

        CounselorRequestIdentity id=new CounselorRequestIdentity();
        id.setCounselor_id(counselor);
        id.setUser_id(user);

        CounselorRequest temp = counselorRequestRepository.save(new CounselorRequest(id,counselorRequest.getRequest_description()));
        if(temp!=null){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.ok(true);
        }
    }

}
