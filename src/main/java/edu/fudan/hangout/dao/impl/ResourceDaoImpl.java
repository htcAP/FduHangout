package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.SessionManager;
import edu.fudan.hangout.bean.ResourceBean;
import edu.fudan.hangout.dao.ResourceDao;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Tong on 06.18.
 */
public class ResourceDaoImpl implements ResourceDao {
    private SessionFactory sessionFactory;
    private SessionManager sessionManager;

    @Override
    public int createResource(ResourceBean resourceBean) {
        Session session = sessionManager.getSession();
        Transaction tx = session.beginTransaction();
        Object o = session.save(resourceBean);
        tx.commit();
        sessionManager.close(session);
        return (Integer) o;
    }

    @Override
    public ResourceBean getResource(int id) {
        Session session = sessionManager.getSession();
        session.beginTransaction();
        ResourceBean resourceBean= session.get(ResourceBean.class, id);
        sessionManager.close(session);
        return resourceBean;
    }

    @Override
    public List<ResourceBean> findResourceUsage(int resType, int resId) {
        Session session = sessionManager.getSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM resource r WHERE r.res_id=" + resId + " AND r.res_type=" + resType);
        List list = sqlQuery.addEntity(ResourceBean.class).list();

        sessionManager.close(session);
        return list;
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

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
