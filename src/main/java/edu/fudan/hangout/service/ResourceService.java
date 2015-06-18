package edu.fudan.hangout.service;

import edu.fudan.hangout.bean.ResourceBean;

/**
 * Created by Tong on 06.18.
 */
public interface ResourceService {
    public int createResource(ResourceBean resourceBean);

    public int getResourceByUsage(int resType, int resID);
}
