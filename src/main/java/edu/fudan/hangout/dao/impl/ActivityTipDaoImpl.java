package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.bean.ActivityTipBean;
import edu.fudan.hangout.dao.ActiviyTipDao;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Tong on 06.18.
 */
public class ActivityTipDaoImpl implements ActiviyTipDao {
    private SessionFactory sessionFactory;

    @Override
    public int createActivityTip(ActivityTipBean activityTipBean) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Object o = session.save(activityTipBean);
        tx.commit();
        return (Integer) o;
    }

    @Override
    public boolean deleteActivityTip(int id) {
        return false;
    }

    @Override
    public boolean updateActivityTip(ActivityTipBean activityTipBean) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(activityTipBean);
        tx.commit();
        return true;
    }

    @Override
    public ActivityTipBean getActivityTip(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session.get(ActivityTipBean.class, id);
    }

    @Override
    public List<Integer> findActivityTipIds(int activityId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM activity_tip a WHERE a.activity_id=" + activityId);
        return sqlQuery.list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
