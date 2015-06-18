package edu.fudan.hangout.controller;

import edu.fudan.hangout.view.request.user.*;
import edu.fudan.hangout.view.response.*;
import oracle.jrockit.jfr.parser.FLREvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lifengshuang on 6/18/15.
 */

@Controller
public class UserController extends BaseController{

    @RequestMapping(value = "/user/get/user", method = RequestMethod.POST)
    public @ResponseBody
    UserResponse getTargetUser(@RequestBody GetUserView user) {
        UserResponse response = new UserResponse();
        JSONResponse error = new JSONResponse();
        response.setError(error);
        if (validate(user, error)) {
            //TODO: tzy
        }
        return response;
    }

    @RequestMapping(value = "/user/get/friend_list", method = RequestMethod.POST)
    public @ResponseBody
    FriendListResponse getFriendList(@RequestBody GetFriendListView getFriendListView) {
        FriendListResponse response = new FriendListResponse();
        JSONResponse error = new JSONResponse();
        response.setError(error);
        if (validate(getFriendListView, error)) {
            //TODO: tzy
        }
        return response;
    }

    @RequestMapping(value = "/user/signature", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse signature(@RequestBody SignatureRequest signatureRequest) {
        JSONResponse response = new JSONResponse();
        if (validate(signatureRequest, response)) {
            //TODO: tzy
        }
        return response;
    }

    @RequestMapping(value = "/user/search", method = RequestMethod.POST)
    public
    @ResponseBody
    SearchUserResponse search(@RequestBody SearchUserView searchUserView) {
        SearchUserResponse response = new SearchUserResponse();
        JSONResponse error = new JSONResponse();
        response.setError(error);
        if (validate(searchUserView, error)) {
            //TODO: tzy
        }
        return response;
    }

}
