package com.jiangtao.cos.service;

import com.jiangtao.cos.dao.ApplicationMapper;
import com.jiangtao.cos.pojo.Application;
import com.jiangtao.cos.pojo.ApplicationCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImp implements ApplicationService {
    @Autowired
    ApplicationMapper applicationMapper;

    @Override
    public List<Application> get(ApplicationCriteria applicationCriteria) throws Exception {
        return null;
    }

    @Override
    public List<Application> get(ApplicationCriteria applicationCriteria, int page, int row) throws Exception {
        return null;
    }

    @Override
    public Application getByPk(String pk) throws Exception {
        return null;
    }

    @Override
    public int insert(Application application) throws Exception {
        return 0;
    }

    @Override
    public int insert(List<Application> applicationList) throws Exception {
        return 0;
    }

    @Override
    public int delete(String pk) throws Exception {
        return 0;
    }

    @Override
    public int delete(ApplicationCriteria applicationCriteria) throws Exception {
        return 0;
    }

    @Override
    public int delete(List<Application> applicationList) throws Exception {
        return 0;
    }

    @Override
    public int update(Application application) throws Exception {
        return 0;
    }

    @Override
    public int update(List<Application> applicationList) throws Exception {
        return 0;
    }

    @Override
    public int update(ApplicationCriteria applicationCriteria) throws Exception {
        return 0;
    }
}
