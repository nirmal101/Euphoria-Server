package lk.ac.cmb.ucsc.euphoria.dto;

import java.util.Objects;

public class GenderCountDTO {
   private String gender;
   private int count;

    public GenderCountDTO(String gender, int count) {
        this.gender = gender;
        this.count = count;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        if (!(o instanceof GenderCountDTO)) return false;
        GenderCountDTO that = (GenderCountDTO) o;
        return getCount() == that.getCount() &&
                getGender().equals(that.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGender(), getCount());
    }
}
