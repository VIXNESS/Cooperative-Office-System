package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.RvFlowCriteria;
import com.jiangtao.cos.pojo.RvFlowKey;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RvFlowServiceImp implements RvFlowService {
    @Override
    public List<RvFlowKey> get(RvFlowCriteria rvFlowCriteria) throws Exception {
        return null;
    }

    @Override
    public List<RvFlowKey> get(RvFlowCriteria rvFlowCriteria, int page, int row) throws Exception {
        return null;
    }

    @Override
    public RvFlowKey getByPk(RvFlowCriteria rvFlowCriteria) throws Exception {
        return null;
    }

    @Override
    public int insert(List<RvFlowKey> rvFlowKeyList) throws Exception {
        return 0;
    }

    @Override
    public int insert(RvFlowKey rvFlowKey) throws Exception {
        return 0;
    }

    @Override
    public int delete(RvFlowKey rvFlowKey) throws Exception {
        return 0;
    }

    @Override
    public int delete(List<RvFlowKey> rvFlowKeyList) throws Exception {
        return 0;
    }

    @Override
    public int delete(RvFlowCriteria rvFlowCriteria) throws Exception {
        return 0;
    }

    @Override
    public int update(RvFlowKey rvFlowKey) throws Exception {
        return 0;
    }

    @Override
    public int update(RvFlowCriteria rvFlowCriteria) throws Exception {
        return 0;
    }

    @Override
    public int update(List<RvFlowKey> rvFlowKeyList) throws Exception {
        return 0;
    }
}
