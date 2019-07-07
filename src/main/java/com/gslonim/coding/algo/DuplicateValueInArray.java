package com.gslonim.coding.algo;

import java.util.HashMap;
import java.util.Map;

public class DuplicateValueInArray {

    private Map<Integer, Boolean> numberOccurrence = new HashMap();

    public int findDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int number = nums[i];

            if (!numberOccurrence.containsKey(number)) {
                numberOccurrence.put(number, false);
            } else{
                numberOccurrence.put(number, true);
            }
        }
        return numberOccurrence.entrySet().stream()
                .filter(entry -> entry.getValue() == true)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
    }

    public static void main (String[] arguments){
        DuplicateValueInArray searcher = new DuplicateValueInArray();
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 3};

        System.out.println("searcher: " + searcher.findDuplicate(numbers));
    }
}
