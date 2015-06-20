package edu.fudan.hangout.view.request.user;

import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class GetUserView {

    @NotNull(message = "100|缺少token字段")
    private String token;

    @NotNull(message = "101|缺少user_id字段")
    private Integer user_id;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
