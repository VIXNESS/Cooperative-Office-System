package com.jiangtao.cos.service;

import com.github.pagehelper.PageHelper;
import com.jiangtao.cos.dao.StaffMapper;
import com.jiangtao.cos.pojo.Staff;
import com.jiangtao.cos.pojo.StaffCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImp implements StaffService {

    @Autowired
    StaffMapper staffMapper;

    @Override
    public List<Staff> get(StaffCriteria staffCriteria) throws Exception {
        return staffMapper.selectByExample(staffCriteria);
    }

    @Override
    public List<Staff> get(StaffCriteria staffCriteria, int page, int row) throws Exception {
        PageHelper.startPage(page,row);
        return staffMapper.selectByExample(staffCriteria);
    }

    @Override
    public Staff getByPk(String pk) throws Exception {
        return staffMapper.selectByPrimaryKey(pk);
    }

    @Override
    public int insert(List<Staff> staffList) throws Exception {
        if(staffList == null) return 0;
        int flag = 0;
        for(Staff s:staffList){
            flag *= insert(s);
        }
        return flag;
    }

    @Override
    public int insert(Staff staff) throws Exception {
        return staffMapper.insertSelective(staff);
    }


    @Override
    public int delete(String staffPk) throws Exception {
        return staffMapper.deleteByPrimaryKey(staffPk);
    }

    @Override
    public int delete(StaffCriteria staffCriteria) throws Exception {
        return staffMapper.deleteByExample(staffCriteria);
    }

    @Override
    public int delete(List<Staff> staffList) throws Exception {
        if(staffList == null) return 0;
        int flag = 0;
        for(Staff staff:staffList){
            flag *= staffMapper.deleteByPrimaryKey(staff.getId());
        }
        return flag;
    }

    @Override
    public int update(Staff staff) throws Exception {
        return staffMapper.updateByPrimaryKeySelective(staff);
    }

}
