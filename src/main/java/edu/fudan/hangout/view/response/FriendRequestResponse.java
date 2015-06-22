package edu.fudan.hangout.view.response;

/**
 * Created by lifengshuang on 6/22/15.
 */
public class FriendRequestResponse {

    private JSONResponse error;

    private UserResponse[] users;

    public JSONResponse getError() {
        return error;
    }

    public void setError(JSONResponse error) {
        this.error = error;
    }

    public UserResponse[] getUsers() {
        return users;
    }

    public void setUsers(UserResponse[] users) {
        this.users = users;
    }
}
