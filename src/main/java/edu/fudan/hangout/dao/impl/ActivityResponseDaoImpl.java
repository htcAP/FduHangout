package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.bean.ActivityResponseBean;
import edu.fudan.hangout.dao.ActivityResponseDao;
import org.hibernate.SessionFactory;

/**
 * Created by Tong on 06.18.
 */
public class ActivityResponseDaoImpl implements ActivityResponseDao {
    private SessionFactory sessionFactory;

    @Override
    public int createActivityResponse(ActivityResponseBean activityResponseBean) {
        return 0;
    }

    @Override
    public boolean deleteActivityResponse(int id) {
        return false;
    }

    @Override
    public boolean updateActivityResponse(ActivityResponseBean activityResponseBean) {
        return false;
    }

    @Override
    public ActivityResponseBean getActivityResponse(int userId, int activityId) {
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
