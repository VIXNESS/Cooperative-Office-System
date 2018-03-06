package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.AtmTran;
import com.jiangtao.cos.pojo.AtmTranCriteria;

import java.util.List;

public interface AtmTranService {
    List<AtmTran> get(AtmTranCriteria atmTranCriteria)throws Exception;
    List<AtmTran> get(AtmTranCriteria atmTranCriteria,int page,int row)throws Exception;
    AtmTran getByPk(String pk)throws Exception;
    int insert(AtmTran atmTran)throws Exception;
    int delete(String pk)throws Exception;
    int delete(AtmTranCriteria atmTranCriteria)throws Exception;
    int update(AtmTran atmTran)throws Exception;
}
