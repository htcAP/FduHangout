package edu.fudan.hangout.view.response;

import edu.fudan.hangout.view.request.activity.TimeLocationView;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class ActivityResponse {

    private String title;

    private String description;

    private Long deadline;

    private JSONResponse error;

    private InviteResponse[] invites;

    private Integer activity_id;

    private TimeLocationView[] timeLocations;

    private String[] photo_urls;

    private Integer status;

    public Integer getOrganizer_id() {
        return organizer_id;
    }

    public void setOrganizer_id(Integer organizer_id) {
        this.organizer_id = organizer_id;
    }

    private Integer organizer_id;

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

    public Long getDeadline() {
        return deadline;
    }

    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }

    public InviteResponse[] getInvites() {
        return invites;
    }

    public void setInvites(InviteResponse[] invites) {
        this.invites = invites;
    }
}
