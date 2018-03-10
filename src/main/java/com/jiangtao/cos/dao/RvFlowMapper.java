package com.jiangtao.cos.dao;

import com.jiangtao.cos.pojo.RvFlow;
import com.jiangtao.cos.pojo.RvFlowCriteria;
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

    int deleteByPrimaryKey(String pk);

    int insert(RvFlow record);

    int insertSelective(RvFlow record);

    List<RvFlow> selectByExampleWithRowbounds(RvFlowCriteria example, RowBounds rowBounds);

    List<RvFlow> selectByExample(RvFlowCriteria example);

    RvFlow selectByPrimaryKey(String pk);

    int updateByExampleSelective(@Param("record") RvFlow record, @Param("example") RvFlowCriteria example);

    int updateByExample(@Param("record") RvFlow record, @Param("example") RvFlowCriteria example);

    int updateByPrimaryKeySelective(RvFlow record);

    int updateByPrimaryKey(RvFlow record);
}