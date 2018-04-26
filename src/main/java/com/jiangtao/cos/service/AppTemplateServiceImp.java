package com.jiangtao.cos.service;

import com.jiangtao.cos.dao.AppTemplateMapper;
import com.jiangtao.cos.pojo.AppTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppTemplateServiceImp implements AppTemplateService {

    private final AppTemplateMapper appTemplateMapper;

    @Autowired
    public AppTemplateServiceImp(AppTemplateMapper appTemplateMapper) {
        this.appTemplateMapper = appTemplateMapper;
    }

    @Override
    public AppTemplate selectByObjPk(String objpk) {
        return appTemplateMapper.selectByObjPk(objpk);

    }

    @Override
    public AppTemplate selectByPk(String pk) {
        return appTemplateMapper.selectByPk(pk);
    }

    @Override
    public List<AppTemplate> selectAll() {
        return appTemplateMapper.selectAll();
    }

    @Override
    public void update(AppTemplate appTemplate) {
        appTemplateMapper.update(appTemplate);
    }

    @Override
    public void delete(String pk) {
         appTemplateMapper.delete(pk);
    }

    @Override
    public void insert(AppTemplate appTemplate) {
        appTemplateMapper.insert(appTemplate);
    }
}
