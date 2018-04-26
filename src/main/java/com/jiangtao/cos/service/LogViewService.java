package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.LogView;

import java.util.List;

public interface LogViewService {
    List<LogView> selectByStaffId(String staffId);
}
