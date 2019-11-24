package com.gslonim.coding.algo;

import java.util.Arrays;

/**
 * Explanation:
 * After sorting the array, it will become evident that the number of digits
 * encapsulating the largest citation number cannot be located past the middle point of the array.
 * ex. 1, 4, 1, 4, 2, 1, 3, 5, 6 => 1, 1, 1, 2, 3, 4, 4, 5, 6
 * Once we found 4, 4 will be a complement of any number that follows it and if it is located at index 5
 * Therefore, there are only 3 elements left, any larger number will not have enough occurrences across the
 * remaining numbers.
 */
public class FindHighestCitationNumber {
    public static int findHighestCitationNumber(int[] citations) {
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int currentCitation = citations[i];
            if (citations.length - i < i) {
                return currentCitation;
            }
        }
        return 0;
    }
}
