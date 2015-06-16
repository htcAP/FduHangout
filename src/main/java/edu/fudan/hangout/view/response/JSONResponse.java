package edu.fudan.hangout.view.response;

/**
 * Created by lifengshuang on 6/16/15.
 */
public class JSONResponse {
    private int ErrNo = 999;
    private String message = "后端忘记修改message";

    public int getErrNo() {
        return ErrNo;
    }

    public void setErrNo(int errNo) {
        ErrNo = errNo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
