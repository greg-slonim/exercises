package com.gslonim.coding.subsets;

import java.util.*;

public class Subsets_Operations {

    public static List<List<Integer>> find_all_combinations(int[] numbers) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        allSubsets.add(new ArrayList<>());
        if (numbers.length == 0) {
            return allSubsets;
        }
        for (int number : numbers) {
            int size = allSubsets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = allSubsets.get(i);
                List<Integer> newList = new ArrayList<>(subset);
                newList.add(number);
                allSubsets.add(newList);
            }
        }
        return allSubsets;
    }

//    public List<List<Integer>> find_unique_subsets(int[] numbers) {
//        List<List<Integer>> allSubsets = new ArrayList<>();
//        allSubsets.add(new ArrayList<>());
//        Arrays.sort(numbers);
//        int left = 0, right = 0;
//        for (int i = 0; i < numbers.length; i++) {
//            left = 0;
//            if (i > 0 && numbers[i] == numbers[i - 1]) {
//                left = right + 1;
//            }
//            right =
//        }
//    }

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>());

        for (int number : nums) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> permutation = queue.poll();
                for (int j = 0; j <= permutation.size(); j++) {
                    List<Integer> newList = new ArrayList<>(permutation);
                    newList.add(j, number);
                    if (newList.size() == nums.length) {
                        permutations.add(newList);
                    } else {
                        queue.offer(newList);
                    }
                }
            }
        }
        return permutations;
    }
}
