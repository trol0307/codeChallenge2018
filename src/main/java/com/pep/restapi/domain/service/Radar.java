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

    private Area visibleArea;

    private Distance closestEnemy;

    private Distance closestInvader;

    private Distance closestNeutralInvader;

    private Distance closestSpace;

    private List<String> freePositions = new ArrayList<>();

    public Radar(Map map, List<WallPosition> walls, Area visibleArea, List<Invader> invaders, List<Enemy> enemies, Player player){
        this.map = map;
        this.walls = walls;
        this.visibleArea = visibleArea;
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
        System.out.println("from radar");
        for(Integer i = visibleArea.getY1(); i<visibleArea.getY2();i++){
            for(Integer t = visibleArea.getX1(); t<visibleArea.getX2(); t++){
                if (i<0) i=0;
                if (t<0) t=0;
                if (i>map.getMapHeight()) i = map.getMapHeight();
                if (t>map.getMapWidth()) t = map.getMapWidth();
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
            } System.out.println("closest active invader at:" + closestInvader.toString());
        }
    }

    public Distance closestEnemy(){
        System.out.println("closest active enemy at:" + closestEnemy.toString());
        return closestEnemy;
    }

    public Distance closestInvader(){
        System.out.println("closest active invader at:" + closestInvader.toString());
        return closestInvader;
    }

    public Distance closestNeutralInvader(){

        return closestNeutralInvader;
    }

    public Integer getFreeSpace(String direction){
        Integer freespace=0;
        Integer maxYPosition;
        Integer maxXPosition;
        Integer minYPosition;
        Integer minXPosition;
        Coordinates myLastPosition = new Coordinates(player.getPrevious().getY(),player.getPrevious().getX());
        Distance LastPositionDistance = DistanceCalculator.distance(map, player.getPosition().getY(),player.getPosition().getX(),myLastPosition.y(),myLastPosition.x());
        if (LastPositionDistance.getDirection()==direction){
            return 0;
        } else {
            System.out.println("checking free space:");
            switch(direction){
                case "up":
                    minYPosition = player.getPosition().getY();
                    for (Integer i=1;i<=minYPosition;i++){
                        Coordinates newPosition = new Coordinates(player.getPosition().getY()-i,player.getPosition().getX());
                        if ("space".equals(map.getMapElement(newPosition))){
                            freespace++;
                        } else {
                            break;
                        }
                    }
                    System.out.println("up free space:"+freespace);
                    break;
                case "down":
                    maxYPosition = map.getMapHeight()-player.getPosition().getY();
                    for (Integer i=1;i<maxYPosition;i++){
                        Coordinates newPosition = new Coordinates(player.getPosition().getY()+i,player.getPosition().getX());
                        System.out.println("coord:"+player.getPosition().getY()+"+"+i+","+player.getPosition().getX()+" -> "+ map.getMapElement(newPosition));
                        if ("space".equals(map.getMapElement(newPosition))){
                            freespace++;
                        } else {
                            break;
                        }
                    }
                    System.out.println("down free space:"+freespace);
                    break;
                case "left":
                    minXPosition = player.getPosition().getX();
                    for (Integer i=1;i<=minXPosition;i++){
                        Coordinates newPosition = new Coordinates(player.getPosition().getY(),player.getPosition().getX()-i);
                        if ("space".equals(map.getMapElement(newPosition))){
                            freespace++;
                        } else {
                            break;
                        }
                    }
                    System.out.println("left free space:"+freespace);
                    break;
                case "right":
                default:
                    maxXPosition = map.getMapWidth()-player.getPosition().getX();
                    for (Integer i=1;i<maxXPosition;i++){
                        Coordinates newPosition = new Coordinates(player.getPosition().getY(),player.getPosition().getX()+i);
                        if (map.getMapElement(newPosition)=="space"){
                            freespace++;
                        } else {
                            break;
                        }
                    }
                    System.out.println("right free space:"+freespace);
                    break;
            }
            return freespace;
        }

    }

    public Route getRoute(){
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
        System.out.println("rumb:"+finalRoute);
        return new Route(finalRoute,maxValueInMap);
    }

}
