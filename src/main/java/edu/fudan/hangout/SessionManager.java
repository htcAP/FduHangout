package edu.fudan.hangout;

import edu.fudan.hangout.util.ThreadId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.HashMap;

/**
 * Created by Tong on 06.20.
 */
public class SessionManager {
    private SessionFactory sessionFactory;
    private HashMap<Integer, Session> sessionHashMap;

    public SessionManager() {
        this.sessionHashMap = new HashMap<>();
    }


    public Session getSession() {
        int currentId = ThreadId.get();
        Session session = this.sessionHashMap.get(currentId);

        if (session == null || !session.isConnected() || !session.isOpen()) {
            session = sessionFactory.openSession();
            this.sessionHashMap.put(currentId, session);
        }

        return session;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
