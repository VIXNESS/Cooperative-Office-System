package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.Department;
import com.jiangtao.cos.pojo.DepartmentCriteria;

import java.util.List;

public interface DepartmentService {
    List<Department> get(DepartmentCriteria departmentCriteria)throws Exception;
    List<Department> get(DepartmentCriteria departmentCriteria,int page, int row)throws Exception;
    Department getByPk(DepartmentCriteria departmentCriteria)throws Exception;
    int insert(List<Department> departmentList)throws Exception;
    int insert(Department department)throws Exception;
    int delete(DepartmentCriteria departmentCriteria)throws Exception;
    int delete(Department department)throws Exception;
    int delete(List<Department> departmentList)throws Exception;
    int update(Department department)throws Exception;
    int update(List<Department> departmentList)throws Exception;
    int update(DepartmentCriteria departmentCriteria)throws Exception;
}
