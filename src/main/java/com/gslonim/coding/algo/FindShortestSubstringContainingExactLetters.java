package com.gslonim.coding.algo;

import java.util.HashMap;
import java.util.Map;

public class FindShortestSubstringContainingExactLetters {
    public static String minWindow(String word, String sub) {
        if (word.equals(sub)) {
            return word;
        }
        if (sub.length() > word.length()) {
            return "";
        }

        int left = 0, right = 0, missing = sub.length();
        int[] shortest = new int[]{0, word.length() - 1};
        Map<String, Integer> windowCounts = new HashMap<>();
        Map<String, Integer> dictionary = initialiseCounts(sub);
        String[] tokenized = word.split("");

        for (; right < tokenized.length; right++) {
            String letter = tokenized[right];
            if (dictionary.containsKey(letter)) {
                if (windowCounts.getOrDefault(letter, 0) < dictionary.getOrDefault(letter, 0)) {
                    missing--;
                }
                bumpCount(windowCounts, letter);
            }

            while (missing == 0) {
                if ((right - left) < (shortest[1] - shortest[0])) {
                    shortest[0] = left;
                    shortest[1] = right;
                }
                letter = tokenized[left];
                if (dictionary.containsKey(letter)) {
                    decreaseCount(windowCounts, letter);
                    if (windowCounts.get(letter) < dictionary.get(letter)) {
                        missing++;
                    }
                }
                left++;
            }
        }
        if (left == 0) {
            return "";
        }

        return word.substring(shortest[0], shortest[1] + 1);
    }

    private static Map<String, Integer> initialiseCounts(String sub) {
        Map<String, Integer> counts = new HashMap<>();
        String[] split = sub.split("");
        for (String letter : split) {
            counts.put(letter, counts.getOrDefault(letter, 0) + 1);
        }
        return counts;
    }

    private static void bumpCount(Map<String, Integer> counts, String letter) {
        counts.put(letter, counts.getOrDefault(letter, 0) + 1);
    }

    private static void decreaseCount(Map<String, Integer> counts, String letter) {
        counts.put(letter, counts.getOrDefault(letter, 0) - 1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("bbaa", "aba"));
    }
}
