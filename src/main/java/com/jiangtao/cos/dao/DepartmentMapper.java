package com.jiangtao.cos.dao;

import com.jiangtao.cos.pojo.Department;
import com.jiangtao.cos.pojo.DepartmentCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DepartmentMapper {
    long countByExample(DepartmentCriteria example);

    int deleteByExample(DepartmentCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExampleWithRowbounds(DepartmentCriteria example, RowBounds rowBounds);

    List<Department> selectByExample(DepartmentCriteria example);

    Department selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentCriteria example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentCriteria example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}