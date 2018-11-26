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

        distance.setBarrier(barrier(map,yOrigin, xOrigin, yTarget, xTarget));

        distance.setDist(y+x);

        if ((y==0 && x<=5) || (y<=5 && x==0)) {
            distance.setTargetActive(true);
        }
        else {
            distance.setTargetActive(false);
        }

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

    private static Boolean barrier(Map map, Integer yOrigin, Integer xOrigin, Integer yTarget, Integer xTarget){
        Integer y = yTarget - yOrigin;
        Integer x = xTarget - xOrigin;
        Integer yDist;
        Integer xDist;

        if (y<0) yDist=y*-1;
        if (x<0) xDist=x*-1;


        if (y<=x) {
            if (x>0) {
                for (Integer i=xOrigin;i<xTarget;i++){
                    if ("wall".equals(map.getMapElement(yOrigin,i))) return true;
                }
            } else {
                for (Integer i=xOrigin;i>xTarget;i--){
                    if ("wall".equals(map.getMapElement(yOrigin,i))) return true;
                }
            }

        } else if (y>x) {
            if (y>0) {
                for (Integer i=yOrigin;i<yTarget;i++){
                    if ("wall".equals(map.getMapElement(i,xOrigin))) return true;
                }
            } else {
                for (Integer i=yOrigin;i>yTarget;i--){
                    if ("wall".equals(map.getMapElement(i,xOrigin))) return true;
                }
            }
        }
        return false;
    }
}
