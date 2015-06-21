package edu.fudan.hangout.controller;

import edu.fudan.hangout.bean.ActivityResponseBean;
import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.bean.UserLocationBean;
import edu.fudan.hangout.service.impl.ActivityServiceImpl;
import edu.fudan.hangout.service.impl.TokenServiceImpl;
import edu.fudan.hangout.service.impl.UserLocationServiceImpl;
import edu.fudan.hangout.service.impl.UserServiceImpl;
import edu.fudan.hangout.view.request.position.GetPositionView;
import edu.fudan.hangout.view.request.position.PostPositionView;
import edu.fudan.hangout.view.response.GetPositionResponse;
import edu.fudan.hangout.view.response.JSONResponse;
import edu.fudan.hangout.view.response.PositionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lifengshuang on 6/21/15.
 */

@Controller
public class PositionController extends BaseController {
    @Autowired
    UserLocationServiceImpl userLocationService;

    public void setTokenService(TokenServiceImpl tokenService) {
        this.tokenService = tokenService;
    }

    public void setUserLocationService(UserLocationServiceImpl userLocationService) {
        this.userLocationService = userLocationService;
    }

    @Autowired
    TokenServiceImpl tokenService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Autowired
    UserServiceImpl userService;

    public void setActivityService(ActivityServiceImpl activityService) {
        this.activityService = activityService;
    }

    @Autowired
    ActivityServiceImpl activityService;


    @RequestMapping(value = "/position/post", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse postPosition(PostPositionView postPositionView) {
        JSONResponse error = new JSONResponse();
        if (validate(postPositionView, error)) {
            /* Check user token.*/
            int userId = tokenService.getUserId(postPositionView.getToken());
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

            UserLocationBean userLocationBean = new UserLocationBean();
            userLocationBean.setId(userId);
            userLocationBean.setLatitude(postPositionView.getLatitude());
            userLocationBean.setLongitude(postPositionView.getLongitude());
            userLocationBean.setTimestamp(new Timestamp(postPositionView.getTime()));
            boolean succeeded = userLocationService.createOrUpdateUserLocationEntry(userLocationBean);

            if (!succeeded) {
                /* Failed*/
                error.setErrNo(3);
                error.setMessage("写入用户位置失败");
            } else {
                error.setErrNo(0);
                error.setMessage("写入用户位置成功");
            }
        }
        return error;
    }

    @RequestMapping(value = "/position/get", method = RequestMethod.POST)
    public
    @ResponseBody
    GetPositionResponse getPosition(GetPositionView getPositionView) {
        GetPositionResponse response = new GetPositionResponse();
        JSONResponse error = new JSONResponse();
        response.setError(error);
        if (validate(getPositionView, error)) {
            /* Check user token.*/
            int userId = tokenService.getUserId(getPositionView.getToken());
            if (userId == -1) {
                /* Token error.*/
                error.setErrNo(1);
                error.setMessage("用户Token错误");
                return response;
            }

            List<ActivityResponseBean> activityResponseBeanList = activityService.getActivityResponses(getPositionView.getActivity_id());
            List<PositionResponse> positionResponseList = new LinkedList<>();
            boolean hasFailure=false;
            for (ActivityResponseBean activityResponseBean : activityResponseBeanList) {
                if (activityResponseBean.getStatus() == 1) {
                    PositionResponse positionResponse = new PositionResponse();

                    int id = activityResponseBean.getUserId();
                    UserLocationBean userLocationBean = userLocationService.findUserLocationEntry(id);

                    UserBean userBean = userService.getUserById(id);
                    if (userBean == null || userLocationBean == null) {
                        hasFailure = true;
                        continue;
                    }

                    positionResponse.setUser_id(id);
                    positionResponse.setLatitude(userLocationBean.getLatitude());
                    positionResponse.setLongitude(userLocationBean.getLongitude());
                    positionResponse.setPhotoURL("");
                    positionResponse.setUsername(userBean.getUsername());

                    positionResponseList.add(positionResponse);
                }
            }

            PositionResponse[] positionResponses = positionResponseList.toArray(new PositionResponse[positionResponseList.size()]);

            if (hasFailure) {
                /* Failed*/
                error.setErrNo(3);
                error.setMessage("读入部分用户位置失败");
                response.setPositions(positionResponses);
            } else {
                error.setErrNo(0);
                error.setMessage("读入用户位置成功");
                response.setPositions(positionResponses);
            }
        }
        return response;
    }

}
