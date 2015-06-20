package edu.fudan.hangout.controller;

import edu.fudan.hangout.view.request.position.GetPositionView;
import edu.fudan.hangout.view.request.position.PostPositionView;
import edu.fudan.hangout.view.response.GetPositionResponse;
import edu.fudan.hangout.view.response.JSONResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lifengshuang on 6/21/15.
 */

@Controller
public class PositionController extends BaseController{

    @RequestMapping(value = "/position/post", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse postPosition(PostPositionView postPositionView){
        JSONResponse response = new JSONResponse();
        if (validate(postPositionView, response)){

        }
        return response;
    }

    @RequestMapping(value = "/position/get", method = RequestMethod.POST)
    public
    @ResponseBody
    GetPositionResponse getPosition(GetPositionView getPositionView) {
        GetPositionResponse response = new GetPositionResponse();
        JSONResponse error = new JSONResponse();
        response.setError(error);
        if (validate(getPositionView, error)) {

        }
        return response;
    }

}
