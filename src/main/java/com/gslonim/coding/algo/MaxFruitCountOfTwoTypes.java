package com.gslonim.coding.algo;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOfTwoTypes {
    public static int findLength(char[] arr) {
        int left = 0, maxFruit = 0;
        Map<Character, Integer> fruitCount = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {
            fruitCount.merge(arr[right], 1, Integer::sum);

            while (fruitCount.size() > 2) {
                fruitCount.computeIfPresent(arr[left],(k, v) -> v - 1);
                if (fruitCount.get(arr[left]) == 0) {
                    fruitCount.remove(arr[left]);
                }
                left++;
            }
            maxFruit = Math.max(maxFruit, right - left + 1);
        }

        return maxFruit;
    }
}
