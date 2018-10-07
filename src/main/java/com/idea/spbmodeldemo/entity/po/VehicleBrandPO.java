package com.idea.spbmodeldemo.entity.po;

import java.util.Date;

public class VehicleBrandPO {
    private Integer id;

    private String name;

    private String logo;

    private Date crtTime;

    private String description;

    private Integer crtUid;

    private Integer updUid;

    private Date updTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getCrtUid() {
        return crtUid;
    }

    public void setCrtUid(Integer crtUid) {
        this.crtUid = crtUid;
    }

    public Integer getUpdUid() {
        return updUid;
    }

    public void setUpdUid(Integer updUid) {
        this.updUid = updUid;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }
}