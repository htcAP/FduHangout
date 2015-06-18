package edu.fudan.hangout.view.response;

/**
 * Created by lifengshuang on 6/17/15.
 */
public class AddActivityResponse {

    private int activity_id;

    private JSONResponse error;

    public int getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }

    public JSONResponse getError() {
        return error;
    }

    public void setError(JSONResponse error) {
        this.error = error;
    }
}
