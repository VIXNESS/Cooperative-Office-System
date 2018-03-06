package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.Position;
import com.jiangtao.cos.pojo.PositionCriteria;

import java.util.List;

public interface PositionService {
    List<Position> get(PositionCriteria positionCriteria);
    List<Position> get(PositionCriteria positionCriteria, int page, int row);
    Position getByPk(Byte pk);
    int insert(Position position);
    int delete(PositionCriteria positionCriteria);
    int delete(Byte pk);
    int update(Position position);
}
