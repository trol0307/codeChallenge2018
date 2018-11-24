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

    private Integer distance;

    private Radar radar;

    public void run(GamePost gamepost){
        partida = Partida.partidaExist(gamepost);
        map = partida.map();
        MapConstructor mapConstructor = new MapConstructor(map,gamepost.getBoard().getWalls(),gamepost.getPlayer().getArea(),gamepost.getInvaders(),gamepost.getPlayers(),gamepost.getPlayer()  );
        mapConstructor.init();
        mapConstructor.setWalls();
        mapConstructor.setInvaders();
        mapConstructor.setEnemies();
        mapConstructor.setPlayer();
        Radar radar = new Radar(map,gamepost.getBoard().getWalls(),gamepost.getPlayer().getArea(),gamepost.getInvaders(),gamepost.getPlayers(),gamepost.getPlayer()  );

        ViewMap.View(map);

        System.out.println("closest enemy at:" + radar.closestEnemy());
        System.out.println("closest invader at:" + radar.closestInvader());


    }

}
