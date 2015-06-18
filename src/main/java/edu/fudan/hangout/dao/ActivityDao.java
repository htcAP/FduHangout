package edu.fudan.hangout.dao;

import edu.fudan.hangout.bean.ActivityBean;

/**
 * Created by Tong on 06.18.
 */
public interface ActivityDao {
    int createActivity(ActivityBean activityBean);

    boolean deleteActivity(int id);

    boolean updateActivity(ActivityBean activityBean);

    ActivityBean getActivity(int id);
}
