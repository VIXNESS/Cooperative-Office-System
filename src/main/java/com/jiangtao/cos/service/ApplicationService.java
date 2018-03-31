package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.Application;
import com.jiangtao.cos.pojo.ApplicationCriteria;

import java.util.List;

public interface ApplicationService {
    /**
     *
     * @param applicationCriteria
     * @return application list
     * @throws Exception
     */
    List<Application> get(ApplicationCriteria applicationCriteria) throws Exception;

    /**
     *
     * @param applicationCriteria
     * @param page
     * @param row
     * @return application list
     * @throws Exception
     */
    List<Application> get(ApplicationCriteria applicationCriteria,int page,int row) throws Exception;

    /**
     *
     * @param pk
     * @return a Application
     * @throws Exception
     */
    Application getByPk(String pk)throws Exception;

    /**
     *
     * @param application
     * @return method result
     * @throws Exception
     */
    int insert(Application application)throws Exception;

    /**
     *
     * @param pk
     * @return method result
     * @throws Exception
     */
    int delete(String pk)throws Exception;

    /**
     *
     * @param applicationCriteria
     * @return method result
     * @throws Exception
     */
    int delete(ApplicationCriteria applicationCriteria)throws Exception;

    /**
     *
     * @param application
     * @return method result
     * @throws Exception
     */
    int update(Application application)throws Exception;
}
