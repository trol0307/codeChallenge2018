package com.pep.restapi.domain.entity;

public class Invader {
    
    private Integer y;
    private Integer x;
    private Boolean neutral;

    @Override
    public String toString() {
        return "Invader{" +
                "y=" + y +
                ", x=" + x +
                ", neutral=" + neutral +
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

    public Boolean getNeutral() {
        return neutral;
    }

    public void setNeutral(Boolean neutral) {
        this.neutral = neutral;
    }

    public Invader(){}
}
