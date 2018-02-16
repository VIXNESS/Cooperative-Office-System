package com.jiangtao.cos.pojo;

import java.io.Serializable;
import java.util.Date;

public class Office implements Serializable {
    private String staff;

    private String department;

    private Byte posi;

    private Date initDate;

    private Date expiredDate;

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

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
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
        sb.append(", initDate=").append(initDate);
        sb.append(", expiredDate=").append(expiredDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}