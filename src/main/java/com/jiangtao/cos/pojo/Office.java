package com.jiangtao.cos.pojo;

import java.io.Serializable;
import java.util.Date;

public class Office extends OfficeKey implements Serializable {
    private Date initDate;

    private Date expiredDate;

    private static final long serialVersionUID = 1L;

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
        sb.append(", initDate=").append(initDate);
        sb.append(", expiredDate=").append(expiredDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}