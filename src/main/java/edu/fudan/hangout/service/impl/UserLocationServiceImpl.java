package edu.fudan.hangout.service.impl;

import edu.fudan.hangout.bean.UserLocationBean;
import edu.fudan.hangout.dao.impl.UserLocationDaoImpl;
import edu.fudan.hangout.service.UserLocationService;

/**
 * Created by Tong on 06.21.
 */
public class UserLocationServiceImpl implements UserLocationService {
    private UserLocationDaoImpl userLocationDao;

    public void setUserLocationDao(UserLocationDaoImpl userLocationDao) {
        this.userLocationDao = userLocationDao;
    }

    @Override
    public boolean createUserLocationEntry(UserLocationBean userLocationBean) {
        return userLocationDao.saveUserLocation(userLocationBean);
    }

    @Override
    public boolean updateUserLocationEntry(double lat, double lon, int userId) {
        return userLocationDao.updateUserLocation(lat, lon, userId);
    }

    @Override
    public UserLocationBean findUserLocationEntry(int userId) {
        return userLocationDao.findUserLocation(userId);
    }
}
