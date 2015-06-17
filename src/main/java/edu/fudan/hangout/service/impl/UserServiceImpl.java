package edu.fudan.hangout.service.impl;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.dao.impl.UserDaoImpl;
import edu.fudan.hangout.service.UserService;

/**
 * Created by Tong on 06.17.
 */
public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao;

    @Override
    public UserBean getUserById(int id) {
        return userDao.getUser(id);
    }

    @Override
    public UserBean getUserByPhone(String phone) {

        return userDao.findUser("phone", phone);
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public UserDaoImpl getUserDao() {
        return userDao;
    }
}