package com.pep.restapi.domain.service;

import com.pep.restapi.domain.entity.Area;
import com.pep.restapi.domain.entity.Map;
import com.pep.restapi.domain.entity.WallPosition;

import java.util.List;

public class MapConstructor {

    private Map map;

    private List<WallPosition> walls;

    private Area visbleArea;
    
    public MapConstructor(Map map, List<WallPosition> walls, Area visbleArea){
        this.map = map;
        this.walls = walls;
        this.visbleArea = visbleArea;
    }

    private Boolean checkVisibility(Integer y, Integer x){

        if (y>=visbleArea.getY1() && y<=visbleArea.getY2() && x>=visbleArea.getX1() && x<=visbleArea.getX2()) {
            return true;
        }
        return false;
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
}
