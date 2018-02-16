package com.jiangtao.cos.pojo;

import java.io.Serializable;

public class Position implements Serializable {
    private Byte posiPk;

    private String posiName;

    private static final long serialVersionUID = 1L;

    public Byte getPosiPk() {
        return posiPk;
    }

    public void setPosiPk(Byte posiPk) {
        this.posiPk = posiPk;
    }

    public String getPosiName() {
        return posiName;
    }

    public void setPosiName(String posiName) {
        this.posiName = posiName == null ? null : posiName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", posiPk=").append(posiPk);
        sb.append(", posiName=").append(posiName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}