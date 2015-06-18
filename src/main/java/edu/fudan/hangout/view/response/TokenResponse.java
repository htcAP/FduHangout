package edu.fudan.hangout.view.response;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class TokenResponse {

    private String token;

    private JSONResponse error;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JSONResponse getError() {
        return error;
    }

    public void setError(JSONResponse error) {
        this.error = error;
    }
}
