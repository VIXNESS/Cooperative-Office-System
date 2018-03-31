package com.jiangtao.cos.pojo;

import java.io.Serializable;

public class OfficeKey implements Serializable {
    protected String staff;

    protected String department;

    protected Byte posi;

    private static final long serialVersionUID = 1L;

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff == null ? null : staff.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public Byte getPosi() {
        return posi;
    }

    public void setPosi(Byte posi) {
        this.posi = posi;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", staff=").append(staff);
        sb.append(", department=").append(department);
        sb.append(", posi=").append(posi);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}