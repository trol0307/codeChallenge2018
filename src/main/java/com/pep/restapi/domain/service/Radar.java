package com.pep.restapi.domain.service;

import com.pep.restapi.domain.entity.*;
import com.pep.restapi.domain.valueobjects.Distance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public Distance closestEnemyData(){

        Distance closestEnemyRadarInfo = new Distance();
        closestEnemyRadarInfo.setDist(20);
        for (Enemy enemy : enemies)
        {
            Distance dist = DistanceCalculator.distance(map, player.getPosition().getY(),player.getPosition().getX(),enemy.getY(),enemy.getX());
            if (dist.getDist()<closestEnemyRadarInfo.getDist() ) {
                closestEnemyRadarInfo = dist;
            }
        }
        return closestEnemyRadarInfo;
    }

    public Distance closestInvaderData(){

        Distance closestInvaderRadarInfo = new Distance();
        closestInvaderRadarInfo.setDist(20);
        for (Invader invader : invaders)
        {
            Distance dist = DistanceCalculator.distance(map, player.getPosition().getY(),player.getPosition().getX(),invader.getY(),invader.getX());
            if (dist.getDist()<closestInvaderRadarInfo.getDist() ) {
                closestInvaderRadarInfo = dist;
            }
        }
        return closestInvaderRadarInfo;
    }

    public String closestEmptySpace(){


        Distance distRight = DistanceCalculator.distance(map, player.getPosition().getY(),player.getPosition().getX(),player.getPosition().getY(),player.getPosition().getX()+1);
        Distance distLeft = DistanceCalculator.distance(map, player.getPosition().getY(),player.getPosition().getX(),player.getPosition().getY(),player.getPosition().getX()-1);
        Distance distUp = DistanceCalculator.distance(map, player.getPosition().getY(),player.getPosition().getX(),player.getPosition().getY()-1,player.getPosition().getX());
        Distance distDown = DistanceCalculator.distance(map, player.getPosition().getY(),player.getPosition().getX(),player.getPosition().getY()+1,player.getPosition().getX());
        List<String> freePositions = new ArrayList<>();
        if (!distRight.getBarrier()) {freePositions.add("right");}
        if (!distLeft.getBarrier()) {freePositions.add("left");}
        if (!distUp.getBarrier()) {freePositions.add("up");}
        if (!distDown.getBarrier()) {freePositions.add("down");}
        Random rand = new Random();

        Integer randomNumber = rand.nextInt(freePositions.size()-1)+1;

        return freePositions.get(randomNumber);
    }
}
