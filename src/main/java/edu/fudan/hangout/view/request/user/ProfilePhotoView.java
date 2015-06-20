package edu.fudan.hangout.view.request.user;

import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/20/15.
 */
public class ProfilePhotoView {

    @NotNull(message = "100|缺少token字段")
    private String token;

    @NotNull(message = "101|缺少url字段")
    private String url;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
