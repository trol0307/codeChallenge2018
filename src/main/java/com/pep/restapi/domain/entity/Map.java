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

    public void setElementOnMap(Integer y, Integer x, String element, Boolean visible){
        switch (element){
            case "walls":
                grid[y][x] = visible ? (char)0x2588: (char)0x2593;
                break;
            case "space":
                grid[y][x] = visible ? (char)0x2591: (char)0x2592;
                break;
            case "invader":
                grid[y][x] = visible ? (char)0x16E5: (char)0x16E5;
                break;
            case "invader-neutral":
                grid[y][x] = visible ? (char)0x16DD: (char)0x16DD;
                break;
            case "enemy":
                grid[y][x] = visible ? (char)0x16C4: (char)0x16C4;
                break;
            case "player":
                grid[y][x] = visible ? (char)0x263F: (char)0x263F;
                break;
        }
    }

    public Character getMapChar(Integer y, Integer x){
        return grid[y][x];
    }

    public String getMapElement(Integer y, Integer x){

        char element = grid[y][x];
        switch (element){
            case (char)0x2588:
                return "wall";
            case (char)0x2593:
                return "wall";
            case (char)0x2591:
                return "space";
            case (char)0x2592:
                return "space";
            case (char)0x16E5:
                return "invader";
            case (char)0x16DD:
                return "invader-neutral";
            case (char)0x16C4:
                return "enemy";
            case (char)0x263F:
                return "player";
        }
        return "";
    }

}
