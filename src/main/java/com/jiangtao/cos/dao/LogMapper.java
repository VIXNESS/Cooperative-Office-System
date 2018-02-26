package com.jiangtao.cos.dao;

import com.jiangtao.cos.pojo.Log;
import com.jiangtao.cos.pojo.LogCriteria;
import com.jiangtao.cos.pojo.LogKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LogMapper {
    long countByExample(LogCriteria example);

    int deleteByExample(LogCriteria example);

    int deleteByPrimaryKey(LogKey key);

    int insert(Log record);

    int insertSelective(Log record);

    List<Log> selectByExampleWithRowbounds(LogCriteria example, RowBounds rowBounds);

    List<Log> selectByExample(LogCriteria example);

    Log selectByPrimaryKey(LogKey key);

    int updateByExampleSelective(@Param("record") Log record, @Param("example") LogCriteria example);

    int updateByExample(@Param("record") Log record, @Param("example") LogCriteria example);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}