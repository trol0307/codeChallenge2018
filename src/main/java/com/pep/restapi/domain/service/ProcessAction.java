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
        Radar radar = new Radar(map,gamepost.getBoard().getWalls(),gamepost.getPlayer().getArea(),gamepost.getInvaders(),gamepost.getPlayers(),gamepost.getPlayer());




        Boolean activeEnemy = radar.closestEnemy().getDist()<20 && radar.closestEnemy().getTargetActive()? true : false;

        Boolean closeEnemy = radar.closestEnemy().getDist()<6;
        Boolean closeInvader = radar.closestInvader().getDist()<6;

        Boolean activeInvader = radar.closestInvader().getDist()<20 && radar.closestInvader().getTargetActive()? true : false;

        if (activeEnemy && activeInvader){
            System.out.println("closest active enemy at:" + radar.closestEnemy().toString());
            System.out.println("closest active invader at:" + radar.closestInvader().toString());
            if (radar.closestEnemy().getDist()<=radar.closestInvader().getDist()){
                return "fire-"+radar.closestEnemy().getDirection();
            } else {
                return "fire-"+radar.closestInvader().getDirection();
            }
        } else if (activeEnemy && !activeInvader){
            return "fire-"+radar.closestEnemy().getDirection();
        } else if (activeInvader && !activeEnemy){
            return "fire-"+radar.closestInvader().getDirection();
        } else if (closeInvader) {
            return radar.closestInvader().getDirection();
        } else if (closeEnemy) {
            return radar.closestEnemy().getDirection();
        } else {
            Route route = radar.getRoute();
            return route.getDirection();

        }

    }

}
