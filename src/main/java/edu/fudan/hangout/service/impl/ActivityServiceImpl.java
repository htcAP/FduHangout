package edu.fudan.hangout.service.impl;

import edu.fudan.hangout.bean.ActivityBean;
import edu.fudan.hangout.bean.ActivityResponseBean;
import edu.fudan.hangout.bean.ActivityTipBean;
import edu.fudan.hangout.dao.impl.ActivityDaoImpl;
import edu.fudan.hangout.dao.impl.ActivityResponseDaoImpl;
import edu.fudan.hangout.dao.impl.ActivityTipDaoImpl;
import edu.fudan.hangout.service.ActivityService;

import java.util.List;

/**
 * Created by Tong on 06.18.
 */
public class ActivityServiceImpl implements ActivityService {
    public static int ACTIVITY_PENDING = 0, ACTIVITY_ACCEPTED = 1, ACTIVITY_REJECTED = -1;
    private ActivityDaoImpl activityDao;
    private ActivityTipDaoImpl activityTipDao;
    private ActivityResponseDaoImpl activityResponseDao;

    @Override
    public int createActivity(ActivityBean activityBean) {
        return activityDao.createActivity(activityBean);
    }

    @Override
    public boolean updateActivity(ActivityBean activityBean) {
        activityDao.updateActivity(activityBean);
        return true;
    }

    @Override
    public ActivityBean getActivity(int id) {
        return activityDao.getActivity(id);
    }

    @Override
    public boolean inviteFriend(int activityId, int userId) {
        ActivityResponseBean hasExisted = activityResponseDao.findActivityResponse(userId, activityId);
        if (hasExisted == null) {
            /* Already invited*/
            return false;
        }

        ActivityResponseBean activityResponseBean = new ActivityResponseBean();
        activityResponseBean.setUserId(userId);
        activityResponseBean.setStatus(ActivityServiceImpl.ACTIVITY_PENDING);
        activityResponseBean.setActivityId(activityId);
        activityResponseDao.createActivityResponse(activityResponseBean);
        return true;
    }

    @Override
    public int createActivityTip(ActivityTipBean activityTipBean) {
        return activityTipDao.createActivityTip(activityTipBean);
    }

    @Override
    public ActivityTipBean getActivityTip(int id) {
        return activityTipDao.getActivityTip(id);
    }

    @Override
    public boolean voteForActivityTip(ActivityTipBean activityTipBean) {
        activityTipBean.setVotes(activityTipBean.getVotes() + 1);
        activityTipDao.updateActivityTip(activityTipBean);
        return false;
    }

    @Override
    public boolean setFinalActivityTip(ActivityBean activityBean, int tipId) {
        activityBean.setFinalTip(tipId);
        activityDao.updateActivity(activityBean);
        return true;
    }

    @Override
    public ActivityResponseBean getActivityResponse(int userId, int activityId) {
        return activityResponseDao.findActivityResponse(userId, activityId);
    }

    @Override
    public boolean updateActivityResponse(ActivityResponseBean activityResponseBean) {
        activityResponseDao.updateActivityResponse(activityResponseBean);
        return true;
    }

    @Override
    public List<Integer> getActivityTipIds(int activityId) {
        return activityTipDao.findActivityTipIds(activityId);
    }

    @Override
    public List<ActivityResponseBean> getActivityResponses(int activityId) {
        return activityResponseDao.findActivityResponses(activityId);
    }

    @Override
    public List<Integer> getAllActivityIds() {
        return activityResponseDao.findUserActivities();
    }

    @Override
    public List<Integer> getUnStartedActivityIds(int userId) {
        return activityDao.findUnStartedActivityStatus(userId);
    }

    @Override
    public List<Integer> getOnGoingActivityIds(int userId) {
        return activityDao.findOnGoingActivityStatus(userId);
    }

    @Override
    public List<Integer> getUserFriendsActivityIds(int userId) {
        return activityDao.findUserFriendsActivityIds(userId);
    }

    @Override
    public List<Integer> getUserActivityIds(int userId) {
        return activityDao.findUserActivityStatus(userId);
    }

    @Override
    public int getHighestVotedTipId(int activityId) {
        return activityTipDao.getHighestVotedTip(activityId);
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
