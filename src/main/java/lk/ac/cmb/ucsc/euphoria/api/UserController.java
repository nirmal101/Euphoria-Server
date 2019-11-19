package lk.ac.cmb.ucsc.euphoria.api;

import lk.ac.cmb.ucsc.euphoria.model.Password;
import lk.ac.cmb.ucsc.euphoria.model.Post;
import lk.ac.cmb.ucsc.euphoria.model.Request;
import lk.ac.cmb.ucsc.euphoria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        userService.addPost(post);
    }
    @PostMapping(path = "/counselorrequest", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public void addPost(@RequestBody @Valid @NonNull Request request) {

        System.out.println("came to the server");
        try{
            userService.addRequest(request);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @PostMapping(path = "/signin", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public ResponseEntity<Boolean> signIn(@RequestBody @Valid @NonNull Password password) {

        System.out.println("came to the server");
        try{
            if(userService.signIn(password)){
                return ResponseEntity.ok(true);
            }else{
                return ResponseEntity.ok(false);
            }
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(false);
        }
    }


}
