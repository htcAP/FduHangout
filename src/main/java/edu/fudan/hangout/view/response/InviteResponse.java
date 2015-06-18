package edu.fudan.hangout.view.response;

/**
 * Created by lifengshuang on 6/19/15.
 */
public class InviteResponse {
    private Integer user_id;
    private Integer invite_status;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getInvite_status() {
        return invite_status;
    }

    public void setInvite_status(Integer invite_status) {
        this.invite_status = invite_status;
    }
}
