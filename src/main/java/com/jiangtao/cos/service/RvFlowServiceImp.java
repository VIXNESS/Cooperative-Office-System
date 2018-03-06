package com.jiangtao.cos.service;

import com.github.pagehelper.PageHelper;
import com.jiangtao.cos.dao.RvFlowMapper;
import com.jiangtao.cos.pojo.RvFlowCriteria;
import com.jiangtao.cos.pojo.RvFlowKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RvFlowServiceImp implements RvFlowService {
    @Autowired
    RvFlowMapper rvFlowMapper;
    @Override
    public List<RvFlowKey> get(RvFlowCriteria rvFlowCriteria) throws Exception {
        return rvFlowMapper.selectByExample(rvFlowCriteria);
    }

    @Override
    public List<RvFlowKey> get(RvFlowCriteria rvFlowCriteria, int page, int row) throws Exception {
        PageHelper.startPage(page,row);
        return rvFlowMapper.selectByExample(rvFlowCriteria);
    }

    @Override
    public int insert(RvFlowKey rvFlowKey) throws Exception {
        return rvFlowMapper.insert(rvFlowKey);
    }

    @Override
    public int delete(RvFlowKey rvFlowKey) throws Exception {
        return rvFlowMapper.deleteByPrimaryKey(rvFlowKey);
    }

    @Override
    public int delete(RvFlowCriteria rvFlowCriteria) throws Exception {
        return rvFlowMapper.deleteByExample(rvFlowCriteria);
    }

    @Override
    public int update(RvFlowKey rvFlowKey,RvFlowCriteria rvFlowCriteria) throws Exception {
        return rvFlowMapper.updateByExampleSelective(rvFlowKey,rvFlowCriteria);
    }
}
