package edu.fudan.hangout.view.request.activity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class GetActivityListView {

    @NotNull(message = "100|缺少token字段")
    private String token;

    @NotNull(message = "101|缺少activity_kind字段")
    @Max(value = 2, message = "102|activity_kind = 0 or 1 or 2")
    @Min(value = 0, message = "103|activity_kind = 0 or 1 or 2")
    private Integer activity_kind;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getActivity_kind() {
        return activity_kind;
    }

    public void setActivity_kind(Integer activity_kind) {
        this.activity_kind = activity_kind;
    }
}
