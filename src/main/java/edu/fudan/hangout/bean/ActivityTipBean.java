package edu.fudan.hangout.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Tong on 06.18.
 */
@Entity
@Table(name = "activity_tip", schema = "", catalog = "fdu_hangout")
public class ActivityTipBean {
    private int id;
    private Timestamp startDatetime;
    private String location;
    private Double longitude;
    private Timestamp endDatetime;
    private Integer votes;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "start_datetime")
    public Timestamp getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Timestamp startDatetime) {
        this.startDatetime = startDatetime;
    }

    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "longitude")
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "end_datetime")
    public Timestamp getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Timestamp endDatetime) {
        this.endDatetime = endDatetime;
    }

    @Basic
    @Column(name = "votes")
    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityTipBean that = (ActivityTipBean) o;

        if (id != that.id) return false;
        if (endDatetime != null ? !endDatetime.equals(that.endDatetime) : that.endDatetime != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (startDatetime != null ? !startDatetime.equals(that.startDatetime) : that.startDatetime != null)
            return false;
        if (votes != null ? !votes.equals(that.votes) : that.votes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (startDatetime != null ? startDatetime.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (endDatetime != null ? endDatetime.hashCode() : 0);
        result = 31 * result + (votes != null ? votes.hashCode() : 0);
        return result;
    }
}
