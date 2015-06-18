package edu.fudan.hangout.view.request.activity;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class ReplyInviteView {

    private String token;

    private boolean attend;

    private Integer activity_id;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isAttend() {
        return attend;
    }

    public void setAttend(boolean attend) {
        this.attend = attend;
    }

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }
}
