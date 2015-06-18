package edu.fudan.hangout.view.request.activity;

import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/17/15.
 */
public class InviteUserView {

    @NotNull(message = "100|缺少token字段")
    private String token;

    @NotNull(message = "101|缺少invites字段")
    private Integer[] invites;//array of user id

    @NotNull(message = "102|缺少activity_id字段")
    private Integer activity_id;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer[] getInvites() {
        return invites;
    }

    public void setInvites(Integer[] invites) {
        this.invites = invites;
    }

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }
}
