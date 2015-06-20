package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.SessionManager;
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
    private SessionManager sessionManager;

    @Override
    public int createUser(UserBean user) {
        Session session = sessionManager.getSession();
        Transaction tx = session.beginTransaction();
        Object o = session.save(user);
        tx.commit();

        return (Integer) o;
    }

    @Override
    public boolean deleteUser(UserBean user) {
        return false;
    }

    @Override
    public boolean updateUser(UserBean user) {
        Session session = sessionManager.getSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();

        return true;
    }

    @Override
    public UserBean getUser(int id) {
        Session session = sessionManager.getSession();
        session.beginTransaction();

        return session.get(UserBean.class, id);
    }

    @Override
    public UserBean findUser(String key, String value) {
        Session session = sessionManager.getSession();
        session.beginTransaction();
        List result = session.createSQLQuery("SELECT * FROM user u WHERE  u." + key + "=" + value).addEntity(UserBean.class).list();

        return (UserBean) QueryListWrapper.from(result);
    }

    @Override
    public List<Integer> findUsers(String query) {
        Session session = sessionManager.getSession();
        session.beginTransaction();
        List result = session.createSQLQuery("SELECT u.id FROM user u WHERE find_in_set('" + query
                + "',u.phone)>=0 OR  find_in_set('" + query + "',u.username)>=0").list();

        return result;
    }

    @Override
    public List<Integer> findUsersByPhone(String query) {
        Session session = sessionManager.getSession();
        session.beginTransaction();
        List result = session.createSQLQuery("SELECT id FROM user WHERE phone in " + query).list();
        return result;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
