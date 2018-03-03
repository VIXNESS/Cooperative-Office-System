package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.Application;
import com.jiangtao.cos.pojo.ApplicationCriteria;

import java.util.List;

public interface ApplicationService {
    List<Application> get(ApplicationCriteria applicationCriteria) throws Exception;
    List<Application> get(ApplicationCriteria applicationCriteria,int page,int row) throws Exception;
    Application getByPk(String pk)throws Exception;
    int insert(Application application)throws Exception;
    int insert(List<Application> applicationList)throws Exception;
    int delete(String pk)throws Exception;
    int delete(ApplicationCriteria applicationCriteria)throws Exception;
    int delete(List<Application> applicationList)throws Exception;
    int update(Application application)throws Exception;
    int update(List<Application> applicationList)throws Exception;
    int update(ApplicationCriteria applicationCriteria)throws Exception;
}
