package edu.fudan.hangout.view.response;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class ActivityListResponse {

    private ActivityInfoResponse[] activities;

    private JSONResponse error;

    public ActivityInfoResponse[] getActivities() {
        return activities;
    }

    public void setActivities(ActivityInfoResponse[] activities) {
        this.activities = activities;
    }

    public JSONResponse getError() {
        return error;
    }

    public void setError(JSONResponse error) {
        this.error = error;
    }
}
