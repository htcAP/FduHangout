package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.bean.FriendshipBean;
import edu.fudan.hangout.dao.FriendshipDao;
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
    }

    @Override
    public void deleteFriendship(int id, int friendId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createSQLQuery("DELETE FROM friendship WHERE user_id=" + id + " AND friend_id=" + friendId).executeUpdate();
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
        return !result.isEmpty();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
