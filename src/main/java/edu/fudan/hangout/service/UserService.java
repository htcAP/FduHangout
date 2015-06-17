package edu.fudan.hangout.service;

import edu.fudan.hangout.bean.UserBean;

/**
 * Created by Tong on 06.17.
 */
public interface UserService {
    UserBean getUserById(int id);

    UserBean getUserByPhone(String phone);
}
