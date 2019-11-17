package lk.ac.cmb.ucsc.euphoria.api;

import lk.ac.cmb.ucsc.euphoria.model.Post;
import lk.ac.cmb.ucsc.euphoria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("api/user")
@RestController
public class UserController {

    @Autowired
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/newpost", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public void addPost(@RequestBody @Valid @NonNull Post post) {

        System.out.println("came to the server");
        System.out.println(post.getFeelings());
//        userService.addPost(post);
    }


}
