package com.pep.restapi.domain.entity;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
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
