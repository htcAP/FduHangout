package edu.fudan.hangout.service.impl;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.bean.UserLogBean;
import edu.fudan.hangout.dao.impl.UserDaoImpl;
import edu.fudan.hangout.dao.impl.UserLogDaoImpl;
import edu.fudan.hangout.service.LoginService;
import edu.fudan.hangout.util.SHA1Hasher;

/**
 * Created by Tong on 06.16.
 */
public class LoginServiceImpl implements LoginService {
    private UserDaoImpl userDao;
    private UserLogDaoImpl userLogDao;

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public UserDaoImpl getUserDao() {
        return userDao;
    }

    @Override
    public String login(UserBean user) {
        UserLogBean userLog = userLogDao.getUserLog(user.getId());
        if (userLog == null) {
            /*Create a new log for the user.*/
            String tokenString = user.getId() + "." + System.currentTimeMillis();

            UserLogBean logBean = new UserLogBean();
            logBean.setUserId(user.getId());
            logBean.setToken(SHA1Hasher.makeSHA1Hash(tokenString));
            userLogDao.createUserLog(logBean);

            /* Get user log.*/
            userLog = userLogDao.getUserLog(user.getId());
        }
        /*The user has already in the log database, return the token.*/
        return userLog.getToken();
    }

    public void setUserLogDao(UserLogDaoImpl userLogDao) {
        this.userLogDao = userLogDao;
    }

    public UserLogDaoImpl getUserLogDao() {
        return userLogDao;
    }
}
