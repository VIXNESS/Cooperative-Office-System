package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.AtmTran;
import com.jiangtao.cos.pojo.AtmTranCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtmTranServiceImp implements AtmTranService {
    @Override
    public List<AtmTran> get(AtmTranCriteria atmTranCriteria) throws Exception {
        return null;
    }

    @Override
    public List<AtmTran> get(AtmTranCriteria atmTranCriteria, int page, int row) throws Exception {
        return null;
    }

    @Override
    public AtmTran getByPk(AtmTranCriteria atmTranCriteria) throws Exception {
        return null;
    }

    @Override
    public int insert(List<AtmTran> atmTranList) throws Exception {
        return 0;
    }

    @Override
    public int insert(AtmTran atmTran) throws Exception {
        return 0;
    }

    @Override
    public int delete(AtmTran atmTran) throws Exception {
        return 0;
    }

    @Override
    public int delete(AtmTranCriteria atmTranCriteria) throws Exception {
        return 0;
    }

    @Override
    public int delete(List<AtmTran> atmTranList) throws Exception {
        return 0;
    }

    @Override
    public int update(AtmTran atmTran) throws Exception {
        return 0;
    }

    @Override
    public int update(List<AtmTran> atmTranList) throws Exception {
        return 0;
    }

    @Override
    public int update(AtmTranCriteria atmTranCriteria) throws Exception {
        return 0;
    }
}
