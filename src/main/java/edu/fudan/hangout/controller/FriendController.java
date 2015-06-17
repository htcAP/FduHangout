package edu.fudan.hangout.controller;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.service.impl.FriendshipServiceImpl;
import edu.fudan.hangout.service.impl.TokenServiceImpl;
import edu.fudan.hangout.service.impl.UserServiceImpl;
import edu.fudan.hangout.view.response.JSONResponse;
import edu.fudan.hangout.view.user.FriendRequest;
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
@RequestMapping("/user/friend")
public class FriendController extends BaseController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TokenServiceImpl tokenService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void setTokenService(TokenServiceImpl tokenService) {
        this.tokenService = tokenService;
    }

    public void setFriendshipService(FriendshipServiceImpl friendshipService) {
        this.friendshipService = friendshipService;
    }

    @Autowired
    private FriendshipServiceImpl friendshipService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse addFriend(@RequestBody FriendRequest friendRequest) {
        JSONResponse response = new JSONResponse();
        if (validate(friendRequest, response)) {
            //TODO: tzy 添加好友： 0|申请成功，1|token错误，2|目标用户不存在，3|对方已经是你的好友
        }

        friendRequest.setToken("98f18b455298667ab4e40af1f49ce444aabde050");
        friendRequest.setTarget_user(21);
        /* Check user token.*/
        int userId = tokenService.getUserId(friendRequest.getToken());
        if (userId == -1) {
            /* Token error.*/
            response.setErrNo(1);
            return response;
        }
        UserBean user = userService.getUserById(userId);

        /* User token checked. Check friend id.*/
        UserBean friend = userService.getUserById(friendRequest.getTarget_user());
        if (friend == null || friendRequest.getTarget_user() == userId) {
            /* Friend id does not exist.*/
            response.setErrNo(2);
            return response;
        }

        /* Friend checked. Do create friend request.*/
        boolean succeeded = friendshipService.createFriendRequest(user, friend);
        if (!succeeded) {
            response.setErrNo(3);
            return response;
        } else {
            response.setErrNo(0);
            return response;
        }
//        return response;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse removeFriend(@RequestBody FriendRequest friendRequest) {
        JSONResponse response = new JSONResponse();
        if (validate(friendRequest, response)) {
            //TODO: tzy 删除好友： 0|删除成功，1|token错误，2|目标用户不存在，3|对方不是你的好友
        }
        return response;
    }

    @RequestMapping(value = "/accept", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse acceptFriend(@RequestBody FriendRequest friendRequest) {
        JSONResponse response = new JSONResponse();
        if (validate(friendRequest, response)) {
            //TODO: tzy 接受好友请求： 0|删除成功，1|token错误，2|目标用户不存在，3|对方不曾发出好友申请
        }
        return response;
    }

    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse rejectFriend(@RequestBody FriendRequest friendRequest) {
        JSONResponse response = new JSONResponse();
        if (validate(friendRequest, response)) {
            //TODO: tzy 拒绝好友请求： 0|删除成功，1|token错误，2|目标用户不存在，3|对方不曾发出好友申请
        }
        return response;
    }


}
