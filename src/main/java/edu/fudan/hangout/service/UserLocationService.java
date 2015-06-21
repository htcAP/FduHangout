package edu.fudan.hangout.service;

import edu.fudan.hangout.bean.UserLocationBean;

/**
 * Created by Tong on 06.21.
 */
public interface UserLocationService {
    boolean createOrUpdateUserLocationEntry(UserLocationBean userLocationBean);

    UserLocationBean findUserLocationEntry(int userId);
}
