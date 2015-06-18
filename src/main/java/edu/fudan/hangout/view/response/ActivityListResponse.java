package edu.fudan.hangout.view.response;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class ActivityListResponse {

    private Integer[] activity_ids;

    private JSONResponse error;

    public Integer[] getActivity_ids() {
        return activity_ids;
    }

    public void setActivity_ids(Integer[] activity_ids) {
        this.activity_ids = activity_ids;
    }

    public JSONResponse getError() {
        return error;
    }

    public void setError(JSONResponse error) {
        this.error = error;
    }
}
