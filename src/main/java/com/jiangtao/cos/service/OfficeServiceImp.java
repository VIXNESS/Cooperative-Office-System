package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.Office;
import com.jiangtao.cos.pojo.OfficeCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServiceImp implements OfficeService {
    @Override
    public List<Office> get(OfficeCriteria officeCriteria) throws Exception {
        return null;
    }

    @Override
    public List<Office> get(OfficeCriteria officeCriteria, int page, int row) throws Exception {
        return null;
    }

    @Override
    public Office getByPk(OfficeCriteria officeCriteria) throws Exception {
        return null;
    }

    @Override
    public int insert(List<Office> officeList) throws Exception {
        return 0;
    }

    @Override
    public int insert(Office office) throws Exception {
        return 0;
    }

    @Override
    public int delete(Office office) throws Exception {
        return 0;
    }

    @Override
    public int delete(List<Office> officeList) throws Exception {
        return 0;
    }

    @Override
    public int delete(OfficeCriteria officeCriteria) throws Exception {
        return 0;
    }

    @Override
    public int update(Office office) throws Exception {
        return 0;
    }

    @Override
    public int update(OfficeCriteria officeCriteria) throws Exception {
        return 0;
    }

    @Override
    public int update(List<Office> officeList) throws Exception {
        return 0;
    }
}
