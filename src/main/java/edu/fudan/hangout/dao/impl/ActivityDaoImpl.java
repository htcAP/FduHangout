package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.bean.ActivityBean;
import edu.fudan.hangout.dao.ActivityDao;
import org.hibernate.SessionFactory;

/**
 * Created by Tong on 06.18.
 */
public class ActivityDaoImpl implements ActivityDao {
    private SessionFactory sessionFactory;

    @Override
    public int createActivity(ActivityBean activityBean) {
        return 0;
    }

    @Override
    public boolean deleteActivity(int id) {
        return false;
    }

    @Override
    public boolean updateActivity(ActivityBean activityBean) {
        return false;
    }

    @Override
    public ActivityBean getActivity(int id) {
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
