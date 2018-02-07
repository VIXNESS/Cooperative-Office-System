package com.jiangtao.cos.dao;

import com.jiangtao.cos.pojo.Student;
import com.jiangtao.cos.pojo.StudentCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentMapper {
    long countByExample(StudentCriteria example);

    int deleteByExample(StudentCriteria example);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExampleWithRowbounds(StudentCriteria example, RowBounds rowBounds);

    List<Student> selectByExample(StudentCriteria example);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentCriteria example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentCriteria example);
}