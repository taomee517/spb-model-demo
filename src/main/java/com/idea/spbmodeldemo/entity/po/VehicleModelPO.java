package com.idea.spbmodeldemo.entity.po;

import java.util.Date;

public class VehicleModelPO {
    private Integer id;

    private String name;

    private Integer energyType;

    private String carCode;

    private Date crtTime;

    private Integer crtUid;

    private Integer updUid;

    private Date updTime;

    private Integer fuelTankCap;

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

    public Integer getEnergyType() {
        return energyType;
    }

    public void setEnergyType(Integer energyType) {
        this.energyType = energyType;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode == null ? null : carCode.trim();
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
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

    public Integer getFuelTankCap() {
        return fuelTankCap;
    }

    public void setFuelTankCap(Integer fuelTankCap) {
        this.fuelTankCap = fuelTankCap;
    }
}