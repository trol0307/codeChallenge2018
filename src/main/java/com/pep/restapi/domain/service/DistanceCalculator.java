package com.pep.restapi.domain.service;

import com.pep.restapi.domain.entity.Map;
import com.pep.restapi.domain.valueobjects.Distance;

public class DistanceCalculator {

    public static Distance distance(Map map, Integer yOrigin, Integer xOrigin, Integer yTarget, Integer xTarget){

        Distance distance = new Distance();
        Integer y = yTarget - yOrigin;
        Integer x = xTarget - xOrigin;

        distance.setDirection(direction(y,x));

        if (y<0) y=y*-1;
        if (x<0) x=x*-1;

        distance.setyDist(y);
        distance.setxDist(x);

        distance.setBarrier(barrier(map,y,x));

        distance.setDist(y+x);

        return distance;
    }

    private static String direction(Integer y,Integer x){

        String yDirection;
        String xDirection;

        if (y<0) {
            yDirection = "up";
            y=y*-1;
        } else {
            yDirection = "down";
        }

        if (x<0) {
            xDirection = "left";
            x=x*-1;
        } else {
            xDirection = "right";
        }

        if (y<x) {
            return xDirection;
        } else if (y>x) {
            return yDirection;
        } else {
            return "";
        }
    }

    private static Boolean barrier(Map map, Integer y,Integer x){

        if (y<=x) {
            for (Integer i=0;i<x;i++){
                if ("wall".equals(map.getMapElement(y,i))) return true;
            }
        } else if (y>x) {
            for (Integer i=0;i<y;i++){
                if ("wall".equals(map.getMapElement(y,i))) return true;
            }
        }
        return false;
    }
}
