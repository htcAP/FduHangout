package edu.fudan.hangout.view.request.user;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class SearchUserView {

    private String token;

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
