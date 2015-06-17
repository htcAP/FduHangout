package edu.fudan.hangout.dao.impl;

import edu.fudan.hangout.dao.FriendshipDao;
import org.hibernate.SessionFactory;

/**
 * Created by Tong on 06.17.
 */
public class FriendshipDaoImpl implements FriendshipDao {
    private SessionFactory sessionFactory;

    @Override
    public void createFriendship(int id, int friendId) {

    }

    @Override
    public void deleteFriendship(int id, int friendId) {

    }

    @Override
    public void updateFriendship(int id, int friendId) {

    }

    @Override
    public boolean getFriendship(int id, int friendId) {
        return false;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
