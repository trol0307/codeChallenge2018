package com.pep.restapi.domain.valueobjects;

public class Distance {



    public static Integer Distance(Integer yOrigin, Integer xOrigin, Integer yTarget, Integer xTarget){

        Integer yDiff = yTarget - yOrigin;
        Integer xDiff = xTarget - xOrigin;

        if (yDiff<0) yDiff=yDiff*-1;
        if (xDiff<0) xDiff=xDiff*-1;

        return yDiff + xDiff;
    }
}
