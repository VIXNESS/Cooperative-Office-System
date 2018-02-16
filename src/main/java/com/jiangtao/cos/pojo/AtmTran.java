package com.jiangtao.cos.pojo;

import java.io.Serializable;

public class AtmTran implements Serializable {
    private String pk;

    private String atmComment;

    private String rvDp;

    private Byte rvPosi;

    private static final long serialVersionUID = 1L;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk == null ? null : pk.trim();
    }

    public String getAtmComment() {
        return atmComment;
    }

    public void setAtmComment(String atmComment) {
        this.atmComment = atmComment == null ? null : atmComment.trim();
    }

    public String getRvDp() {
        return rvDp;
    }

    public void setRvDp(String rvDp) {
        this.rvDp = rvDp == null ? null : rvDp.trim();
    }

    public Byte getRvPosi() {
        return rvPosi;
    }

    public void setRvPosi(Byte rvPosi) {
        this.rvPosi = rvPosi;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pk=").append(pk);
        sb.append(", atmComment=").append(atmComment);
        sb.append(", rvDp=").append(rvDp);
        sb.append(", rvPosi=").append(rvPosi);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}