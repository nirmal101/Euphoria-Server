package lk.ac.cmb.ucsc.euphoria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RateDTO {
    private long counselorId;
    private long userId;
    private long rate;

    public RateDTO() {
    }

    public RateDTO(@JsonProperty("counselorId") long counselorId,
                   @JsonProperty("userId") long userId,
                   @JsonProperty("rate") long rate) {
        this.counselorId = counselorId;
        this.userId = userId;
        this.rate = rate;
    }

    public long getCounselorId() {
        return counselorId;
    }

    public void setCounselorId(long counselorId) {
        this.counselorId = counselorId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRate() {
        return rate;
    }

    public void setRate(long rate) {
        this.rate = rate;
    }
}
