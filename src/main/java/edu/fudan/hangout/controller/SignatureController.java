package edu.fudan.hangout.controller;

import edu.fudan.hangout.view.request.user.SignatureRequest;
import edu.fudan.hangout.view.response.JSONResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lifengshuang on 6/18/15.
 */

@Controller
public class SignatureController extends BaseController {

    @RequestMapping(value = "/user/signature", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONResponse addActivity(@RequestBody SignatureRequest signatureRequest) {
        JSONResponse response = new JSONResponse();
        if (validate(signatureRequest, response)) {
            //TODO: tzy
        }
        return response;
    }

}
