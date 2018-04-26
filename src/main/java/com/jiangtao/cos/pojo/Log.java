package com.jiangtao.cos.pojo;

import java.io.Serializable;
import java.util.Date;

public class Log extends LogKey implements Serializable {
    private String content;

    private String tgTable;

    private Byte category;

    private static final long serialVersionUID = 1L;

    public Log(){
//        super();
    }

    public Log(String staffId, Date logDate) {
        super(staffId, logDate);
    }

    public Log(String staffId, Date logDate, String content, String tgTable, Byte category) {
        super(staffId, logDate);
        this.content = content;
        this.tgTable = tgTable;
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getTgTable() {
        return tgTable;
    }

    public void setTgTable(String tgTable) {
        this.tgTable = tgTable == null ? null : tgTable.trim();
    }

    public Byte getCategory() {
        return category;
    }

    public void setCategory(Byte category) {
        this.category = category;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", content=").append(content);
        sb.append(", tgTable=").append(tgTable);
        sb.append(", category=").append(category);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}