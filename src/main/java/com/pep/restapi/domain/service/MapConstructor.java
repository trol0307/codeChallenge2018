package com.pep.restapi.domain.service;

import com.pep.restapi.domain.entity.Map;
import com.pep.restapi.domain.entity.WallPosition;

import java.util.List;

public class MapConstructor {

    private Map map;

    private List<WallPosition> walls;
    
    public MapConstructor(Map map,List<WallPosition> walls){
        this.map = map;
        this.walls = walls;
    }

    public void init(){
        for (Integer y=0;y<map.getMapHeight();y++){
            for (Integer x=0;x<map.getMapWidth();x++) {
                if (y == 0 || y == map.getMapHeight()-1) {
                    map.setElementOnMap(y,x,'B');
                } else if (x == 0 || x   == map.getMapWidth()-1) {
                    map.setElementOnMap(y,x,'B');
                }
            }
        }
    }

    public void setWalls(){

        for (WallPosition wallPosition : walls)
        {
            map.setElementOnMap(wallPosition.getY(), wallPosition.getX(),'B');
        }
    }
}
