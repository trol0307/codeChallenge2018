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

    private Distance closestEnemy;

    private Distance closestInvader;

    private Distance closestNeutralInvader;

    private Distance closestSpace;

    private List<String> freePositions = new ArrayList<>();

    public Radar(Map map, List<WallPosition> walls, Area visibleArea, List<Invader> invaders, List<Enemy> enemies, Player player){
        this.map = map;
        this.walls = walls;
        this.visbleArea = visibleArea;
        this.invaders = invaders;
        this.enemies = enemies;
        this.player = player;
        closestEnemy = new Distance();
        closestEnemy.setDist(20);
        closestNeutralInvader = new Distance();
        closestNeutralInvader.setDist(20);
        closestInvader = new Distance();
        closestInvader.setDist(20);
        closestSpace = new Distance();
        closestSpace.setDist(20);

        String element ;

        for(Integer i = visbleArea.getY1(); i<visbleArea.getY2();i++){
            for(Integer t = visbleArea.getX1(); t<visbleArea.getX2(); t++){
                element = map.getMapElement(i, t);
                switch(element){
                    case "invader":
                        Distance distInvader = DistanceCalculator.distance(map, player.getPosition().getY(),player.getPosition().getX(),i,t);
                        if (distInvader.getDist()<closestInvader.getDist() && !distInvader.getBarrier()) {
                            closestInvader = distInvader;
                        }
                        break;
                    case "invader-neutral":
                        Distance distNeutralInvader = DistanceCalculator.distance(map, player.getPosition().getY(),player.getPosition().getX(),i,t);
                        if (distNeutralInvader.getDist()<closestNeutralInvader.getDist() && !distNeutralInvader.getBarrier()) {
                            closestNeutralInvader = distNeutralInvader;
                        }
                        break;
                    case "enemy":
                        Distance distEnemy = DistanceCalculator.distance(map, player.getPosition().getY(),player.getPosition().getX(),i,t);
                        if (distEnemy.getDist()<closestEnemy.getDist() && !distEnemy.getBarrier() && distEnemy.getTargetActive()) {
                            closestEnemy = distEnemy;
                        }
                        break;

                }
            }
        }
    }

    public Distance closestEnemy(){

        return closestEnemy;
    }

    public Distance closestInvader(){

        return closestInvader;
    }

    public Distance closestNeutralInvader(){

        return closestNeutralInvader;
    }

    public String closestEmptySpace(){

        List<String> freePositions = new ArrayList<>();
        if (map.getMapElement(player.getPosition().getY(),player.getPosition().getX()+1)=="space") {freePositions.add("right");}
        if (map.getMapElement(player.getPosition().getY(),player.getPosition().getX()-1)=="space") {freePositions.add("left");}
        if (map.getMapElement(player.getPosition().getY()-1,player.getPosition().getX())=="space") {freePositions.add("up");}
        if (map.getMapElement(player.getPosition().getY()+1,player.getPosition().getX())=="space") {freePositions.add("down");}
        Random rand = new Random();

        Integer randomNumber = rand.nextInt(freePositions.size()-1)+1;

        return freePositions.get(randomNumber);
    }
}
