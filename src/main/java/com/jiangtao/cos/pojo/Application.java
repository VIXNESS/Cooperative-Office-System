package com.jiangtao.cos.pojo;

import java.io.Serializable;
import java.util.Date;

public class Application implements Serializable {
    private String apPk;

    private String apActor;

    private String rvPk;

    private Date apDate;

    private String apComment;

    private Byte apStat;

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

    public Byte getApStat() {
        return apStat;
    }

    public void setApStat(Byte apStat) {
        this.apStat = apStat;
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
        sb.append(", apStat=").append(apStat);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}