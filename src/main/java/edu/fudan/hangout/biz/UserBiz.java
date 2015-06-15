package edu.fudan.hangout.biz;

import edu.fudan.hangout.dao.UserDao;

/**
 * Created by Tong on 06.15.
 */
public class UserBiz {
    private UserDao userDao;

    public UserBiz() {
        userDao = new UserDao();
    }



}
