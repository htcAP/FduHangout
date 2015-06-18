package edu.fudan.hangout.view.response;

import edu.fudan.hangout.view.request.activity.TimeLocationView;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class ActivityResponse {

    private String title;

    private String description;

    private String deadline;

    private JSONResponse error;

    private Integer[] invites;

    private Integer activity_id;

    private TimeLocationView[] timeLocations;

    private String[] photo_urls;

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

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

    public JSONResponse getError() {
        return error;
    }

    public void setError(JSONResponse error) {
        this.error = error;
    }

    public Integer[] getInvites() {
        return invites;
    }

    public void setInvites(Integer[] invites) {
        this.invites = invites;
    }

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }

    public TimeLocationView[] getTimeLocations() {
        return timeLocations;
    }

    public void setTimeLocations(TimeLocationView[] timeLocations) {
        this.timeLocations = timeLocations;
    }

    public String[] getPhoto_urls() {
        return photo_urls;
    }

    public void setPhoto_urls(String[] photo_urls) {
        this.photo_urls = photo_urls;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
