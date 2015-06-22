package edu.fudan.hangout.service.impl;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.dao.impl.FriendshipDaoImpl;
import edu.fudan.hangout.service.FriendshipService;

import java.util.List;

/**
 * Created by Tong on 06.17.
 */
public class FriendshipServiceImpl implements FriendshipService {
    private FriendshipDaoImpl friendshipDao;

    @Override
    public boolean createFriendRequest(UserBean user, UserBean friend) {
        /* Notice that if friend sent a request to you and you also sent a request to you. Then you two becomes
        * friends. There will be no acceptance and rejection involved.*/
        boolean userToFriendRelation = friendshipDao.getFriendship(user.getId(), friend.getId());
        if (userToFriendRelation) {
            /* You two have already been friends.*/
            return false;
        } else {
            friendshipDao.createFriendship(user.getId(), friend.getId());
            return true;
        }
    }

    @Override
    public boolean cancelFriendRequest(UserBean user, UserBean friend) {
        boolean userToFriendRelation = friendshipDao.getFriendship(user.getId(), friend.getId());
        if (!userToFriendRelation) {
            /* You two have not been friends.*/
            return false;
        } else {
            friendshipDao.deleteFriendship(user.getId(), friend.getId());
            return true;
        }
    }

    @Override
    public boolean acceptFriendRequest(UserBean user, UserBean friend) {
        boolean userToFriendRelation = friendshipDao.getFriendship(user.getId(), friend.getId()),
                friendToUserRelation = friendshipDao.getFriendship(friend.getId(), user.getId());
        if (friendToUserRelation && !userToFriendRelation) {
            /* You have a friend request and have not accepted.*/
            friendshipDao.createFriendship(user.getId(), friend.getId());
            return true;
        } else {
            /* Either you do not have a friend request or you have already accepted.*/
            return false;
        }
    }

    @Override
    public boolean rejectFriendRequest(UserBean user, UserBean friend) {
        boolean userToFriendRelation = friendshipDao.getFriendship(user.getId(), friend.getId()),
                friendToUserRelation = friendshipDao.getFriendship(friend.getId(), user.getId());
        if (friendToUserRelation && !userToFriendRelation) {
            /* You have a friend request and have not accepted.*/
            friendshipDao.deleteFriendship(friend.getId(), user.getId());
            return true;
        } else {
            /* Either you do not have a friend request or you have already accepted.*/
            return false;
        }
    }

    @Override
    public boolean deleteFriendship(UserBean user, UserBean friend) {
        boolean userToFriendRelation = friendshipDao.getFriendship(user.getId(), friend.getId()),
                friendToUserRelation = friendshipDao.getFriendship(friend.getId(), user.getId());
        if (friendToUserRelation && userToFriendRelation) {
            /* You have a friend request and have not accepted.*/
            friendshipDao.deleteFriendship(friend.getId(), user.getId());
            friendshipDao.deleteFriendship(user.getId(), friend.getId());
            return true;
        } else {
            /* You two have not been friends.*/
            return false;
        }
    }

    @Override
    public int isFriend(int userId, int friendId) {
        if (userId == friendId) {
            return 4;
        }
        boolean userToFriendRelation = friendshipDao.getFriendship(userId, friendId),
                friendToUserRelation = friendshipDao.getFriendship(friendId, userId);
        if (userToFriendRelation) {
            if (friendToUserRelation) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (friendToUserRelation) {
                return 2;
            } else {
                return 3;
            }
        }
    }

    @Override
    public List<Integer> getAllFriends(int userId) {
        return friendshipDao.findAllFriends(userId);
    }

    @Override
    public List<Integer> getFriendRequests(int userId) {
        return friendshipDao.findFriendRequests(userId);
    }

    public void setFriendshipDao(FriendshipDaoImpl friendshipDao) {
        this.friendshipDao = friendshipDao;
    }
}
