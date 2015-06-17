package edu.fudan.hangout.controller;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.service.impl.SignupServiceImpl;
import edu.fudan.hangout.service.impl.UserServiceImpl;
import edu.fudan.hangout.util.SHA1Hasher;
import edu.fudan.hangout.view.response.JSONResponse;
import edu.fudan.hangout.view.user.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lifengshuang on 6/17/15.
 */

@Controller
public class RegisterController extends BaseController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private SignupServiceImpl signupService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void setSignupService(SignupServiceImpl signupService) {
        this.signupService = signupService;
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse register(@RequestBody RegisterUser user) {
        JSONResponse response = new JSONResponse();
        if (validate(user, response)) {
            //TODO: tzy 登录验证，0|无错误（返回token）,1|手机号已被注册
            if (userService.getUserByPhone(user.getPhone()) != null) {
                /* user already existed.*/
                response.setErrNo(1);
                return response;
            }

            /* Create user with a fake password to get a id.*/
            UserBean userBean = new UserBean();
            userBean.setPhone(user.getPhone());
            userBean.setPassword(user.getPassword());
            userBean.setUsername(user.getUsername());
            int id = signupService.signup(userBean);
            userBean.setId(id);
            /* User id acquired. Save encrypted password then*/
            String passwordString = id + "." + user.getPassword();
            userBean.setPassword(SHA1Hasher.makeSHA1Hash(passwordString));
            signupService.update(userBean);

            response.setErrNo(0);
            return response;
        }
        /* Validation error*/
        return response;
    }
}
