package edu.fudan.hangout.view.response;

/**
 * Created by lifengshuang on 6/17/15.
 */
public class ImageUploadResponse {

    private JSONResponse error;

    private String url;

    public JSONResponse getError() {
        return error;
    }

    public void setError(JSONResponse error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
