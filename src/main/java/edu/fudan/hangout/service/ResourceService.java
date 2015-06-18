package edu.fudan.hangout.service;

import edu.fudan.hangout.bean.ResourceBean;

import java.util.List;

/**
 * Created by Tong on 06.18.
 */
public interface ResourceService {
    public static int ACTIVITY_IMAGE = 0, USER_PROTRAIT = 1;

    public int createResource(ResourceBean resourceBean);

    public List<ResourceBean> getResourcesByUsage(int resType, int resID);
}
