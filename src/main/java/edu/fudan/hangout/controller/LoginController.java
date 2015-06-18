package edu.fudan.hangout.controller;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.service.impl.LoginServiceImpl;
import edu.fudan.hangout.service.impl.UserServiceImpl;
import edu.fudan.hangout.util.SHA1Hasher;
import edu.fudan.hangout.view.request.user.LoginUser;
import edu.fudan.hangout.view.response.JSONResponse;
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
    JSONResponse commonLogin(@RequestBody LoginUser user) {
        JSONResponse response = new JSONResponse();
        if (validate(user, response)) {
            UserBean userBean = userService.getUserByPhone(user.getPhone());
            if (userBean == null) {
                /* User does not exist.*/
                response.setErrNo(1);
                response.setMessage("用户不存在");
                return response;
            } else {
                String passwordString = userBean.getId() + "." + user.getPassword();
                if (!(SHA1Hasher.makeSHA1Hash(passwordString).equals(userBean.getPassword()))) {
                   /* Wrong phone number.*/
                    response.setErrNo(2);
                    response.setMessage("用户名或密码错误");
                    return response;
                }
            }

            /* User identification checked. Do login.*/
            String token = loginService.login(userBean);
            if (token != null) {
                /* Login succeeded.*/
                response.setErrNo(0);
                response.setMessage(token);
            } else {
                /* Login failed*/
                response.setErrNo(3);
                response.setMessage("登录失败");
            }
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
