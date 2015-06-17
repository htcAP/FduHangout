package edu.fudan.hangout.controller;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.service.impl.LoginServiceImpl;
import edu.fudan.hangout.service.impl.UserServiceImpl;
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
    private UserServiceImpl userService;

    @Autowired
    private LoginServiceImpl loginService;

    @RequestMapping(value = "/common", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse commonLogin(@RequestBody LoginUser user) {
        JSONResponse response = new JSONResponse();
        if (validate(user, response)) {
            //TODO: tzy 登录验证，0|无错误（返回token）
            UserBean userBean = userService.getUserByPhone(user.getPhone());
            if (userBean == null) {
            /* User does not exist.*/
                response.setErrNo(1);
                response.setMessage("User does not exist.");
                return response;
            }

        /* Do login.*/
            String token = loginService.login(userBean);
            if (token != null) {
            /* Login succeeded.*/
                response.setErrNo(0);
                response.setMessage(token);
            } else {
            /* Login failed*/
                response.setErrNo(1);
            }
        }

        return response;
    }

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    @ResponseBody
    public JSONResponse tokenLogin(@RequestBody TokenValidation token) {
        JSONResponse response = new JSONResponse();
        if (validate(token, response)) {
            //TODO: tzy 验证token： 0|无错误，1|token错误，请重新登录
        }
        return response;
    }


    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void setLoginService(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }
}
