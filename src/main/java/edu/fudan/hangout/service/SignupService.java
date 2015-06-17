package edu.fudan.hangout.service;

import edu.fudan.hangout.bean.UserBean;

/**
 * Created by Tong on 06.17.
 */
public interface SignupService {
    int signup(UserBean userBean);

    void update(UserBean userBean);
}
