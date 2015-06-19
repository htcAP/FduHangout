package edu.fudan.hangout.dao.impl;

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

    @Override
    public int createActivity(ActivityBean activityBean) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Object o = session.save(activityBean);
        tx.commit();
        session.close();
        return (Integer) o;
    }

    @Override
    public boolean deleteActivity(int id) {
        return false;
    }

    @Override
    public boolean updateActivity(ActivityBean activityBean) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(activityBean);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public ActivityBean getActivity(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.close();
        return session.get(ActivityBean.class, id);
    }

    @Override
    public List<Integer> findOnGoingActivityStatus(int userId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT a.id FROM activity a  JOIN activity_response r  JOIN activity_tip t " +
                "ON a.final_tip=t.id WHERE t.end_datetime>NOW() AND NOW()>t.start_datetime AND r.user_id = " + userId + " AND r.status = 1 AND r.activity_id = a.id");
        session.close();
        return sqlQuery.list();
    }

    @Override
    public List<Integer> findFinishedActivityStatus(int userId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT a.id FROM activity a  JOIN activity_response r  JOIN activity_tip t " +
                "ON a.final_tip=t.id WHERE NOW()>t.end_datetime AND r.user_id = " + userId + " AND r.status = 1 AND r.activity_id = a.id");
        session.close();
        return sqlQuery.list();
    }

    @Override
    public List<Integer> findUnStartedActivityStatus(int userId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT a.id FROM activity a JOIN activity_response r JOIN activity_tip t " +
                "ON a.final_tip=t.id WHERE NOW()<t.start_datetime AND r.user_id = " + userId + " AND r.status = 1 AND r.activity_id = a.id");
        session.close();
        return sqlQuery.list();
    }

    @Override
    public List<Integer> findOrganizingActivityStatus(int userId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT a.id\n" +
                "FROM activity a JOIN activity_response r\n" +
                "WHERE (a.join_deadline > NOW() OR a.final_tip IS NOT NULL) AND r.user_id = " + userId + " AND r.status = 1 AND r.activity_id = a.id");
        session.close();
        return sqlQuery.list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
