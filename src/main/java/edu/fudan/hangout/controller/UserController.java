package edu.fudan.hangout.controller;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.service.impl.FriendshipServiceImpl;
import edu.fudan.hangout.service.impl.TokenServiceImpl;
import edu.fudan.hangout.service.impl.UserServiceImpl;
import edu.fudan.hangout.view.request.user.*;
import edu.fudan.hangout.view.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lifengshuang on 6/18/15.
 */

@Controller
public class UserController extends BaseController {
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void setFriendshipService(FriendshipServiceImpl friendshipService) {
        this.friendshipService = friendshipService;
    }

    @Autowired
    public UserServiceImpl userService;

    @Autowired
    public FriendshipServiceImpl friendshipService;

    public void setTokenService(TokenServiceImpl tokenService) {
        this.tokenService = tokenService;
    }

    @Autowired
    public TokenServiceImpl tokenService;

    @RequestMapping(value = "/user/get/user", method = RequestMethod.POST)
    public
    @ResponseBody
    UserResponse getTargetUser(@RequestBody GetUserView userView) {
        UserResponse response = new UserResponse();
        JSONResponse error = new JSONResponse();
        response.setError(error);
        if (validate(userView, error)) {
            /* Check user token.*/
            int userId = tokenService.getUserId(userView.getToken());
            if (userId == -1) {
                /* Token error.*/
                error.setErrNo(1);
                error.setMessage("用户Token错误");
                return response;
            }
            UserBean user = userService.getUserById(userId);

            /* User token checked. Check target user.*/
            /* If target user == -1, get my info.*/
            int targetId = (userView.getUser_id() == -1) ? userId : userView.getUser_id();
            UserBean userBean = userService.getUserById(targetId);
            if (userBean == null) {
                /* User does not exist.*/
                error.setErrNo(2);
                error.setMessage("用户不存在");
                return response;
            }


            /* Check friendship*/
            boolean isMyFriend = (userView.getUser_id() == -1) || friendshipService.isFriend(userId, targetId);

            /* Set information.*/
            response.setPhone(userBean.getPhone());
            response.setSignature(userBean.getSignature());
            response.setUser_id(targetId);
            response.setUsername(userBean.getUsername());
            response.setIs_my_friend(isMyFriend);

            error.setErrNo(0);
            error.setMessage("获取好友成功");
        }
        return response;
    }

    @RequestMapping(value = "/user/get/friend_list", method = RequestMethod.POST)
    public
    @ResponseBody
    FriendListResponse getFriendList(@RequestBody GetFriendListView getFriendListView) {
        FriendListResponse response = new FriendListResponse();
        JSONResponse error = new JSONResponse();
        response.setError(error);
        if (validate(getFriendListView, error)) {
            /* Check user token.*/
            int userId = tokenService.getUserId(getFriendListView.getToken());
            if (userId == -1) {
                /* Token error.*/
                error.setErrNo(1);
                error.setMessage("用户Token错误");
                return response;
            }
            UserBean user = userService.getUserById(userId);

            if (user == null) {
                error.setErrNo(2);
                error.setMessage("用户不存在");
                return response;
            }

            List<Integer> friendIds = friendshipService.getAllFriends(userId);

            List<UserResponse> userResponseList = new LinkedList<>();
            for (int friendId : friendIds) {
                /* User token checked. Check target user.*/
                UserBean userBean = userService.getUserById(friendId);
                if (userBean == null) {
                    /* User does not exist.*/
                    error.setErrNo(3);
                    error.setMessage("好友Id不存在");
                    continue;
                }

                /* Set information.*/
                UserResponse userResponse = new UserResponse();
                userResponse.setPhone(userBean.getPhone());
                userResponse.setSignature(userBean.getSignature());
                userResponse.setUser_id(friendId);
                userResponse.setUsername(userBean.getUsername());
                userResponse.setIs_my_friend(true);
                userResponseList.add(userResponse);
            }

            UserResponse[] userResponses = new UserResponse[0];
            userResponses = userResponseList.toArray(userResponses);
            response.setFriend_list(userResponses);

            error.setErrNo(0);
            error.setMessage("获取好友列表成功");
        }
        return response;
    }

    @RequestMapping(value = "/user/signature", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse signature(@RequestBody SignatureRequest signatureRequest) {
        JSONResponse error = new JSONResponse();
        if (validate(signatureRequest, error)) {
            /* Check user token.*/
            int userId = tokenService.getUserId(signatureRequest.getToken());
            if (userId == -1) {
                /* Token error.*/
                error.setErrNo(1);
                error.setMessage("用户Token错误");
                return error;
            }
            UserBean user = userService.getUserById(userId);

            if (user == null) {
                error.setErrNo(2);
                error.setMessage("用户不存在");
                return error;
            }

            user.setSignature(signatureRequest.getSignature());
            boolean succeeded = userService.updateUser(user);
            if (!succeeded) {
                error.setErrNo(3);
                error.setMessage("修改签名失败");
            } else {
                error.setErrNo(0);
                error.setMessage("修改签名成功");
            }
        }
        return error;
    }

    @RequestMapping(value = "/user/search", method = RequestMethod.POST)
    public
    @ResponseBody
    SearchUserResponse search(@RequestBody SearchUserView searchUserView) {
        SearchUserResponse response = new SearchUserResponse();
        JSONResponse error = new JSONResponse();
        response.setError(error);
        if (validate(searchUserView, error)) {
            /* Check user token.*/
            int userId = tokenService.getUserId(searchUserView.getToken());
            if (userId == -1) {
                /* Token error.*/
                error.setErrNo(1);
                error.setMessage("用户Token错误");
                return response;
            }
            UserBean user = userService.getUserById(userId);

            if (user == null) {
                error.setErrNo(2);
                error.setMessage("用户不存在");
                return response;
            }

            /* Do search.*/
            List<Integer> resultIds = userService.searchUsers(searchUserView.getSearch_text());


            List<UserResponse> userResponseList = new LinkedList<>();
            for (int friendId : resultIds) {
                /* User token checked. Check target user.*/
                UserBean userBean = userService.getUserById(friendId);
                if (userBean == null) {
                    /* User does not exist.*/
                    error.setErrNo(3);
                    error.setMessage("好友Id不存在");
                    continue;
                }

                /* Set information.*/
                UserResponse userResponse = new UserResponse();
                userResponse.setPhone(userBean.getPhone());
                userResponse.setSignature(userBean.getSignature());
                userResponse.setUser_id(friendId);
                userResponse.setUsername(userBean.getUsername());
                userResponse.setIs_my_friend(true);
                userResponseList.add(userResponse);
            }

            UserResponse[] userResponses = new UserResponse[0];
            userResponses = userResponseList.toArray(userResponses);
            response.setUsers(userResponses);

            error.setErrNo(0);
            error.setMessage("搜索好友成功");
        }
        return response;
    }

    @RequestMapping(value = "/user/search_contact", method = RequestMethod.POST)
    public
    @ResponseBody
    SearchContactResponse searchContact(@RequestBody SearchContactView searchContactView) {
        SearchContactResponse response = new SearchContactResponse();
        JSONResponse error = new JSONResponse();
        response.setError(error);
        if (validate(searchContactView, error)) {
            /* Check user token.*/
            int userId = tokenService.getUserId(searchContactView.getToken());
            if (userId == -1) {
                /* Token error.*/
                error.setErrNo(1);
                error.setMessage("用户Token错误");
                return response;
            }
            UserBean user = userService.getUserById(userId);

            if (user == null) {
                error.setErrNo(2);
                error.setMessage("用户不存在");
                return response;
            }

            /* Do search.*/
            List<Integer> userIds = userService.searchUsersByContacts(searchContactView.getPhones());

            List<UserResponse> userResponseList = new LinkedList<>();
            for (int friendId : userIds) {
                /* User token checked. Check target user.*/
                UserBean userBean = userService.getUserById(friendId);
                if (userBean == null) {
                    /* User does not exist.*/
                    error.setErrNo(3);
                    error.setMessage("好友Id不存在");
                    continue;
                }

                /* Set information.*/
                UserResponse userResponse = new UserResponse();
                userResponse.setPhone(userBean.getPhone());
                userResponse.setSignature(userBean.getSignature());
                userResponse.setUser_id(friendId);
                userResponse.setUsername(userBean.getUsername());
                userResponse.setIs_my_friend(true);
                userResponseList.add(userResponse);
            }

            UserResponse[] userResponses = new UserResponse[0];
            userResponses = userResponseList.toArray(userResponses);
            response.setUsers(userResponses);

            error.setErrNo(0);
            error.setMessage("获取通讯录好友列表成功");
        }
        return response;
    }

}
