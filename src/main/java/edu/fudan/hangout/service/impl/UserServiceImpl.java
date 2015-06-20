package edu.fudan.hangout.service.impl;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.dao.impl.UserDaoImpl;
import edu.fudan.hangout.service.UserService;

import java.util.List;

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

    @Override
    public boolean updateUser(UserBean userBean) {
        return userDao.updateUser(userBean);
    }

    @Override
    public List<Integer> searchUsers(int userId, String query) {
        return userDao.findUsers(userId, query);
    }

    @Override
    public List<Integer> searchUsersByContacts(int userId, String[] phones) {
        /* Parse phone string.*/
        String phoneString = "(";
        for (String phone : phones) {
            phoneString += "'"+phone + "',";
        }
        phoneString = phoneString.substring(0, phoneString.length() - 1) + ")";
        return userDao.findUsersByPhone(userId, phoneString);
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public UserDaoImpl getUserDao() {
        return userDao;
    }
}