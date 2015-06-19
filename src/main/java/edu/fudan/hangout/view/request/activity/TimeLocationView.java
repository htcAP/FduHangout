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

    @NotNull(message = "102|缺少activity_id字段")
    private Integer activity_id;

    @NotNull(message = "103|缺少time字段")
    public TimeLocationView() {
        this.location = new LocationView();
        this.time = new ActivityTimeView();

    }
    private ActivityTimeView time;

    private Integer time_location_id;

    private Integer votes;

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }

    public ActivityTimeView getTime() {
        return time;
    }

    public void setTime(ActivityTimeView time) {
        this.time = time;
    }

    public LocationView getLocation() {
        return location;
    }

    public void setLocation(LocationView location) {
        this.location = location;
    }

    public Integer getTime_location_id() {
        return time_location_id;
    }

    public void setTime_location_id(Integer time_location_id) {
        this.time_location_id = time_location_id;
    }
}
