package com.gslonim.coding.hashtables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Count_Geometrical_Progression_Triplets {
    public static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> counts = loadCounts(arr);
        long tripletCount = 0;
        for (Long currentNum : arr) {
            long[] pair = calculateTuple(currentNum, r);
            tripletCount += countOccurence(pair, counts);
        }
        return tripletCount;
    }

    private static Map<Long, Long> loadCounts(List<Long> list) {
        Map<Long, Long> counts = new HashMap<>();
        for (long number : list) {
            counts.merge(number, 1L, Long::sum);
        }
        return counts;
    }

    private static long[] calculateTuple(long currentNum, long multiplier) {
        return new long[] {currentNum * multiplier, currentNum * multiplier * multiplier};
    }

    private static long countOccurence(long[] pair, Map<Long, Long> counts) {
        long countOne = counts.getOrDefault(pair[0], 0L);
        long countTwo = counts.getOrDefault(pair[1], 0L);

        if (countOne == 1 && countTwo == 1) {
            return 1;
        }
        if (countOne != 1 && countTwo == 1) {
            return countOne;
        }
        if (countOne == 1) {
            return countTwo;
        }

        return countOne + countTwo;
    }
}
