package edu.fudan.hangout.controller;

import edu.fudan.hangout.bean.ActivityBean;
import edu.fudan.hangout.bean.ActivityTipBean;
import edu.fudan.hangout.bean.ResourceBean;
import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.service.impl.ActivityServiceImpl;
import edu.fudan.hangout.service.impl.ResourceServiceImpl;
import edu.fudan.hangout.service.impl.TokenServiceImpl;
import edu.fudan.hangout.service.impl.UserServiceImpl;
import edu.fudan.hangout.view.request.activity.*;
import edu.fudan.hangout.view.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;

/**
 * Created by lifengshuang on 6/17/15.
 */

@Controller
@RequestMapping("/activity")
public class ActivityController extends BaseController {
    @Autowired
    private ActivityServiceImpl activityService;

    @Autowired
    private TokenServiceImpl tokenService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ResourceServiceImpl resourceService;

    @RequestMapping(value = "/post/new", method = RequestMethod.POST)
    public
    @ResponseBody
    AddActivityResponse addActivity(@RequestBody AddActivityView addActivityView) {
        JSONResponse error = new JSONResponse();
        AddActivityResponse response = new AddActivityResponse();
        response.setError(error);
        if (validate(addActivityView, error)) {
            /* Check user token.*/
            int userId = tokenService.getUserId(addActivityView.getToken());
            if (userId == -1) {
                /* Token error.*/
                error.setErrNo(1);
                error.setMessage("用户Token错误");
                return response;
            }

            /* User checked. Do add activity.*/
            ActivityBean activityBean = new ActivityBean();
            activityBean.setTitle(addActivityView.getTitle());
            activityBean.setDetail(addActivityView.getDescription());
            activityBean.setJoinDeadline(Timestamp.valueOf(addActivityView.getDeadline()));
            activityBean.setOrganizerId(userId);

            int activityId = activityService.createActivity(activityBean);
            if (activityId == -1) {
                error.setErrNo(2);
                error.setMessage("添加活动失败");
            } else {
                error.setErrNo(0);
                error.setMessage("添加活动成功");
                response.setActivity_id(activityId);
            }

        }
        return response;
    }

    @RequestMapping(value = "/post/invite", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse inviteUser(@RequestBody InviteUserView inviteUserView) {
        JSONResponse error = new JSONResponse();
        if (validate(inviteUserView, error)) {
            /* Check user token.*/
            int userId = tokenService.getUserId(inviteUserView.getToken());
            if (userId == -1) {
                /* Token error.*/
                error.setErrNo(1);
                error.setMessage("用户Token错误");
                return error;
            }

            /* User checked. Now check activity.*/
            int activityId = inviteUserView.getActivity_id();
            ActivityBean activityBean = activityService.getActivity(activityId);
            if (activityBean == null) {
                error.setErrNo(2);
                error.setMessage("活动不存在");
                return error;
            }

            /* Activity checked. Check invited users.*/
            boolean hasFailure = false;
            for (int id : inviteUserView.getInvites()) {
                UserBean userBean = userService.getUserById(id);
                if (userBean == null || !activityService.inviteFriend(id)) {
                    hasFailure = true;
                }
            }

            /* Invite action succeed.*/
            if (hasFailure) {
                error.setErrNo(3);
                error.setMessage("部分好友邀请失败");
            } else {
                error.setErrNo(0);
                error.setMessage("好友邀请成功");
            }

        }
        return error;
    }

    @RequestMapping(value = "/post/time_location", method = RequestMethod.POST)
    public
    @ResponseBody
    TimeLocationResponse addTimeLocation(@RequestBody TimeLocationView timeLocationView) {
        TimeLocationResponse response = new TimeLocationResponse();
        JSONResponse error = new JSONResponse();
        response.setError(error);
        if (validate(timeLocationView, error)) {
            /* Check user token.*/
            int userId = tokenService.getUserId(timeLocationView.getToken());
            if (userId == -1) {
                /* Token error.*/
                error.setErrNo(1);
                error.setMessage("用户Token错误");
                return response;
            }

            /* User checked. Now check activity.*/
            int activityId = timeLocationView.getActivity_id();
            ActivityBean activityBean = activityService.getActivity(activityId);
            if (activityBean == null) {
                error.setErrNo(2);
                error.setMessage("活动不存在");
                return response;
            }

            /* Activity checked. Do create action tip.*/
            ActivityTipBean activityTipBean = new ActivityTipBean();
            activityTipBean.setLongitude(timeLocationView.getLocation().getLongitude());
            activityTipBean.setLatitude(timeLocationView.getLocation().getLongitude());
            activityTipBean.setLocation(timeLocationView.getLocation().getPlace());
            activityTipBean.setStartDatetime(Timestamp.valueOf(timeLocationView.getTime().getStart_time()));
            activityTipBean.setEndDatetime(Timestamp.valueOf(timeLocationView.getTime().getEnd_time()));
            activityTipBean.setUserId(userId);
            activityTipBean.setActivityId(activityId);

            int tipId = activityService.createActivityTip(activityTipBean);
            if (tipId == -1) {
                /* Failed.*/
                error.setErrNo(3);
                error.setMessage("创建活动建议失败");
                return response;
            } else {
                /* Succeeded.*/
                error.setErrNo(0);
                error.setMessage("创建活动建议成功");
            }
        }
        return response;
    }

    @RequestMapping(value = "/post/photo", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse addPhoto(@RequestBody ActivityPhotoView activityPhotoView) {
        JSONResponse error = new JSONResponse();
        if (validate(activityPhotoView, error)) {
            /* Check user token.*/
            int userId = tokenService.getUserId(activityPhotoView.getToken());
            if (userId == -1) {
                /* Token error.*/
                error.setErrNo(1);
                error.setMessage("用户Token错误");
                return error;
            }

            /* User checked. Now check activity.*/
            int activityId = activityPhotoView.getActivity_id();
            ActivityBean activityBean = activityService.getActivity(activityId);
            if (activityBean == null) {
                error.setErrNo(2);
                error.setMessage("活动不存在");
                return error;
            }

            /* Activity checked. Do create resource.*/
            ResourceBean resourceBean = new ResourceBean();
            resourceBean.setResId(activityId);
            resourceBean.setResType(0);
            resourceBean.setUrl(activityPhotoView.getUrl());

            int resId = resourceService.createResource(resourceBean);
            if (resId == -1) {
                /* Failed*/
                error.setErrNo(3);
                error.setMessage("资源储存失败");
            } else {
                /* Succeeded*/
                error.setErrNo(0);
                error.setMessage("资源储存成功");
            }
        }
        return error;
    }

    @RequestMapping(value = "/post/vote", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse vote(@RequestBody VoteView voteView) {
        JSONResponse error = new JSONResponse();
        if (validate(voteView, error)) {
            /* Check user token.*/
            int userId = tokenService.getUserId(voteView.getToken());
            if (userId == -1) {
                /* Token error.*/
                error.setErrNo(1);
                error.setMessage("用户Token错误");
                return error;
            }

            /* User checked. Now check activity.*/
            int tipId = voteView.getTime_location_id();
            ActivityTipBean activityTipBean = activityService.getActionTip(tipId);
            if (activityTipBean == null) {
                /* Tip does not exist.*/
                error.setErrNo(2);
                error.setMessage("活动建议不存在");
            } else {
                activityService.voteForActivityTip(activityTipBean);
                error.setErrNo(0);
                error.setMessage("活动建议投票成功");
            }
        }
        return error;
    }

    @RequestMapping(value = "/post/decide", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse decide(@RequestBody DecideView decideView) {
        JSONResponse error = new JSONResponse();
        if (validate(decideView, error)) {
            /* Check user token.*/
            int userId = tokenService.getUserId(decideView.getToken());
            if (userId == -1) {
                /* Token error.*/
                error.setErrNo(1);
                error.setMessage("用户Token错误");
                return error;
            }

            /* User checked. Check activity tip.*/
            int tipId = decideView.getTime_location_id();
            ActivityTipBean activityTipBean = activityService.getActionTip(tipId);
            if (activityTipBean == null) {
                /* Tip does not exist.*/
                error.setErrNo(2);
                error.setMessage("活动建议不存在");
                return error;
            }
            int activityId = activityTipBean.getActivityId();

            /* Do decide.*/
            ActivityBean activityBean = activityService.getActivity(activityId);
            boolean succeed = activityService.setFinalActivityTip(activityBean, tipId);
            if (succeed) {
                error.setErrNo(0);
                error.setMessage("活动时间地点设置成功");
            } else {
                error.setErrNo(3);
                error.setMessage("活动时间地点设置失败");
            }
        }
        return error;
    }

    @RequestMapping(value = "/post/reply_invite", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse reply(@RequestBody ReplyInviteView replyInviteView) {
        JSONResponse error = new JSONResponse();
        if (validate(replyInviteView, error)) {
            /* Check user token.*/
            int userId = tokenService.getUserId(replyInviteView.getToken());
            if (userId == -1) {
                /* Token error.*/
                error.setErrNo(1);
                error.setMessage("用户Token错误");
                return error;
            }



            /* Do decide.*/
        }
        return error;
    }


    @RequestMapping(value = "/get/activity", method = RequestMethod.POST)
    public
    @ResponseBody
    ActivityResponse getActivity(@RequestBody GetActivityView getActivityView) {
        ActivityResponse response = new ActivityResponse();
        JSONResponse error = new JSONResponse();
        response.setError(error);
        if (validate(getActivityView, error)) {
            //TODO: tzy
        }
        return response;
    }


    @RequestMapping(value = "/get/list/all", method = RequestMethod.POST)
    public
    @ResponseBody
    ActivityListResponse getAllActivityList(@RequestBody GetActivityListView getActivityListView) {
        ActivityListResponse response = new ActivityListResponse();
        JSONResponse error = new JSONResponse();
        response.setError(error);
        if (validate(getActivityListView, error)) {
            //TODO: tzy
        }
        return response;
    }


    @RequestMapping(value = "/get/list/ongoing", method = RequestMethod.POST)
    public
    @ResponseBody
    ActivityListResponse getOngoingActivityList(@RequestBody GetActivityListView getActivityListView) {
        ActivityListResponse response = new ActivityListResponse();
        JSONResponse error = new JSONResponse();
        response.setError(error);
        if (validate(getActivityListView, error)) {
            //TODO: tzy
        }
        return response;
    }


    @RequestMapping(value = "/get/list/finished", method = RequestMethod.POST)
    public
    @ResponseBody
    ActivityListResponse getFinishedActivityList(@RequestBody GetActivityListView getActivityListView) {
        ActivityListResponse response = new ActivityListResponse();
        JSONResponse error = new JSONResponse();
        response.setError(error);
        if (validate(getActivityListView, error)) {
            //TODO: tzy
        }
        return response;
    }


    public void setActivityService(ActivityServiceImpl activityService) {
        this.activityService = activityService;
    }

    public void setTokenService(TokenServiceImpl tokenService) {
        this.tokenService = tokenService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void setResourceService(ResourceServiceImpl resourceService) {
        this.resourceService = resourceService;
    }
}
