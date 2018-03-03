package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.AtmTran;
import com.jiangtao.cos.pojo.AtmTranCriteria;

import java.util.List;

public interface AtmTranService {
    List<AtmTran> get(AtmTranCriteria atmTranCriteria)throws Exception;
    List<AtmTran> get(AtmTranCriteria atmTranCriteria,int page,int row)throws Exception;
    AtmTran getByPk(AtmTranCriteria atmTranCriteria)throws Exception;
    int insert(List<AtmTran> atmTranList)throws Exception;
    int insert(AtmTran atmTran)throws Exception;
    int delete(AtmTran atmTran)throws Exception;
    int delete(AtmTranCriteria atmTranCriteria)throws Exception;
    int delete(List<AtmTran> atmTranList)throws Exception;
    int update(AtmTran atmTran)throws Exception;
    int update(List<AtmTran> atmTranList)throws Exception;
    int update(AtmTranCriteria atmTranCriteria)throws Exception;
}
