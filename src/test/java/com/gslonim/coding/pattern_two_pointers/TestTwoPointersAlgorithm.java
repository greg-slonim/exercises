package com.gslonim.coding.pattern_two_pointers;

import com.gslonim.coding.BaseAlgoTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestTwoPointersAlgorithm extends BaseAlgoTest {

    @Test
    public void should_find_a_pair_that_sums_to_target_sum() {
        whenArrayIs(new int[] {1, 2, 3, 4, 6});
        whenTargetSumIs(6);
        then_expected_pair_is(new int[]{1, 3});

        whenArrayIs(new int[] {2, 5, 9, 11});
        whenTargetSumIs(11);
        then_expected_pair_is(new int[] {0, 2});

        whenArrayIs(new int[] {2, 3, 4, 5, 6, 12, 33, 34, 67, 71, 84});
        whenTargetSumIs(45);
        then_expected_pair_is(new int[] {5, 6});
    }

    @Test
    public void should_sort_array_of_tree_types_in_place() {
        whenArrayIs(new int[] {1, 0, 2, 1, 0});
        then_SortedArray_Is(new int[] {0, 0, 1, 1, 2});

        whenArrayIs(new int[] {2, 2, 0, 1, 2, 0});
        then_SortedArray_Is(new int[] {0, 0, 1, 2, 2, 2});
    }

    private static final class TwoPointersProblems {

        static int[] findPairWithTargetSum(int[] input, int targetSum) {
            int left = 0, right = input.length - 1;
            while (left != right) {
                int leftValue = input[left];
                int rightValue = input[right];

                if (leftValue + rightValue == targetSum) {
                    return new int[] {left, right};
                }
                if (leftValue + rightValue < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
            return new int[0];
        }

        static void solve_dutch_national_flag_problem_by_sorting_array_in_place(int[] input) {
            int left = 0, right = input.length - 1;
            for (int i = 0; i <= right;) {
                if (input[i] == 0) {
                    swap(input, i, left);
                    left++;
                    i++;
                } else if (input[i] == 1) {
                    i++;
                } else {
                    swap(input, i, right);
                    right--;
                }
            }
        }

        private static void swap(int[] input, int left, int right) {
            int temp = input[left];
            input[left] = input[right];
            input[right] = temp;
        }
    }

    private void then_SortedArray_Is(int[] expectedSortedArray) {
        TwoPointersProblems.solve_dutch_national_flag_problem_by_sorting_array_in_place(input);
        assertThat(input).containsExactly(expectedSortedArray);
    }

    private void then_expected_pair_is(int[] expectedPair) {
        assertThat(TwoPointersProblems.findPairWithTargetSum(input, sum))
                .containsExactly(expectedPair);
    }
}
