package edu.fdu.hangout.controller;

import edu.fdu.hangout.view.Token;
import edu.fdu.hangout.view.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by lifengshuang on 6/16/15.
 */

@Controller
//@EnableWebMvc
@RequestMapping("/user/login")
public class LoginController {

    @RequestMapping(value = "/common", method = RequestMethod.POST)
    public @ResponseBody
    User commonLogin(@RequestBody User in) {
        User user = new User();

        user.setPhone(in.getPhone());
        user.setPassword("123321");
        return user;
    }

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public @ResponseBody
    Token tokenLogin(@RequestBody Token token) {
        return token;
    }


}
