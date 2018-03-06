package com.jiangtao.cos.service;

import com.github.pagehelper.PageHelper;
import com.jiangtao.cos.dao.AtmTranMapper;
import com.jiangtao.cos.pojo.AtmTran;
import com.jiangtao.cos.pojo.AtmTranCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtmTranServiceImp implements AtmTranService {
    @Autowired
    AtmTranMapper atmTranMapper;
    @Override
    public List<AtmTran> get(AtmTranCriteria atmTranCriteria) throws Exception {
        return atmTranMapper.selectByExample(atmTranCriteria);
    }

    @Override
    public List<AtmTran> get(AtmTranCriteria atmTranCriteria, int page, int row) throws Exception {
        PageHelper.startPage(page,row);
        return atmTranMapper.selectByExample(atmTranCriteria);
    }

    @Override
    public AtmTran getByPk(String pk) throws Exception {
        return atmTranMapper.selectByPrimaryKey(pk);
    }

    @Override
    public int insert(AtmTran atmTran) throws Exception {
        return atmTranMapper.insert(atmTran);
    }

    @Override
    public int delete(String pk) throws Exception {
        return atmTranMapper.deleteByPrimaryKey(pk);
    }

    @Override
    public int delete(AtmTranCriteria atmTranCriteria) throws Exception {
        return atmTranMapper.deleteByExample(atmTranCriteria);
    }

    @Override
    public int update(AtmTran atmTran) throws Exception {
        return atmTranMapper.updateByPrimaryKeySelective(atmTran);
    }

}
