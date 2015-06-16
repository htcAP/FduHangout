package edu.fudan.hangout.controller;

import edu.fudan.hangout.view.user.LoginUser;
import edu.fudan.hangout.view.user.RegisterUser;
import edu.fudan.hangout.view.user.TokenValidation;
import edu.fudan.hangout.view.response.JSONResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lifengshuang on 6/16/15.
 */

@Controller
@RequestMapping("/user/login")
public class LoginController extends BaseController {

    @RequestMapping(value = "/common", method = RequestMethod.POST)
    public @ResponseBody
    JSONResponse commonLogin(@RequestBody LoginUser user) {
        JSONResponse response = new JSONResponse();
        if (validate(user, response)){
            //TODO: tzy 登录验证，0|无错误（返回token）,1|用户名或密码错误
        }
        return response;
    }

//    @RequestMapping(value = "/token", method = RequestMethod.POST)
//    public @ResponseBody
//    JSONResponse tokenLogin(@RequestBody TokenValidation token) {
//        JSONResponse response = new JSONResponse();
//        if (validate(token, response)) {
//            //TODO: tzy 验证token： 0|无错误，1|token错误，请重新登录
//        }
//        return response;
//    }

}
