package edu.fudan.hangout.dao;

import edu.fudan.hangout.bean.UserBean;

import java.util.List;

/**
 * Created by Tong on 06.15.
 */
public interface UserDao {
    int createUser(UserBean user);

    boolean deleteUser(UserBean user);

    boolean updateUser(UserBean user);

    UserBean getUser(int id);

    UserBean findUser(String key, String value);

    List<Integer> findUsers(String query);
}
