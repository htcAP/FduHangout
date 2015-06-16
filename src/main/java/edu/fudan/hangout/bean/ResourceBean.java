package edu.fudan.hangout.bean;

import javax.persistence.*;

/**
 * Created by Tong on 06.16.
 */
@Entity
@Table(name = "resource", schema = "", catalog = "fdu_hangout")
public class ResourceBean {
    private int id;
    private int resType;
    private int resId;
    private String url;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "res_type")
    public int getResType() {
        return resType;
    }

    public void setResType(int resType) {
        this.resType = resType;
    }

    @Basic
    @Column(name = "res_id")
    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResourceBean that = (ResourceBean) o;

        if (id != that.id) return false;
        if (resId != that.resId) return false;
        if (resType != that.resType) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + resType;
        result = 31 * result + resId;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
