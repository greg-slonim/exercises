package com.gslonim.coding.algo;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubsetsOfGivenNumbers {

    public static List<List<Integer>> findSubsets(int[] testCase) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        allSubsets.add(new ArrayList<>());
        if (testCase.length == 0) {
            return allSubsets;
        }
        for (int number : testCase) {
            int size = allSubsets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(allSubsets.get(i));
                subset.add(number);
                allSubsets.add(subset);
            }
        }
        return allSubsets;
    }
}
