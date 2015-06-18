package edu.fudan.hangout.view.request.user;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class GetUserView {

    private String token;

    private Integer user_id;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
