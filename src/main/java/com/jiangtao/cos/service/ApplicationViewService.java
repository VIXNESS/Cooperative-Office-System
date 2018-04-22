package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.ApplicationView;

import java.util.List;

public interface ApplicationViewService {
    List<ApplicationView> selectApplicationViewByViewerPk(String viewerPk);
}
