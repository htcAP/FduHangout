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
    public boolean createOrUpdateUserLocationEntry(UserLocationBean userLocationBean) {
        return userLocationDao.saveOrUpdateUserLocation(userLocationBean);
    }

    @Override
    public UserLocationBean findUserLocationEntry(int userId) {
        return userLocationDao.findUserLocation(userId);
    }
}
