package com.gslonim.coding.algo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String findSubstring(String str, String pattern) {
        String shortSub = "";
        Map<Character, Integer> counts = initialiseCounts(pattern);
        int left = 0, matched = 0;

        for (int right = 0; right < str.length(); right++) {
            Character letter = str.charAt(right);
            if (counts.containsKey(letter)) {
                counts.put(letter, counts.get(letter) - 1);
                if (counts.get(letter) == 0) {
                    matched++;
                }
            }
            while (matched == counts.size()) {
                matched--;
                if (!allZero(counts.values())) {
                   letter = str.charAt(left);
                   if(counts.containsKey(letter)) {
                       if (counts.get(letter) == 0) {
                       }
                       counts.put(letter, counts.get(letter) + 1);
                   }
                   left++;
               }
               return str.substring(left, right + 1);
            }
        }
        return shortSub;
    }

    private static boolean allZero(Collection<Integer> counts) {
        return counts.stream().allMatch(value -> value.equals(0));
    }

    private static Map<Character, Integer> initialiseCounts(String pattern) {
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character letter = pattern.charAt(i);
            counts.merge(letter, 1, (k, v) -> v = v + 1);
        }
        return counts;
    }
}
