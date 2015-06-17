package edu.fudan.hangout.service.impl;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.dao.impl.UserDaoImpl;
import edu.fudan.hangout.dao.impl.UserLogDaoImpl;
import edu.fudan.hangout.service.LoginService;

/**
 * Created by Tong on 06.16.
 */
public class LoginServiceImpl implements LoginService{
    private UserDaoImpl userDao;
    private UserLogDaoImpl userLogDao;

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public UserDaoImpl getUserDao() {
        return userDao;
    }

    @Override
    public int login(UserBean user) {
        userLogDao.getUserLog(1);
        return 0;
    }

    public void setUserLogDao(UserLogDaoImpl userLogDao) {
        this.userLogDao = userLogDao;
    }

    public UserLogDaoImpl getUserLogDao() {
        return userLogDao;
    }
}
