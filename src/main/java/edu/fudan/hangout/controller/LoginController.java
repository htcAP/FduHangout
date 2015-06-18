package edu.fudan.hangout.controller;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.service.impl.LoginServiceImpl;
import edu.fudan.hangout.service.impl.UserServiceImpl;
import edu.fudan.hangout.util.SHA1Hasher;
import edu.fudan.hangout.view.request.user.LoginUser;
import edu.fudan.hangout.view.response.JSONResponse;
import edu.fudan.hangout.view.response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lifengshuang on 6/16/15.
 */

@Controller
@RequestMapping("/user/login")
public class LoginController extends BaseController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private LoginServiceImpl loginService;

    @RequestMapping(value = "/common", method = RequestMethod.POST)
    public
    @ResponseBody
    TokenResponse commonLogin(@RequestBody LoginUser user) {
        TokenResponse response = new TokenResponse();
        JSONResponse errResponse = new JSONResponse();
        if (validate(user, errResponse)) {
            UserBean userBean = userService.getUserByPhone(user.getPhone());
            if (userBean == null) {
                /* User does not exist.*/
                errResponse.setErrNo(1);
                errResponse.setMessage("用户不存在");
                response.setError(errResponse);
                return response;
            } else {
                String passwordString = userBean.getId() + "." + user.getPassword();
                if (!(SHA1Hasher.makeSHA1Hash(passwordString).equals(userBean.getPassword()))) {
                   /* Wrong phone number.*/
                    errResponse.setErrNo(2);
                    errResponse.setMessage("用户名或密码错误");
                    response.setError(errResponse);
                    return response;
                }
            }

            /* User identification checked. Do login.*/
            String token = loginService.login(userBean);
            if (token != null) {
                /* Login succeeded.*/
                errResponse.setErrNo(0);
                errResponse.setMessage("登录成功");
                response.setToken(token);
            } else {
                /* Login failed*/
                errResponse.setErrNo(3);
                errResponse.setMessage("登录失败");
            }
        }
        response.setError(errResponse);
        return response;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void setLoginService(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }
}
