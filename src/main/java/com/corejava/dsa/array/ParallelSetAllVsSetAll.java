package com.corejava.dsa.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class ParallelSetAllVsSetAll {

    private static final Logger log = LoggerFactory.getLogger(ParallelSetAllVsSetAll.class);

    public static void main(String[] args) {
        int arraySize = 100;
        int[] numbersSequential = new int[arraySize];
        int[] numbersParallel = new int[arraySize];

        log.info("Comparing Arrays.setAll() vs Arrays.parallelSetAll() for an array of size {}", arraySize);

        int[] updatedSetAll = performActionInSetAll(numbersSequential);
        int[] updatedParallelSetAll = performActionInParallelSetAll(numbersParallel);

        log.info("First 10 elements after setAll(): {}", Arrays.toString(Arrays.copyOfRange(updatedSetAll, 0, 10)));
        log.info("First 10 elements after parallelSetAll(): {}", Arrays.toString(Arrays.copyOfRange(updatedParallelSetAll, 0, 10)));
    }

    /**
     * Applies Arrays.setAll() to transform the array sequentially.
     * Each element at index i is replaced with i * i.
     *
     * @param numbers The array to be updated.
     * @return The transformed array.
     */
    public static int[] performActionInSetAll(int[] numbers) {
        log.info("Executing Arrays.setAll() (sequential execution)");

        long startTime = System.nanoTime(); // Start timing

        Arrays.setAll(numbers, i -> i * i); // Applies function sequentially

        long endTime = System.nanoTime(); // End timing
        long executionTime = endTime - startTime;

        log.info("Arrays.setAll() execution time: {} nanoseconds ({} ms)", executionTime, executionTime / 1_000_000);
        return numbers;
    }

    /**
     * Applies Arrays.parallelSetAll() to transform the array using parallel execution.
     * Each element at index i is replaced with i * i.
     *
     * @param numbers The array to be updated.
     * @return The transformed array.
     */
    public static int[] performActionInParallelSetAll(int[] numbers) {
        log.info("Executing Arrays.parallelSetAll() (parallel execution)");

        long startTime = System.nanoTime(); // Start timing

        Arrays.parallelSetAll(numbers, i -> i * i); // Applies function in parallel

        long endTime = System.nanoTime(); // End timing
        long executionTime = endTime - startTime;

        log.info("Arrays.parallelSetAll() execution time: {} nanoseconds ({} ms)", executionTime, executionTime / 1_000_000);
        return numbers;
    }
}
