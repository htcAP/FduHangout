package edu.fudan.hangout.view.request.user;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class SignatureRequest {

    private String token;

    private String signature;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}