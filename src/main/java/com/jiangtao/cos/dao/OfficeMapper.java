package com.jiangtao.cos.dao;

import com.jiangtao.cos.pojo.Office;
import com.jiangtao.cos.pojo.OfficeCriteria;
import com.jiangtao.cos.pojo.OfficeKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OfficeMapper {
    long countByExample(OfficeCriteria example);

    int deleteByExample(OfficeCriteria example);

    int deleteByPrimaryKey(OfficeKey key);

    int insert(Office record);

    int insertSelective(Office record);

    List<Office> selectByExampleWithRowbounds(OfficeCriteria example, RowBounds rowBounds);

    List<Office> selectByExample(OfficeCriteria example);

    Office selectByPrimaryKey(OfficeKey key);

    int updateByExampleSelective(@Param("record") Office record, @Param("example") OfficeCriteria example);

    int updateByExample(@Param("record") Office record, @Param("example") OfficeCriteria example);

    int updateByPrimaryKeySelective(Office record);

    int updateByPrimaryKey(Office record);
}