package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.SessionManager;
import edu.fudan.hangout.bean.FriendshipBean;
import edu.fudan.hangout.dao.FriendshipDao;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Tong on 06.17.
 */
public class FriendshipDaoImpl implements FriendshipDao {
    private SessionFactory sessionFactory;
    private SessionManager sessionManager;

    @Override
    public void createFriendship(int id, int friendId) {
        FriendshipBean friendshipBean = new FriendshipBean();
        friendshipBean.setUserId(id);
        friendshipBean.setFriendId(friendId);

        Session session = sessionManager.getSession();
        Transaction tx = session.beginTransaction();
        session.save(friendshipBean);
        tx.commit();
        sessionManager.close(session);
    }

    @Override
    public void deleteFriendship(int id, int friendId) {
        Session session = sessionManager.getSession();
        Transaction tx = session.beginTransaction();
        session.createSQLQuery("DELETE FROM friendship WHERE user_id=" + id + " AND friend_id=" + friendId).executeUpdate();
        tx.commit();
        sessionManager.close(session);
    }

    @Override
    public void updateFriendship(int id, int friendId) {

    }

    @Override
    public boolean getFriendship(int id, int friendId) {
        Session session = sessionManager.getSession();
        session.beginTransaction();
        List result = session.createSQLQuery("SELECT * FROM friendship f WHERE f.user_id=" + id
                + " AND f.friend_id=" + friendId).addEntity(FriendshipBean.class).list();
        sessionManager.close(session);

        return !result.isEmpty();
    }

    @Override
    public List<Integer> findAllFriends(int id) {
        Session session = sessionManager.getSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT a.friend_id FROM friendship a WHERE a.user_id=" + id
                + " AND exists(SELECT * FROM friendship b WHERE b.user_id=a.friend_id AND b.friend_id=" + id + ")");
        List list = sqlQuery.list();

        sessionManager.close(session);
        return list;
    }

    @Override
    public List<Integer> findFriendRequests(int id) {
        Session session = sessionManager.getSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT a.user_id FROM friendship a WHERE a.friend_id=" + id
                + " AND NOT exists(SELECT * FROM friendship b WHERE b.user_id=" + id + " AND b.friend_id=a.user_id)");
        List list = sqlQuery.list();

        sessionManager.close(session);
        return list;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
