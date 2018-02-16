package com.jiangtao.cos.pojo;

import java.io.Serializable;

public class RvFlowKey implements Serializable {
    private String robjPk;

    private Byte rbojSerial;

    private String atPk;

    private static final long serialVersionUID = 1L;

    public String getRobjPk() {
        return robjPk;
    }

    public void setRobjPk(String robjPk) {
        this.robjPk = robjPk == null ? null : robjPk.trim();
    }

    public Byte getRbojSerial() {
        return rbojSerial;
    }

    public void setRbojSerial(Byte rbojSerial) {
        this.rbojSerial = rbojSerial;
    }

    public String getAtPk() {
        return atPk;
    }

    public void setAtPk(String atPk) {
        this.atPk = atPk == null ? null : atPk.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", robjPk=").append(robjPk);
        sb.append(", rbojSerial=").append(rbojSerial);
        sb.append(", atPk=").append(atPk);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}