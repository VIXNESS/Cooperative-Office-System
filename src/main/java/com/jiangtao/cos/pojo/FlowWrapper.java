package com.jiangtao.cos.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class FlowWrapper {
    @JSONField(name = "index")
    Integer index;

    @JSONField(name = "pk")
    String pk;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }
}
