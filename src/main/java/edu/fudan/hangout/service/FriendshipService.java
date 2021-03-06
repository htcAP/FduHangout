package edu.fudan.hangout.service;

import edu.fudan.hangout.bean.UserBean;

import java.util.List;

/**
 * Created by Tong on 06.17.
 */
public interface FriendshipService {
    boolean createFriendRequest(UserBean user, UserBean friend);

    boolean cancelFriendRequest(UserBean user, UserBean friend);

    boolean acceptFriendRequest(UserBean user, UserBean friend);

    boolean rejectFriendRequest(UserBean user, UserBean friend);

    boolean deleteFriendship(UserBean user, UserBean friend);

    int isFriend(int userId, int friendId);

    List<Integer> getAllFriends(int userId);

    List<Integer> getFriendRequests(int userId);
}
