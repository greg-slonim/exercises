package com.gslonim.algo;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Streams;
import com.gslonim.coding.algo.*;
import com.gslonim.coding.datastructure.Node;
import one.util.streamex.EntryStream;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class TestHarness {
    @Test
    public void should_find_mountain_peak() {
        FindAMountainPeak solution = new FindAMountainPeak();
        assertThat(solution.solution().apply(new int[]{2, 3, 4, 7, 8, 6, 3, 2, 1}))
                .isEqualTo(4);

        assertThat(solution.solution().apply(new int[]{0, 2, 3, 4, 2, 1, 0}))
                .isEqualTo(3);
    }

    @Test
    public void should_partition_array_and_find_max_sum_of_mins() {
        PartitionArrayToFindMaxMins solution = new PartitionArrayToFindMaxMins();
        assertThat(solution.solution().apply(new int[]{1, 4, 3, 2}))
                .isEqualTo(4);
        assertThat(solution.solution().apply(new int[]{1, 3, 5, 5, 6, 7}))
                .isEqualTo(12);
        assertThat(solution.solution().apply(new int[]{1, 2, 3, 4, 5, 6, 7, 8}))
                .isEqualTo(16);
    }

    @Test
    public void should_count_columns_to_delete_to_achieve_non_decreasing_order() {
        CountColumnsToDeleteForNonDecreasingLetters solution = new CountColumnsToDeleteForNonDecreasingLetters();
        assertThat(solution.solution().apply(new String[]{"cba", "daf", "ghi"}))
                .isEqualTo(1);
        assertThat(solution.solution().apply(new String[]{"aaaa", "bbbb", "cccc"}))
                .isEqualTo(0);
        assertThat(solution.solution().apply(new String[]{"zvabb", "sfabc", "fdbad"}))
                .isEqualTo(3);
        assertThat(solution.solution().apply(new String[]{"zxv", "stg", "eoa"}))
                .isEqualTo(3);
    }

    @Test
    public void should_count_a_number_of_requests_in_the_last_3000_ms_from_time_t() {
        CountRequestsInTheLastPeriodSinceTime solution = new CountRequestsInTheLastPeriodSinceTime();
        List<Integer> counts = new ArrayList<>();
        Integer[] input = new Integer[]{null, 1, 100, 3001, 3002};
        for (int i = 0; i < input.length; i++) {
            counts.add(solution.solution().apply(input[i]));
        }
        assertThat(counts).containsExactly(null, 1, 2, 3, 3);
    }

    @Test
    public void should_traverse_tree_iteratively_preorder() {
        Node one = buildTree();

        IterativePreOrderTreeTraverser treeTraverser = new IterativePreOrderTreeTraverser();
        List<Integer> result = treeTraverser.solution().apply(one);
        assertThat(result).containsExactly(1, 3, 5, 6, 2, 4);
    }

    @Test
    public void should_traverse_tree_iteratively_postorder() {
        Node one = buildTree();

        IterativePostOrderTreeTraverser treeTraverser = new IterativePostOrderTreeTraverser();
        List<Integer> result = treeTraverser.solution().apply(one);
        assertThat(result).containsExactly(5, 6, 3, 2, 4, 1);
    }

    @Test
    public void should_sort_array_by_parity() {
        SortArrayByParity solution = new SortArrayByParity();
        assertThat(solution.solution().apply(new int[]{4, 2, 5, 7}))
                .containsExactly(4, 5, 2, 7);
    }

    @Test
    public void should_add_one_to_array() {
        /**
         * Given a number represented by an array, add 1 to it.
         * For instance,
         *  - 1,234 is represented by [1, 2, 3, 4]. A resulting array will be [1, 2, 3, 5]
         *  - 99 is represented by [9, 9]. A resulting array will be [1, 0, 0]
         */
        AddOneToNumberRepresentedByArray solution = new AddOneToNumberRepresentedByArray();
        assertThat(solution.solution().apply(new int[]{1, 2, 3, 4}))
                .containsExactly(1, 2, 3, 5);

        assertThat(solution.solution().apply(new int[]{9, 9, 9, 9}))
                .containsExactly(1, 0, 0, 0, 0);

        assertThat(solution.solution().apply(new int[]{9}))
                .containsExactly(1, 0);

        assertThat(solution.solution().apply(new int[]{1, 9, 9}))
                .containsExactly(2, 0, 0);
    }

    @Test
    public void should_find_two_numbers_that_multiply_to_20() {
        FindTwoNumbersThatMultiplyTo20 solution = new FindTwoNumbersThatMultiplyTo20();
        assertThat(solution.solution().apply(new int[]{2, 4, 1, 6, 5, 4, -1}))
                .contains(4, 5);
    }

    /**
     * Find a shortest substring containing all the required letters in no particular order.
     * input = "ADOBECODEBANC", ["A", "B", "C"] output = [9, 12] for "BANC"
     */
    @Test
    public void should_find_the_shortest_substring_in_a_string() {
        String inputString = "ADOBECODEBANC";
        Set<String> lettersToFind = ImmutableSet.of("A", "B", "C");

        assertThat(FindShortestSubstringContainingLetters.solution(inputString, lettersToFind))
                .containsExactly(9, 12);
    }

    /**
     * Find the largest number H representing the ranking of the researcher's papers. For example,
     * if a researcher published papers A, B, C, E, D, E, F, G, H, I and they are each cited 1, 4, 1, 4, 2, 1, 3, 5, 6
     * times, this means the H number is 4 because it is the highest number of citations across all papers.
     * (4, 4, 5, 6 all contain 4, therefore there have been 4 papers cited 4 or more times).
     */
    @Test
    public void should_find_highest_citation_number_across_published_papers() {
        int[] citations = new int[]{1, 4, 1, 4, 2, 1, 3, 5, 6};
        assertThat(FindHighestCitationNumber.findHighestCitationNumber(citations))
                .isEqualTo(4);
        citations = new int[]{23, 11, 22, 21, 5, 1, 3, 5, 6};
        assertThat(FindHighestCitationNumber.findHighestCitationNumber(citations))
                .isEqualTo(11);
    }

    @Test
    public void testBitwiseOperators() {
        // & - copies bit to the result only if it exists in both operands.
        // 4 -> 0 1 0 0
        // 6 -> 0 1 1 0
        // ------------
        //      0 1 0 0
        assertThat(6 & 4).isEqualTo(4);
        assertThat(3 & 5).isEqualTo(1);

        // | - copies bit to the result if it exists in either operands.
        // 4 -> 0 1 0 0
        // 6 -> 0 1 1 0
        // ------------
        //      0 1 1 0
        assertThat(6 | 4).isEqualTo(6);
        assertThat(3 | 5).isEqualTo(7);

        // >> - SIGNED right shift
        // Left operand value is shifted to the right by the number of bits specified by the right operand
        // 6 >> 2 (0 1 1 0 >> 2 = 0 0 0 1, or 1)
        // 6 >> n is the same as dividing by 2^n: 6 >> 2 => 6/2^2 => 1 (rounded towards 0)
        assertThat(6 >> 2).isEqualTo(1);

        // >>> - UNSIGNED right shift
        // Left operand value is shifted to the right by the number of bits specified by the right operand.
        // The values are filled with 0s, WHICH MEANS THE RESULT IS ALWAYS POSITIVE
        // 6 >>> 2 (1 1 1 0 >>> 2 = 1)
        // 6 >> n is the same as dividing by 2^n: 6 >> 2 => 6/2^2 => 1 (rounded towards 0)
        assertThat(6 >>> 2).isEqualTo(1);
//        IMPORTANT: unsigned shift and signed shift work THE SAME for positive numbers.


        // IMPORTANT: Negative numbers in Java are represented by flipping all the bits and adding 1.
        // Ex. -6 => [1]110 => [1]001 => [1]010
        // so, -6 >>>
        assertThat(-6 >>> 2).isEqualTo(1);

    }

    @Test
    public void shouldFindTwoSum() {
        int[] test1 = new int[]{2, 7, 11, 15};
        assertThat(twoSum(test1, 9))
                .containsExactly(0, 1);
        int[] test2 = new int[]{2, 7, 11, 15, 3};
        assertThat(twoSum(test2, 14))
                .containsExactly(2, 4);

        int[] test3 = new int[]{2};
        assertThat(twoSum(test3, 14))
                .containsExactly(0, 0);
    }

    @Test
    public void shouldFindMaxProfit() {
        int[] testCase = new int[]{7, 1, 5, 3, 6, 4};
        assertThat(FindHighestProfit.maxProfit(testCase))
                .isEqualTo(5);
        testCase = new int[]{7, 2, 5, 3, 6, 4, 1, 10};
        assertThat(FindHighestProfit.maxProfit(testCase))
                .isEqualTo(9);
        testCase = new int[]{7};
        assertThat(FindHighestProfit.maxProfit(testCase))
                .isEqualTo(0);
        testCase = new int[]{7, 2};
        assertThat(FindHighestProfit.maxProfit(testCase))
                .isEqualTo(0);
    }

    @Test
    public void shouldDetermineIfArrayHasDuplicates() {
        int[] testCase = new int[]{1, 2, 3, 1};
        assertThat(ContainsDuplicate.containsDuplicate(testCase))
                .isTrue();
        testCase = new int[]{1, 2, 3, 4};
        assertThat(ContainsDuplicate.containsDuplicate(testCase))
                .isFalse();
        testCase = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        assertThat(ContainsDuplicate.containsDuplicate(testCase))
                .isTrue();
    }

    @Test
    public void shouldFindMaxCongigiousSubarraySum() {
        int[] testCase = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertThat(MaxSubarraySum.maxSubArray(testCase))
                .isEqualTo(6);
        testCase = new int[]{2, -1, 3, 4, -1, 2, 1, -5, 4};
        assertThat(MaxSubarraySum.maxSubArray(testCase))
                .isEqualTo(10);

        testCase = new int[]{2, -11, 4, 4, -1, 2, 1, -5, 4};
        assertThat(MaxSubarraySum.maxSubArray(testCase))
                .isEqualTo(10);
    }

    @Test
    public void shouldFindMaxCongigiousSubarrayProduct() {
        int[] testCase = new int[]{2, 3, -2, 4};
//        assertThat(MaxSubArrayProduct.maxProduct(testCase))
//                .isEqualTo(6);
//        testCase = new int[] {2, -1, 3, 4, -1, 2, 1, -5, 4};
//        assertThat(MaxSubArrayProduct.maxProduct(testCase))
//                .isEqualTo(480);
//
//        testCase = new int[] {2, 1};
//        assertThat(MaxSubArrayProduct.maxProduct(testCase))
//                .isEqualTo(2);
//
//        testCase = new int[] {-1, -2, 3, -5};
//        assertThat(MaxSubArrayProduct.maxProduct(testCase))
//                .isEqualTo(30);

        testCase = new int[]{-2, 3, -4};
        assertThat(MaxSubArrayProduct.maxProduct(testCase))
                .isEqualTo(24);
    }

    @Test
    public void should_fild_all_subsets_of_given_numbers() {
        int[] testCase = new int[]{1, 5, 3};
        List<List<Integer>> subsets = FindAllSubsetsOfGivenNumbers.findSubsets(testCase);
        List<List<Integer>> expected = ImmutableList.of(
                ImmutableList.of(), ImmutableList.of(1),
                ImmutableList.of(5), ImmutableList.of(1, 5),
                ImmutableList.of(3), ImmutableList.of(1, 3), ImmutableList.of(5, 3), ImmutableList.of(1, 5, 3));
        assertThat(subsets).hasSameElementsAs(expected);
    }

    @Test
    public void test() {
        Map<String, Optional<String>> configuration = ImmutableMap.of(
                "install.yml", Optional.of("install"),
                "runtime.yml", Optional.of("runtime"),
                "something.xml", Optional.empty());

        List<String> strings = EntryStream.of(configuration)
                .filterValues(Optional::isPresent)
                .mapValues(Optional::get)
                .values()
                .toImmutableList();

        assertThat(strings).contains("install", "runtime");

        Optional<String> optional = Optional.of("string");
        Optional<String> blah = optional.flatMap(maybeString -> Optional.of(maybeString + "_blah"));
        assertThat(blah).hasValue("string_blah");

    }

    private Object mapValues(Object value) {
        Integer i = (Integer) value;
        if (i.intValue() == 3) {
            return null;
        }
        return i;
    }

    @NotNull
    private String getAnotherWord() {
        System.out.println("Else executes");
        return "anotherWord";
    }

    private String getAnotherWordGet() {
        System.out.println("Or Else Get executes");
        return "anotherWord";
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] noSolution = new int[]{0, 0};
        if (nums.length == 0) {
            return noSolution;
        }

        Map<Integer, Integer> diffLookup = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            int diff = target - nums[i];
            if (diffLookup.containsKey(nums[i])) {
                return new int[]{diffLookup.get(nums[i]), i};
            } else {
                diffLookup.put(diff, i);
            }
        }
        return noSolution;
    }

    @Test
    public void should_find_max_sum_of_subarray() {
        int[] testCase = new int[]{2, 1, 5, 1, 3, 2};
        assertThat(FindMaximumSumOfSubarray.findMaxSumSubArray(3, testCase))
                .isEqualTo(9);
    }

    @Test
    public void should_find_the_length_of_the_longest_substring_with_k_unique_chars() {
        String testCase = "araaci";

        assertThat(FindLongestSubstringWithKdistinctChars.findLength(testCase, 2))
                .isEqualTo(4);
        assertThat(FindLongestSubstringWithKdistinctChars.findLength(testCase, 1))
                .isEqualTo(2);
        testCase = "cbbebi";
        assertThat(FindLongestSubstringWithKdistinctChars.findLength(testCase, 3))
                .isEqualTo(5);
        testCase = "cbbeebrtyyuuuuuuuuui";
        assertThat(FindLongestSubstringWithKdistinctChars.findLength(testCase, 2))
                .isEqualTo(11);
        testCase = "aaaaaaaaaaacbbee";
        assertThat(FindLongestSubstringWithKdistinctChars.findLength(testCase, 2))
                .isEqualTo(12);
    }

    @Test
    public void should_find_max_fruit_count_of_two_types() {
        char[] testCase = new char[]{'A', 'B', 'C', 'A', 'C'};
        assertThat(MaxFruitCountOfTwoTypes.findLength(testCase))
                .isEqualTo(3);
        testCase = new char[]{'A', 'B', 'C', 'B', 'B', 'C'};
        assertThat(MaxFruitCountOfTwoTypes.findLength(testCase))
                .isEqualTo(5);

        testCase = new char[]{'A', 'A', 'A', 'A', 'A', 'B', 'C', 'B', 'B', 'C'};
        assertThat(MaxFruitCountOfTwoTypes.findLength(testCase))
                .isEqualTo(6);
    }

    @Test
    public void should_find_longest_substring_with_no_repeating_characters() {
        assertThat(NoRepeatSubstring.findLength("aabccbb"))
                .isEqualTo(3);
        assertThat(NoRepeatSubstring.findLength("abbbb"))
                .isEqualTo(2);
        assertThat(NoRepeatSubstring.findLength("abccde"))
                .isEqualTo(3);
        assertThat(NoRepeatSubstring.findLength("aaaabbccde"))
                .isEqualTo(2);
    }

    @Test
    public void should_find_the_longest_substring_after_replacement() {
        assertThat(FindLongestSubstringAfterCharacterReplacement.findLength("aabccbb", 2))
                .isEqualTo(5);
        assertThat(FindLongestSubstringAfterCharacterReplacement.findLength("abbcb", 1))
                .isEqualTo(4);

    }

    @Test
    public void should_find_the_longest_subarray_after_replacing_zeroes() {
        int[] testCase = new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        assertThat(FindLongestArrayOfOneAfterReplacement.findLength(testCase, 2))
                .isEqualTo(6);
        testCase = new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        assertThat(FindLongestArrayOfOneAfterReplacement.findLength(testCase, 3))
                .isEqualTo(9);
    }

    @Test
    public void should_find_permutation_of_pattern_in_string() {
        assertThat(FindSubstringPermutationOfPattern.findPermutation("odicf", "dc"))
                .isFalse();
        assertThat(FindSubstringPermutationOfPattern.findPermutation("oidbcaf", "abc"))
                .isTrue();
        assertThat(FindSubstringPermutationOfPattern.findPermutation("oidbcaaaaf", "aaaabc"))
                .isTrue();
        assertThat(FindSubstringPermutationOfPattern.findPermutation("oaidbcaf", "abc"))
                .isTrue();
        assertThat(FindSubstringPermutationOfPattern.findPermutation("bcdxabcdy", "bcdyabcdx"))
                .isTrue();
        assertThat(FindSubstringPermutationOfPattern.findPermutation("aaacb", "abc"))
                .isTrue();
        assertThat(FindSubstringPermutationOfPattern.findPermutation("aabcc", "aaabc"))
                .isTrue();
    }

    @Test
    public void should_find_indices_of_all_anagrams_of_pattern() {
        assertThat(FindAllStringAnagrams.findStringAnagrams("ppqp", "pq"))
                .contains(1, 2);
        assertThat(FindAllStringAnagrams.findStringAnagrams("abbcabc", "abc"))
                .contains(2, 3, 4);
        assertThat(FindAllStringAnagrams.findStringAnagrams("abbcabc", "abc"))
                .contains(2, 3, 4);
    }

    @Test
    public void should_find_minimum_window_substring() {
        assertThat(MinimumWindowSubstring.findSubstring("aabdec", "abc"))
                .isEqualTo("abdec");
        assertThat(MinimumWindowSubstring.findSubstring("abdabca", "abc"))
                .isEqualTo("abc");
    }

    @Test
    public void should_remove_array_duplicates_return_new_size() {
        int[] testCase = new int[]{2, 3, 3, 3, 6, 9, 9};
        assertThat(RemoveSortedArrayDuplicates.removeDuplicates(testCase))
                .isEqualTo(4);
        testCase = new int[]{2, 2, 2, 11};
        assertThat(RemoveSortedArrayDuplicates.removeDuplicates(testCase))
                .isEqualTo(2);
        testCase = new int[]{1, 2, 3, 4, 5};
        assertThat(RemoveSortedArrayDuplicates.removeDuplicates(testCase))
                .isEqualTo(5);
        testCase = new int[]{1, 1, 1, 1, 1};
        assertThat(RemoveSortedArrayDuplicates.removeDuplicates(testCase))
                .isEqualTo(1);
    }

    @Test
    public void should_create_array_of_squares_in_sorted_order() {
        int[] testCase = new int[]{-2, -1, 0, 2, 3};
        assertThat(SortArraySquares.makeSquares(testCase))
                .containsExactly(0, 1, 4, 4, 9);
    }

    @Test
    public void should_validate_sudoku_board() {
        String[][] board = new String[][]{
                {"9", ".", "3", ".", "5", "1"},
                {"1", "5", "4", ".", "2", "."},
                {"2", ".", ".", ".", ".", "9"},
                {"3", "8", ".", "7", ".", "."},
                {"4", "1", ".", "5", ".", "3"},
                {".", ".", "6", ".", "1", "4"}
        };
        assertThat(ValidateSudokuBoard.validateBoard(board))
                .isTrue();
    }

    @Test
    public void testFizzBuzz() {
        assertThat(fizzBuzz(6)).isEqualTo("fizz");
        assertThat(fizzBuzz(5)).isEqualTo("buzz");
        assertThat(fizzBuzz(3)).isEqualTo("fizz");
        assertThat(fizzBuzz(15)).isEqualTo("fizzbuzz");
        assertThat(fizzBuzz(20)).isEqualTo("buzz");
        assertThat(fizzBuzz(81)).isEqualTo("fizz");
        assertThat(fizzBuzz(300)).isEqualTo("fizzbuzz");
    }

    @Test
    public void testFizzBuzzV2() {
        assertThat(fizzBuzzV2(6)).isEqualTo("fizz");
        assertThat(fizzBuzzV2(5)).isEqualTo("buzz");
        assertThat(fizzBuzzV2(3)).isEqualTo("fizz");
        assertThat(fizzBuzzV2(15)).isEqualTo("fizzbuzz");
        assertThat(fizzBuzzV2(20)).isEqualTo("buzz");
        assertThat(fizzBuzzV2(81)).isEqualTo("fizz");
        assertThat(fizzBuzzV2(300)).isEqualTo("fizzbuzz");
    }

    @Test
    public void testMatchingParenthesis() {
        assertThat(MatchParenthesis.areParenthesisMatched("(a + b) + ((1 + 3) - (9 - 8))"))
                .isTrue();
        assertThat(MatchParenthesis.areParenthesisMatched("(a + b) + ((9 - 8)"))
                .isFalse();
        assertThat(MatchParenthesis.areParenthesisMatched(")(a + b)"))
                .isFalse();
        assertThat(MatchParenthesis.areParenthesisMatched("(a + b) + ()((()))"))
                .isTrue();

        assertThat(MatchParenthesis.areParenthesisMatched("(a + [b]) + {()}((( a + b)))"))
                .isTrue();

        assertThat(MatchParenthesis.areParenthesisMatched("[)({a} + b)]"))
                .isFalse();

        assertThat(MatchParenthesis.areParenthesisMatched("()[)(]"))
                .isFalse();
    }

    @Test
    public void should_move_all_zeroes_to_the_end_of_array() {
        assertThat(MoveAllZeroesToTheEndOfTheArray.moveZeroes(new int[]{1, 5, 0, 3, 0, 7, 5, 0, 7, 4}))
                .containsExactly(1, 5, 3, 7, 5, 7, 4, 0, 0, 0);
    }

    @Test
    public void should_count_sub_domains() {
        assertThat(CountSubDomains.subdomainVisits(new String[]{"9001 discuss.leetcode.com"}))
                .containsExactlyInAnyOrder("9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com");

    }

    @Test
    public void should_find_a_duplicate_number_in_array_1_to_n() {
        int[] nums = new int[] {2, 1, 3, 3, 5, 4};
        int pointer = 0;
        int answer = -1;

        while (pointer < nums.length) {
            int currNum = nums[pointer];
            int numAtCorrectLocation = nums[currNum - 1];

            if (currNum != numAtCorrectLocation) {
                nums[pointer] = numAtCorrectLocation;
                nums[currNum - 1] = currNum;
            } else {
                pointer++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                answer = nums[i];
            }
        }
        assertThat(answer).isEqualTo(3);
    }

    @Test
    public void should_find_all_missing_numbers_in_array_1_to_n() {
        int[] nums = new int[] {2, 3, 1, 8, 2, 3, 5, 1};
        List<Integer> missingNumbers = new ArrayList<>();
        int pointer = 0;
        while (pointer < nums.length) {
            int currNum = nums[pointer];
            int correctNum = nums[currNum - 1];
            if (currNum != correctNum) {
                nums[pointer] = correctNum;
                nums[currNum - 1] = currNum;
            } else {
                pointer++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                missingNumbers.add(i + 1);
            }
        }
        assertThat(missingNumbers).containsExactly(4, 6, 7);
    }

    @Test
    public void should_find_all_missing_numbers_in_array_1_to_n_with_fast_and_slow_pointers() {

    }

    @Test
    public void should_sort() {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        queue.offer(5);
        queue.offer(4);
        queue.offer(1);
        queue.offer(3);
        for (int number : queue.toArray(new Integer[0])) {
            System.out.println("number = " + number);
        }

    }

    private static String fizzBuzz(int input) {
        if (input % 3 == 0 && input % 5 == 0) {
            return "fizzbuzz";
        } else if (input % 3 == 0) {
            return "fizz";
        } else if (input % 5 == 0) {
            return "buzz";
        } else {
            return Integer.toString(input);
        }
    }

    private static String fizzBuzzV2(int input) {
        return Optional.of(input)
                .map(num -> (num % 3 == 0 ? "fizz" : "") + (num % 5 == 0 ? "buzz" : ""))
                .orElseGet(() -> Integer.toString(input));
    }

    @NotNull
    private Node buildTree() {
        Node five = new Node(5, ImmutableList.of());
        Node six = new Node(6, ImmutableList.of());
        Node three = new Node(3, ImmutableList.of(five, six));
        Node two = new Node(2, ImmutableList.of());
        Node four = new Node(4, ImmutableList.of());
        return new Node(1, ImmutableList.of(three, two, four));
    }
}
