package com.pep.restapi.domain.entity;

import java.util.List;
import java.util.UUID;


public class Map{

    private char[][] grid;

    private Integer mapHeight;

    private Integer mapWidth;

    private UUID mapId;

    public char[][] getGrid() {
        return grid;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

    public Integer getMapHeight() {
        return mapHeight;
    }

    public void setMapHeight(Integer mapHeight) {
        this.mapHeight = mapHeight;
    }

    public Integer getMapWidth() {
        return mapWidth;
    }

    public void setMapWidth(Integer mapWidth) {
        this.mapWidth = mapWidth;
    }

    public UUID getMapId() {
        return mapId;
    }

    public void setMapId(UUID mapId) {
        this.mapId = mapId;
    }

    public Map(Integer mapHeight, Integer mapWidth, UUID mapId) {
        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;
        this.mapId = mapId;
        this.grid = new char[mapHeight][mapWidth];
    }

    public void setElementOnMap(Integer y, Integer x, Character element){
        grid[y][x] = element;
    }

    public Character getMapElement(Integer y, Integer x){
        return grid[y][x];
    }

}
