package com.corejava.dsa.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayTraversal {

    private static final Logger log = LoggerFactory.getLogger(ArrayTraversal.class);

    public static void main(String[] args) {

        int[] array1 = {1, 2, 3, 3, 4, 5, 6, 7, 8};

        for (int i = 0; i < array1.length; i++) {
            log.info("Retrieved value from array {} for index {} is {}", array1, i, getArrayElements(array1, i));
        }
    }

    public static int getArrayElements(int[] array, int index) {
        return array[index];
    }
}
