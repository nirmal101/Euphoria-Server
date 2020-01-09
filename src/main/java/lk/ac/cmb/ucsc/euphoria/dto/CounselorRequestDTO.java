package lk.ac.cmb.ucsc.euphoria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CounselorRequestDTO {
    private  long counselor_id;
    private long user_id;
    private String request_description;

    public CounselorRequestDTO(@JsonProperty("counselor_id") long counselor_id,@JsonProperty("user_id") long user_id,@JsonProperty("request_description") String request_description) {
        this.counselor_id = counselor_id;
        this.user_id = user_id;
        this.request_description = request_description;
    }

    public CounselorRequestDTO() {
    }

    public long getCounselor_id() {
        return counselor_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public String getRequest_description() {
        return request_description;
    }
}
