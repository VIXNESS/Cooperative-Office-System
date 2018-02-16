package com.jiangtao.cos.dao;

import com.jiangtao.cos.pojo.Office;
import com.jiangtao.cos.pojo.OfficeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OfficeMapper {
    long countByExample(OfficeCriteria example);

    int deleteByExample(OfficeCriteria example);

    int insert(Office record);

    int insertSelective(Office record);

    List<Office> selectByExampleWithRowbounds(OfficeCriteria example, RowBounds rowBounds);

    List<Office> selectByExample(OfficeCriteria example);

    int updateByExampleSelective(@Param("record") Office record, @Param("example") OfficeCriteria example);

    int updateByExample(@Param("record") Office record, @Param("example") OfficeCriteria example);
}