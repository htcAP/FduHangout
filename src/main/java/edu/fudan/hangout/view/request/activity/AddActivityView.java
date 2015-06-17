package edu.fudan.hangout.view.request.activity;

import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/17/15.
 */

public class AddActivityView {

    @NotNull(message = "100|缺少token字段")
    private String token;

    @NotNull(message = "101|缺少title字段")
    private String title;

    @NotNull(message = "102|缺少description字段")
    private String description;

    @NotNull(message = "103|缺少deadline字段")
    private String deadline;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
