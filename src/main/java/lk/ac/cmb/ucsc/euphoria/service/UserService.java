package lk.ac.cmb.ucsc.euphoria.service;

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


    public void addPost(Post post) {
        userRepository.save(post);
    }
    public void addRequest(Request request){
        requestRepository.save(request);
    }

    public Boolean signIn(Password password) {

        Optional<Password> existing= passwordRepository.findById(password.getEmail());
        if(!existing.isEmpty()){
            Password temp=existing.get();
            return(temp.getPassword().equals(password.getPassword()));

        }else{
            return false;
        }
    }
}
