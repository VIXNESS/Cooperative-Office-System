package com.jiangtao.cos.service;

import com.jiangtao.cos.dao.StaffMapper;
import com.jiangtao.cos.pojo.Staff;
import com.jiangtao.cos.pojo.StaffCriteria;
import com.jiangtao.cos.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImp implements StaffService{
    @Autowired
    StaffMapper staffMapper;
    @Override
    public boolean addStaff(Staff staff) {
        staffMapper.insertSelective(staff);
        return true;
    }

    @Override
    public Staff findStaffById(String id) {
        StaffCriteria staffCriteria = new StaffCriteria();
        return staffMapper.selectByPrimaryKey(id);
    }
}
