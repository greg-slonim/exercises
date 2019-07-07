package com.gslonim.coding.algo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LongestSubstringWithoutRepeatTest {
    @Test
    public void should_return_correct_substring_length() {
        String inputString = "abcabcbb";
        int expectedLength = 3; //The answer is "abc", with the length of 3.
        assertThat(LongestSubstringWithoutRepeat.lengthOfLongestSubstringReference(inputString)).isEqualTo(expectedLength);

        inputString = "bbbbb";
        expectedLength = 1  ; //The answer is "b", with the length of 1.
        assertThat(LongestSubstringWithoutRepeat.lengthOfLongestSubstringReference(inputString)).isEqualTo(expectedLength);

        inputString = "pwwkew";
        expectedLength = 3  ; //The answer is "wke", with the length of 3.
        assertThat(LongestSubstringWithoutRepeat.lengthOfLongestSubstringReference(inputString)).isEqualTo(expectedLength);

        inputString = " ";
        expectedLength = 1  ; //The answer is " ", empty string counts too.
        assertThat(LongestSubstringWithoutRepeat.lengthOfLongestSubstringReference(inputString)).isEqualTo(expectedLength);
    }

    @Test
    public void should_return_zero_with_zero_length_input() {
        String inputString = "";
        int expectedLength = 0;
        assertThat(LongestSubstringWithoutRepeat.lengthOfLongestSubstringReference(inputString)).isEqualTo(expectedLength);
    }

    @Test
    public void should_return_one_with_empty_string_input() {
        String inputString = " ";
        int expectedLength = 1;
        assertThat(LongestSubstringWithoutRepeat.lengthOfLongestSubstringReference(inputString)).isEqualTo(expectedLength);

        inputString = "          ";
        expectedLength = 1;
        assertThat(LongestSubstringWithoutRepeat.lengthOfLongestSubstringReference(inputString)).isEqualTo(expectedLength);
    }

    @Test
    public void should_return_two_with_empty_string_input() {
        String inputString = " aaa";
        int expectedLength = 2;
        assertThat(LongestSubstringWithoutRepeat.lengthOfLongestSubstringReference(inputString)).isEqualTo(expectedLength);
    }

    @Test
    public void should_account_for_strings_with_repeated_characters() {
        String inputString = "dvdf";
        int expectedLength = 3;
        assertThat(LongestSubstringWithoutRepeat.lengthOfLongestSubstringReference(inputString)).isEqualTo(expectedLength);
    }
}