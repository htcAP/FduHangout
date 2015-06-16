package edu.fudan.hangout.service.impl;

import edu.fudan.hangout.dao.impl.UserDaoImpl;

/**
 * Created by Tong on 06.16.
 */
public class LoginServiceImpl {
    private UserDaoImpl userDao;

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public UserDaoImpl getUserDao() {
        return userDao;
    }
}
