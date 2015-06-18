package edu.fudan.hangout.service.impl;

import edu.fudan.hangout.bean.ResourceBean;
import edu.fudan.hangout.dao.impl.ResourceDaoImpl;
import edu.fudan.hangout.service.ResourceService;

import java.util.List;

/**
 * Created by Tong on 06.18.
 */
public class ResourceServiceImpl implements ResourceService {
    public static int ACTIVITY_IMAGE = 0, USER_PROTRAIT = 1;

    private ResourceDaoImpl resourceDao;

    @Override
    public int createResource(ResourceBean resourceBean) {
        return 0;
    }

    @Override
    public List<ResourceBean> getResourcesByUsage(int resType, int resID) {
        return null;
    }

    public void setResourceDao(ResourceDaoImpl resourceDao) {
        this.resourceDao = resourceDao;
    }
}
