package com.gslonim.coding.pattern_array_occurrences;

import com.gslonim.coding.BaseAlgoTest;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FindSmallestPositiveNumberMissingInArray extends BaseAlgoTest {

    @Test
    public void should_find_smallest_positive_number_in_array() {
        whenArrayIs(new int[] {1, 3, 6, 4, 1, 2});
        thenTheSmallestNumberIs(5);

        whenArrayIs(new int[] {1, 2, 3});
        thenTheSmallestNumberIs(4);

        whenArrayIs(new int[] {-1, -3});
        thenTheSmallestNumberIs(1);

        whenArrayIs(new int[] {-1, -3, 4});
        thenTheSmallestNumberIs(1);
    }

    private void thenTheSmallestNumberIs(int smallestNumber) {
        assertThat(Solution.findSmallestMissingNumber(input)).isEqualTo(smallestNumber);
    }

    private static class Solution {
        private static int MAX_NUMBER = 1_000_001;
        static int findSmallestMissingNumber(int[] array) {
            int length = array.length;
            if (length == 0) {
                return 1;
            }
            Arrays.sort(array);
            int missing = MAX_NUMBER;
            for (int i = 1; i < length; i++) {
                int current = array[i];
                int previous = array[i - 1];
                if (current != previous + 1) {
                    missing = previous + 1;
                }
            }
            if (missing <= 0) {
                return 1;
            }
            if (missing == MAX_NUMBER) {
                return array[length - 1] + 1;
            }
            return missing;
        }
    }
}
