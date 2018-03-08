package com.jiangtao.cos.dao;

import com.jiangtao.cos.pojo.RvObject;
import com.jiangtao.cos.pojo.RvObjectCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface RvObjectMapper {
    long countByExample(RvObjectCriteria example);

    int deleteByExample(RvObjectCriteria example);

    int deleteByPrimaryKey(String objPk);

    int insert(RvObject record);

    int insertSelective(RvObject record);

    List<RvObject> selectByExampleWithRowbounds(RvObjectCriteria example, RowBounds rowBounds);

    List<RvObject> selectByExample(RvObjectCriteria example);

    RvObject selectByPrimaryKey(String objPk);

    int updateByExampleSelective(@Param("record") RvObject record, @Param("example") RvObjectCriteria example);

    int updateByExample(@Param("record") RvObject record, @Param("example") RvObjectCriteria example);

    int updateByPrimaryKeySelective(RvObject record);

    int updateByPrimaryKey(RvObject record);
}