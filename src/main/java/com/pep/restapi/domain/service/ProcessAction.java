package com.pep.restapi.domain.service;


import com.pep.restapi.domain.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProcessAction {

    private Partida partida;
    private Map map;
    private MapRow maprow;

    public String run(GamePost gamepost){
        partida = Partida.partidaExist(gamepost);
        map = partida.map();
        MapConstructor mapConstructor = new MapConstructor(map,gamepost.getBoard().getWalls(),gamepost.getPlayer().getArea(),gamepost.getInvaders());
        mapConstructor.init();
        mapConstructor.setWalls();
        ViewMap.View(map);

        return "fet";
    }

}
