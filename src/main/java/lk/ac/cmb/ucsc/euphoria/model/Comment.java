package lk.ac.cmb.ucsc.euphoria.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long comment_id;
    private  String comment_description;
    private Date timestamp;
    @Transient
    private String comment_age;
    @ManyToOne
    private User commented_user_id;

    public Comment() {
    }


    public Comment(String comment_description,User commented_user_id) {
        this.comment_description = comment_description;
        this.commented_user_id = commented_user_id;
        this.timestamp = new Date();

    }

    public String getComment_age() {
        return comment_age;
    }


    public void setComment_age(String comment_age) {
        this.comment_age = comment_age;
    }

    public User getCommented_user_id() {
        return commented_user_id;
    }

    public void setCommented_user_id(User commented_user_id) {
        this.commented_user_id = commented_user_id;
    }

    public long getComment_id() {
        return comment_id;
    }

    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_description() {
        return comment_description;
    }

    public void setComment_description(String comment_description) {
        this.comment_description = comment_description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
