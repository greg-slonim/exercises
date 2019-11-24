package com.gslonim.coding.algo;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSubstringAfterCharacterReplacement {
    public static int findLength(String str, int k) {
        int left = 0, maxLength = 0, maxRepeatedLetter = 0;
        Map<Character, Integer> counts = new HashMap<>();

        for (int right = 0; right < str.length(); right++) {
            Character letter = str.charAt(right);
            counts.put(letter, counts.getOrDefault(letter, 0) + 1);
            maxRepeatedLetter = Math.max(maxRepeatedLetter, counts.get(letter));

            int windowSize = (right - left + 1) - maxRepeatedLetter;
            if (windowSize > k) {
                letter = str.charAt(left);
                counts.computeIfPresent(letter, (key, v) -> v = v - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
