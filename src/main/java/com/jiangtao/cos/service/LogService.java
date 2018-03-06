package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.Log;
import com.jiangtao.cos.pojo.LogCriteria;
import com.jiangtao.cos.pojo.LogKey;

import java.util.List;

public interface LogService {
    List<Log> get(LogCriteria logCriteria)throws Exception;
    List<Log> get(LogCriteria logCriteria,int page, int row)throws Exception;
    Log getByPk(LogKey logKey)throws Exception;
    int insert(Log log)throws Exception;
    int delete(LogCriteria logCriteria)throws Exception;
    int delete(LogKey logKey)throws Exception;
    int update(Log log)throws Exception;
}
