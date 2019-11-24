package com.gslonim.coding.algo;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeSubstring {
    public static String longestPalindrome(String input) {
        if (input.length() == 0) {
            return "";
        }
        if (input.trim().length() == 0
                || input.length() == 1
                || isPalindrome(input)) {
            return input;
        }

        int leftIndex = 0, rightIndex = 0;
        String longestPalindrome = "";
        Map<Character, Integer> dictionary = new HashMap<>();

        while(leftIndex < input.length() && rightIndex < input.length()) {

            Character currentChar = input.charAt(rightIndex);

            if (dictionary.containsKey(currentChar)) {
                String maybePalindrome;
                if (input.length() - rightIndex == 1) {
                    maybePalindrome = input.substring(dictionary.get(currentChar));
                } else {
                    maybePalindrome = input.substring(dictionary.get(currentChar), rightIndex + 1);
                }

                if (isPalindrome(maybePalindrome)) {
                    if (longestPalindrome.length() < maybePalindrome.length()) {
                        longestPalindrome = maybePalindrome;
                    }
                }
                rightIndex ++;
                leftIndex++;

            } else {
                dictionary.put(currentChar, rightIndex);
                rightIndex++;
            }
        }
        if (longestPalindrome.equals("")) {
            return input.substring(0, 1);
        }

        return longestPalindrome;
    }

    public static boolean isPalindrome(String input) {
        int leftIndex = 0, rightIndex = input.length() - 1;

        while (leftIndex < rightIndex) {
            if (input.charAt(leftIndex) != input.charAt(rightIndex)) {
                return false;
            }
            ++leftIndex;
            --rightIndex;
        }
        return true;
    }

    public static String longestPalindromeReference(String input) {
        if (input == null || input.length() < 1) {
            return "";
        }
        int start = 0, end = 0;

        for (int i = 0; i < input.length(); i++) {

            int len1 = expandAroundCenter(input, i, i);
            int len2 = expandAroundCenter(input, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return input.substring(start, end + 1);
    }

    public static int expandAroundCenter(String input, int left, int right) {
        int leftIndex = left, rightIndex = right;

        while (leftIndex >= 0 && rightIndex < input.length()
                && input.charAt(leftIndex) == input.charAt(rightIndex)) {
            leftIndex--;
            rightIndex++;
        }
        return rightIndex - leftIndex - 1;
    }
}
