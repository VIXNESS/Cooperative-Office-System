package com.jiangtao.cos.dao;

import com.jiangtao.cos.pojo.Position;
import com.jiangtao.cos.pojo.PositionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PositionMapper {
    long countByExample(PositionCriteria example);

    int deleteByExample(PositionCriteria example);

    int deleteByPrimaryKey(Byte posiPk);

    int insert(Position record);

    int insertSelective(Position record);

    List<Position> selectByExampleWithRowbounds(PositionCriteria example, RowBounds rowBounds);

    List<Position> selectByExample(PositionCriteria example);

    Position selectByPrimaryKey(Byte posiPk);

    int updateByExampleSelective(@Param("record") Position record, @Param("example") PositionCriteria example);

    int updateByExample(@Param("record") Position record, @Param("example") PositionCriteria example);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
}