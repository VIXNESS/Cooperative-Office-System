package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.Log;
import com.jiangtao.cos.pojo.LogCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImp implements LogService {
    @Override
    public List<Log> get(LogCriteria logCriteria) throws Exception {
        return null;
    }

    @Override
    public List<Log> get(LogCriteria logCriteria, int page, int row) throws Exception {
        return null;
    }

    @Override
    public Log getByPk(LogCriteria logCriteria) throws Exception {
        return null;
    }

    @Override
    public int insert(List<Log> logList) throws Exception {
        return 0;
    }

    @Override
    public int insert(Log log) throws Exception {
        return 0;
    }

    @Override
    public int delete(LogCriteria logCriteria) throws Exception {
        return 0;
    }

    @Override
    public int delete(List<Log> logList) throws Exception {
        return 0;
    }

    @Override
    public int delete(Log log) throws Exception {
        return 0;
    }

    @Override
    public int update(List<Log> logList) throws Exception {
        return 0;
    }

    @Override
    public int update(Log log) throws Exception {
        return 0;
    }

    @Override
    public int update(LogCriteria logCriteria) throws Exception {
        return 0;
    }
}
