package edu.fudan.hangout.view.user;

import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/17/15.
 */
public class FriendRequest {

    @NotNull(message = "100|缺少token字段")
    private String token;

    @NotNull(message = "101|缺少target_user字段")
    private int target_user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getTarget_user() {
        return target_user;
    }

    public void setTarget_user(int target_user) {
        this.target_user = target_user;
    }
}
