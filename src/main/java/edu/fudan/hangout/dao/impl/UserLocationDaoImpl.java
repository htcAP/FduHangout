package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.SessionManager;
import edu.fudan.hangout.bean.UserLocationBean;
import edu.fudan.hangout.dao.UserLocationDao;
import edu.fudan.hangout.util.QueryListWrapper;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Tong on 06.21.
 */
public class UserLocationDaoImpl implements UserLocationDao {
    private SessionManager sessionManager;

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public boolean saveUserLocation(UserLocationBean userLocationBean) {
        Session session = sessionManager.getSession();
        Transaction tx = session.beginTransaction();
        session.save(userLocationBean);
        tx.commit();
        sessionManager.close(session);
        return true;
    }

    @Override
    public boolean updateUserLocation(double lat, double lon, int userId) {
        Session session = sessionManager.getSession();
        Transaction tx = session.beginTransaction();
        session.createSQLQuery("UPDATE user_location SET latitude = "+lat+" , longitude="+lon+" WHERE user_id=" + userId).executeUpdate();
        tx.commit();
        sessionManager.close(session);
        return true;
    }


    @Override
    public UserLocationBean findUserLocation(int userId) {
        Session session = sessionManager.getSession();
        List list = session.createSQLQuery("SELECT * FROM user_location WHERE user_id=" + userId).addEntity(UserLocationBean.class).list();
        sessionManager.close(session);
        return (UserLocationBean) QueryListWrapper.from(list);
    }
}
