package com.pep.restapi.domain.valueobjects;

import com.pep.restapi.domain.entity.Size;
import com.pep.restapi.domain.entity.WallPosition;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Board {

    private Size size;
    private List<WallPosition> walls;

    @Override
    public String toString() {
        return "Board{" +
                "size=" + size +
                ", walls=" + walls +
                '}';
    }

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
