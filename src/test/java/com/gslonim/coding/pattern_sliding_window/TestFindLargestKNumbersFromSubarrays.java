package com.gslonim.coding.pattern_sliding_window;

import com.google.common.collect.ImmutableList;
import com.gslonim.coding.BaseAlgoTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestFindLargestKNumbersFromSubarrays extends BaseAlgoTest {
    private static int kLargest;
    private static int subSize;

    @Test
    public void should_find_largest_k_elements_in_subarrays_of_size_n() {
        whenArrayIs(new int[] {0, 1, 7, 3, 2, 0, 1, 15, 3, 5, 8});
        whenKis(2);
        whenSubArraySizeIs(4);
        then_expected_largest_k_subarraysAre(ImmutableList.of(
                ImmutableList.of(3, 7),
                ImmutableList.of(3, 7),
                ImmutableList.of(3, 7),
                ImmutableList.of(2, 3),
                ImmutableList.of(2, 15),
                ImmutableList.of(3, 15),
                ImmutableList.of(5, 15),
                ImmutableList.of(8, 15)));

    }

    private void then_expected_largest_k_subarraysAre(List<List<Integer>> expectedResult) {
        assertThat(LargestKNumbers.findLargestKInSubarraysOfN(input, kLargest, subSize))
                .hasSameElementsAs(expectedResult);
    }

    private static void whenSubArraySizeIs(int sub) {
        subSize = sub;
    }

    private static void whenKis(int size) {
        kLargest = size;
    }

    private static class LargestKNumbers {
        static List<List<Integer>> findLargestKInSubarraysOfN(int[] array, int largestK, int subSize) {
            assert(largestK < subSize);

            int left = 0;
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> sublist =  new ArrayList<>();

            for (int right = 0; right < array.length; right++) {
                sublist.add(array[right]);
                if(right - left == subSize  - 1) {
                    result.add(getLargestK(sublist, largestK));
                    sublist.remove(0);
                    left++;
                }
            }

            return ImmutableList.copyOf(result);
        }

        private static List<Integer> getLargestK(List<Integer> sublist, int largestK) {
            List<Integer> toSort = new ArrayList<>(sublist);
            Collections.sort(toSort);
            return toSort.subList(sublist.size() - largestK, sublist.size());
        }
    }
}
