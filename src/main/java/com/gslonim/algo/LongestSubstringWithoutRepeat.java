package com.gslonim.algo;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {
    public static int lengthOfLongestSubstring(String string) {

        if (string.length() == 0) {
            return 0;
        }

        int maxCount = 0;
        int count = 0;
        String[] array = string.split("");
        Set<String> dictionary = new HashSet<>(string.length());

        for(String character : array) {
            if (dictionary.contains(character)) {
                count = 0;
                dictionary.remove(character);
                continue;
            }
            dictionary.add(character);
            count++;
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }

    public static int lengthOfLongestSubstringReference(String input) {
        int length = input.length();
        Set<Character> dictionary = new HashSet<>();

        int maxCount = 0, leftIndex = 0, rightIndex = 0;

        while (leftIndex < length && rightIndex < length) {

            // try to extend the range [leftIndex, rightIndex]
            char currentChacter = input.charAt(rightIndex);
            if (!dictionary.contains(currentChacter)){
                dictionary.add(currentChacter);
                rightIndex++;
                maxCount = Math.max(maxCount, rightIndex - leftIndex);
            }
            else {
                dictionary.remove(input.charAt(leftIndex));
                leftIndex++;
            }
        }
        return maxCount;
    }
}
