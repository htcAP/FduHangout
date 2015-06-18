package edu.fudan.hangout.view.request.activity;

import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class DecideView {

    @NotNull(message = "100|缺少token字段")
    private String token;

    @NotNull(message = "101|缺少time_location_id字段")
    private Integer time_location_id;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getTime_location_id() {
        return time_location_id;
    }

    public void setTime_location_id(Integer time_location_id) {
        this.time_location_id = time_location_id;
    }
}
