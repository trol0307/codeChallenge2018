package com.pep.restapi.domain.valueobjects;

import java.util.ArrayList;
import java.util.List;

public class Area {
    private Integer y1;
    private Integer x1;
    private Integer y2;
    private Integer x2;

    public Integer getY1() {
        return y1;
    }

    public void setY1(Integer y1) {
        this.y1 = y1;
    }

    public Integer getX1() {
        return x1;
    }

    public void setX1(Integer x1) {
        this.x1 = x1;
    }

    public Integer getY2() {
        return y2;
    }

    public void setY2(Integer y2) {
        this.y2 = y2;
    }

    public Integer getX2() {
        return x2;
    }

    public void setX2(Integer x2) {
        this.x2 = x2;
    }

    public Area(){}

    public Area(Integer y1, Integer x1, Integer y2, Integer x2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public List<Integer> area(){
        List<Integer> area = new ArrayList<>();
        area.add(this.y1);
        area.add(this.x1);
        area.add(this.y2);
        area.add(this.x2);
        return area;
    }

}
