package edu.fdu.hangout.controller;

import edu.fdu.hangout.view.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lifengshuang on 6/16/15.
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public @ResponseBody
    User login(@PathVariable String name) {
        User user = new User();
        user.setPhone(name);
        user.setPassword("123321");
        return user;
    }

}
