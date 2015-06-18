package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.bean.ActivityTipBean;
import edu.fudan.hangout.dao.ActiviyTipDao;
import org.hibernate.SessionFactory;

/**
 * Created by Tong on 06.18.
 */
public class ActivityTipDaoImpl implements ActiviyTipDao {
    private SessionFactory sessionFactory;

    @Override
    public int createActivityTip(ActivityTipBean activityTipBean) {
        return 0;
    }

    @Override
    public boolean deleteActivityTip(int id) {
        return false;
    }

    @Override
    public boolean updateActivityTip(ActivityTipBean activityTipBean) {
        return false;
    }

    @Override
    public ActivityTipBean getActivityTip(int id) {
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
