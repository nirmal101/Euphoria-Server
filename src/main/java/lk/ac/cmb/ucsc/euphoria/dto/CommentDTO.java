package lk.ac.cmb.ucsc.euphoria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentDTO {
    private String comment_description;
    private long user_id;
    private long post_id;

    public CommentDTO(@JsonProperty("comment_description") String comment_description,@JsonProperty("user_id") long user_id,@JsonProperty("post_id") long post_id) {
        this.comment_description = comment_description;
        this.user_id = user_id;
        this.post_id = post_id;
    }

    public String getComment_description() {
        return comment_description;
    }

    public long getUser_id() {
        return user_id;
    }

    public long getPost_id() {
        return post_id;
    }
}
