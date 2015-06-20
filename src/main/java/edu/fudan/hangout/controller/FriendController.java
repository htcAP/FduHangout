package edu.fudan.hangout.controller;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.service.impl.FriendshipServiceImpl;
import edu.fudan.hangout.service.impl.TokenServiceImpl;
import edu.fudan.hangout.service.impl.UserServiceImpl;
import edu.fudan.hangout.view.request.user.FriendRequest;
import edu.fudan.hangout.view.response.JSONResponse;
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
            /* Check user token.*/
            int userId = tokenService.getUserId(friendRequest.getToken());
            if (userId == -1) {
            /* Token error.*/
                response.setErrNo(1);
                response.setMessage("用户Token错误");
                return response;
            }
            UserBean user = userService.getUserById(userId);

            /* User token checked. Check friend id.*/
            UserBean friend = userService.getUserById(friendRequest.getTarget_user());
            if (friend == null || friendRequest.getTarget_user() == userId) {
            /* Friend id does not exist or your id duplicates with friend's id.*/
                response.setErrNo(2);
                response.setMessage("目标用户不存在或非法");
                return response;
            }

            /* Friend checked. Do create friend request.*/
            boolean succeeded = friendshipService.createFriendRequest(user, friend);
            if (!succeeded) {
                response.setErrNo(3);
                response.setMessage("发送好友申请失败");
                return response;
            } else {
                response.setErrNo(0);
                response.setMessage("发送好友申请成功");
                return response;
            }
        }
        /* Validation failed.*/
        return response;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse removeFriend(@RequestBody FriendRequest friendRequest) {
        JSONResponse response = new JSONResponse();
        if (validate(friendRequest, response)) {
            /* Check user token.*/
            int userId = tokenService.getUserId(friendRequest.getToken());
            if (userId == -1) {
            /* Token error.*/
                response.setErrNo(1);
                response.setMessage("用户Token错误");
                return response;
            }
            UserBean user = userService.getUserById(userId);

            /* User token checked. Check friend id.*/
            UserBean friend = userService.getUserById(friendRequest.getTarget_user());
            if (friend == null || friendRequest.getTarget_user() == userId) {
                /* Friend id does not exist or your id duplicates with friend's id.*/
                response.setErrNo(2);
                response.setMessage("目标用户不存在或非法");
                return response;
            }

            /* Friend checked. Do create friend request.*/
            boolean succeeded = friendshipService.deleteFriendship(user, friend);
            if (!succeeded) {
                response.setErrNo(3);
                response.setMessage("目标用户不是用户的好友");
                return response;
            } else {
                response.setErrNo(0);
                response.setMessage("删除好友成功");
                return response;
            }
        }
        /* Validation failed.*/
        return response;
    }

    @RequestMapping(value = "/accept", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse acceptFriend(@RequestBody FriendRequest friendRequest) {
        JSONResponse response = new JSONResponse();
        if (validate(friendRequest, response)) {
            /* Check user token.*/
            int userId = tokenService.getUserId(friendRequest.getToken());
            if (userId == -1) {
                /* Token error.*/
                response.setErrNo(1);
                response.setMessage("用户Token错误");
                return response;
            }
            UserBean user = userService.getUserById(userId);

            /* User token checked. Check friend id.*/
            UserBean friend = userService.getUserById(friendRequest.getTarget_user());
            if (friend == null || friendRequest.getTarget_user() == userId) {
                /* Friend id does not exist or your id duplicates with friend's id.*/
                response.setErrNo(2);
                response.setMessage("目标用户不存在或非法");
                return response;
            }

            /* Friend checked. Do create friend request.*/
            boolean succeeded = friendshipService.acceptFriendRequest(user, friend);
            if (!succeeded) {
                response.setErrNo(3);
                response.setMessage("未收到目标用户的好友请求或已经是好友");
                return response;
            } else {
                response.setErrNo(0);
                response.setMessage("已接受好友请求");
                return response;
            }
        }
        /* Validation failed.*/
        return response;
    }

    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse rejectFriend(@RequestBody FriendRequest friendRequest) {
        JSONResponse response = new JSONResponse();
        if (validate(friendRequest, response)) {
            /* Check user token.*/
            int userId = tokenService.getUserId(friendRequest.getToken());
            if (userId == -1) {
                /* Token error.*/
                response.setErrNo(1);
                response.setMessage("用户Token错误");
                return response;
            }
            UserBean user = userService.getUserById(userId);

            /* User token checked. Check friend id.*/
            UserBean friend = userService.getUserById(friendRequest.getTarget_user());
            if (friend == null || friendRequest.getTarget_user() == userId) {
                /* Friend id does not exist or your id duplicates with friend's id.*/
                response.setErrNo(2);
                response.setMessage("目标用户不存在或非法");
                return response;
            }

            /* Friend checked. Do create friend request.*/
            boolean succeeded = friendshipService.rejectFriendRequest(user, friend);
            if (!succeeded) {
                response.setErrNo(3);
                response.setMessage("未收到目标用户的好友请求或已经是好友");
                return response;
            } else {
                response.setErrNo(0);
                response.setMessage("已拒绝好友请求");
                return response;
            }
        }
            /* Validation failed.*/
        return response;
    }
}
