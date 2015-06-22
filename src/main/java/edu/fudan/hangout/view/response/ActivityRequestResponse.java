package edu.fudan.hangout.view.response;

/**
 * Created by lifengshuang on 6/22/15.
 */
public class ActivityRequestResponse {

    private JSONResponse error;

    private ActivityInfoResponse[] activities;

    public JSONResponse getError() {
        return error;
    }

    public void setError(JSONResponse error) {
        this.error = error;
    }

    public ActivityInfoResponse[] getActivities() {
        return activities;
    }

    public void setActivities(ActivityInfoResponse[] activities) {
        this.activities = activities;
    }
}
