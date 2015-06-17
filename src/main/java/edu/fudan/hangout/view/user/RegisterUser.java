package edu.fudan.hangout.view.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by lifengshuang on 6/17/15.
 */
public class RegisterUser {

    @NotNull(message = "100|缺少phone字段")
    @Size(min = 11, max = 11, message = "200|请输入11位手机号")
    private String phone;

    @NotNull(message = "101|缺少username字段")
    @Size(min = 1, max = 30, message = "201|用户名长度为1-30字符")
    private String username;

    @NotNull(message = "102|缺少password字段")
    @Size(min = 6, max = 30, message = "202|密码长度为6-30位")
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
