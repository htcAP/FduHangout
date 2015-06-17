package edu.fudan.hangout.view.request.image;

import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/17/15.
 */
public class ImageView {

    @NotNull(message = "100|缺少type字段")
    private String type;

    @NotNull(message = "101|缺少data字段或未收到数据")
    private String data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
