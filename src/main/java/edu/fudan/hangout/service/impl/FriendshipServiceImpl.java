package edu.fudan.hangout.service.impl;

import edu.fudan.hangout.bean.UserBean;
import edu.fudan.hangout.dao.impl.FriendshipDaoImpl;
import edu.fudan.hangout.service.FriendshipService;

/**
 * Created by Tong on 06.17.
 */
public class FriendshipServiceImpl implements FriendshipService {
    private FriendshipDaoImpl friendshipDao;

    @Override
    public boolean createFriendRequest(UserBean user, UserBean friend) {
        return false;
    }

    @Override
    public boolean cancelFriendRequest(UserBean user, UserBean friend) {
        return false;
    }

    @Override
    public boolean confirmFriendRequest(UserBean user, UserBean friend) {
        return false;
    }

    @Override
    public boolean rejectFriendRequest(UserBean user, UserBean friend) {
        return false;
    }

    public void setFriendshipDao(FriendshipDaoImpl friendshipDao) {
        this.friendshipDao = friendshipDao;
    }
}
