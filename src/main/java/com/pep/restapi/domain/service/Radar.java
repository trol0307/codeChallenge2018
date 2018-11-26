package com.pep.restapi.domain.service;

import com.pep.restapi.domain.entity.*;
import com.pep.restapi.domain.entity.Map;
import com.pep.restapi.domain.valueobjects.Area;
import com.pep.restapi.domain.valueobjects.Coordinates;
import com.pep.restapi.domain.valueobjects.Distance;

import java.util.*;

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

    public Integer getFreeSpace(String direction){
        Integer freespace=0;
        Coordinates myLastPosition = new Coordinates(player.getPrevious().getY(),player.getPrevious().getX());
        Distance LastPositionDistance = DistanceCalculator.distance(map, player.getPosition().getY(),player.getPosition().getX(),myLastPosition.y(),myLastPosition.x());
        if (LastPositionDistance.getDirection()==direction){
            return 0;
        } else {
            switch(direction){
                case "up":

                    for (Integer i=1;i<5;i++){
                        Coordinates newPosition = new Coordinates(player.getPrevious().getY()-i,player.getPrevious().getX());
                        if (map.getMapElement(newPosition)=="space"){
                            freespace++;
                        } else {
                            continue;
                        }
                    }
                    break;
                case "down":
                    for (Integer i=1;i<5;i++){
                        Coordinates newPosition = new Coordinates(player.getPrevious().getY()+i,player.getPrevious().getX());
                        if (map.getMapElement(newPosition)=="space"){
                            freespace++;
                        } else {
                            continue;
                        }
                    }
                    break;
                case "left":
                    for (Integer i=1;i<5;i++){
                        Coordinates newPosition = new Coordinates(player.getPrevious().getY(),player.getPrevious().getX()-i);
                        if (map.getMapElement(newPosition)=="space"){
                            freespace++;
                        } else {
                            continue;
                        }
                    }
                    break;
                case "right":
                default:
                    for (Integer i=1;i<5;i++){
                        Coordinates newPosition = new Coordinates(player.getPrevious().getY(),player.getPrevious().getX()+i);
                        if (map.getMapElement(newPosition)=="space"){
                            freespace++;
                        } else {
                            continue;
                        }
                    }
                    break;
            }
            return freespace;
        }

    }

    public String closestEmptySpace(){
        Integer maxFreeSpace=0;
        Integer result;
        String finalRoute="";
        java.util.Map<String ,Integer> possibleDirections = new HashMap<>();
        List<String> directions = new ArrayList<>();
        directions.add("up");
        directions.add("down");
        directions.add("left");
        directions.add("right");

        for(String direction : directions){
            result = getFreeSpace(direction);
            possibleDirections.put(direction,result);
        }

        int maxValueInMap=(Collections.max(possibleDirections.values()));  // This will return max value in the Hashmap
        for (java.util.Map.Entry<String, Integer> entry : possibleDirections.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()==maxValueInMap) {
                finalRoute=entry.getKey();     // Print the key with max value
            }
        }

        return finalRoute;
    }

}
