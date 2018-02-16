package com.jiangtao.cos.dao;

import com.jiangtao.cos.pojo.Staff;
import com.jiangtao.cos.pojo.StaffCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface StaffMapper {
    long countByExample(StaffCriteria example);

    int deleteByExample(StaffCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Staff record);

    int insertSelective(Staff record);

    List<Staff> selectByExampleWithRowbounds(StaffCriteria example, RowBounds rowBounds);

    List<Staff> selectByExample(StaffCriteria example);

    Staff selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Staff record, @Param("example") StaffCriteria example);

    int updateByExample(@Param("record") Staff record, @Param("example") StaffCriteria example);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
}