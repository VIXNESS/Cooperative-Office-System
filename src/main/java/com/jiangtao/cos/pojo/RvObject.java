package com.jiangtao.cos.pojo;

import java.io.Serializable;

public class RvObject implements Serializable {
    private String objPk;

    private String objName;

    private Byte type;

    private static final long serialVersionUID = 1L;

    public String getObjPk() {
        return objPk;
    }

    public void setObjPk(String objPk) {
        this.objPk = objPk == null ? null : objPk.trim();
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName == null ? null : objName.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", objPk=").append(objPk);
        sb.append(", objName=").append(objName);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}