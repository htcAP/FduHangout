package edu.fudan.hangout.bean;

import javax.persistence.*;

/**
 * Created by Tong on 06.16.
 */
@Entity
@Table(name = "friendship", schema = "", catalog = "fdu_hangout")
public class FriendshipBean {
    private int id;
    private int userId;
    private int friendId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "friend_id")
    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FriendshipBean that = (FriendshipBean) o;

        if (friendId != that.friendId) return false;
        if (id != that.id) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + friendId;
        return result;
    }
}
