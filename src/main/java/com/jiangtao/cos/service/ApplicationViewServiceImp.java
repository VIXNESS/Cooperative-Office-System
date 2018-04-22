package com.jiangtao.cos.service;

import com.jiangtao.cos.dao.ApplicationViewMapper;
import com.jiangtao.cos.pojo.ApplicationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationViewServiceImp implements ApplicationViewService {
    @Autowired
    private ApplicationViewMapper applicationViewMapper;
    @Override
    public List<ApplicationView> selectApplicationViewByViewerPk(String viewerPk) {
        return applicationViewMapper.selectByViewerPk(viewerPk);
    }
}
