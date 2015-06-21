package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.SessionManager;
import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.bean.UserLogBean;
import edu.fudan.hangout.dao.UserLogDao;
import edu.fudan.hangout.util.QueryListWrapper;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Tong on 06.17.
 */


public class UserLogDaoImpl implements UserLogDao {
    private SessionManager sessionManager;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory sessionFactory;

    public UserLogDaoImpl() {

    }


    @Override
    public boolean createUserLog(UserLogBean userLogBean) {
        Session session = sessionManager.getSession();
        Transaction tx = session.beginTransaction();
        session.save(userLogBean);
        tx.commit();
        sessionManager.close(session);
        return true;
    }

    @Override
    public boolean deleteUserLog(UserBean userBean) {
        return false;
    }

    @Override
    public boolean updateUserLog(UserLogBean userBean) {
        Session session = sessionManager.getSession();
        Transaction tx = session.beginTransaction();
        session.update(userBean);
        tx.commit();
        sessionManager.close(session);
        return true;
    }


    @Override
    public UserLogBean getUserLog(int id) {
        Session session = sessionManager.getSession();
        session.beginTransaction();
        SQLQuery query = session.createSQLQuery("SELECT * FROM user_log l WHERE l.user_id=" + id).addEntity(UserLogBean.class);
        List result = query.list();
        sessionManager.close(session);
        return (UserLogBean) QueryListWrapper.from(result);
    }

    @Override
    public UserLogBean findUserLogByToken(String token) {
        Session session = sessionManager.getSession();
        session.beginTransaction();
        SQLQuery query = session.createSQLQuery("SELECT * FROM user_log l WHERE l.token=\'" + token + "\'").addEntity(UserLogBean.class);
        List result = query.list();
        sessionManager.close(session);
        return (UserLogBean) QueryListWrapper.from(result);
    }


    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
