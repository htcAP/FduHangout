package edu.fudan.hangout.controller;

import edu.fudan.hangout.view.response.JSONResponse;
import edu.fudan.hangout.view.user.RegisterUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lifengshuang on 6/17/15.
 */

@Controller
public class RegisterController extends BaseController{

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public @ResponseBody
    JSONResponse register(@RequestBody RegisterUser user) {
        JSONResponse response = new JSONResponse();
        if (validate(user, response)){
            //TODO: tzy 登录验证，0|无错误（返回token）,1|手机号已被注册
        }
        return response;
    }
}
