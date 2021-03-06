package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.RvObject;
import com.jiangtao.cos.pojo.RvObjectCriteria;

import java.util.List;

public interface RvObjectService {
    /**
     *
     * @param rvObjectCriteria
     * @return RvObject list
     * @throws Exception
     */
    List<RvObject> get(RvObjectCriteria rvObjectCriteria)throws Exception;
    List<RvObject> get(RvObjectCriteria rvObjectCriteria,int page, int row)throws Exception;
    RvObject getByPk(String pk);
    int insert(RvObject rvObject);
    int delete(RvObjectCriteria rvObjectCriteria)throws Exception;
    int delete(String pk)throws Exception;
    int update(RvObject rvObject);
}
