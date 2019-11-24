package com.gslonim.coding.algo;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    /**
     * Given an array of integers, find if the array contains any duplicates.
     * Your function should return true if any value appears at least twice in the array, and it should return false
     * if every element is distinct.
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> knownNumbers = new HashSet<>();

        for (int currentNum : nums) {
            if (knownNumbers.contains(currentNum)) {
                return true;
            } else {
                knownNumbers.add(currentNum);
            }
        }
        return false;
    }
}
