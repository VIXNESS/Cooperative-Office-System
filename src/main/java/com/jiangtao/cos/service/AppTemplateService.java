package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.AppTemplate;

import java.util.List;

public interface AppTemplateService {
    /**
     *
     * @param objpk
     * @return Application Template.
     */
    AppTemplate selectByObjPk(String objpk);

    /**
     *
     * @param pk
     * @return Application Template.
     */
    AppTemplate selectByPk(String pk);
    /**
     *
     * @return All of Application Templates.
     */
    List<AppTemplate> selectAll();

    /**
     *
     * @param appTemplate
     *
     */
    void update(AppTemplate appTemplate);

    /**
     *
     * @param pk
     *
     */
    void delete(String pk);

    /**
     *
     * @param appTemplate
     *
     */
    void insert(AppTemplate appTemplate);
}
