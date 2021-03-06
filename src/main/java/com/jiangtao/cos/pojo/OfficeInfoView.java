package com.jiangtao.cos.pojo;

import java.io.Serializable;
import java.util.List;

public class OfficeInfoView implements Serializable {
    private Department department;
    private List<Position> positionList;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }
}
