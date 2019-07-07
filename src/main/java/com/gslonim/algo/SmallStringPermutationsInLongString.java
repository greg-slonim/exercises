package com.gslonim.algo;

import java.util.HashMap;
import java.util.Map;

public class SmallStringPermutationsInLongString {
    public static void main(String[] args) {
        String smallString = "abbc";
        String longString = "cbabadcbbabbcbabaabccbabc";
        SmallStringPermutationsInLongString.printPermutationLocations(smallString, longString);
    }

    public static void printPermutationLocations(String small, String large) {
        if (small.isEmpty() || large.isEmpty()) {
            return;
        }
        Map<String, Integer> expectedCounts = getLetterCounts(small);

        for (int i = 0; i <= large.length() - 4; i++) {
            String substring = large.substring(i, i + 4);
            Map<String, Integer> actualCounts = getLetterCounts(substring);
            if (actualCounts.equals(expectedCounts)) {
                System.out.println("Found permutation " + substring + " at location " + i);
            }
        }
    }

    private static Map<String, Integer> getLetterCounts(String word) {
        Map<String, Integer> letterCounts = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            String currentLetter = word.substring(i, i + 1);
            if (letterCounts.containsKey(currentLetter)) {
                int count = letterCounts.get(currentLetter);
                letterCounts.put(currentLetter, ++count);
            } else {
                letterCounts.put(currentLetter, 1);
            }
        }
        return letterCounts;
    }
}
