package lk.ac.cmb.ucsc.euphoria.dto;

import java.util.Objects;

public class EmotionCountDTO {
    private String emotion;
    private int count;

    public EmotionCountDTO(String emotion, int count) {
        this.emotion = emotion;
        this.count = count;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public void increment(){
        this.count+=1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmotionCountDTO)) return false;
        EmotionCountDTO that = (EmotionCountDTO) o;
        return getEmotion().equals(that.getEmotion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmotion());
    }
}
