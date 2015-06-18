package edu.fudan.hangout.service;

import edu.fudan.hangout.bean.ActivityBean;
import edu.fudan.hangout.bean.ActivityTipBean;

/**
 * Created by Tong on 06.18.
 */
public interface ActivityService {
    public int createActivity(ActivityBean activityBean);

    public ActivityBean getActivity(int id);

    public boolean inviteFriend(int userId);

    public int createActivityTip(ActivityTipBean activityTipBean);
}
