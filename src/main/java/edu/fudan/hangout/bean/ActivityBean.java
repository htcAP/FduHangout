package edu.fudan.hangout.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Tong on 06.16.
 */
@Entity
@Table(name = "activity", schema = "", catalog = "fdu_hangout")
public class ActivityBean {
    private int id;
    private String title;
    private String detail;
    private Timestamp joinDeadline;
    private int organizer;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "detail")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Basic
    @Column(name = "join_deadline")
    public Timestamp getJoinDeadline() {
        return joinDeadline;
    }

    public void setJoinDeadline(Timestamp joinDeadline) {
        this.joinDeadline = joinDeadline;
    }

    @Basic
    @Column(name = "organizer")
    public int getOrganizer() {
        return organizer;
    }

    public void setOrganizer(int organizer) {
        this.organizer = organizer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityBean that = (ActivityBean) o;

        if (id != that.id) return false;
        if (organizer != that.organizer) return false;
        if (detail != null ? !detail.equals(that.detail) : that.detail != null) return false;
        if (joinDeadline != null ? !joinDeadline.equals(that.joinDeadline) : that.joinDeadline != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        result = 31 * result + (joinDeadline != null ? joinDeadline.hashCode() : 0);
        result = 31 * result + organizer;
        return result;
    }
}
