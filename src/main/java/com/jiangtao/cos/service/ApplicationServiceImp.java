package com.jiangtao.cos.service;

import com.github.pagehelper.PageHelper;
import com.jiangtao.cos.dao.ApplicationMapper;
import com.jiangtao.cos.pojo.Application;
import com.jiangtao.cos.pojo.ApplicationCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImp implements ApplicationService {
    private final ApplicationMapper applicationMapper;

    @Autowired
    public ApplicationServiceImp(ApplicationMapper applicationMapper) {
        this.applicationMapper = applicationMapper;
    }

    @Override
    public List<Application> get(ApplicationCriteria applicationCriteria) throws Exception {
        return applicationMapper.selectByExample(applicationCriteria);
    }

    @Override
    public List<Application> get(ApplicationCriteria applicationCriteria, int page, int row) throws Exception {
        PageHelper.startPage(page,row);
        return applicationMapper.selectByExample(applicationCriteria);
    }

    @Override
    public Application getByPk(String pk) {
        return applicationMapper.selectByPrimaryKey(pk);
    }

    @Override
    public int insert(Application application)  {
        return applicationMapper.insert(application);
    }

    @Override
    public int delete(String pk) throws Exception {
        return applicationMapper.deleteByPrimaryKey(pk);
    }

    @Override
    public int delete(ApplicationCriteria applicationCriteria) throws Exception {
        return applicationMapper.deleteByExample(applicationCriteria);
    }

    @Override
    public int update(Application application){
        return applicationMapper.updateByPrimaryKey(application);
    }

}
