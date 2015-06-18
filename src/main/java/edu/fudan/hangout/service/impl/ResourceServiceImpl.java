package edu.fudan.hangout.service.impl;

import edu.fudan.hangout.bean.ResourceBean;
import edu.fudan.hangout.dao.impl.ResourceDaoImpl;
import edu.fudan.hangout.service.ResourceService;

/**
 * Created by Tong on 06.18.
 */
public class ResourceServiceImpl implements ResourceService{
    private ResourceDaoImpl resourceDao;

    @Override
    public int createResource(ResourceBean resourceBean) {
        return 0;
    }

    @Override
    public int getResourceByUsage(int resType, int resID) {
        return 0;
    }

    public void setResourceDao(ResourceDaoImpl resourceDao) {
        this.resourceDao = resourceDao;
    }
}
