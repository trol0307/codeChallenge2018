package com.pep.restapi.domain.valueobjects;

public class Coordinates {

    private Integer y;
    private Integer x;

    public Coordinates(Integer y, Integer x) {
        this.y = y;
        this.x = x;
    }

    public Integer y(){
        return y;
    }

    public Integer x(){
        return x;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (y != null ? !y.equals(that.y) : that.y != null) return false;
        return x != null ? x.equals(that.x) : that.x == null;
    }


}
