package com.gslonim.coding.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// UNSOLVED
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] inputNumbers = {-1, 0, 1, 2, -1, -4};
        System.out.println("Brute Force: " + threeSum.bruteForceWithDupes(inputNumbers));
        System.out.println("Faster one: " + threeSum.fasterOne(inputNumbers));
    }

    private List<List<Integer>> bruteForceWithDupes(int[] numbers) {

        List<List<Integer>> solutions = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length; j++) {
                for (int k = 2; k < numbers.length; k++) {
                    if ((numbers[i] + numbers[j] + numbers[k]) == 0) {
                        List<Integer> aSolution = Arrays.asList(numbers[i], numbers[j], numbers[k]);
                        Collections.sort(aSolution);

                        if (!solutions.contains(aSolution)) {
                            solutions.add(aSolution);
                        }
                    }
                }
            }
        }
        return solutions;
    }

    private List<List<Integer>> fasterOne (int[] numbers) {
        return null;
    }
}
