package com.jiangtao.cos.pojo;

import java.io.Serializable;

public class AtmView implements Serializable {
    private AtmTran atmTran;
    private String posi;
    private String dpm;

    public AtmTran getAtmTran() {
        return atmTran;
    }

    public void setAtmTran(AtmTran atmTran) {
        this.atmTran = atmTran;
    }

    public String getPosi() {
        return posi;
    }

    public void setPosi(String posi) {
        this.posi = posi;
    }

    public String getDpm() {
        return dpm;
    }

    public void setDpm(String dpm) {
        this.dpm = dpm;
    }
}
