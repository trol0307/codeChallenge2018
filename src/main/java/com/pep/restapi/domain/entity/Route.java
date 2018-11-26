package com.pep.restapi.domain.entity;

public class Route {



    private Integer miles;

    private String direction;

    public Route(String direction, Integer miles) {
        this.miles = miles;
        this.direction = direction;
    }

    public Integer getMiles() {
        return miles;
    }

    public void setMiles(Integer miles) {
        this.miles = miles;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
