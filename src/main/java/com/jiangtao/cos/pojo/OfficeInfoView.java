package com.jiangtao.cos.pojo;

public class OfficeInfoView {
    private Byte positionId;
    private String positionName;
    private String departmentId;
    private String departmentName;

    public Byte getPositionId() {
        return positionId;
    }

    public void setPositionId(Byte positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
