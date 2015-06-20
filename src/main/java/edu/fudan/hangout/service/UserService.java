package edu.fudan.hangout.service;

import edu.fudan.hangout.bean.UserBean;

import java.util.List;

/**
 * Created by Tong on 06.17.
 */
public interface UserService {
    UserBean getUserById(int id);

    UserBean getUserByPhone(String phone);

    boolean updateUser(UserBean userBean);

    List<Integer> searchUsers(String query);

    List<Integer> searchUsersByContacts(String[] phones);
}
