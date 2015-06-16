package edu.fudan.hangout.controller;

import edu.fudan.hangout.view.response.JSONResponse;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by lifengshuang on 6/16/15.
 */
public class BaseController {
    protected static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    protected boolean validate(Object object, JSONResponse response) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
        if (constraintViolations.size() == 0) {
            return true;
        }
        else {
            int minErrNo = 999;
            for (ConstraintViolation violation : constraintViolations) {
                String message = violation.getMessage();
                int errNo = Integer.parseInt(message.substring(0, message.indexOf("|")));
                if (errNo < minErrNo) {
                    minErrNo = errNo;
                    response.setErrNo(errNo);
                    response.setMessage(message.substring(message.indexOf("|") + 1));
                }
                System.out.println(message);
            }

            return false;
        }
    }
}
