package com.pep.restapi.domain.entity;

import java.util.UUID;

public class invader {

    private UUID id;
    private Integer xPosition;
    private Integer yPosition;
    private Boolean canBeKilled;

    public invader(Integer xPosition, Integer yPosition, Boolean canBeKilled){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.canBeKilled = canBeKilled;
    }
}
