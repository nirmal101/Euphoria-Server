package lk.ac.cmb.ucsc.euphoria.service;

import lk.ac.cmb.ucsc.euphoria.dao.UserDAO;
import lk.ac.cmb.ucsc.euphoria.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public void addPost(Post post) {
        userDAO.save(post);
    }
}
