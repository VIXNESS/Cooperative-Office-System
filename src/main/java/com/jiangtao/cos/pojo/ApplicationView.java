package com.jiangtao.cos.pojo;

public class ApplicationView extends Application {
    protected String viewerPk;
    private static final long serialVersionUID = 1L;

    public String getViewerPk() {
        return viewerPk;
    }

    public void setViewerPk(String viewerPk) {
        this.viewerPk = viewerPk;
    }
}
