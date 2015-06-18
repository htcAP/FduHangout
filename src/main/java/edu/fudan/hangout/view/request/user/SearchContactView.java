package edu.fudan.hangout.view.request.user;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class SearchContactView {

    private String token;

    private String[] phones;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }
}
