package com.pep.restapi.domain.valueobjects;

public class Distance {

    private Integer yDist;

    private Integer xDist;

    private Integer dist;

    private String direction;

    private Boolean barrier;

    @Override
    public String toString() {
        return "Distance{" +
                "yDist=" + yDist +
                ", xDist=" + xDist +
                ", dist=" + dist +
                ", direction='" + direction + '\'' +
                ", barrier=" + barrier +
                '}';
    }

    public Integer getyDist() {
        return yDist;
    }

    public void setyDist(Integer yDist) {
        this.yDist = yDist;
    }

    public Integer getxDist() {
        return xDist;
    }

    public void setxDist(Integer xDist) {
        this.xDist = xDist;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Boolean getBarrier() {
        return barrier;
    }

    public void setBarrier(Boolean barrier) {
        this.barrier = barrier;
    }

    public Integer getDist() {
        return dist;
    }

    public void setDist(Integer dist) {
        this.dist = dist;
    }
}
