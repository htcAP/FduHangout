package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.SessionManager;
import edu.fudan.hangout.bean.ActivityResponseBean;
import edu.fudan.hangout.dao.ActivityResponseDao;
import edu.fudan.hangout.util.QueryListWrapper;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Tong on 06.18.
 */
public class ActivityResponseDaoImpl implements ActivityResponseDao {
    private SessionFactory sessionFactory;
    private SessionManager sessionManager;

    @Override
    public int createActivityResponse(ActivityResponseBean activityResponseBean) {
        Session session = sessionManager.getSession();
        Transaction tx = session.beginTransaction();
        Object o = session.save(activityResponseBean);
        tx.commit();
        sessionManager.close(session);

        return (Integer) o;
    }

    @Override
    public boolean deleteActivityResponse(int id) {
        return false;
    }

    @Override
    public boolean updateActivityResponse(ActivityResponseBean activityResponseBean) {
        Session session = sessionManager.getSession();
        Transaction tx = session.beginTransaction();
        session.update(activityResponseBean);
        tx.commit();
        sessionManager.close(session);

        return true;
    }

    @Override
    public ActivityResponseBean findActivityResponse(int userId, int activityId) {
        Session session = sessionManager.getSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM activity_response ar WHERE ar.user_id=" + userId + " AND ar.activity_id=" + activityId);
        sqlQuery.addEntity(ActivityResponseBean.class);
        List list = sqlQuery.list();
        sessionManager.close(session);

        return (ActivityResponseBean) QueryListWrapper.from(list);
    }

    @Override
    public List<ActivityResponseBean> findActivityResponses(int activityId) {
        Session session = sessionManager.getSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM activity_response ar WHERE ar.activity_id=" + activityId).addEntity(ActivityResponseBean.class);

        List list = sqlQuery.list();
        sessionManager.close(session);
        return list;
    }

    @Override
    public ActivityResponseBean getActivityResponse(int id) {
        return null;
    }

    @Override
    public List<Integer> findUserActivities() {
        Session session = sessionManager.getSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT a.id FROM activity a");

        List list = sqlQuery.list();
        sessionManager.close(session);
        return list;
    }

    @Override
    public List<Integer> findUserActivityRequests(int userId) {
        Session session = sessionManager.getSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT a.activity_id FROM activity_response a WHERE a.user_id=" + userId + " AND a.status=0");

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
