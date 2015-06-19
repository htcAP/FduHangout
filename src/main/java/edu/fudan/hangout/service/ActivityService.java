package edu.fudan.hangout.service;

import edu.fudan.hangout.bean.ActivityBean;
import edu.fudan.hangout.bean.ActivityResponseBean;
import edu.fudan.hangout.bean.ActivityTipBean;

import java.util.List;

/**
 * Created by Tong on 06.18.
 */
public interface ActivityService {
    public int createActivity(ActivityBean activityBean);

    public ActivityBean getActivity(int id);

    public boolean inviteFriend(int activityId, int userId);

    public int createActivityTip(ActivityTipBean activityTipBean);

    public ActivityTipBean getActivityTip(int id);

    public boolean voteForActivityTip(ActivityTipBean activityTipBean);

    public boolean setFinalActivityTip(ActivityBean activityBean, int tipId);

    public ActivityResponseBean getActivityResponse(int userId, int activityId);

    public boolean updateActivityResponse(ActivityResponseBean activityResponseBean);

    public List<Integer> getActivityTipIds(int activityId);

    public List<ActivityResponseBean> getActivityResponses(int activityId);

    public List<Integer> getAllActivityIds(int userId);
    public List<Integer> getUnStartedActivityIds(int userId);
    public List<Integer> getOnGoingActivityIds(int userId);
    public List<Integer> getFinishedActivityIds(int userId);
    public List<Integer> getOrganizingActivityIds(int userId);



}
