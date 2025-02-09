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
                "Sindhudurg", "Bhandara", "Gondia", "Wardha", "Chandrapur", "Yavatmal", "Osmanabad",
                "Parbhani", "Hingoli", "Washim", "Palghar", "Raigad", "Thane", "Buldhana", "Osmanabad"
        };

        log.info("Original array: {}", Arrays.toString(strArray));

        log.info("Updated array: {}", Arrays.toString(deleteElement(strArray, 8)));
        log.info("Updated array: {}", Arrays.toString(deleteElement(strArray, "Beed")));
        log.info("Updated array: {}", Arrays.toString(deleteElementFromAllOccurrences(strArray, "Osmanabad")));

    }

    /**
     * This method removes an element from the given position in the array and returns a new array with the updated elements.
     *
     * @param strArray The input array from which an element is to be deleted.
     * @param position The index position of the element to be removed.
     * @return A new String[] array with the specified element removed.
     */
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

    /**
     * This method removes the first occurrence of a specified element from the array and returns a new array with the updated elements.
     *
     * @param strArray          The input array from which an element is to be deleted.
     * @param elementToBeDelete The string value of the element to be removed.
     * @return A new String[] array with the specified element removed.
     */
    public static String[] deleteElement(String[] strArray, String elementToBeDelete) {

        if (!Arrays.toString(strArray).contains(elementToBeDelete)) {
            throw new RuntimeException(String.format("Element to be delete %s not found in array %s", elementToBeDelete, Arrays.toString(strArray)));
        }

        int position = Arrays.asList(strArray).indexOf(elementToBeDelete);
        log.info("Deleting element {} from array {}", elementToBeDelete, Arrays.toString(strArray));

        String[] newArray = new String[strArray.length - 1];

        // Copy elements before the position
        System.arraycopy(strArray, 0, newArray, 0, position);
        // Copy elements after the position
        System.arraycopy(strArray, position + 1, newArray, position, strArray.length - position - 1);

        return newArray;
    }

    /**
     * This method removes all occurrences of a specified element from the array and returns a new array with the updated elements.
     *
     * @param strArray        The input array from which elements are to be deleted.
     * @param elementToDelete The string value of the element to be removed.
     * @return A new String[] array with all occurrences of the specified element removed.
     */
    public static String[] deleteElementFromAllOccurrences(String[] strArray, String elementToDelete) {

        if (strArray == null || strArray.length == 0) {
            return strArray;
        }

        // Count occurrences of elementToDelete
        int count = 0;
        for (String str : strArray) {
            if (str.equals(elementToDelete)) {
                count++;
            }
        }

        // If no occurrences found, return the same array
        if (count == 0) {
            return strArray;
        }

        // Create a new array without the occurrences of elementToDelete
        String[] newArray = new String[strArray.length - count];
        int index = 0;
        for (String str : strArray) {
            if (!str.equals(elementToDelete)) {
                newArray[index++] = str;
            }
        }

        return newArray;
    }

}
