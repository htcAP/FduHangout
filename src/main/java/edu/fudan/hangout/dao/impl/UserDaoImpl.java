package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.dao.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by Tong on 06.15.
 */
public class UserDaoImpl extends CustomHibernateDaoSupport implements UserDao {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

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
    public UserBean getUserById(int id) {
        return (UserBean) session().get("user", id);
    }
}
