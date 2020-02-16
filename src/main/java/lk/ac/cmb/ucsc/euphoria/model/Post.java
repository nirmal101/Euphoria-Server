package lk.ac.cmb.ucsc.euphoria.model;


import lk.ac.cmb.ucsc.euphoria.model.common.SuperEntity;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Post extends SuperEntity {

    private  String post_title;
    @Size(max=1000)
    private String post_description;
    private Date timestamp;
    @Transient
    private String post_age;


    @ManyToOne
    @JoinColumn
    private User user_id;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Comment> comments=new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PostEmotionTag> emotion_tags=new ArrayList<>();

    public Post() {
    }

    public Post(String post_title, String post_description, User user_id,List<PostEmotionTag> emotion_tags) {
        this.post_title=post_title;
        this.emotion_tags=emotion_tags;
        this.post_description = post_description;
        this.timestamp = new Date();
        this.user_id = user_id;
    }

    public String getPost_age() {
        return post_age;
    }

    public void setPost_age(String post_age) {
        this.post_age = post_age;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_description() {
        return post_description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public User getUser_id() {
        return user_id;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<PostEmotionTag> getEmotion_tags() {
        return emotion_tags;
    }
}
