package com.jiangtao.cos.pojo;

import java.io.Serializable;
import java.util.Date;

public class Application implements Serializable {
    protected String apPk;

    protected String apActor;

    protected String rvPk;

    protected Date apDate;

    protected String apComment;

    protected String ptr;

    private static final long serialVersionUID = 1L;

    public String getApPk() {
        return apPk;
    }

    public void setApPk(String apPk) {
        this.apPk = apPk == null ? null : apPk.trim();
    }

    public String getApActor() {
        return apActor;
    }

    public void setApActor(String apActor) {
        this.apActor = apActor == null ? null : apActor.trim();
    }

    public String getRvPk() {
        return rvPk;
    }

    public void setRvPk(String rvPk) {
        this.rvPk = rvPk == null ? null : rvPk.trim();
    }

    public Date getApDate() {
        return apDate;
    }

    public void setApDate(Date apDate) {
        this.apDate = apDate;
    }

    public String getApComment() {
        return apComment;
    }

    public void setApComment(String apComment) {
        this.apComment = apComment == null ? null : apComment.trim();
    }

    public String getPtr() {
        return ptr;
    }

    public void setPtr(String ptr) {
        this.ptr = ptr == null ? null : ptr.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", apPk=").append(apPk);
        sb.append(", apActor=").append(apActor);
        sb.append(", rvPk=").append(rvPk);
        sb.append(", apDate=").append(apDate);
        sb.append(", apComment=").append(apComment);
        sb.append(", ptr=").append(ptr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}