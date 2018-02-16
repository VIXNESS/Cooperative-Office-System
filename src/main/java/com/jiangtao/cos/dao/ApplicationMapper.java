package com.jiangtao.cos.dao;

import com.jiangtao.cos.pojo.Application;
import com.jiangtao.cos.pojo.ApplicationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ApplicationMapper {
    long countByExample(ApplicationCriteria example);

    int deleteByExample(ApplicationCriteria example);

    int deleteByPrimaryKey(String apPk);

    int insert(Application record);

    int insertSelective(Application record);

    List<Application> selectByExampleWithRowbounds(ApplicationCriteria example, RowBounds rowBounds);

    List<Application> selectByExample(ApplicationCriteria example);

    Application selectByPrimaryKey(String apPk);

    int updateByExampleSelective(@Param("record") Application record, @Param("example") ApplicationCriteria example);

    int updateByExample(@Param("record") Application record, @Param("example") ApplicationCriteria example);

    int updateByPrimaryKeySelective(Application record);

    int updateByPrimaryKey(Application record);
}