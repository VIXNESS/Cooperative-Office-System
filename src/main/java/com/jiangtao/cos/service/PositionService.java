package com.jiangtao.cos.service;

import com.jiangtao.cos.pojo.Position;
import com.jiangtao.cos.pojo.PositionCriteria;

import java.util.List;

public interface PositionService {
    List<Position> get(PositionCriteria positionCriteria);
    List<Position> get(PositionCriteria positionCriteria, int page, int row);
    Position getByPk(PositionCriteria positionCriteria);
    int insert(List<Position> positionList);
    int insert(Position position);
    int delete(List<Position> positionList);
    int delete(PositionCriteria positionCriteria);
    int delete(Position position);
    int update(Position position);
    int update(PositionCriteria positionCriteria);
    int update(List<Position> positionList);
}
