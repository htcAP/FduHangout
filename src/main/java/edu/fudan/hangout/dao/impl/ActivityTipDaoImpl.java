package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.SessionManager;
import edu.fudan.hangout.bean.ActivityTipBean;
import edu.fudan.hangout.dao.ActivityTipDao;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Tong on 06.18.
 */
public class ActivityTipDaoImpl implements ActivityTipDao {
    private SessionFactory sessionFactory;
    private SessionManager sessionManager;

    @Override
    public int createActivityTip(ActivityTipBean activityTipBean) {
        Session session = sessionManager.getSession();
        Transaction tx = session.beginTransaction();
        Object o = session.save(activityTipBean);
        tx.commit();

        sessionManager.close(session);
        return (Integer) o;
    }

    @Override
    public boolean deleteActivityTip(int id) {
        return false;
    }

    @Override
    public boolean updateActivityTip(ActivityTipBean activityTipBean) {
        Session session = sessionManager.getSession();
        Transaction tx = session.beginTransaction();
        session.update(activityTipBean);
        tx.commit();

        sessionManager.close(session);
        return true;
    }

    @Override
    public ActivityTipBean getActivityTip(int id) {
        Session session = sessionManager.getSession();
        session.beginTransaction();
        ActivityTipBean activityTipBean = session.get(ActivityTipBean.class, id);
        sessionManager.close(session);
        return activityTipBean;
    }

    @Override
    public List<Integer> findActivityTipIds(int activityId) {
        Session session = sessionManager.getSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT a.id FROM activity_tip a WHERE a.activity_id=" + activityId);

        List list = sqlQuery.addEntity(ActivityTipBean.class).list();
        sessionManager.close(session);
        return list;
    }

    @Override
    public int getHighestVotedTip(int activityId) {
        Session session = sessionManager.getSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT a.id FROM activity_tip a WHERE a.activity_id=" + activityId + " ORDER BY a.votes DESC LIMIT 1");
        List list = sqlQuery.list();
        sessionManager.close(session);
        return (list.isEmpty()) ? -1 : (Integer) list.get(0);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
