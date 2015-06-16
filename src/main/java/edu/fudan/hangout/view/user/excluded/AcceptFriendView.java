package edu.fudan.hangout.view.user.excluded;

import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/17/15.
 */
public class AcceptFriendView {

    @NotNull(message = "100|缺少token字段")
    private String token;

    @NotNull(message = "101|缺少user_to_accept字段")
    private int user_to_accept;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUser_to_accept() {
        return user_to_accept;
    }

    public void setUser_to_accept(int user_to_accept) {
        this.user_to_accept = user_to_accept;
    }
}
