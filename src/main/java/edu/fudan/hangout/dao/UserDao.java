package edu.fudan.hangout.dao;

import edu.fudan.hangout.bean.User;

/**
 * Created by Tong on 06.15.
 */
public interface UserDao {
    boolean createUser(User user);

    boolean deleteUser(User user);

    boolean updateUser(User user);

    User getUserById(String id);
}
