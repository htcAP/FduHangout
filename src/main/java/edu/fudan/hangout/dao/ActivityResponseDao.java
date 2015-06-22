package edu.fudan.hangout.dao;

import edu.fudan.hangout.bean.ActivityResponseBean;

import java.util.List;

/**
 * Created by Tong on 06.18.
 */
public interface ActivityResponseDao {
    int createActivityResponse(ActivityResponseBean activityResponseBean);

    boolean deleteActivityResponse(int id);

    boolean updateActivityResponse(ActivityResponseBean activityResponseBean);

    ActivityResponseBean findActivityResponse(int userId, int activityId);

    List<ActivityResponseBean> findActivityResponses(int activityId);

    ActivityResponseBean getActivityResponse(int id);

    List<Integer> findUserActivities();

    List<Integer> findUserActivityRequests(int userId);

}
