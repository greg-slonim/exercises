package com.gslonim.coding.strings;

import java.util.HashSet;
import java.util.Set;

public class Find_All_Unique_Palindromic_Substrings {
    public static int count_substring_palindromes(String str) {
        Set<String> distinctPalindromes = new HashSet<>();
        // pass one, add every letter as a unique palindromic string
        int length = str.length();
        for (int i = 0; i < str.length(); i++) {
            distinctPalindromes.add(String.valueOf(str.charAt(i)));
            int start = i - 1;
            int end = i;
            while (start >= 0 && end < length && str.charAt(start) == str.charAt(end)) {
                distinctPalindromes.add(str.substring(start, end + 1));
                start--;
                end++;
            }
        }
        return distinctPalindromes.size();
    }
}
