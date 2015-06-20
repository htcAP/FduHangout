package edu.fudan.hangout.view.request.position;

import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/21/15.
 */
public class GetPositionView {

    @NotNull(message = "100|缺少token字段")
    private String token;

    @NotNull(message = "101|缺少activity_id字段")
    private Integer activity_id;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }
}
