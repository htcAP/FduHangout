package edu.fudan.hangout.dao;

import edu.fudan.hangout.bean.ResourceBean;

import java.util.List;

/**
 * Created by Tong on 06.18.
 */
public interface ResourceDao {
    public int createResource(ResourceBean resourceBean);

    public ResourceBean getResource(int id);

    public List<ResourceBean> findResourceUsage(int resType, int resId);

    public boolean updateResource(ResourceBean resourceBean);

    public boolean deleteResource(int id);
}
