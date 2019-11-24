package com.gslonim.coding.algo;

import java.util.HashMap;
import java.util.Map;

public class FindSubstringPermutationOfPattern {
    public static boolean findPermutation(String str, String pattern) {
        Map<Character, Integer> counts = initialisePattern(pattern);
        int left = 0, matched = 0;

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (counts.containsKey(rightChar)) {
                // decrement the frequency of the matched character
                counts.put(rightChar, counts.get(rightChar) - 1);
                if (counts.get(rightChar) == 0) // character is completely matched
                    matched++;
            }

            if (matched == counts.size())
                return true;

            if (windowEnd >= pattern.length() - 1) { // shrink the window by one character
                char leftChar = str.charAt(left++);
                if (counts.containsKey(leftChar)) {
                    if (counts.get(leftChar) == 0)
                        matched--; // before putting the character back, decrement the matched count
                    // put the character back for matching
                    counts.put(leftChar, counts.get(leftChar) + 1);
                }
            }
        }
        return false;
    }

    private static Map<Character, Integer> initialisePattern(String pattern) {
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character letter = pattern.charAt(i);
            counts.merge(letter, 1, (k, v) -> v = v + 1);
        }
        return counts;
    }
}
