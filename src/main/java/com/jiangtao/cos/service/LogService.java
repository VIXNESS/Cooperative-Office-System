package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.Log;
import com.jiangtao.cos.pojo.LogCriteria;

import java.util.List;

public interface LogService {
    List<Log> get(LogCriteria logCriteria)throws Exception;
    List<Log> get(LogCriteria logCriteria,int page, int row)throws Exception;
    Log getByPk(LogCriteria logCriteria)throws Exception;
    int insert(List<Log> logList)throws Exception;
    int insert(Log log)throws Exception;
    int delete(LogCriteria logCriteria)throws Exception;
    int delete(List<Log> logList)throws Exception;
    int delete(Log log)throws Exception;
    int update(List<Log> logList)throws Exception;
    int update(Log log)throws Exception;
    int update(LogCriteria logCriteria)throws Exception;
}
