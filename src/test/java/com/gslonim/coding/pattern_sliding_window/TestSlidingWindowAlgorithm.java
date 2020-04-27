package com.gslonim.coding.pattern_sliding_window;

import com.google.common.collect.ImmutableList;
import com.gslonim.coding.BaseAlgoTest;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TestSlidingWindowAlgorithm extends BaseAlgoTest {
    private static int k;
    private static String stringInput;
    private static int[] input;

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

    @Test
    public void should_find_all_largest_k_elements_in_all_subarrays_of_size_n() {
        whenInputIs(new int[] {18, 3, 2, 5, 14, 2, 6, 1, 45, 44, 7, 21, 42, 12, 4, 1 -3, 0});
        List<Integer> one = ImmutableList.of(3, 18);
        List<Integer> two = ImmutableList.of(3, 5);
        List<Integer> three = ImmutableList.of(5, 14);
        List<Integer> four = ImmutableList.of(5, 14);
        List<Integer> five = ImmutableList.of(6, 14);
        List<Integer> six = ImmutableList.of(2, 6);
        List<Integer> seven = ImmutableList.of(6, 45);
        List<Integer> eight = ImmutableList.of(44, 45);
        List<Integer> nine = ImmutableList.of(21, 44);
        List<Integer> ten = ImmutableList.of(21, 42);
        List<Integer> eleven = ImmutableList.of(12, 42);
        List<Integer> twelve = ImmutableList.of(4, 12);
        List<Integer> thirteen = ImmutableList.of(1, 4);
        List<Integer> fourteen = ImmutableList.of(0, 1);
        List<List<Integer>> expectedResult = ImmutableList.<List<Integer>>builder()
                .add(one)
                .add(two)
                .add(three)
                .add(four)
                .add(five)
                .add(six)
                .add(seven)
                .add(eight)
                .add(nine)
                .add(ten)
                .add(eleven)
                .add(twelve)
                .add(thirteen)
                .add(fourteen)
                .build();
        List<List<Integer>> actual = SlidingWindowProblems.largest_k_numbers_in_all_subarrays_of_size_n(input, 2, 3);
        assertThat(actual).hasSameElementsAs(expectedResult);
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

        public static List<List<Integer>> largest_k_numbers_in_all_subarrays_of_size_n(
                int[] input, int k, int n) {
            int left = 0, counter = 0;
            List<List<Integer>> result = new ArrayList<>();
            MinHeap minHeap = new MinHeap();
            for (int right = 0; right < input.length; right++) {
                minHeap.offer(input[right]);
                counter++;
                if (counter == n) {
                    result.add(minHeap.getTopK(k));
                    minHeap.remove(input[left]);
                    left++;
                    counter--;
                }
            }
            return result;
        }

    }
    private static final class MinHeap {
        private final List<Integer> orderedList = new LinkedList<>();
        List<Integer> getTopK(int numberOfTopElements) {
            return ImmutableList.copyOf(
                    orderedList.subList(orderedList.size() - numberOfTopElements, orderedList.size()));
        }

        void offer(int element) {
            if (orderedList.isEmpty()) {
                orderedList.add(element);
            } else {
                int index = 0;
                while(index < orderedList.size() && orderedList.get(index) < element) {
                    index++;
                }
                orderedList.add(index, element);
            }
        }

        void remove(int element) {
            orderedList.remove(orderedList.indexOf(element));
        }
    }

    private static void whenInputIs(int[] inputArray) {
        input = inputArray;
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
