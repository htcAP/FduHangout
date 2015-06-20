package edu.fudan.hangout.view.response;

/**
 * Created by lifengshuang on 6/21/15.
 */
public class GetPositionResponse {

    private JSONResponse error;

    private PositionResponse[] positions;

    public JSONResponse getError() {
        return error;
    }

    public void setError(JSONResponse error) {
        this.error = error;
    }

    public PositionResponse[] getPositions() {
        return positions;
    }

    public void setPositions(PositionResponse[] positions) {
        this.positions = positions;
    }
}
