package com.jiangtao.cos.service;

import com.github.pagehelper.PageHelper;
import com.jiangtao.cos.dao.LogMapper;
import com.jiangtao.cos.pojo.Log;
import com.jiangtao.cos.pojo.LogCriteria;
import com.jiangtao.cos.pojo.LogKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImp implements LogService {
    @Autowired
    LogMapper logMapper;

    @Override
    public List<Log> get(LogCriteria logCriteria) throws Exception {
        return logMapper.selectByExample(logCriteria);
    }

    @Override
    public List<Log> get(LogCriteria logCriteria, int page, int row) throws Exception {
        PageHelper.startPage(page,row);
        return logMapper.selectByExample(logCriteria);
    }

    @Override
    public Log getByPk(LogKey logKey) throws Exception {
        return logMapper.selectByPrimaryKey(logKey);
    }

    @Override
    public int insert(Log log) throws Exception {
        return logMapper.insertSelective(log);
    }

    @Override
    public int delete(LogCriteria logCriteria) throws Exception {
        return logMapper.deleteByExample(logCriteria);
    }

    @Override
    public int delete(LogKey logKey) throws Exception {
        return logMapper.deleteByPrimaryKey(logKey);
    }

    @Override
    public int update(Log log) throws Exception {
        return logMapper.updateByPrimaryKey(log);
    }
}
