package edu.fudan.hangout.service.impl;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.dao.impl.UserDaoImpl;
import edu.fudan.hangout.service.SignupService;

/**
 * Created by Tong on 06.17.
 */
public class SignupServiceImpl1 implements SignupService {
    private UserDaoImpl userDao;

    @Override
    public int signup(UserBean userBean) {
        return userDao.createUser(userBean);
    }

    @Override
    public void update(UserBean userBean) {
        userDao.updateUser(userBean);
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

}
