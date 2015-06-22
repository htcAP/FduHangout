package edu.fudan.hangout.service;

import edu.fudan.hangout.bean.UserLocationBean;

/**
 * Created by Tong on 06.21.
 */
public interface UserLocationService {
    boolean createUserLocationEntry(UserLocationBean userLocationBean);
    boolean updateUserLocationEntry(double lat, double lon, int userId);

    UserLocationBean findUserLocationEntry(int userId);
}
