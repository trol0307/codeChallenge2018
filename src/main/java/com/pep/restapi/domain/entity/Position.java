package com.pep.restapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Position {

    private Integer y;
    private Integer x;

    @Override
    public String toString() {
        return "Position{" +
                "y=" + y +
                ", x=" + x +
                '}';
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Position(Integer y, Integer x){
        this.y = y;
        this.x = x;
    }
    public Position(){}

    public List<Integer> playerPosition(){
        List<Integer> position = new ArrayList<>();
        position.add(this.y);
        position.add(this.x);
        return position;
    }
}
