package com.pep.restapi.domain.entity;

import java.util.UUID;

public class Game {

    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Game(){}

    public Game(UUID id){
        this.id = id;
    }

    public UUID id(){
        return this.id;
    }
}
