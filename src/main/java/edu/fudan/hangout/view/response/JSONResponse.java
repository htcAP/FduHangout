package edu.fudan.hangout.view.response;

/**
 * Created by lifengshuang on 6/16/15.
 */
public class JSONResponse {
    private int ErrNo;
    private String message;

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
