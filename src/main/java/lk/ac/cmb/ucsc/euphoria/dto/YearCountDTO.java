package lk.ac.cmb.ucsc.euphoria.dto;

import java.util.Objects;

public class YearCountDTO {
    private int year;
    private int count;

    public YearCountDTO(int year, int count) {
        this.year = year;
        this.count = count;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
        if (!(o instanceof YearCountDTO)) return false;
        YearCountDTO that = (YearCountDTO) o;
        return getYear() == that.getYear();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear());
    }
}
