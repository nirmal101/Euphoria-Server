package lk.ac.cmb.ucsc.euphoria.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Map;

@Entity
public class Post{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank

    private  String postTitle;
    @NotBlank
    private  String postBody;
    @ElementCollection
    private  Map<String,Boolean> feelings;
//    private  Feelings feelings;
    public Post(){

    }
    public Post(@JsonProperty("postTitle") String postTitle, @JsonProperty("postBody") @NotBlank String postBody,@JsonProperty("checkboxes") Map<String, Boolean> feelings) {
        this.postTitle = postTitle;
        this.postBody = postBody;
//        this.feelings = feelings;
        this.feelings = feelings;
    }

    public Map<String, Boolean> getFeelings() {
        return feelings;
    }

    public long getId() {
        return id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostBody() {
        return postBody;
    }
}
