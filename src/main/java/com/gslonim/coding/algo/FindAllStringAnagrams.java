package com.gslonim.coding.algo;

import java.util.*;

public class FindAllStringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        Map<Character, Integer> counts = initialiseCounts(pattern);
        int left = 0, matched = 0;

        for(int right = 0; right < str.length(); right++) {
            Character letter = str.charAt(right);
            if (counts.containsKey(letter)) {
                counts.put(letter, counts.get(letter) - 1);
                if (counts.get(letter) == 0) {
                    matched++;
                }
            }

            if (right > pattern.length() - 1) {
                letter = str.charAt(left);
                if (counts.containsKey(letter)) {
                    if (counts.get(letter) == 0) {
                        matched--;
                    }
                    counts.put(letter, counts.get(letter) + 1);
                }
                left++;
            }
            if (matched == counts.size()) {
                resultIndices.add(left);
            }
        }

        return resultIndices;
    }

    private static Map<Character, Integer> initialiseCounts(String pattern) {
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character letter = pattern.charAt(i);
            counts.merge(letter, 1, (k, v) -> v = v + 1);
        }
        Collection<Integer> b = counts.values();
        b.stream().allMatch(value -> value.equals(0));
        return counts;
    }
}
