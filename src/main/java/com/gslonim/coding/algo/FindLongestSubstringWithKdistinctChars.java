package com.gslonim.coding.algo;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSubstringWithKdistinctChars {
    public static int findLength(String testCase, int maxCount) {
        Map<Character, Integer> counts = new HashMap<>();
        int left = 0, maxLength = 0;
        for (int right = 0; right < testCase.length(); right ++) {
            char letter = testCase.charAt(right);
            if (counts.containsKey(letter)) {
                counts.computeIfPresent(letter, (k, v) -> v = v + 1);
            } else {
                counts.put(letter, 1);
            }
            while (counts.size() > maxCount) {
                counts.computeIfPresent(testCase.charAt(left), (k, v) -> v = v - 1);
                if (counts.get(testCase.charAt(left)) == 0) {
                    counts.remove(testCase.charAt(left));
                }
                left++;
            }
            maxLength = Math.max(right - left + 1, maxLength);
        }
        return maxLength;
    }
}
