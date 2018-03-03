package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.Department;
import com.jiangtao.cos.pojo.DepartmentCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService {
    @Override
    public List<Department> get(DepartmentCriteria departmentCriteria) throws Exception {
        return null;
    }

    @Override
    public List<Department> get(DepartmentCriteria departmentCriteria, int page, int row) throws Exception {
        return null;
    }

    @Override
    public Department getByPk(DepartmentCriteria departmentCriteria) throws Exception {
        return null;
    }

    @Override
    public int insert(List<Department> departmentList) throws Exception {
        return 0;
    }

    @Override
    public int insert(Department department) throws Exception {
        return 0;
    }

    @Override
    public int delete(DepartmentCriteria departmentCriteria) throws Exception {
        return 0;
    }

    @Override
    public int delete(Department department) throws Exception {
        return 0;
    }

    @Override
    public int delete(List<Department> departmentList) throws Exception {
        return 0;
    }

    @Override
    public int update(Department department) throws Exception {
        return 0;
    }

    @Override
    public int update(List<Department> departmentList) throws Exception {
        return 0;
    }

    @Override
    public int update(DepartmentCriteria departmentCriteria) throws Exception {
        return 0;
    }
}
