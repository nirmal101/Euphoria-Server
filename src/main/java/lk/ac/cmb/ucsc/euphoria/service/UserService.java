package lk.ac.cmb.ucsc.euphoria.service;

import lk.ac.cmb.ucsc.euphoria.dao.PasswordDAO;
import lk.ac.cmb.ucsc.euphoria.dao.RequestDAO;
import lk.ac.cmb.ucsc.euphoria.dao.UserDAO;
import lk.ac.cmb.ucsc.euphoria.model.Password;
import lk.ac.cmb.ucsc.euphoria.model.Post;
import lk.ac.cmb.ucsc.euphoria.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private RequestDAO requestDAO;
    @Autowired
    private PasswordDAO passwordDAO;


    public void addPost(Post post) {
        userDAO.save(post);
    }
    public void addRequest(Request request){
        requestDAO.save(request);
    }

    public Boolean signIn(Password password) {

        Optional<Password> existing=passwordDAO.findById(password.getEmail());
        if(!existing.isEmpty()){
            Password temp=existing.get();
            return(temp.getPassword().equals(password.getPassword()));

        }else{
            return false;
        }
    }
}
