package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.Office;
import com.jiangtao.cos.pojo.OfficeCriteria;
import com.jiangtao.cos.pojo.OfficeKey;

import java.util.List;

public interface OfficeService {
    List<Office> get(OfficeCriteria officeCriteria)throws Exception;
    List<Office> get(OfficeCriteria officeCriteria,int page, int row)throws Exception;
    Office getByPk(OfficeKey officeKey)throws Exception;
    int insert(Office office)throws Exception;
    int delete(Office office)throws Exception;
    int delete(OfficeCriteria officeCriteria)throws Exception;
    int update(Office office)throws Exception;
}
