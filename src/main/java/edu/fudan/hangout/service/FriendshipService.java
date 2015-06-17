package edu.fudan.hangout.service;

import edu.fudan.hangout.bean.UserBean;

/**
 * Created by Tong on 06.17.
 */
public interface FriendshipService {
    boolean createFriendRequest(UserBean user, UserBean friend);

    boolean cancelFriendRequest(UserBean user, UserBean friend);

    boolean acceptFriendRequest(UserBean user, UserBean friend);

    boolean rejectFriendRequest(UserBean user, UserBean friend);

    boolean deleteFriendship(UserBean user, UserBean friend);
}
