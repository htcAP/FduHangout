package edu.fudan.hangout.controller;

import edu.fudan.hangout.view.request.activity.*;
import edu.fudan.hangout.view.response.AddActivityResponse;
import edu.fudan.hangout.view.response.JSONResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lifengshuang on 6/17/15.
 */

@Controller
@RequestMapping("/activity")
public class ActivityController extends BaseController {

    @RequestMapping(value = "/post/new", method = RequestMethod.POST)
    public
    @ResponseBody
    AddActivityResponse addActivity(@RequestBody AddActivityView addActivityView) {
        JSONResponse error = new JSONResponse();
        AddActivityResponse response = new AddActivityResponse();
        response.setError(error);
        if (validate(addActivityView, error)) {
            //TODO: tzy 新建活动，0|无错误 1|token错误 2|deadline时间解析错误
        }
        return response;
    }

    @RequestMapping(value = "/post/invite", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse inviteUser(@RequestBody InviteUserView inviteUserView) {
        JSONResponse response = new JSONResponse();
        if (validate(inviteUserView, response)) {
            //TODO: tzy 邀请好友，0|无错误 1|token错误 2|activity_id错误 3|user_id有误 4|没有权限
        }
        return response;
    }

    @RequestMapping(value = "/post/time_location", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse addTimeLocation(@RequestBody TimeLocationView timeLocationView) {
        JSONResponse response = new JSONResponse();
        if (validate(timeLocationView, response)) {
            //TODO: tzy 添加时间地点，0|无错误 1|token错误 2|activity_id错误 3|time解析错误 4|没有权限
        }
        return response;
    }

    @RequestMapping(value = "/post/photo", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse addPhoto(@RequestBody ActivityPhotoView activityPhotoView) {
        JSONResponse response = new JSONResponse();
        if (validate(activityPhotoView, response)) {
            //TODO: tzy 添加照片，0|无错误 1|token错误 2|activity_id错误 3|url不存在 4|没有权限
        }
        return response;
    }

    @RequestMapping(value = "/post/vote", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse vote(@RequestBody VoteView voteView) {
        JSONResponse response = new JSONResponse();
        if (validate(voteView, response)) {
            //TODO: tzy 给时间地点投票，0|无错误 1|token错误 2|time_location_id错误 3|没有权限
        }
        return response;
    }

}
