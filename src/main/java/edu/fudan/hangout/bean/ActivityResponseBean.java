package edu.fudan.hangout.bean;

import javax.persistence.*;

/**
 * Created by Tong on 06.18.
 */
@Entity
@Table(name = "activity_response", schema = "", catalog = "fdu_hangout")
public class ActivityResponseBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int activityId;
    private int status;


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
    @Column(name = "activity_id")
    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityResponseBean that = (ActivityResponseBean) o;

        if (activityId != that.activityId) return false;
        if (id != that.id) return false;
        if (status != that.status) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + activityId;
        result = 31 * result + status;
        return result;
    }
}
