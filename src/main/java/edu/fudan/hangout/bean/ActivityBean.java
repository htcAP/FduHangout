package edu.fudan.hangout.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Tong on 06.18.
 */
@Entity
@Table(name = "activity", schema = "", catalog = "fdu_hangout")
public class ActivityBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String detail;
    private Timestamp joinDeadline;
    private Integer organizerId;
    private Integer finalTip;

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
    @Column(name = "organizer_id")
    public Integer getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Integer organizerId) {
        this.organizerId = organizerId;
    }

    @Basic
    @Column(name = "final_tip")
    public Integer getFinalTip() {
        return finalTip;
    }

    public void setFinalTip(Integer finalTip) {
        this.finalTip = finalTip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityBean that = (ActivityBean) o;

        if (id != that.id) return false;
        if (detail != null ? !detail.equals(that.detail) : that.detail != null) return false;
        if (finalTip != null ? !finalTip.equals(that.finalTip) : that.finalTip != null) return false;
        if (joinDeadline != null ? !joinDeadline.equals(that.joinDeadline) : that.joinDeadline != null) return false;
        if (organizerId != null ? !organizerId.equals(that.organizerId) : that.organizerId != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        result = 31 * result + (joinDeadline != null ? joinDeadline.hashCode() : 0);
        result = 31 * result + (organizerId != null ? organizerId.hashCode() : 0);
        result = 31 * result + (finalTip != null ? finalTip.hashCode() : 0);
        return result;
    }
}
