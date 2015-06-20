package edu.fudan.hangout.view.request.user;

import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class SearchUserView {

    @NotNull(message = "100|缺少token字段")
    private String token;

    @NotNull(message = "101|缺少search_text字段")
    private String search_text;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSearch_text() {
        return search_text;
    }

    public void setSearch_text(String search_text) {
        this.search_text = search_text;
    }
}
