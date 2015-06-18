package edu.fudan.hangout.service.impl;

import edu.fudan.hangout.bean.ActivityBean;
import edu.fudan.hangout.bean.ActivityTipBean;
import edu.fudan.hangout.dao.impl.ActivityDaoImpl;
import edu.fudan.hangout.dao.impl.ActivityResponseDaoImpl;
import edu.fudan.hangout.dao.impl.ActivityTipDaoImpl;
import edu.fudan.hangout.service.ActivityService;

/**
 * Created by Tong on 06.18.
 */
public class ActivityServiceImpl implements ActivityService {
    private ActivityDaoImpl activityDao;
    private ActivityTipDaoImpl activityTipDao;
    private ActivityResponseDaoImpl activityResponseDao;

    @Override
    public int createActivity(ActivityBean activityBean) {
        return 0;
    }

    @Override
    public ActivityBean getActivity(int id) {
        return null;
    }

    @Override
    public boolean inviteFriend(int userId) {
        return false;
    }

    @Override
    public int createActivityTip(ActivityTipBean activityTipBean) {
        return 0;
    }

    @Override
    public ActivityTipBean getActionTip(int id) {
        return null;
    }

    @Override
    public boolean voteForActivityTip(ActivityTipBean activityTipBean) {
        return false;
    }

    @Override
    public boolean setFinalActivityTip(ActivityBean activityBean, int tipId) {
        return false;
    }

    ActivityBean getActivityById(int id) {

        return null;
    }

    public void setActivityDao(ActivityDaoImpl activityDao) {
        this.activityDao = activityDao;
    }

    public void setActivityTipDao(ActivityTipDaoImpl activityTipDao) {
        this.activityTipDao = activityTipDao;
    }

    public void setActivityResponseDao(ActivityResponseDaoImpl activityResponseDao) {
        this.activityResponseDao = activityResponseDao;
    }
}
