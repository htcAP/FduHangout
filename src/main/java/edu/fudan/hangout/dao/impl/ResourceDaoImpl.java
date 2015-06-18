package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.bean.ResourceBean;
import edu.fudan.hangout.dao.ResourceDao;
import org.hibernate.SessionFactory;

/**
 * Created by Tong on 06.18.
 */
public class ResourceDaoImpl implements ResourceDao {
    private SessionFactory sessionFactory;

    @Override
    public boolean createResource(ResourceBean resourceBean) {
        return false;
    }

    @Override
    public ResourceBean getResource(int id) {
        return null;
    }

    @Override
    public ResourceBean findResourceyUsage(int resType, int resId) {
        return null;
    }

    @Override
    public boolean updateResource(ResourceBean resourceBean) {
        return false;
    }

    @Override
    public boolean deleteResource(int id) {
        return false;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
