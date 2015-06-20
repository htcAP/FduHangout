package edu.fudan.hangout.view.request.activity;

import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class ReplyInviteView {

    @NotNull(message = "100|缺少token字段")
    private String token;

    @NotNull(message = "101|缺少attend字段")
    private boolean attend;

    @NotNull(message = "102|缺少activity_id字段")
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
