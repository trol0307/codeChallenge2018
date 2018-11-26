package com.pep.restapi.domain.service;

import com.pep.restapi.domain.entity.*;
import com.pep.restapi.domain.valueobjects.Area;
import com.pep.restapi.domain.valueobjects.Coordinates;
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
                Coordinates mapPosition= new Coordinates(i,t);
                element = map.getMapElement(mapPosition);
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

        List<Coordinates> freePositions = new ArrayList<>();
        Coordinates myPosition = new Coordinates(player.getPosition().getY(),player.getPosition().getX());
        Coordinates myLastPosition = new Coordinates(player.getPrevious().getY(),player.getPrevious().getX());

        Coordinates leftPosition = new Coordinates(player.getPrevious().getY(),player.getPrevious().getX()-1);
        Coordinates rightPosition = new Coordinates(player.getPrevious().getY(),player.getPrevious().getX()+1);
        Coordinates upPosition = new Coordinates(player.getPrevious().getY()-1,player.getPrevious().getX());
        Coordinates downPosition = new Coordinates(player.getPrevious().getY()+1,player.getPrevious().getX());

        Coordinates leftLeftPosition = new Coordinates(player.getPrevious().getY(),player.getPrevious().getX()-2);
        Coordinates rightRightPosition = new Coordinates(player.getPrevious().getY(),player.getPrevious().getX()+2);
        Coordinates upUpPosition = new Coordinates(player.getPrevious().getY()-2,player.getPrevious().getX());
        Coordinates downDownPosition = new Coordinates(player.getPrevious().getY()+2,player.getPrevious().getX());

        if (map.getMapElement(leftPosition)=="space" && !leftPosition.equals(myLastPosition)) {freePositions.add(leftPosition);}
        if (map.getMapElement(rightPosition)=="space" && !rightPosition.equals(myLastPosition)) {freePositions.add(rightPosition);}
        if (map.getMapElement(upPosition)=="space" && !upPosition.equals(myLastPosition)) {freePositions.add(upPosition);}
        if (map.getMapElement(downPosition)=="space" && !downPosition.equals(myLastPosition)) {freePositions.add(downPosition);}

        if (freePositions.size()<2){
            if (map.getMapElement(leftPosition)=="space" && map.getMapElement(leftLeftPosition)=="space") {freePositions.add(leftPosition);}
            if (map.getMapElement(rightPosition)=="space" && map.getMapElement(rightRightPosition)=="space") {freePositions.add(rightPosition);}
            if (map.getMapElement(upPosition)=="space" && map.getMapElement(upUpPosition)=="space") {freePositions.add(upPosition);}
            if (map.getMapElement(downPosition)=="space" && map.getMapElement(downDownPosition)=="space") {freePositions.add(downPosition);}
        }

        Random rand = new Random();

        Integer randomNumber = rand.nextInt(freePositions.size()-1)+1;

        Coordinates freeSpace = freePositions.get(randomNumber);
        Distance distFreeSpace = DistanceCalculator.distance(map, player.getPosition().getY(),player.getPosition().getX(),freeSpace.y(),freeSpace.x());

        return distFreeSpace.getDirection();
    }

}
