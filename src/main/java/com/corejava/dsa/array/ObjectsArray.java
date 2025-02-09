package com.corejava.dsa.array;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ToString
@AllArgsConstructor
class City {

    private String cityName;
}

public class ObjectsArray {

    private static final Logger log = LoggerFactory.getLogger(ObjectsArray.class);

    public static void main(String[] args) {

        City[] cities = new City[]{
                new City("Nashik"),
                new City("Pune"),
                new City("Mumbai")
        };

        for (City city : cities) {
            log.info(String.valueOf(city));
        }
    }
}
