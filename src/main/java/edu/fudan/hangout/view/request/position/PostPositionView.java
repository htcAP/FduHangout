package edu.fudan.hangout.view.request.position;

import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/21/15.
 */
public class PostPositionView {

    @NotNull(message = "100|缺少token字段")
    private String token;

    @NotNull(message = "101|缺少latitude字段")
    private Double latitude;

    @NotNull(message = "102|缺少longitude字段")
    private Double longitude;

    @NotNull(message = "103|缺少time字段")
    private Integer time;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
