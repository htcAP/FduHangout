package edu.fudan.hangout;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Tong on 06.20.
 */
public class SessionManager {
    private SessionFactory sessionFactory;
    private Session session;


    public Session getSession() {
        if (this.session == null) {
            this.session = sessionFactory.openSession();
        }

        return this.session;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
