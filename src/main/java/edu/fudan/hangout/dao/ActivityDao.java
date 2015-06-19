package edu.fudan.hangout.dao;

import edu.fudan.hangout.bean.ActivityBean;

import java.util.List;

/**
 * Created by Tong on 06.18.
 */
public interface ActivityDao {
    int createActivity(ActivityBean activityBean);

    boolean deleteActivity(int id);

    boolean updateActivity(ActivityBean activityBean);

    ActivityBean getActivity(int id);

    List<Integer> findOnGoingActivityStatus(int id);
    List<Integer> findFinishedActivityStatus(int id);
    List<Integer> findUnStartedActivityStatus(int id);
    List<Integer> findOrganizingActivityStatus(int id);

}
