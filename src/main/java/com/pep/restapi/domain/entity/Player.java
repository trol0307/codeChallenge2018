package com.pep.restapi.domain.entity;

import java.util.UUID;

public class Player {
    private UUID id;
    private String name;
    private Position position;
    private Previous Previous;
    private Area area;
    private Boolean fire;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Previous getPrevious() {
        return Previous;
    }

    public void setPrevious(Previous Previous) {
        this.Previous = Previous;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Boolean getFire() {
        return fire;
    }

    public void setFire(Boolean fire) {
        this.fire = fire;
    }

    public Player(){}

    public Player(UUID id, String name, Position position, Previous Previous, Area area, Boolean fire){
        this.id = id;
        this.name = name;
        this.position = position;
        this.Previous = Previous;
        this.area = area;
        this.fire = fire;
    }


}
