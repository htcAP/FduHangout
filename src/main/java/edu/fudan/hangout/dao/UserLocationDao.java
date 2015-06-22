package edu.fudan.hangout.dao;

import edu.fudan.hangout.bean.UserLocationBean;

/**
 * Created by Tong on 06.21.
 */
public interface UserLocationDao {

    boolean saveUserLocation(UserLocationBean userLocationBean);
    boolean updateUserLocation(double lat, double lon, int userId);

    UserLocationBean findUserLocation(int userId);
}
