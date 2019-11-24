package com.gslonim.coding.algo;

import java.util.HashSet;
import java.util.Set;

public class NoRepeatSubstring {
    public static int findLength(String str) {
        int left = 0, maxLength = 0;
        Set<Character> letters = new HashSet<>();

        for (int right = 0; right < str.length(); right++) {
            Character letter = str.charAt(right);
            while(letters.contains(letter)) {
                maxLength = Math.max(right - left, maxLength);
                Character existingLetter = str.charAt(left);
                letters.remove(existingLetter);
                left++;
            }
            letters.add(letter);
        }

        return maxLength;
    }
}
