package edu.fudan.hangout.view.response;

import edu.fudan.hangout.view.request.activity.TimeLocationView;

/**
 * Created by lifengshuang on 6/20/15.
 */
public class ActivityInfoResponse {

    private String title;

    private String description;

    private Integer startTime;

    private String location;


    private Integer activity_id;

    private Integer status;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }
}
