package com.gslonim.coding.algo;

import java.util.HashMap;
import java.util.Map;

public class SockMatcher {
    static int sockMerchant(int n, int[] arrayOfColor) {

        Map<Integer, Integer> matchingPairs = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (matchingPairs.containsKey(arrayOfColor[i])) {
                int currentValue = matchingPairs.get(arrayOfColor[i]);
                matchingPairs.put(arrayOfColor[i], ++currentValue);
            } else {
                matchingPairs.put(arrayOfColor[i], 1);
            }
        }
        int pairCount = 0;
        for (int value : matchingPairs.values()) {
           value = value / 2;
           pairCount = pairCount + value;

        }

        return pairCount;
    }
}
