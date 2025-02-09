package com.corejava.dsa.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Objects;

public class SearchingArray {

    private static final Logger log = LoggerFactory.getLogger(SearchingArray.class);

    public static void main(String[] args) {

        String[] landmarks = {
                "Statue of Liberty, USA",
                "Eiffel Tower, France",
                "Great Wall of China, China",
                "Taj Mahal, India",
                "Sydney Opera House, Australia",
                "Machu Picchu, Peru",
                "Christ the Redeemer, Brazil",
                "Colosseum, Italy",
                "Big Ben, United Kingdom",
                "Mount Everest, Nepal",
                "Niagara Falls, Canada/USA",
                "Grand Canyon, USA",
                "Pyramids of Giza, Egypt",
                "Petra, Jordan",
                "Burj Khalifa, UAE",
                "Stonehenge, United Kingdom",
                "Golden Gate Bridge, USA",
                "Chichen Itza, Mexico",
                "Angkor Wat, Cambodia",
                "Mount Fuji, Japan"
        };

        log.info("Original array : {}", Arrays.toString(landmarks));

        String elementToBeSearch = "Angkor Wat, Cambodia";
        log.info("Index of element {} is {}", elementToBeSearch, searchInArray(landmarks, elementToBeSearch));

    }

    public static Integer searchInArray(String[] strArray, String elementToBeSearch) {

        if (strArray == null || strArray.length == 0) {
            throw new RuntimeException(String.format("Given array %s is empty", Arrays.toString(strArray)));
        }

        if (!Arrays.toString(strArray).contains(elementToBeSearch)) {
            throw new RuntimeException(String.format("Element to be search %s not found in array %s", elementToBeSearch, Arrays.toString(strArray)));
        }

        for (int index = 0; index < strArray.length; index++) {
            if (Objects.equals(strArray[index], elementToBeSearch)) {
                return index;
            }
        }

        return null;
    }
}
