package com.gslonim.coding.twosigma;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class TwoSigma_Challenge {
    public static String compressedString(String message) {
        if (message.length() <= 1) {
            return message;
        }
        StringBuilder sb = new StringBuilder();
        int left = 0, right = 0, count = 0;
        Character leftC = ' ', rightC;
        while (right < message.length()) {
            leftC = message.charAt(left);
            rightC = message.charAt(right);
            if (leftC == rightC) {
               count++;
               right++;
            } else {
                sb.append(leftC).append(count != 1 ? count : "");
                left = right;
                count = 0;
            }
        }
        sb.append(leftC).append(count != 1 ? count : "");
        return sb.toString();
    }


    public static int find_distinct_palindromes(String str) {
        Set<String> distinctPalindromes = new HashSet<>();

        if (isPalindrome(str)) {
            distinctPalindromes.add(str);
        }
        // pass one, add every letter as a unique palindromic string
        for (int i = 0; i < str.length(); i++) {
            Character current = str.charAt(i);
            distinctPalindromes.add(String.valueOf(current));
        }
        // pass two, checking larger substrings
        int leftIndex = 0, rightIndex = 1;
        while (rightIndex < str.length()) {
            String currentSub = substring(str, leftIndex, rightIndex);
            if (!distinctPalindromes.contains(currentSub)) {
                if(isPalindrome(currentSub)) {
                    distinctPalindromes.add(currentSub);
                    rightIndex++;
                } else {
                    if (currentSub.length() == 2) {
                        rightIndex++;
                    } else {
                        leftIndex++;
                    }
                }
            } else {
                rightIndex++;
            }
        }

        return distinctPalindromes.size();
    }

    @NotNull
    private static String substring(String str, int leftIndex, int rightIndex) {
        if (rightIndex == str.length() - 1) {
            return str.substring(leftIndex);
        }
        return str.substring(leftIndex, rightIndex + 1);
    }

    private static boolean isPalindrome(String input) {
        if (input.length() == 1) {
            return true;
        }

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

    public static int problem_three(String str) {
        Set<String> distinctPalindromes = new HashSet<>();
        // pass one, add every letter as a unique palindromic string
        int length = str.length();
        for (int i = 0; i < str.length(); i++) {
            distinctPalindromes.add(String.valueOf(str.charAt(i)));
            int start  =  i - 1;
            int end = i + 1;
            while( start >= 0 && end < length && str.charAt(start) == str.charAt(end)) {
                distinctPalindromes.add(str.substring(start, end + 1));
                start--;
                end++;
            }
            start  =  i;
            end = i + 1;
            while( start >= 0 && end < length && str.charAt(start) == str.charAt(end)) {
                distinctPalindromes.add(str.substring(start, end + 1));
                start--;
                end++;
            }
        }
        return distinctPalindromes.size();
    }
}
