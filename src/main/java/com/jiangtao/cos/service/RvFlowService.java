package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.RvFlowCriteria;
import com.jiangtao.cos.pojo.RvFlowKey;

import java.util.List;

public interface RvFlowService {
    List<RvFlowKey> get(RvFlowCriteria rvFlowCriteria)throws Exception;
    List<RvFlowKey> get(RvFlowCriteria rvFlowCriteria,int page, int row)throws Exception;
    RvFlowKey getByPk(RvFlowCriteria rvFlowCriteria)throws Exception;
    int insert(List<RvFlowKey> rvFlowKeyList)throws Exception;
    int insert(RvFlowKey rvFlowKey)throws Exception;
    int delete(RvFlowKey rvFlowKey)throws Exception;
    int delete(List<RvFlowKey> rvFlowKeyList)throws Exception;
    int delete(RvFlowCriteria rvFlowCriteria)throws Exception;
    int update(RvFlowKey rvFlowKey)throws Exception;
    int update(RvFlowCriteria rvFlowCriteria)throws Exception;
    int update(List<RvFlowKey> rvFlowKeyList)throws Exception;
}
