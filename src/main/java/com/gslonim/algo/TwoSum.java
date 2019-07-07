package com.gslonim.algo;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private final int[] numbers;

    public TwoSum(int[] numbers) {
        this.numbers = numbers;
    }

    public static void main(String[] args) {

        TwoSum twoSum = new TwoSum(new int[] {2, 7, 11, 15});
        System.out.println("Brute force " + twoSum.bruteForce(9));
        System.out.println("Faster one " + twoSum.fasterOne(9));
    }

    private Pair bruteForce(int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new Pair(i, j);
                }
            }
        }
        throw new IllegalStateException("Number combination summing to " + target + " was found");
    }

    private int[] fasterOne(int target) {
        Map<Integer, Integer> lookup = new HashMap<>();

        for (int i = 0; i < numbers.length; i ++) {
            int difference = target - numbers[i];
            if (lookup.containsKey(difference)) {
                return new int[] {lookup.get(difference), i};
            } else {
                lookup.put(numbers[i], i);
            }
        }
        throw new IllegalStateException("Number combination summing to " + target + " was found");
    }

    class Pair {
        final int one;
        final int two;

        Pair(int one, int two) {
            this.one = one;
            this.two = two;
        }
        public String toString() {
            return String.format("[%s,%s]", one, two);
        }
    }
}
