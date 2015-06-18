package edu.fudan.hangout.view.response;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class FriendListResponse {

    private JSONResponse error;

    private Integer[] friend_list;

    public JSONResponse getError() {
        return error;
    }

    public void setError(JSONResponse error) {
        this.error = error;
    }

    public Integer[] getFriend_list() {
        return friend_list;
    }

    public void setFriend_list(Integer[] friend_list) {
        this.friend_list = friend_list;
    }
}
