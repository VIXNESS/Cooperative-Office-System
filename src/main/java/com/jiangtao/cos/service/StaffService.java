package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.Staff;
import com.jiangtao.cos.pojo.StaffCriteria;

import java.util.List;

public interface StaffService {
    List<Staff> get(StaffCriteria staffCriteria)throws Exception;
    List<Staff> get(StaffCriteria staffCriteria,int page,int row)throws Exception;
    Staff getByPk(StaffCriteria staffCriteria)throws Exception;
    int insert(List<Staff> staffList)throws Exception;
    int insert(Staff staff)throws Exception;
    int insert(StaffCriteria staffCriteria)throws Exception;
    int delete(Staff staff)throws Exception;
    int delete(StaffCriteria staffCriteria)throws Exception;
    int delete(List<Staff> staffList)throws Exception;
    int update(Staff staff)throws Exception;
    int update(List<Staff> staffList)throws Exception;
    int update(StaffCriteria staffCriteria)throws Exception;
}
