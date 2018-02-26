package com.jiangtao.cos.dao;

import com.jiangtao.cos.pojo.RvFlowCriteria;
import com.jiangtao.cos.pojo.RvFlowKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RvFlowMapper {
    long countByExample(RvFlowCriteria example);

    int deleteByExample(RvFlowCriteria example);

    int deleteByPrimaryKey(RvFlowKey key);

    int insert(RvFlowKey record);

    int insertSelective(RvFlowKey record);

    List<RvFlowKey> selectByExampleWithRowbounds(RvFlowCriteria example, RowBounds rowBounds);

    List<RvFlowKey> selectByExample(RvFlowCriteria example);

    int updateByExampleSelective(@Param("record") RvFlowKey record, @Param("example") RvFlowCriteria example);

    int updateByExample(@Param("record") RvFlowKey record, @Param("example") RvFlowCriteria example);
}