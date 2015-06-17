package edu.fudan.hangout.view.user.excluded;

import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/17/15.
 */
public class RejectFriendView {

    @NotNull(message = "100|缺少token字段")
    private String token;

    @NotNull(message = "101|缺少user_to_reject字段")
    private int user_to_reject;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUser_to_reject() {
        return user_to_reject;
    }

    public void setUser_to_reject(int user_to_reject) {
        this.user_to_reject = user_to_reject;
    }
}
