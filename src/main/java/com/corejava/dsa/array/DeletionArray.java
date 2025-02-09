package com.corejava.dsa.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class DeletionArray {

    private static final Logger log = LoggerFactory.getLogger(DeletionArray.class);

    public static void main(String[] args) {

        String[] strArray = {
                "Nashik", "Pune", "Mumbai", "Nagpur", "Amravati", "Ahilyanagar",
                "Chhatrapati Sambhaji Nagar", "Beed", "Dhule", "Kolhapur", "Satara",
                "Sangli", "Solapur", "Jalgaon", "Latur", "Osmanabad", "Nanded", "Ratnagiri",
                "Sindhudurg", "Bhandara", "Gondia", "Wardha", "Chandrapur", "Yavatmal",
                "Parbhani", "Hingoli", "Washim", "Palghar", "Raigad", "Thane", "Buldhana"
        };
        log.info("Original array: {}", Arrays.toString(strArray));
        log.info("Updated array: {}", Arrays.toString(deleteElement(strArray, 7)));

    }

    public static String[] deleteElement(String[] strArray, int position) {
        if (position < 0 || position >= strArray.length) {
            log.info("Invalid position: {}", position);
            return strArray;
        }

        log.info("Deleting element '{}' at position {}", strArray[position], position);
        String[] newArray = new String[strArray.length - 1];

        // Copy elements before the position
        System.arraycopy(strArray, 0, newArray, 0, position);
        // Copy elements after the position
        System.arraycopy(strArray, position + 1, newArray, position, strArray.length - position - 1);

        /* Another way of doing the same
        for (int i = 0, j = 0; i < strArray.length; i++) {
            if (i != position) {
                newArray[j++] = strArray[i];
            }
        }
        */

        return newArray;
    }
}
