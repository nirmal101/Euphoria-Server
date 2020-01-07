package lk.ac.cmb.ucsc.euphoria.service;

import lk.ac.cmb.ucsc.euphoria.model.*;
import lk.ac.cmb.ucsc.euphoria.repository.CounselorRepository;
import lk.ac.cmb.ucsc.euphoria.repository.PasswordRepository;
import lk.ac.cmb.ucsc.euphoria.repository.RequestRepository;
import lk.ac.cmb.ucsc.euphoria.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
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



    public void addPost(Post post) {
    }
    public void addRequest(Request request){
        requestRepository.save(request);
    }

    public Boolean signIn(Password password) {
        System.out.println(password.getEmail());
        Optional<Password> existing= passwordRepository.findById(password.getEmail());
        System.out.println(existing.isEmpty());
        if(!existing.isEmpty()){
            Password temp=existing.get();
            return(temp.getPassword().equals(password.getPassword()));

        }else{
            return false;
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
}
