package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.dao.UserDao;
import edu.fudan.hangout.util.QueryListWrapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


/**
 * Created by Tong on 06.15.
 */
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @Override
    public int createUser(UserBean user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Object o  = session.save(user);
        tx.commit();
        return (Integer) o;
    }

    @Override
    public boolean deleteUser(UserBean user) {
        return false;
    }

    @Override
    public boolean updateUser(UserBean user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        return true;
    }

    @Override
    public UserBean getUser(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session.get(UserBean.class, id);
    }

    @Override
    public UserBean findUser(String key, String value) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createSQLQuery("SELECT * FROM user u WHERE  u." + key + "=" + value).addEntity(UserBean.class).list();
        return (UserBean) QueryListWrapper.from(result);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
