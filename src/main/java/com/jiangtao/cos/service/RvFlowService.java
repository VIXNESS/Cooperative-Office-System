package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.RvFlow;
import com.jiangtao.cos.pojo.RvFlowCriteria;

import java.util.List;

public interface RvFlowService {
    List<RvFlow> get(RvFlowCriteria rvFlowCriteria)throws Exception;
    List<RvFlow> get(RvFlowCriteria rvFlowCriteria,int page, int row)throws Exception;
    RvFlow getByPk(String pk);
    int insert(RvFlow rvFlow,String position);
    int delete(String pk)throws Exception;
    int update(RvFlow rvFlow);
    String HEAD = "head";
    String MID = "mid";
    String TAIL = "tail";
    String SIG = "sig";
}
