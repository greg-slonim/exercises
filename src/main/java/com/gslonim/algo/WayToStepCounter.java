package com.gslonim.algo;

import java.util.Arrays;

public class WayToStepCounter {
    private static int counter = 0;

    public static void main(String[] args) {
        WayToStepCounter wayToStepCounter = new WayToStepCounter();
//        long count = wayToStepCounter.countWaysUpBruteForce(10);

        int[] cache = new int[11];
        Arrays.fill(cache, -1);

        int count =  wayToStepCounter.countWithMemoization(10, cache);
        System.out.println("count = " + count);
        System.out.println("Executed " + counter + " times");
    }

    private long countWaysUpBruteForce(long numOfSteps) {
        counter ++;
        if (numOfSteps == 0) {
            return 1;
        } else if (numOfSteps < 0) {
            return 0;
        }

        System.out.println(String.format("Examining %d and %d and %d", numOfSteps - 3, numOfSteps - 2, numOfSteps - 1));
        return countWaysUpBruteForce(numOfSteps - 3)
                + countWaysUpBruteForce(numOfSteps - 2)
                + countWaysUpBruteForce(numOfSteps - 1);
    }

    private int countWithMemoization(int numOfSteps, int[] cache) {
        counter++;
        if (numOfSteps == 0) {
            return 1;
        } else if (numOfSteps < 0) {
            return 0;
        } else if (cache[numOfSteps] > -1) {
            return cache[numOfSteps];
        }

        System.out.println(String.format("Examining %d and %d and %d", numOfSteps - 3, numOfSteps - 2, numOfSteps - 1));
        cache[numOfSteps] = countWithMemoization(numOfSteps - 3, cache)
                + countWithMemoization(numOfSteps -2, cache)
                + countWithMemoization(numOfSteps - 1, cache);
        System.out.println(String.format("Filling cache with value %d at position %d", cache[numOfSteps], numOfSteps));


        return cache[numOfSteps];
    }
}
