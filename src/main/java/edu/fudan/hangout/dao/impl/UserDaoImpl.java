package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.dao.UserDao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Created by Tong on 06.15.
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {


    @Override
    public boolean createUser(UserBean user) {
        return false;
    }

    @Override
    public boolean deleteUser(UserBean user) {
        return false;
    }

    @Override
    public boolean updateUser(UserBean user) {
        return false;
    }

    @Override
    public UserBean getUserById(String id) {
        getSession().get("user", id);
        return null;
    }
}
