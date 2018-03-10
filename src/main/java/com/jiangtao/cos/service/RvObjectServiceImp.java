package com.jiangtao.cos.service;

import com.github.pagehelper.PageHelper;
import com.jiangtao.cos.dao.RvFlowMapper;
import com.jiangtao.cos.dao.RvObjectMapper;
import com.jiangtao.cos.pojo.RvFlowCriteria;
import com.jiangtao.cos.pojo.RvObject;
import com.jiangtao.cos.pojo.RvObjectCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RvObjectServiceImp implements RvObjectService {

    @Autowired
    RvObjectMapper rvObjectMapper;

    @Autowired
    RvFlowMapper rvFlowMapper;

    @Override
    public List<RvObject> get(RvObjectCriteria rvObjectCriteria) throws Exception {
        return rvObjectMapper.selectByExample(rvObjectCriteria);
    }

    @Override
    public List<RvObject> get(RvObjectCriteria rvObjectCriteria, int page, int row) throws Exception {
        PageHelper.startPage(page,row);
        return rvObjectMapper.selectByExample(rvObjectCriteria);
    }

    @Override
    public RvObject getByPk(String pk){
        return rvObjectMapper.selectByPrimaryKey(pk);
    }

    @Override
    public int insert(RvObject rvObject){
        return rvObjectMapper.insert(rvObject);
    }

    @Override
    public int delete(RvObjectCriteria rvObjectCriteria) throws Exception {
        List<RvObject> rvObjectList = rvObjectMapper.selectByExample(rvObjectCriteria);
        RvFlowCriteria rvFlowCriteria;
        for(RvObject r : rvObjectList){
            rvFlowCriteria = new RvFlowCriteria();
            rvFlowCriteria.or().andObjEqualTo(r.getObjPk());
            rvFlowMapper.deleteByExample(rvFlowCriteria);
        }
        return rvObjectMapper.deleteByExample(rvObjectCriteria);
    }

    @Override
    public int delete(String pk) throws Exception {
        RvFlowCriteria rvFlowCriteria = new RvFlowCriteria();
        rvFlowCriteria.or().andObjEqualTo(pk);
        rvFlowMapper.deleteByExample(rvFlowCriteria);
        return rvObjectMapper.deleteByPrimaryKey(pk);
    }

    @Override
    public int update(RvObject rvObject){
        return rvObjectMapper.updateByPrimaryKeySelective(rvObject);
    }
}
