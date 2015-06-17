package edu.fudan.hangout.view.request.activity;

import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class ActivityPhotoView {

    @NotNull(message = "102|缺少token字段")
    private String token;

    @NotNull(message = "102|缺少url字段")
    private String url;

    @NotNull(message = "102|缺少activity_id字段")
    private Integer activity_id;

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

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }
}
