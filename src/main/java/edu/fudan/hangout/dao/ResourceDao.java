package edu.fudan.hangout.dao;

import edu.fudan.hangout.bean.ResourceBean;

/**
 * Created by Tong on 06.18.
 */
public interface ResourceDao {
    public boolean createResource(ResourceBean resourceBean);

    public ResourceBean getResource(int id);

    public ResourceBean findResourceyUsage(int resType, int resId);

    public boolean updateResource(ResourceBean resourceBean);

    public boolean deleteResource(int id);
}
