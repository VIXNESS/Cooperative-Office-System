package com.jiangtao.cos.pojo;

import java.util.Date;

public class LogView {
    private String staffId;
    private String apPk;
    private String apActor;
    private String name;
    private Date apDate;
    private Byte category;
    private String rvPk;
    private String objName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getApPk() {
        return apPk;
    }

    public void setApPk(String apPk) {
        this.apPk = apPk;
    }

    public String getApActor() {
        return apActor;
    }

    public void setApActor(String apActor) {
        this.apActor = apActor;
    }

    public Date getApDate() {
        return apDate;
    }

    public void setApDate(Date apDate) {
        this.apDate = apDate;
    }

    public Byte getCategory() {
        return category;
    }

    public void setCategory(Byte category) {
        this.category = category;
    }

    public String getRvPk() {
        return rvPk;
    }

    public void setRvPk(String rvPk) {
        this.rvPk = rvPk;
    }
}
