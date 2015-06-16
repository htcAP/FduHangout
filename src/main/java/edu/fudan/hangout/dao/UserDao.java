package edu.fudan.hangout.dao;

import edu.fudan.hangout.bean.UserBean;

/**
 * Created by Tong on 06.15.
 */
public interface UserDao {
    boolean createUser(UserBean user);

    boolean deleteUser(UserBean user);

    boolean updateUser(UserBean user);

    UserBean getUserById(int id);
}
