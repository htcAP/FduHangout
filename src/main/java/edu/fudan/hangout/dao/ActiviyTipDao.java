package edu.fudan.hangout.dao;

import edu.fudan.hangout.bean.ActivityTipBean;

/**
 * Created by Tong on 06.18.
 */
public interface ActiviyTipDao {
    int createActivityTip(ActivityTipBean activityTipBean);

    boolean deleteActivityTip(int id);

    boolean updateActivityTip(ActivityTipBean activityTipBean);

    ActivityTipBean getActivityTip(int id);
}
