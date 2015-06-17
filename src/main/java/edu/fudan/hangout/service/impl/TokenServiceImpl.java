package edu.fudan.hangout.service.impl;

import edu.fudan.hangout.bean.UserLogBean;
import edu.fudan.hangout.dao.impl.UserDaoImpl;
import edu.fudan.hangout.dao.impl.UserLogDaoImpl;
import edu.fudan.hangout.service.TokenService;

/**
 * Created by Tong on 06.17.
 */
public class TokenServiceImpl implements TokenService {
    private UserDaoImpl userDao;
    private UserLogDaoImpl userLogDao;

    @Override
    public int getUserId(String token) {
        UserLogBean logBean = userLogDao.findUserLogByToken(token);
        return (logBean == null) ? -1 : logBean.getUserId();
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public void setUserLogDao(UserLogDaoImpl userLogDao) {
        this.userLogDao = userLogDao;
    }
}
