package com.jiangtao.cos.service;

import com.github.pagehelper.PageHelper;
import com.jiangtao.cos.dao.OfficeMapper;
import com.jiangtao.cos.pojo.Office;
import com.jiangtao.cos.pojo.OfficeCriteria;
import com.jiangtao.cos.pojo.OfficeKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServiceImp implements OfficeService {
    @Autowired
    OfficeMapper officeMapper;
    @Override
    public List<Office> get(OfficeCriteria officeCriteria) throws Exception {
        return officeMapper.selectByExample(officeCriteria);
    }

    @Override
    public List<Office> get(OfficeCriteria officeCriteria, int page, int row) throws Exception {
        PageHelper.startPage(page,row);
        return officeMapper.selectByExample(officeCriteria);
    }

    @Override
    public Office getByPk(OfficeKey officeKey) throws Exception {
        return officeMapper.selectByPrimaryKey(officeKey);
    }

    @Override
    public int insert(Office office) throws Exception {
        return officeMapper.insert(office);
    }

    @Override
    public int delete(Office office) throws Exception {
        //TODO
        return 0;
    }

    @Override
    public int delete(OfficeCriteria officeCriteria) throws Exception {
        //TODO
        return 0;
    }

    @Override
    public int update(Office office) throws Exception {
        //TODO
        return 0;
    }
}
