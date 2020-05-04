package com.gslonim.coding.pattern_array_occurrences;

import com.gslonim.coding.BaseAlgoTest;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FindMissingNumberInArray extends BaseAlgoTest {

    @Test
    public void should_find_a_missing_number_in_array_of_unique_numbers_using_cyclic_sort() {
        whenArrayIs(new int[]{2, 3, 1, 5});
        thenMissingNumberIs(4);

        whenArrayIs(new int[]{2});
        thenMissingNumberIs(1);

        whenArrayIs(new int[]{1, 2, 3, 4, 5, 7, 8, 9, 10});
        thenMissingNumberIs(6);

        whenArrayIs(new int[]{2, 3, 4, 5});
        thenMissingNumberIs(1);

        whenArrayIs(new int[]{1, 2, 3});
        thenMissingNumberIs(4);
    }

    private void thenMissingNumberIs(int missingNumber) {
        assertThat(Solution.findAMissingNumberInArray(input)).isEqualTo(missingNumber);
    }

    private static class Solution {
        static int findAMissingNumberInArray(int[] array) {
            if (array.length == 0 || array.length == 1) {
                return 1;
            }

            Arrays.sort(array);
            for (int i = 0; i < array.length; i++) {
                if (array[i] != i + 1) {
                    return i + 1;
                }
            }
            return array.length + 1;
        }
    }
}
