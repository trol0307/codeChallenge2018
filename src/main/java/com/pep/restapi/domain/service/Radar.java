package com.pep.restapi.domain.service;

import com.pep.restapi.domain.entity.*;
import com.pep.restapi.domain.valueobjects.Distance;

import java.util.List;

public class Radar {

    private Map map;

    private List<WallPosition> walls;

    private List<Invader> invaders;

    private List<Enemy> enemies;

    private Player player;

    private Area visbleArea;

    public Radar(Map map, List<WallPosition> walls, Area visbleArea, List<Invader> invaders, List<Enemy> enemies, Player player){
        this.map = map;
        this.walls = walls;
        this.visbleArea = visbleArea;
        this.invaders = invaders;
        this.enemies = enemies;
        this.player = player;
    }

    public Integer closestEnemy(){
        Integer minDistance = 20;
        for (Enemy enemy : enemies)
        {
            Distance dist = DistanceCalculator.distance(map, player.getPosition().getY(),player.getPosition().getX(),enemy.getY(),enemy.getX());
            minDistance = (minDistance>dist.getDist())? dist.getDist() : minDistance;
        }
        return minDistance;
    }

    public Integer closestInvader(){
        Integer minDistance = 20;
        for (Invader invader : invaders)
        {
            Distance dist = DistanceCalculator.distance(map, player.getPosition().getY(),player.getPosition().getX(),invader.getY(),invader.getX());
            minDistance = (minDistance>dist.getDist())? dist.getDist() : minDistance;
        }
        return minDistance;
    }
}
