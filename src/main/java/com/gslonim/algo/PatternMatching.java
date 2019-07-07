package com.gslonim.algo;

public class PatternMatching {
    public static boolean matchesPattern(char[] word, char[] pattern) {

        if (pattern.length == 0 || word.length < pattern.length) {
            return false;
        }

        int patternCode = hashCode(pattern);

        for (int i = 0; i < (word.length - pattern.length); i++) {
            char[] subString = subString(word, i, i + pattern.length);
            if (hashCode(subString) == patternCode) {
                return true;
            }
        }

        return false;
    }

    private static char[] subString(char[] word, int start, int end) {
        int arraySize = end - start;
        char[] subString = new char[arraySize];

        for(int i = start, j=0; i < end; i++, j++) {
            subString[j] = word[i];
        }
        return subString;
    }

    private static int hashCode(char[] word) {
        int hash = 0;
        for (char character : word) {
            hash += character;
        }
        return hash;
    }
}
