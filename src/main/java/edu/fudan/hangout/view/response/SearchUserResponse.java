package edu.fudan.hangout.view.response;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class SearchUserResponse {

    private JSONResponse error;

    private Integer[] user_ids;

    public JSONResponse getError() {
        return error;
    }

    public void setError(JSONResponse error) {
        this.error = error;
    }

    public Integer[] getUser_ids() {
        return user_ids;
    }

    public void setUser_ids(Integer[] user_ids) {
        this.user_ids = user_ids;
    }
}
