package edu.fudan.hangout.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.ejb.Singleton;

/**
 * Created by Tong on 06.16.
 */
@Singleton(name = "SessionEJB")
public class SessionBean {

    private SessionFactory sessionFactory = null;

    public SessionBean() {
    }

    public Session openSession() {
        if (this.sessionFactory == null) {
            this.sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory.openSession();
    }
}
