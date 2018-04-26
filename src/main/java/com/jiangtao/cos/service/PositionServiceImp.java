package com.jiangtao.cos.service;

import com.github.pagehelper.PageHelper;
import com.jiangtao.cos.dao.PositionMapper;
import com.jiangtao.cos.pojo.Position;
import com.jiangtao.cos.pojo.PositionCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImp implements PositionService {
    private final PositionMapper positionMapper;

    @Autowired
    public PositionServiceImp(PositionMapper positionMapper) {
        this.positionMapper = positionMapper;
    }

    @Override
    public List<Position> get(PositionCriteria positionCriteria) {
        return positionMapper.selectByExample(positionCriteria);
    }

    @Override
    public List<Position> get(PositionCriteria positionCriteria, int page, int row) {
        PageHelper.startPage(page,row);
        return positionMapper.selectByExample(positionCriteria);
    }

    @Override
    public Position getByPk(Byte pk) {
        return positionMapper.selectByPrimaryKey(pk);
    }

    @Override
    public int insert(Position position) {
        return positionMapper.insert(position);
    }

    @Override
    public int delete(PositionCriteria positionCriteria) {
        //TODO
        return 0;
    }

    @Override
    public int delete(Byte pk) {
        //TODO
        return 0;
    }

    @Override
    public int update(Position position) {
        //TODO
        return 0;
    }
}
