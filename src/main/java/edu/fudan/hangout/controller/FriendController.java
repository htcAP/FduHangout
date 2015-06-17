package edu.fudan.hangout.controller;

import edu.fudan.hangout.view.response.JSONResponse;
import edu.fudan.hangout.view.user.*;
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
public class FriendController extends BaseController{

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    JSONResponse addFriend(@RequestBody FriendRequest friendRequest){
        JSONResponse response = new JSONResponse();
        if (validate(friendRequest, response)) {
            //TODO: tzy 添加好友： 0|申请成功，1|token错误，2|目标用户不存在，3|对方已经是你的好友
        }
        return response;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public @ResponseBody
    JSONResponse removeFriend(@RequestBody FriendRequest friendRequest){
        JSONResponse response = new JSONResponse();
        if (validate(friendRequest, response)) {
            //TODO: tzy 删除好友： 0|删除成功，1|token错误，2|目标用户不存在，3|对方不是你的好友
        }
        return response;
    }

    @RequestMapping(value = "/accept", method = RequestMethod.POST)
    public @ResponseBody
    JSONResponse acceptFriend(@RequestBody FriendRequest friendRequest){
        JSONResponse response = new JSONResponse();
        if (validate(friendRequest, response)) {
            //TODO: tzy 接受好友请求： 0|删除成功，1|token错误，2|目标用户不存在，3|对方不曾发出好友申请
        }
        return response;
    }

    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    public @ResponseBody
    JSONResponse rejectFriend(@RequestBody FriendRequest friendRequest){
        JSONResponse response = new JSONResponse();
        if (validate(friendRequest, response)) {
            //TODO: tzy 拒绝好友请求： 0|删除成功，1|token错误，2|目标用户不存在，3|对方不曾发出好友申请
        }
        return response;
    }



}
