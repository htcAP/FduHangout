package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.SessionManager;
import edu.fudan.hangout.bean.ActivityBean;
import edu.fudan.hangout.dao.ActivityDao;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Tong on 06.18.
 */
public class ActivityDaoImpl implements ActivityDao {
    private SessionFactory sessionFactory;
    private SessionManager sessionManager;

    @Override
    public int createActivity(ActivityBean activityBean) {
        Session session = sessionManager.getSession();
        Transaction tx = session.beginTransaction();
        Object o = session.save(activityBean);
        tx.commit();

        sessionManager.close(session);
        return (Integer) o;
    }

    @Override
    public boolean deleteActivity(int id) {
        return false;
    }

    @Override
    public boolean updateActivity(ActivityBean activityBean) {
        Session session = sessionManager.getSession();
        Transaction tx = session.beginTransaction();
        session.update(activityBean);
        tx.commit();

        sessionManager.close(session);
        return true;
    }

    @Override
    public ActivityBean getActivity(int id) {
        Session session = sessionManager.getSession();
        session.beginTransaction();

        ActivityBean activityBean = session.get(ActivityBean.class, id);
        sessionManager.close(session);
        return activityBean;
    }

    @Override
    public List<Integer> findOnGoingActivityStatus(int userId) {
        Session session = sessionManager.getSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT a.id FROM activity a  JOIN activity_response r  JOIN activity_tip t " +
                "ON a.final_tip=t.id WHERE t.end_datetime>NOW() AND NOW()>t.start_datetime AND r.user_id = " + userId + " AND r.status = 1 AND r.activity_id = a.id");
        List list = sqlQuery.list();
        sessionManager.close(session);
        return list;
    }

    @Override
    public List<Integer> findUserFriendsActivityIds(int userId) {
        Session session = sessionManager.getSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT DISTINCT ar.activity_id FROM  activity_response ar  JOIN activity_tip t JOIN friendship a \n" +
                "WHERE ar.status = 1 AND a.user_id=" + userId + " AND exists(SELECT * FROM friendship b WHERE b.user_id=ar.user_id AND b.friend_id=" + userId + ")\n");
        List list = sqlQuery.list();
        sessionManager.close(session);
        return list;
    }

    @Override
    public List<Integer> findUnStartedActivityStatus(int userId) {
        Session session = sessionManager.getSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT a.id FROM activity a JOIN activity_response r JOIN activity_tip t " +
                "ON a.final_tip=t.id WHERE NOW()<t.start_datetime AND r.user_id = " + userId + " AND r.status = 1 AND r.activity_id = a.id");

        List list = sqlQuery.list();
        sessionManager.close(session);
        return list;
    }

    @Override
    public List<Integer> findUserActivityStatus(int userId) {
        Session session = sessionManager.getSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT a.id\n" +
                "FROM activity a JOIN activity_response r\n" +
                "WHERE  r.user_id = " + userId + " AND r.status = 1 AND r.activity_id = a.id");
        List list = sqlQuery.list();
        sessionManager.close(session);
        return list;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
