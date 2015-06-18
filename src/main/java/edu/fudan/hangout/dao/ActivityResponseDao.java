package edu.fudan.hangout.dao;

import edu.fudan.hangout.bean.ActivityResponseBean;

/**
 * Created by Tong on 06.18.
 */
public interface ActivityResponseDao {
    int createActivityResponse(ActivityResponseBean activityResponseBean);

    boolean deleteActivityResponse(int id);

    boolean updateActivityResponse(ActivityResponseBean activityResponseBean);

    ActivityResponseBean getActivityResponse(int userId, int activityId);
}
