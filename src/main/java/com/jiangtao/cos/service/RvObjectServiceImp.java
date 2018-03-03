package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.RvObject;
import com.jiangtao.cos.pojo.RvObjectCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RvObjectServiceImp implements RvObjectService {
    @Override
    public List<RvObject> get(RvObjectCriteria rvObjectCriteria) throws Exception {
        return null;
    }

    @Override
    public List<RvObject> get(RvObjectCriteria rvObjectCriteria, int page, int row) throws Exception {
        return null;
    }

    @Override
    public RvObject getByPk(RvObjectCriteria rvObjectCriteria) throws Exception {
        return null;
    }

    @Override
    public int insert(List<RvObject> rvObjectList) throws Exception {
        return 0;
    }

    @Override
    public int insert(RvObject rvObject) throws Exception {
        return 0;
    }

    @Override
    public int delete(RvObjectCriteria rvObjectCriteria) throws Exception {
        return 0;
    }

    @Override
    public int delete(List<RvObject> rvObjectList) throws Exception {
        return 0;
    }

    @Override
    public int delete(RvObject rvObject) throws Exception {
        return 0;
    }

    @Override
    public int update(RvObject rvObject) throws Exception {
        return 0;
    }

    @Override
    public int update(List<RvObject> rvObjectList) throws Exception {
        return 0;
    }

    @Override
    public int update(RvObjectCriteria rvObjectCriteria) throws Exception {
        return 0;
    }
}
