package lk.ac.cmb.ucsc.euphoria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RateDTO {
    private long counselor_id;
    private long user_id;
    private long rate;

    public RateDTO(@JsonProperty("counselor_id") long counselor_id,
                   @JsonProperty("user_id") long user_id,
                   @JsonProperty("rating") long rate) {
        this.counselor_id = counselor_id;
        this.user_id = user_id;
        this.rate = rate;
    }

    public long getCounselor_id() {
        return counselor_id;
    }

    public void setCounselor_id(long counselor_id) {
        this.counselor_id = counselor_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getRate() {
        return rate;
    }

    public void setRate(long rate) {
        this.rate = rate;
    }
}
