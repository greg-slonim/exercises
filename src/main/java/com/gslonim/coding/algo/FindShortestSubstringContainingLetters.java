package com.gslonim.coding.algo;

import com.gslonim.coding.Harness;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 * Given a string of letters, find the shortest substring containing all the given letters.
 * The string of letters is not sorted. Given letters may appear in any order.
 * ex.
 * Given "ADOBECODEBANC", find the shortest substring containing A,B, and C and return the start/end indices.
 * In this case, the substrings are "ADOBEC" "BECODEBA" "CODEBA" and "BANC"
 * Shortest string is "BANC" and the answer is [9, 12]
 */
public class FindShortestSubstringContainingLetters {
    public static int[] solution(String inputString, Set<String> letters) {
        int[] substringIndices = new int[] {0, inputString.length() + 1};
        int lettersMissing = letters.size();
        Map<String, Integer> letterCounts = initialiseLetterCounts(letters);
        int slowPointer = 0;
        int fastPointer = 0;
        String[] tokenizedString = inputString.split("");

        for (;fastPointer < tokenizedString.length; fastPointer++) {

            String currentLetter = tokenizedString[fastPointer];
            if (letters.contains(currentLetter)) {
                if (letterCounts.get(currentLetter) == 0) {
                    lettersMissing--;
                }
                incrementCount(letterCounts, currentLetter);
            }

            while(lettersMissing == 0) {
                if ((substringIndices[1] - substringIndices[0]) > (fastPointer - slowPointer)) {
                    substringIndices[0] = slowPointer;
                    substringIndices[1] = fastPointer;
                }
                currentLetter = tokenizedString[slowPointer];
                if (letters.contains(currentLetter)) {
                    decrementCount(letterCounts, currentLetter);
                    if (letterCounts.get(currentLetter) == 0) {
                        lettersMissing++;
                    }
                }
                slowPointer++;
            }
        }

        return substringIndices;
    }

    private static void incrementCount(Map<String, Integer> letterCounts, String currentLetter) {
        letterCounts.put(currentLetter, letterCounts.get(currentLetter) + 1);
    }

    private static void decrementCount(Map<String, Integer> letterCounts, String currentLetter) {
        letterCounts.put(currentLetter, letterCounts.get(currentLetter) - 1);
    }

    private static Map<String, Integer> initialiseLetterCounts(Set<String> letters) {
        Map<String, Integer> letterCounts = new HashMap<>();
        for (String letter : letters) {
            letterCounts.put(letter, 0);
        }
        return letterCounts;
    }
}
