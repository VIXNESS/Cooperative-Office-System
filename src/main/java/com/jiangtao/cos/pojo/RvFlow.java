package com.jiangtao.cos.pojo;

import java.io.Serializable;

public class RvFlow implements Serializable {
    protected String pk;

    protected String pre;

    protected String suc;

    protected String atm;

    protected String obj;

    private static final long serialVersionUID = 1L;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk == null ? null : pk.trim();
    }

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre == null ? null : pre.trim();
    }

    public String getSuc() {
        return suc;
    }

    public void setSuc(String suc) {
        this.suc = suc == null ? null : suc.trim();
    }

    public String getAtm() {
        return atm;
    }

    public void setAtm(String atm) {
        this.atm = atm == null ? null : atm.trim();
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj == null ? null : obj.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pk=").append(pk);
        sb.append(", pre=").append(pre);
        sb.append(", suc=").append(suc);
        sb.append(", atm=").append(atm);
        sb.append(", obj=").append(obj);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}