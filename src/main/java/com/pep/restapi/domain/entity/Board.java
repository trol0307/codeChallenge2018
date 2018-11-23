package com.pep.restapi.domain.entity;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Board {

    private Size size;
    private List<WallPosition> walls;

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public List<WallPosition> getWalls() {
        return walls;
    }

    public void setWalls(List<WallPosition> walls) {
        this.walls = walls;
    }

    public Board(){}


}
