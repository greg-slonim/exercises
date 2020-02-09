package com.gslonim.coding.pattern_sliding_window;

import com.gslonim.coding.BaseAlgoTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TestSlidingWindowAlgorithm extends BaseAlgoTest {
    private static int k;
    private static String stringInput;

    @Test
    public void should_find_averages_of_window_size_k_in_array() {
        whenArrayIs(new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
        whenKis(5);

        then_Expected_Averages_Are(new double[] {2.2, 2.8, 2.4, 3.6, 2.8});
    }

    @Test
    public void should_find_averages_of_window_size_k_and_handle_empty_input() {
        whenArrayIs(new int[] {});
        whenKis(2);

        then_Expected_Averages_Are(new double[] {});
    }

    @Test
    public void should_find_smallest_contiguous_subarray_with_sum_greater_or_equal_to_given_sum() {
        whenArrayIs(new int[] {2, 1, 5, 2, 3, 2});
        whenTargetSumIs(7);

        then_Expected_Length_Of_Smallest_Continuous_Subarray_Is(2);
    }

    @Test
    public void should_find_length_of_longest_substring_without_repeating_characters() {
        whenStringIs("aabccbb");
        then_Expected_Longest_Substring_Length_Is(3);

        whenStringIs("abbbb");
        then_Expected_Longest_Substring_Length_Is(2);

        whenStringIs("abccde");
        then_Expected_Longest_Substring_Length_Is(3);
    }

    private static final class SlidingWindowProblems {

        public static double[] averageOfSubarrayOfSizeK(int k, int[] input) {
            if (input.length == 0) {
                return new double[] {};
            }
            double[] result = new double[input.length - k + 1];
            int left = 0;
            double sum = 0;
            for (int right = 0; right < input.length; right++) {
                sum += input[right];
                if (right >= k - 1) {
                    result[left] = sum/k;
                    sum -= input[left];
                    left++;
                }
            }
            return result;
        }
        public static int smallestContinuousSubarrayWithSum(int targetSum, int[] input) {
            int sum = 0, minLength = input.length, left = 0;
            for (int right = 0; right < input.length; right++) {
                sum += input[right];
                while (sum >= targetSum) {
                    minLength = Math.min(right - left + 1, minLength);
                    sum -= input[left];
                    left++;
                }
            }
            return minLength;
        }

        public static int longestSubstringWithoutRepeatingCharacters(String input) {
            int longestLength = 0, left = 0;
            Map<Character, Integer> dictionary = new HashMap<>();

            for (int right = 0; right < input.length(); right++) {
                Character current = input.charAt(right);
                if (dictionary.containsKey(current)) {
                    longestLength = Math.max(right - left, longestLength);
                    int repeatedPosition = dictionary.get(current);
                    left = repeatedPosition + 1;
                }
                dictionary.put(current, right);
            }

            return longestLength;
        }
    }

    private static void then_Expected_Longest_Substring_Length_Is(int expectedLength) {
        assertThat(SlidingWindowProblems.longestSubstringWithoutRepeatingCharacters(stringInput))
                .isEqualTo(expectedLength);
    }

    private void then_Expected_Averages_Are(double[] expectedResult) {
        assertThat(SlidingWindowProblems.averageOfSubarrayOfSizeK(k, input))
                .containsExactly(expectedResult);
    }

    private void then_Expected_Length_Of_Smallest_Continuous_Subarray_Is(int length) {
        assertThat(SlidingWindowProblems.smallestContinuousSubarrayWithSum(sum, input))
                .isEqualTo(length);
    }

    private static void whenKis(int size) {
        k = size;
    }

    private static void whenStringIs(String input) {
        stringInput = input;
    }
}
