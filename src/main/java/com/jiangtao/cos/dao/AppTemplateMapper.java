package com.jiangtao.cos.dao;

import com.jiangtao.cos.pojo.AppTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AppTemplateMapper {
    String select = "SELECT * from app_template where objpk = #{objpk};";
    String selectPk = "SELECT * from app_template where pk = #{pk};";
    String selectAll = "SELECT * from app_template;";
    String update = "UPDATE app_template SET template = #{template} WHERE objpk = #{objpk};";
    String delete = "UPDATE app_template SET objpk = null where pk = #{pk};";
    String insert = "INSERT INTO app_template (pk, objpk, template) VALUES (#{pk}, #{objpk}, #{template});";

    @Select(select)
    @Results(value = {
            @Result(property = "pk",column = "pk"),
            @Result(property = "objpk",column = "objpk"),
            @Result(property = "template",column = "template")
    })
    AppTemplate selectByObjPk(String objpk);

    @Select(selectPk)
    @Results(value = {
            @Result(property = "pk",column = "pk"),
            @Result(property = "objpk",column = "objpk"),
            @Result(property = "template",column = "template")
    })
    AppTemplate selectByPk(String pk);

    @Select(selectAll)
    @Results(value = {
            @Result(property = "pk",column = "pk"),
            @Result(property = "objpk",column = "objpk"),
            @Result(property = "template",column = "template")
    })
    List<AppTemplate> selectAll();

    @Select(update)
    @Results(value = {
            @Result(property = "pk",column = "pk"),
            @Result(property = "objpk",column = "objpk"),
            @Result(property = "template",column = "template")
    })
    void update(AppTemplate appTemplate);

    @Select(delete)
    @Results(value = {
            @Result(property = "pk",column = "pk"),
            @Result(property = "objpk",column = "objpk"),
            @Result(property = "template",column = "template")
    })
    void delete(String pk);

    @Select(insert)
    @Results(value = {
            @Result(property = "pk",column = "pk"),
            @Result(property = "objpk",column = "objpk"),
            @Result(property = "template",column = "template")
    })
    void insert(AppTemplate appTemplate);
}
