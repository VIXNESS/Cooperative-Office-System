package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.Staff;
import com.jiangtao.cos.pojo.StaffCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImp implements StaffService {
    @Override
    public List<Staff> get(StaffCriteria staffCriteria) throws Exception {
        return null;
    }

    @Override
    public List<Staff> get(StaffCriteria staffCriteria, int page, int row) throws Exception {
        return null;
    }

    @Override
    public Staff getByPk(StaffCriteria staffCriteria) throws Exception {
        return null;
    }

    @Override
    public int insert(List<Staff> staffList) throws Exception {
        return 0;
    }

    @Override
    public int insert(Staff staff) throws Exception {
        return 0;
    }

    @Override
    public int insert(StaffCriteria staffCriteria) throws Exception {
        return 0;
    }

    @Override
    public int delete(Staff staff) throws Exception {
        return 0;
    }

    @Override
    public int delete(StaffCriteria staffCriteria) throws Exception {
        return 0;
    }

    @Override
    public int delete(List<Staff> staffList) throws Exception {
        return 0;
    }

    @Override
    public int update(Staff staff) throws Exception {
        return 0;
    }

    @Override
    public int update(List<Staff> staffList) throws Exception {
        return 0;
    }

    @Override
    public int update(StaffCriteria staffCriteria) throws Exception {
        return 0;
    }
}
