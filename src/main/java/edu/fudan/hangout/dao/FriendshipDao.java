package edu.fudan.hangout.dao;

/**
 * Created by Tong on 06.17.
 */
public interface FriendshipDao {
    void createFriendship(int id, int friendId);

    void deleteFriendship(int id, int friendId);

    void updateFriendship(int id, int friendId);

    boolean getFriendship(int id, int friendId);
}