package edu.fudan.hangout.view.request.user;

import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class SignatureRequest {

    @NotNull(message = "100|缺少token字段")
    private String token;

    @NotNull(message = "101|缺少signature字段")
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
