package edu.fudan.hangout.dao;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.bean.UserLogBean;

/**
 * Created by Tong on 06.17.
 */
public interface UserLogDao {

    boolean createUserLog(UserLogBean userLogBean);

    boolean deleteUserLog(UserBean userBean);

    boolean updateUserLog(UserLogBean userBean);

    UserLogBean getUserLog(int id);

    UserLogBean findUserLogByToken(String token);
}
