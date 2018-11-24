package com.pep.restapi.domain.service;

import com.pep.restapi.domain.entity.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ViewMap {

    private Map map;

    public static void View(Map map){

        for (Integer y=0;y<map.getMapHeight();y++){
            StringBuilder rowBuilder = new StringBuilder();
            for (Integer x=0;x<map.getMapWidth();x++){
                rowBuilder.append(map.getMapChar(y,x));
            }
            System.out.println(rowBuilder.toString());
        }

    }


}
