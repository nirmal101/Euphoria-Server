package lk.ac.cmb.ucsc.euphoria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PostEmotionTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private String emotion_tag;

    public PostEmotionTag() {
    }

    public PostEmotionTag(String emotion_tag) {

        this.emotion_tag = emotion_tag;
    }

    public long getId() {
        return id;
    }

    public String getEmotion_tag() {
        return emotion_tag;
    }

    public void setEmotion_tag(String emotion_tag) {
        this.emotion_tag = emotion_tag;
    }
}
