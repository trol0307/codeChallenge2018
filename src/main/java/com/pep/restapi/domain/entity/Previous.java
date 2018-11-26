package com.pep.restapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Previous {

    private Integer y;
    private Integer x;

    @Override
    public String toString() {
        return "Previous{" +
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

    public Previous(){}

}
