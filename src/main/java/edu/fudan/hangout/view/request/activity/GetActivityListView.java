package edu.fudan.hangout.view.request.activity;

import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/18/15.
 */
public class GetActivityListView {

    @NotNull(message = "100|缺少user_id字段")
    private Integer user_id;

//    @NotNull(message = "101|缺少activity_kind字段")
//    @Max(value = 2, message = "102|activity_kind = 0 or 1 or 2")
//    @Min(value = 0, message = "103|activity_kind = 0 or 1 or 2")
//    private Integer activity_kind;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
