package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.bean.UserLogBean;
import edu.fudan.hangout.dao.UserLogDao;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Tong on 06.17.
 */


public class UserLogDaoImpl extends CustomHibernateDaoSupport implements UserLogDao {
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory sessionFactory;

    public UserLogDaoImpl() {

    }

    @Override
    public boolean createUserLog(UserBean userBean) {
        return false;
    }

    @Override
    public boolean deleteUserLog(UserBean userBean) {
        return false;
    }

    @Override
    public boolean updateUserLog(UserBean userBean) {
        return false;
    }

    @Override
    public UserLogBean getUserLog(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery query = session.createSQLQuery("SELECT * FROM user_log l WHERE l.user_id=" + id).addEntity(UserLogBean.class);
        List result = query.list();
        return (UserLogBean) result.get(0);
    }
}
