package com.jiangtao.cos.service;

import com.github.pagehelper.PageHelper;
import com.jiangtao.cos.dao.DepartmentMapper;
import com.jiangtao.cos.pojo.Department;
import com.jiangtao.cos.pojo.DepartmentCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    public List<Department> get(DepartmentCriteria departmentCriteria) throws Exception {
        return departmentMapper.selectByExample(departmentCriteria);
    }

    @Override
    public List<Department> get(DepartmentCriteria departmentCriteria, int page, int row) throws Exception {
        PageHelper.startPage(page,row);
        return departmentMapper.selectByExample(departmentCriteria);
    }

    @Override
    public Department getByPk(String pk) throws Exception {
        return departmentMapper.selectByPrimaryKey(pk);
    }

    @Override
    public int insert(Department department) throws Exception {
        return departmentMapper.insertSelective(department);
    }

    @Override
    public int delete(String pk) throws Exception {
        //TODO
        return 0;
    }

    @Override
    public int delete(DepartmentCriteria departmentCriteria) throws Exception {
        //TODO
        return 0;
    }

    @Override
    public int update(Department department) throws Exception {
        //TODO
        return 0;
    }
}
