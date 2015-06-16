package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.bean.User;
import edu.fudan.hangout.dao.UserDao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by Tong on 06.15.
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {


    @Override
    public boolean createUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public User getUserById(String id) {
        String hqlString = "from Users user where user.id = ?";
        List result = this.getHibernateTemplate().find(hqlString, id);
        return null;
    }
}
