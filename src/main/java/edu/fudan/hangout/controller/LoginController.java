package edu.fudan.hangout.controller;

import edu.fudan.hangout.view.request.user.LoginUser;
import edu.fudan.hangout.view.response.JSONResponse;
import edu.fudan.hangout.view.response.TokenResponse;
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
    TokenResponse commonLogin(@RequestBody LoginUser user) {
        TokenResponse response = new TokenResponse();
        JSONResponse error = new JSONResponse();
        response.setError(error);
        if (validate(user, error)) {
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
