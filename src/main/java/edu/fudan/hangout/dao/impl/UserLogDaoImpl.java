package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.bean.UserLogBean;
import edu.fudan.hangout.dao.UserLogDao;
import edu.fudan.hangout.util.DaoResultWrapper;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Tong on 06.17.
 */


public class UserLogDaoImpl implements UserLogDao {
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory sessionFactory;

    public UserLogDaoImpl() {

    }


    @Override
    public boolean createUserLog(UserLogBean userLogBean) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(userLogBean);
        tx.commit();
        return true;
    }

    @Override
    public boolean deleteUserLog(UserBean userBean) {
        return false;
    }

    @Override
    public boolean updateUserLog(UserLogBean userBean) {
        return false;
    }


    @Override
    public UserLogBean getUserLog(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery query = session.createSQLQuery("SELECT * FROM user_log l WHERE l.user_id=" + id).addEntity(UserLogBean.class);
        List result = query.list();
        return (UserLogBean) DaoResultWrapper.get(result);
    }

    @Override
    public UserLogBean findUserLogByToken(String token) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery query = session.createSQLQuery("SELECT * FROM user_log l WHERE l.token=" + token).addEntity(UserLogBean.class);
        List result = query.list();
        return (UserLogBean) DaoResultWrapper.get(result);
    }


}
