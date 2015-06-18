package edu.fudan.hangout.view.response;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class TimeLocationResponse {

    private Integer time_location_id;

    private JSONResponse error;

    public Integer getTime_location_id() {
        return time_location_id;
    }

    public void setTime_location_id(Integer time_location_id) {
        this.time_location_id = time_location_id;
    }

    public JSONResponse getError() {
        return error;
    }

    public void setError(JSONResponse error) {
        this.error = error;
    }
}
