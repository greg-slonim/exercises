package com.gslonim.coding.pattern_array_occurrences;

import com.gslonim.coding.BaseAlgoTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class FindUniqueOrOddArrayValue extends BaseAlgoTest {

    @Test
    public void should_find_unpaired_number_in_array() {
        whenArrayIs(new int[] {9, 3, 9, 3, 9, 7, 9});
        thenUnpairedNumberUsingHashingIs(7);

        whenArrayIs(new int[] {9, 3, 9, 3, 9, 7, 9});
        thenUnpairedNumberUsingXORIs(7);
    }

    private void thenUnpairedNumberUsingXORIs(int number) {
        assertThat(Solution.findOddOrUniqueNumberWithXOR(input)).isEqualTo(number);
    }

    private void thenUnpairedNumberUsingHashingIs(int number) {
        assertThat(Solution.findOddOrUniqueNumberWithMapCounts(input)).isEqualTo(number);
    }

    private static class Solution {
        static int findOddOrUniqueNumberWithMapCounts(int[] array) {
            long start = System.nanoTime();
            Map<Integer, Integer> counts = new HashMap<>();

            for (int number : array) {
                counts.merge(number, 1, Integer::sum);
            }
            Optional<Integer> oddOccurrence = counts.entrySet().stream()
                    .filter(entry -> entry.getValue() % 2 != 0)
                    .map(Map.Entry::getKey)
                    .findFirst();
            System.out.println("task took: " + (System.nanoTime() - start) + " nanoseconds");

            return oddOccurrence.orElse(-1);
        }

        static int findOddOrUniqueNumberWithXOR(int[] array) {
            long start = System.nanoTime();
            int result = 0;
            for (int number : array) {
                result = result ^ number;
            }
            System.out.println("task took: " + (System.nanoTime() - start)  + " nanoseconds");
            return result;
        }
    }
}
