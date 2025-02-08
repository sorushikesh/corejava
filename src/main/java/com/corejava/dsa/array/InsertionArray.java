package com.corejava.dsa.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class InsertionArray {

    private static final Logger log = LoggerFactory.getLogger(InsertionArray.class);

    public static void main(String[] args) {

        char[] chars = {'a', 'b', 'c', 'd', 'f', 'g', 'h', 'i'};
        log.info("Character array before update: {}", Arrays.toString(chars));

        chars = insertElement(chars, 4, 'e');
        log.info("Character array after update: {}", Arrays.toString(chars));
    }

    public static char[] insertElement(char[] chars, int position, char toBeInsertChar) {
        if (position < 0 || position > chars.length) {
            throw new IllegalArgumentException("Invalid position: " + position);
        }

        // Create new array with extra space
        char[] newChars = new char[chars.length + 1];

        /*
          src – the source array.
          srcPos – starting position in the source array.
          dest – the destination array.
          destPos – starting position in the destination data.
          length – the number of array elements to be copied.
         */
        // Copy elements before the insertion point
        System.arraycopy(chars, 0, newChars, 0, position);
        log.info("{}", newChars);

        // Insert the new element
        newChars[position] = toBeInsertChar;
        log.info("{}", newChars);

        // Copy remaining elements after the insertion point
        System.arraycopy(chars, position, newChars, position + 1, chars.length - position);
        log.info("{}", newChars);

        return newChars;
    }
}
