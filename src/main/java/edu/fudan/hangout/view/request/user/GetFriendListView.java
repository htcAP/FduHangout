package edu.fudan.hangout.view.request.user;

import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class GetFriendListView {

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @NotNull(message = "100|缺少token字段")
    private String token;

}
