package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.dao.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


/**
 * Created by Tong on 06.15.
 */
public class UserDaoImpl extends CustomHibernateDaoSupport implements UserDao {

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
    public UserBean getUser(int id) {
        Session session = session();
        session.beginTransaction();
        return session.get(UserBean.class, id);
    }

    @Override
    public UserBean findUser(String key, String value) {
        Session session = sessionFactory.openSession();
        List results = session.createSQLQuery("SELECT * FROM user u WHERE  u." + key + "=" + value).addEntity(UserBean.class).list();
        return (UserBean)results.get(0);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
