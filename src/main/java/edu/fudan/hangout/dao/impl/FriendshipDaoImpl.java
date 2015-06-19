package edu.fudan.hangout.dao.impl;

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

    @Override
    public void createFriendship(int id, int friendId) {
        FriendshipBean friendshipBean = new FriendshipBean();
        friendshipBean.setUserId(id);
        friendshipBean.setFriendId(friendId);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(friendshipBean);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteFriendship(int id, int friendId) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.createSQLQuery("DELETE FROM friendship WHERE user_id=" + id + " AND friend_id=" + friendId).executeUpdate();
        tx.commit();
        session.close();
    }

    @Override
    public void updateFriendship(int id, int friendId) {

    }

    @Override
    public boolean getFriendship(int id, int friendId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createSQLQuery("SELECT * FROM friendship f WHERE f.user_id=" + id
                + " AND f.friend_id=" + friendId).addEntity(FriendshipBean.class).list();
        session.close();
        return !result.isEmpty();
    }

    @Override
    public List<Integer> findAllFriends(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT a.friend_id FROM friendship a WHERE a.user_id=" + id
                + " AND exists(SELECT * FROM friendship b WHERE b.user_id=a.friend_id AND b.friend_id=" + id + ")");
        session.close();
        return sqlQuery.list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
