package lk.ac.cmb.ucsc.euphoria.controller;

import lk.ac.cmb.ucsc.euphoria.model.*;
import lk.ac.cmb.ucsc.euphoria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/user")
@RestController
public class UserController {

    @Autowired
    private final UserService userService;
    private Boolean value=false;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/counselorrequest", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public void addRequest(@RequestBody @Valid @NonNull Request request) {

        System.out.println("came to the server");
        System.out.println(request.getUser_id());
        System.out.println(request.getUser_name());
        System.out.println(request.getDoctor_name());
    }
    @GetMapping(path = "/getCounselors", produces = "application/json")
    @CrossOrigin
    public List<Counselor> getCounselors() {
        System.out.println("Get counselors");
        return userService.getCounselors();
    }

    @PostMapping(path = "/newpost", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public void addPost(@RequestBody @Valid @NonNull Post post) {

        System.out.println("came to the server");
        System.out.println(post.getFeelings());
        userService.addPost(post);
    }

    @PostMapping(path = "/signin", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public ResponseEntity<Boolean> signIn(@RequestBody @Valid @NonNull Password password) {

        System.out.println("came to the server");
        System.out.println(password.getEmail()+" email");
        value=true;
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
    @PostMapping(path = "/sign", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public ResponseEntity<Boolean> sign(@RequestBody @Valid @NonNull Password password) {

        System.out.println("came to the server");
        try{
            return ResponseEntity.ok(value);

        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(false);
        }
    }

    @PostMapping(path = "/quicksignup", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public ResponseEntity<Boolean> quickSignUp(@RequestBody @Valid @NonNull User user) {

        System.out.println("came to the server");
        try{
            if(userService.quickSignUp(user)){
                return ResponseEntity.ok(true);
            }else{
                return ResponseEntity.ok(false);
            }
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(false);
        }
    }
    @PostMapping(path = "/formalsignup", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public ResponseEntity<Boolean> formalSignUp(@RequestBody @Valid @NonNull User user) {

        System.out.println("came to the server");
        try{
            if(userService.formalSignUp(user)){
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
