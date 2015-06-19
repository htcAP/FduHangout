package edu.fudan.hangout.dao;

import edu.fudan.hangout.bean.ActivityTipBean;

import java.util.List;

/**
 * Created by Tong on 06.18.
 */
public interface ActiviyTipDao {
    int createActivityTip(ActivityTipBean activityTipBean);

    boolean deleteActivityTip(int id);

    boolean updateActivityTip(ActivityTipBean activityTipBean);

    ActivityTipBean getActivityTip(int id);

    List<Integer> findActivityTipIds(int activityId);
}
