package com.gslonim.coding.pattern_merge_intervals;

import com.gslonim.coding.BaseAlgoTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindSmallestDifferenceBetweenArraySplits extends BaseAlgoTest {

    @Test
    public void should_find_minimal_difference_between_two_subarrays() {
        whenArrayIs(new int[] {3, 1, 2, 4, 3});
        thenTheMinimalDifferenceIs(1);
    }

    private void thenTheMinimalDifferenceIs(int difference) {
        assertThat(Solution.findSmallestDifferenceBetweenIntervals(input)).isEqualTo(difference);
    }

    private static class Solution {
        static int findSmallestDifferenceBetweenIntervals(int[] array) {
            int length = array.length;
            if (length == 2) {
                return Math.abs(array[0] - array[1]);
            }

            int leftSum = array[0], rightSum = 0;
            for (int i = 1; i < length; i++) {
                rightSum += array[i];
            }
            int minDiff = Math.abs(leftSum - rightSum);

            for (int i = 2; i < length; i++) {
                leftSum += array[i - 1];
                rightSum -= array[i -1];

                minDiff = Math.min(Math.abs(leftSum - rightSum), minDiff);
            }
            return minDiff;
        }
    }
}
