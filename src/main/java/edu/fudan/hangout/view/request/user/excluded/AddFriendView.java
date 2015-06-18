package edu.fudan.hangout.view.request.user.excluded;

import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/17/15.
 */
public class AddFriendView {

    @NotNull(message = "100|缺少token字段")
    private String token;

    @NotNull(message = "101|缺少user_to_add字段")
    private int user_to_add;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUser_to_add() {
        return user_to_add;
    }

    public void setUser_to_add(int user_to_add) {
        this.user_to_add = user_to_add;
    }
}
