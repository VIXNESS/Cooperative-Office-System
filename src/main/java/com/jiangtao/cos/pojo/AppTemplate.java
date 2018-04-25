package com.jiangtao.cos.pojo;

import java.io.Serializable;

public class AppTemplate implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String pk;
    protected String objpk;
    protected String template;

    public String getObjpk() {
        return objpk;
    }

    public void setObjpk(String objpk) {
        this.objpk = objpk;
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
