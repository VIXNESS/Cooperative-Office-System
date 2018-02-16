package com.jiangtao.cos.dao;

import com.jiangtao.cos.pojo.AtmTran;
import com.jiangtao.cos.pojo.AtmTranCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AtmTranMapper {
    long countByExample(AtmTranCriteria example);

    int deleteByExample(AtmTranCriteria example);

    int deleteByPrimaryKey(String pk);

    int insert(AtmTran record);

    int insertSelective(AtmTran record);

    List<AtmTran> selectByExampleWithRowbounds(AtmTranCriteria example, RowBounds rowBounds);

    List<AtmTran> selectByExample(AtmTranCriteria example);

    AtmTran selectByPrimaryKey(String pk);

    int updateByExampleSelective(@Param("record") AtmTran record, @Param("example") AtmTranCriteria example);

    int updateByExample(@Param("record") AtmTran record, @Param("example") AtmTranCriteria example);

    int updateByPrimaryKeySelective(AtmTran record);

    int updateByPrimaryKey(AtmTran record);
}