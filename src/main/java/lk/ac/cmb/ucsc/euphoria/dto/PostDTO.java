package lk.ac.cmb.ucsc.euphoria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lk.ac.cmb.ucsc.euphoria.model.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class PostDTO {

    private String post_title;
    private String post_description;
    private long user_id;
    private List<String> emotion_tags;



    public PostDTO(@JsonProperty("emotion_tags")List<String> emotion_tags,
                   @JsonProperty("post_title") String post_title,
                   @JsonProperty("post_description") String post_description,
                   @JsonProperty("user_id") long user_id) {
        this.post_title = post_title;
        this.post_description = post_description;
        this.user_id = user_id;
        this.emotion_tags=emotion_tags;
    }

    public String getPost_description() {
        return post_description;
    }

    public long getUser_id() {
        return user_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public List<String> getEmotion_tags() {
        return emotion_tags;
    }
}
