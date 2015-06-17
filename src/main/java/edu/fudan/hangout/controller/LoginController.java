package edu.fudan.hangout.controller;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.service.LoginService;
import edu.fudan.hangout.service.UserService;
import edu.fudan.hangout.view.login.LoginUser;
import edu.fudan.hangout.view.login.TokenValidation;
import edu.fudan.hangout.view.response.JSONResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lifengshuang on 6/16/15.
 */

@Controller
@RequestMapping("/user/login")
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/common", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse commonLogin(@RequestBody LoginUser user) {
        JSONResponse response = new JSONResponse();
        if (validate(user, response)) {
            //TODO: tzy 登录验证，0|无错误（返回token）
            UserBean userBean = userService.getUserByPhone(user.getPhone());
            loginService.login(userBean);
        }


        return response;
    }

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    @ResponseBody
    public
    JSONResponse tokenLogin(@RequestBody TokenValidation token) {
        JSONResponse response = new JSONResponse();
        if (validate(token, response)) {
            //TODO: tzy 验证token： 0|无错误，1|token错误，请重新登录
        }
        return response;
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
