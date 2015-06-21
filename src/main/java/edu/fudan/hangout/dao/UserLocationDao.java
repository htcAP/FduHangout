package edu.fudan.hangout.dao;

import edu.fudan.hangout.bean.UserLocationBean;

/**
 * Created by Tong on 06.21.
 */
public interface UserLocationDao {

    boolean saveOrUpdateUserLocation(UserLocationBean userLocationBean);

    UserLocationBean findUserLocation(int userId);
}
