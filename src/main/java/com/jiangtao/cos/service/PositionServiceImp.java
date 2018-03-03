package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.Position;
import com.jiangtao.cos.pojo.PositionCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImp implements PositionService {
    @Override
    public List<Position> get(PositionCriteria positionCriteria) {
        return null;
    }

    @Override
    public List<Position> get(PositionCriteria positionCriteria, int page, int row) {
        return null;
    }

    @Override
    public Position getByPk(PositionCriteria positionCriteria) {
        return null;
    }

    @Override
    public int insert(List<Position> positionList) {
        return 0;
    }

    @Override
    public int insert(Position position) {
        return 0;
    }

    @Override
    public int delete(List<Position> positionList) {
        return 0;
    }

    @Override
    public int delete(PositionCriteria positionCriteria) {
        return 0;
    }

    @Override
    public int delete(Position position) {
        return 0;
    }

    @Override
    public int update(Position position) {
        return 0;
    }

    @Override
    public int update(PositionCriteria positionCriteria) {
        return 0;
    }

    @Override
    public int update(List<Position> positionList) {
        return 0;
    }
}
