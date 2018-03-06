package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.RvFlowCriteria;
import com.jiangtao.cos.pojo.RvFlowKey;

import java.util.List;

public interface RvFlowService {
    List<RvFlowKey> get(RvFlowCriteria rvFlowCriteria)throws Exception;
    List<RvFlowKey> get(RvFlowCriteria rvFlowCriteria,int page, int row)throws Exception;
    int insert(RvFlowKey rvFlowKey)throws Exception;
    int delete(RvFlowKey rvFlowKey)throws Exception;
    int delete(RvFlowCriteria rvFlowCriteria)throws Exception;
    int update(RvFlowKey rvFlowKey,RvFlowCriteria rvFlowCriteria)throws Exception;
}
