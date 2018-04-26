package com.jiangtao.cos.dao;

import com.jiangtao.cos.pojo.LogView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LogViewMapper {
    String selectByUser = "SELECT staff_id, ap_pk, ap_actor,ap_date,category,rv_pk,obj_name,name FROM log INNER JOIN application on application.ap_pk = log.content INNER JOIN rv_object o on application.rv_pk = o.obj_pk INNER JOIN staff s on application.ap_actor = s.id WHERE (category = 1 OR category = 2) AND staff_id = #{staffId};";
    @Select(selectByUser)
    @Results(value = {
            @Result(property = "staffId", column = "staff_id"),
            @Result(property = "apPk", column = "ap_pk"),
            @Result(property = "apActor", column = "ap_actor"),
            @Result(property = "apDate", column = "ap_date"),
            @Result(property = "category", column = "category"),
            @Result(property = "rvPk", column = "rv_pk"),
            @Result(property = "objName",column = "obj_name"),
            @Result(property = "name", column = "name")
    })
    List<LogView> selectByStaffId(String staffId);
}
