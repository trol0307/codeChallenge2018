package com.pep.restapi.domain.service;


import com.pep.restapi.domain.entity.*;
import com.pep.restapi.domain.valueobjects.GamePost;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProcessAction {

    private Partida partida;

    private Map map;

    private Integer distance;

    private Radar radar;

    public String run(GamePost gamepost){

        partida = Partida.partidaExist(gamepost);

        map = partida.map();

        MapConstructor mapConstructor = new MapConstructor(map,gamepost.getBoard().getWalls(),gamepost.getPlayer().getArea(),gamepost.getInvaders(),gamepost.getPlayers(),gamepost.getPlayer()  );
        mapConstructor.init();
        mapConstructor.setWalls();
        mapConstructor.setInvaders();
        mapConstructor.setEnemies();
        mapConstructor.setPlayer();
        ViewMap.View(map);
        Radar radar = new Radar(map,gamepost.getBoard().getWalls(),gamepost.getPlayer().getArea(),gamepost.getInvaders(),gamepost.getPlayers(),gamepost.getPlayer()  );



        System.out.println("closest enemy at:" + radar.closestEnemy().toString());
        System.out.println("closest invader at:" + radar.closestInvader().toString());
        System.out.println("closestEmptySpace at:" + radar.closestEmptySpace());

        Boolean activeEnemy = radar.closestEnemy().getDist()<20 ? true : false;

        Boolean activeInvader = radar.closestInvader().getDist()<20 ? true : false;

        if (activeEnemy && activeInvader){
            System.out.println("closest active enemy at:" + radar.closestEnemy().toString());
            System.out.println("closest active invader at:" + radar.closestInvader().toString());
            if (radar.closestEnemy().getDist()<=radar.closestInvader().getDist()){
                System.out.println("target active enemy at:" + radar.closestEnemy().toString());
                return "fire-"+radar.closestEnemy().getDirection();
            } else {
                System.out.println("target active invader at:" + radar.closestInvader().toString());
                return "fire-"+radar.closestInvader().getDirection();
            }
        } else if (activeEnemy && !activeInvader){
            System.out.println("target active enemy at:" + radar.closestEnemy().toString());
            return "fire-"+radar.closestEnemy().getDirection();
        } else if (activeInvader && !activeEnemy){
            System.out.println("target active invader at:" + radar.closestInvader().toString());
            return "fire-"+radar.closestInvader().getDirection();
        } else {
            System.out.println("target free space at:" + radar.closestEmptySpace());
            return radar.closestEmptySpace();
        }

    }

}
