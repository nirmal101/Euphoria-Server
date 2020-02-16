package lk.ac.cmb.ucsc.euphoria.dto;

import java.util.Objects;

public class DistrictCountDTO {
    private String district;
    private int count=0;

    public DistrictCountDTO(String district, int count) {
        this.district = district;
        this.count = count;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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
    public  void decrement(){
        this.count-=1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DistrictCountDTO)) return false;
        DistrictCountDTO that = (DistrictCountDTO) o;
        return Objects.equals(getDistrict(), that.getDistrict());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDistrict());
    }
}
