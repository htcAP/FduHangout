package edu.fudan.hangout.view.response;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class UserResponse {
    private int IS_FRIEND = 0, SENT_REQUEST = 1, WAIT_REPLY = 2, NOT_FRIEND = 3, MYSELF = 4;

    private Integer user_id;

    private String phone;

    private String username;

    private String signature;

    public Integer getIs_my_friend() {
        return is_my_friend;
    }

    public void setIs_my_friend(Integer is_my_friend) {
        this.is_my_friend = is_my_friend;
    }

    private Integer is_my_friend;

    private JSONResponse error;

    private String photo;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }


    public JSONResponse getError() {
        return error;
    }

    public void setError(JSONResponse error) {
        this.error = error;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
