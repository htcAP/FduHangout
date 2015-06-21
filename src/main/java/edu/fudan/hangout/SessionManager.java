package edu.fudan.hangout;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Tong on 06.20.
 */
public class SessionManager {
    private SessionFactory sessionFactory;
//    private HashMap<Integer, Session> sessionHashMap;

    public SessionManager() {
//        this.sessionHashMap = new HashMap<>();
    }

//    private Session session;

    public Session getSession() {
//        int currentId = ThreadId.get();
//        Session session = this.sessionHashMap.get(currentId);
//
//        if (session == null || !session.isConnected() || !session.isOpen()) {
//            session = sessionFactory.openSession();
//            this.sessionHashMap.put(currentId, session);
//        }

        return sessionFactory.openSession();
    }

    public void close(Session session) {
        session.close();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
