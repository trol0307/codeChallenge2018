package com.pep.restapi.domain.service;

import com.pep.restapi.domain.entity.*;
import com.pep.restapi.domain.valueobjects.Area;

import java.util.List;

public class MapConstructor {

    private Map map;

    private List<WallPosition> walls;

    private List<Invader> invaders;

    private List<Enemy> enemies;

    private Player player;

    private Area visbleArea;
    
    public MapConstructor(Map map, List<WallPosition> walls, Area visbleArea, List<Invader> invaders, List<Enemy> enemies, Player player){
        this.map = map;
        this.walls = walls;
        this.visbleArea = visbleArea;
        this.invaders = invaders;
        this.enemies = enemies;
        this.player = player;
    }

    private Boolean checkVisibility(Integer y, Integer x){

        if (y>=visbleArea.getY1() && y<=visbleArea.getY2() && x>=visbleArea.getX1() && x<=visbleArea.getX2()) {
            return true;
        }
        return false;
    }

    private String checkInvader(Invader invader){

        if (invader.getNeutral()) {
            return "invader-neutral";
        }
        return "invader";
    }

    public void init(){
        for (Integer y=0;y<map.getMapHeight();y++){
            for (Integer x=0;x<map.getMapWidth();x++) {
                if (y == 0 || y == map.getMapHeight()-1) {
                    map.setElementOnMap(y,x,"walls",checkVisibility(y,x));
                } else if (x == 0 || x   == map.getMapWidth()-1) {
                    map.setElementOnMap(y,x,"walls",checkVisibility(y,x));
                } else {
                    map.setElementOnMap(y,x,"space",checkVisibility(y,x));
                }

            }
        }
    }

    public void setWalls(){

        for (WallPosition wallPosition : walls)
        {
            map.setElementOnMap(wallPosition.getY(), wallPosition.getX(),"walls",checkVisibility(wallPosition.getY(),wallPosition.getX()));
        }
    }

    public void setInvaders(){

        for (Invader invader : invaders)
        {
            map.setElementOnMap(invader.getY(), invader.getX(),checkInvader(invader),checkVisibility(invader.getY(),invader.getX()));
        }
    }

    public void setEnemies(){

        for (Enemy enemy : enemies)
        {
            map.setElementOnMap(enemy.getY(), enemy.getX(),"enemy",checkVisibility(enemy.getY(),enemy.getX()));
        }
    }

    public void setPlayer(){

        map.setElementOnMap(player.getPosition().getY(), player.getPosition().getX(),"player",true);

    }
}
