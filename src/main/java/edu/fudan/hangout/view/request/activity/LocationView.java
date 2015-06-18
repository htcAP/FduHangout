package edu.fudan.hangout.view.request.activity;

import javax.validation.constraints.NotNull;

/**
 * Created by lifengshuang on 6/17/15.
 */
public class LocationView {

    @NotNull(message = "110|缺少location.place字段")
    private String place;

    @NotNull(message = "111|缺少location.latitude字段")
    private double latitude;

    @NotNull(message = "112|缺少location.longitude字段")
    private double longitude;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
