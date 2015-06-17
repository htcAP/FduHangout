package edu.fudan.hangout.view.request.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by lifengshuang on 6/16/15.
 */
public class LoginUser {

    @NotNull(message = "100|缺少字段：phone")
    @Size(min = 11, max = 11, message = "200|请输入11位手机号")
    private String phone;

    @NotNull(message = "101|缺少字段：password")
    @Size(min = 6,max = 30, message = "201|密码长度为6-30位")
    private String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
