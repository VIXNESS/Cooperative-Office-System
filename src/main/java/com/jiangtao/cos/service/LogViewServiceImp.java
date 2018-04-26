package com.jiangtao.cos.service;

import com.jiangtao.cos.dao.LogViewMapper;
import com.jiangtao.cos.pojo.LogView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogViewServiceImp implements LogViewService{
    private final LogViewMapper logViewMapper;

    public LogViewServiceImp(LogViewMapper logViewMapper) {
        this.logViewMapper = logViewMapper;
    }

    @Override
    public List<LogView> selectByStaffId(String staffId) {
        return logViewMapper.selectByStaffId(staffId);
    }
}
