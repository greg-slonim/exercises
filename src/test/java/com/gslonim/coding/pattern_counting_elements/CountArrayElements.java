package com.gslonim.coding.pattern_counting_elements;

import com.gslonim.coding.BaseAlgoTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountArrayElements extends BaseAlgoTest {

    private int maxValue;
    private int[] arrayA;
    private int[] arrayB;

    @Test
    public void should_count_array_elements() {
        whenArrayIs(new int[] {0, 0, 4, 2, 4, 5});
        whenMaxValueIs(5);
        thenTheCountsAre(new int[] {2, 0, 1, 0, 2, 1});
    }

    @Test
    public void should_swap_one_element_in_two_arrays_for_sum_to_be_equal() {
        whenArrayAIs(new int[] {5, 3, 4});
        whenArrayBIs(new int[] {5, 1, 2});
        whenMaxValueIs(5);

        thenTherAreElementsWeCanSwap();

        whenArrayAIs(new int[] {5, 1, 2, 10, 4, 8, 2, 7});
        whenArrayBIs(new int[] {2, 3, 4, 10, 3, 5, 6, 7, 8, 6, 1, 0});
        whenMaxValueIs(10);
        thenTherAreElementsWeCanSwap();
    }

    @Test
    public void should_find_the_earliest_time_frog_can_jump_across_river() {
        whenArrayAIs(new int[] {1, 3, 1, 4, 2, 3, 5, 4});
        whenMaxValueIs(5);
        thenEarliestTimeOfJumpIs(6);

        whenArrayAIs(new int[] {3, 1, 3, 4, 5, 2, 4, 5, 1, 3});
        whenMaxValueIs(5);
        thenEarliestTimeOfJumpIs(5);

        whenArrayAIs(new int[] {3, 1, 3, 4, 4, 2, 4, 4, 1, 3});
        whenMaxValueIs(5);
        thenEarliestTimeOfJumpIs(-1);

        whenArrayAIs(new int[] {3});
        whenMaxValueIs(5);
        thenEarliestTimeOfJumpIs(-1);
    }

    @Test
    public void should_calculate_value_of_every_counter_after_all_operations() {
    /*
        Calculate the values of counters after applying all alternating operations: increase counter by 1; set value of all counters to current maximum.
        You are given N counters, initially set to 0, and you have two possible operations on them:

        increase(X) − counter X is increased by 1,
        max counter − all counters are set to the maximum value of any counter.

        A non-empty array A of M integers is given. This array represents consecutive operations:

        if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
        if A[K] = N + 1 then operation K is max counter.
        For example, given integer N = 5 and array A such that:

        A[0] = 3
        A[1] = 4
        A[2] = 4
        A[3] = 6
        A[4] = 1
        A[5] = 4
        A[6] = 4
        the values of the counters after each consecutive operation will be:

        (0, 0, 1, 0, 0)
        (0, 0, 1, 1, 0)
        (0, 0, 1, 2, 0)
        (2, 2, 2, 2, 2)
        (3, 2, 2, 2, 2)
        (3, 2, 2, 3, 2)
        (3, 2, 2, 4, 2)
        The goal is to calculate the value of every counter after all operations.
       */

    }

    private void thenEarliestTimeOfJumpIs(int index) {
        assertThat(Solution.earliestFrogCanJumpAcrossRiver(arrayA, maxValue)).isEqualTo(index);
    }

    private void thenTherAreElementsWeCanSwap() {
        assertThat(Solution.canSwapElementsForEqualSums(arrayA, arrayB, maxValue)).isTrue();
    }

    private void whenArrayBIs(int[] ints) {
        arrayB = ints;
    }

    private void whenArrayAIs(int[] ints) {
        arrayA = ints;
    }

    private void thenTheCountsAre(int[] counts) {
        assertThat(Solution.countElements(input, maxValue)).contains(counts);
    }

    private void whenMaxValueIs(int maxValue) {
        this.maxValue = maxValue;
    }

    private static class Solution {

        static int earliestFrogCanJumpAcrossRiver(int[] leafPositions, int maxValue) {
            int[] counts = countElements(leafPositions, maxValue);
            int sum = 0;
            for (int i = 1; i <= maxValue; i++) {
                sum += i;
            }

            for (int i = 0; i < leafPositions.length; i++) {
                if (counts[leafPositions[i]] > 0) {
                    counts[leafPositions[i]] = 0;
                    sum = sum - leafPositions[i];
                    if (sum == 0) {
                        return i;
                    }
                }
            }
            return -1;
        }

        static int[] countElements(int[] array, int maxValue) {
            int[] counts = new int[maxValue + 1];
            for (int value : array) {
                counts[value] = counts[value] + 1;
            }
            return counts;
        }

        static boolean canSwapElementsForEqualSums(int[] arrayA, int[] arrayB, int maxValue) {
            int length = arrayA.length;
            int sum_a = sum(arrayA);
            int sum_b = sum(arrayB);
            if ((sum_b - sum_a) % 2 != 0) {
                return false;
            }
            int halfDiff = (sum_b - sum_a) / 2;

            int[] counts = countElements(arrayA, maxValue);
            for (int i = 0; i < length; i++) {
                int currentDiff = arrayB[i] - halfDiff;
                if (currentDiff >= 0 && currentDiff <= maxValue && counts[currentDiff] > 0) {
                    return true;
                }
            }
            return false;
        }

        static int sum(int[] array) {
            int sum = 0;
            for (int element : array) {
                sum += element;
            }
            return sum;
        }
    }
}
