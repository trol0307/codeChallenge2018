package com.pep.restapi.domain.service;

import com.pep.restapi.domain.entity.*;
import com.pep.restapi.domain.valueobjects.Distance;

import java.util.List;

public class EnemiesRadar {

    private Map map;

    private List<WallPosition> walls;

    private List<Invader> invaders;

    private List<Enemy> enemies;

    private Player player;

    private Area visbleArea;

    public EnemiesRadar(Map map, List<WallPosition> walls, Area visbleArea, List<Invader> invaders, List<Enemy> enemies, Player player){
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
            Integer dist = Distance.Distance(player.getPosition().getY(),player.getPosition().getX(),enemy.getY(),enemy.getX());
            minDistance = (minDistance>dist)? dist : minDistance;
        }
        return minDistance;
    }
}
