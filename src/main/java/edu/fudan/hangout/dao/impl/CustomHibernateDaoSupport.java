package edu.fudan.hangout.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Created by Tong on 06.16.
 */
public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }
}
