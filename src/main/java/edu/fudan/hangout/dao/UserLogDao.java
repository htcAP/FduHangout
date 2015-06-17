package edu.fudan.hangout.dao;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.bean.UserLogBean;

/**
 * Created by Tong on 06.17.
 */
public interface UserLogDao {

    boolean createUserLog(UserBean userBean);

    boolean deleteUserLog(UserBean userBean);

    boolean updateUserLog(UserBean userBean);

    UserLogBean getUserLog(int id);
}
