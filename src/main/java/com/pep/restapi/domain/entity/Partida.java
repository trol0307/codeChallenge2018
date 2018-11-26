package com.pep.restapi.domain.entity;


import com.pep.restapi.domain.valueobjects.GamePost;

import java.util.UUID;

public class Partida {

    private UUID id;
    private Map map;

    private static Partida instanciaUnica;

    private Partida(GamePost gamepost) {
        this.id = gamepost.getGame().getId();
        this.map = new Map(gamepost.getBoard().getSize().getHeight(),gamepost.getBoard().getSize().getWidth(),gamepost.getGame().getId());

    }

    public static Partida  partidaExist(GamePost gamepost) {

        if (instanciaUnica == null) {
            instanciaUnica = new Partida(gamepost);
        }

        if (instanciaUnica.id != gamepost.getGame().getId()){

        }
        return instanciaUnica;
    }

    public Map map(){
        return this.map;
    }
}
