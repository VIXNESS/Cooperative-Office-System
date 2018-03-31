package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.Staff;
import com.jiangtao.cos.pojo.StaffCriteria;

import java.util.List;

public interface StaffService {
    /**
     *
     * @param staffCriteria
     * @return Staff list
     * @throws Exception
     */
    List<Staff> get(StaffCriteria staffCriteria)throws Exception;

    /**
     *
     * @param staffCriteria
     * @param page
     * @param row
     * @return Staff list
     * @throws Exception
     */
    List<Staff> get(StaffCriteria staffCriteria,int page,int row)throws Exception;

    /**
     *
     * @param pk
     * @return Staff
     * @throws Exception
     */
    Staff getByPk(String pk)throws Exception;

    /**
     *
     * @param staffList
     * @return Method result
     * @throws Exception
     */
    int insert(List<Staff> staffList)throws Exception;

    /**
     *
     * @param staff
     * @return Method result
     * @throws Exception
     */
    int insert(Staff staff)throws Exception;

    /**
     *
     * @param staffPk
     * @return Method result
     * @throws Exception
     */
    int delete(String staffPk)throws Exception;

    /**
     *
     * @param staffCriteria
     * @return Method result
     * @throws Exception
     */
    int delete(StaffCriteria staffCriteria)throws Exception;

    /**
     *
     * @param staffList
     * @return Method result
     * @throws Exception
     */
    int delete(List<Staff> staffList)throws Exception;

    /**
     *
     * @param staff
     * @return Method result
     * @throws Exception
     */
    int update(Staff staff)throws Exception;
}
