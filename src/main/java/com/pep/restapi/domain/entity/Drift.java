package com.pep.restapi.domain.entity;

public class Drift {

    private static Drift uniqueInstance;
    private Integer milesToRun;
    private String direction;
    private Drift(String direction, Integer milesToRun) {
        this.direction = direction;
        this.milesToRun = milesToRun;
    }
    public static Drift runDrift(String direction, Integer milesToRun) {
        if (uniqueInstance == null || milesToRun==0) {
            uniqueInstance = new Drift(direction,milesToRun);
        }
        return uniqueInstance;
    }

    public void runMile(){
        this.milesToRun = milesToRun -1;
    }

    public String getDirection(){
        return direction;
    }
}
