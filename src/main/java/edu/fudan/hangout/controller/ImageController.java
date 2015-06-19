package edu.fudan.hangout.controller;

import edu.fudan.hangout.view.request.image.ImageView;
import edu.fudan.hangout.view.response.ImageUploadResponse;
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
public class ImageController extends BaseController {

    @RequestMapping(value = "/image/upload", method = RequestMethod.POST)
    public
    @ResponseBody
    ImageUploadResponse uploadImage(@RequestBody ImageView imageView) {
        ImageUploadResponse response = new ImageUploadResponse();
        JSONResponse error = new JSONResponse();
        response.setError(error);
        if (validate(imageView, error)) {

        }
        return response;
    }

}
