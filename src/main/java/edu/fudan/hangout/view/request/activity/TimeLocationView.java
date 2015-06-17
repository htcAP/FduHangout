package edu.fudan.hangout.view.request.activity;

import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class TimeLocationView {


    @NotNull(message = "100|缺少token字段")
    private String token;

    @NotNull(message = "101|缺少location字段")
    private LocationView location;

    @NotNull(message = "105|缺少activity_id字段")
    private Integer activity_id;

    @NotNull(message = "100|缺少time字段")
    private String time;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LocationView getLocation() {
        return location;
    }

    public void setLocation(LocationView location) {
        this.location = location;
    }
}
