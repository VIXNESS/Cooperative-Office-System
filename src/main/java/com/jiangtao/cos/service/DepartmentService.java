package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.Department;
import com.jiangtao.cos.pojo.DepartmentCriteria;

import java.util.List;

public interface DepartmentService {
    List<Department> get(DepartmentCriteria departmentCriteria)throws Exception;
    List<Department> get(DepartmentCriteria departmentCriteria,int page, int row)throws Exception;
    Department getByPk(String pk)throws Exception;
    int insert(Department department)throws Exception;
    int delete(String pk)throws Exception;
    int delete(DepartmentCriteria departmentCriteria)throws Exception;
    int update(Department department)throws Exception;
}
