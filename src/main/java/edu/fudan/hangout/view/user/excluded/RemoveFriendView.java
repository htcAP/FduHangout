package edu.fudan.hangout.view.user.excluded;

import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/17/15.
 */
public class RemoveFriendView {

    @NotNull(message = "100|缺少token字段")
    private String token;

    @NotNull(message = "101|缺少user_to_remove字段")
    private int user_to_remove;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUser_to_remove() {
        return user_to_remove;
    }

    public void setUser_to_remove(int user_to_remove) {
        this.user_to_remove = user_to_remove;
    }
}
