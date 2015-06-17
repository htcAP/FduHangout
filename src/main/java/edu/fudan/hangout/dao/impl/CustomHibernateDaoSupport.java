package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.dao.MySessionFactory;
import org.hibernate.Session;

/**
 * Created by Tong on 06.16.
 */
public abstract class CustomHibernateDaoSupport {


    public Session session() {
        return MySessionFactory.getFactory().getCurrentSession();
    }
}
