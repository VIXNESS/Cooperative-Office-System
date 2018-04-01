package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.AtmTran;
import com.jiangtao.cos.pojo.AtmTranCriteria;

import java.util.List;

public interface AtmTranService {
    /**
     *
     * @param atmTranCriteria
     * @return AtmTran list
     * @throws Exception
     */
    List<AtmTran> get(AtmTranCriteria atmTranCriteria)throws Exception;

    /**
     *
     * @param atmTranCriteria
     * @param page
     * @param row
     * @return AtmTran list
     * @throws Exception
     */
    List<AtmTran> get(AtmTranCriteria atmTranCriteria, int page, int row)throws Exception;

    /**
     *
     * @param pk
     * @return a AtmTran object
     * @throws Exception
     */
    AtmTran getByPk(String pk)throws Exception;

    /**
     *
     * @param atmTran
     * @return method result
     * @throws Exception
     */
    int insert(AtmTran atmTran)throws Exception;

    /**
     *
     * @param pk
     * @return method result
     * @throws Exception
     */
    int delete(String pk)throws Exception;

    /**
     *
     * @param atmTranCriteria
     * @return method result
     * @throws Exception
     */
    int delete(AtmTranCriteria atmTranCriteria)throws Exception;

    /**
     *
     * @param atmTran
     * @return method result
     * @throws Exception
     */
    int update(AtmTran atmTran)throws Exception;

    /**
     *
     * @return count
     * @throws Exception
     */
    long countAtms(AtmTranCriteria atmTranCriteria)throws Exception;
}
