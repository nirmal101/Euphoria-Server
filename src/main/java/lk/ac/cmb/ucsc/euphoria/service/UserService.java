package lk.ac.cmb.ucsc.euphoria.service;

import lk.ac.cmb.ucsc.euphoria.constants.AppointmentStatus;
import lk.ac.cmb.ucsc.euphoria.dto.CommentDTO;
import lk.ac.cmb.ucsc.euphoria.dto.CounselorRequestDTO;
import lk.ac.cmb.ucsc.euphoria.dto.PasswordChangeDTO;
import lk.ac.cmb.ucsc.euphoria.dto.PostDTO;
import lk.ac.cmb.ucsc.euphoria.model.*;
import lk.ac.cmb.ucsc.euphoria.model.counselor.Counselor;
import lk.ac.cmb.ucsc.euphoria.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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
    private AppointmentRequestRepository appointmentRequestRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private EmailService emailService;

    private String link="http://localhost:3000/user/verifyaccount";

    public Post addPost(PostDTO postdto) {
        System.out.println("came to posting");
        User user = userRepository.findById(postdto.getUser_id()).get();


        List<PostEmotionTag> emotionTags = new ArrayList<>();
        postdto.getEmotion_tags().forEach((tag) -> {
            System.out.println(tag);
            emotionTags.add(new PostEmotionTag(tag));
        });

        Post post = new Post(postdto.getPost_title(), postdto.getPost_description(), user, emotionTags);

        return postRepository.save(post);

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

            Password temp=new Password(user.getEmail(),user.getPassword(),"Patient");
            Password pw=passwordRepository.save(temp);

            //verification
            emailService.sendSimpleMessage(user.getEmail(),"Welcome to Euphoria","Please click the following link to verify your account \n"+link+"/"+user.getEmail());

            user.setActivated("no");
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
    public boolean
    formalSignUp(User user) {
        Optional<Password> existing= passwordRepository.findById(user.getEmail());

        if(existing.isEmpty()){
            Password temp=new Password(user.getEmail(),user.getPassword(),"User");
            Password pw=passwordRepository.save(temp);

            if(pw==null){
                return false;
            }
            //verification
            emailService.sendSimpleMessage(user.getEmail(),"Welcome to Euphoria","Please click the following link to verify your account \n"+link+"/"+user.getEmail());

        }


        user.setActivated("yes");
        User us=userRepository.save(user);
        if ( us==null) {
            return false;

        }else{
            return true;
        }

    }

    public List<Counselor> getCounselors() {
        Iterable<Counselor> all = counselorRepository.findAll();
        List<Counselor> counselorList=new ArrayList<Counselor>();
        all.forEach(counselorList::add );
        return counselorList;
    }

    public List<User> getUsers(){
        Iterable<User> all = userRepository.findAll();
        List<User> userList = new ArrayList<User>();
        all.forEach(userList::add);
        return userList;
    }

    public ResponseEntity<Boolean> requestCounselor(@Valid CounselorRequestDTO counselorRequest) {

        Counselor counselor=new Counselor();
        counselor.setId(counselorRequest.getCounselor_id());

        User user=new User();
        user.setUid(counselorRequest.getUser_id());

        AppointmentRequestPK id=new AppointmentRequestPK();
        id.setCounselor(counselor);
        id.setUser(user);

        AppointmentRequest new_request=new AppointmentRequest(id,counselorRequest.getRequest_description());
        new_request.setStatus(AppointmentStatus.PENDING);
        AppointmentRequest temp = appointmentRequestRepository.save(new_request);
        if(temp!=null){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.ok(true);
        }
    }

    public List<Post> getPosts() {
        long x=9;
       List<Post> posts=(List<Post>) postRepository.findAll();
       posts.forEach(post -> {
           List<Comment> comments=post.getComments();
           comments.forEach(comment -> {
               String comment_age=calculateDateDifference(comment.getTimestamp());
               comment.setComment_age(comment_age);
           });
           String post_age=calculateDateDifference(post.getTimestamp());
           post.setPost_age(post_age);
       });
       return posts;
    }

    public Post addCommentToPost(CommentDTO commentdto) {
        //create a user object for primary key in comment.set the uid to the commented user's id
        User commented_user=new User();
        commented_user.setUid(commentdto.getUser_id());

        //create a new comment object using the commentdto
        Comment new_comment=new Comment(commentdto.getComment_description(),commented_user);

        //get the post in order to the comment
        Optional<Post> optional=postRepository.findById(commentdto.getPost_id());
        Post post=optional.get();

        //add the comment to the post
        post.getComments().add(new_comment);

        //update the post in the databse
        return postRepository.save(post);

    }

    public String calculateDateDifference(Date old){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date firstDate = new Date();
        Date secondDate = old;

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        if(diff<1){
            long diff2=TimeUnit.HOURS.convert(diffInMillies,TimeUnit.MILLISECONDS);
            if(diff2<1){
                long diff3=TimeUnit.MINUTES.convert(diffInMillies,TimeUnit.MILLISECONDS);
                if(diff3<1){
                    return "Just now";
                }
                return diff3==1 ? diff3+ " minute ago":diff3+" minutes ago";
            }
            return diff2==1 ? diff2+ " hour ago":diff2+" hours ago";
        }
        return diff==1 ? diff+ " day ago":diff+" days ago";
    }

    public void verifyAccount(String email) {
        List<User> user=userRepository.findByEmail(email);
        User us=user.get(0);
        if(us!=null){
            us.setActivated("yes");
            userRepository.save(us);
        }else{
            System.out.println("user does not exist");
        }
    }

    public User getUser(long id) {
        return userRepository.findById(id).get();
    }

    public User updateUser(User user) {
        List<User> list=userRepository.findByEmail(user.getEmail());
        User temp=list.get(0);
        user.setUid(temp.getUid());
        user.setTimestamp(new Date());
        return userRepository.save(user);
    }

    public Password changePassword(PasswordChangeDTO pw) {
        List<Password> list=passwordRepository.findByEmail(pw.getEmail());
        String pwd=list.get(0).getPassword();
        if(pwd.equals(pw.getOldPassword())){
            if(pw.getNewPassword().equals(pw.getOldPassword())){
                Password new_pw=list.get(0);
                new_pw.setPassword(pw.getNewPassword());
                return passwordRepository.save(new_pw);
            }
        }
        return null;
    }

    public List<AppointmentRequest> getRequests() {
        return (List<AppointmentRequest>) appointmentRequestRepository.findAll();
    }
}
