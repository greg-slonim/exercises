package com.gslonim.coding.algo;

import org.junit.Test;

import static com.gslonim.coding.algo.LongestPalindromeSubstring.expandAroundCenter;
import static org.assertj.core.api.Assertions.assertThat;

public class LongestPalindromeSubstringTest {
    @Test
    public void should_detect_palindrome_in_a_single_palindrome_containing_string() {
        String input = "cbbd";
        String expected = "bb";

        assertThat(LongestPalindromeSubstring.longestPalindrome(input)).isEqualTo(expected);

        input = "babad";
        expected = "bab";

        assertThat(LongestPalindromeSubstring.longestPalindrome(input)).isEqualTo(expected);

        input = "asdfgaagoel";
        expected = "gaag";
        assertThat(LongestPalindromeSubstring.longestPalindrome(input)).isEqualTo(expected);

        input = "bb";
        expected = "bb";
        assertThat(LongestPalindromeSubstring.longestPalindrome(input)).isEqualTo(expected);

        input = "bbbbbbbb";
        expected = "bbbbbbbb";
        assertThat(LongestPalindromeSubstring.longestPalindrome(input)).isEqualTo(expected);
    }

    @Test
    public void should_detect_longest_palindrome_in_a_multiple_palindrome_containing_string() {
        String input = "abacab";
        String expected = "bacab";
        assertThat(LongestPalindromeSubstring.longestPalindromeReference(input)).isEqualTo(expected);

        input = "cbbdasdfgaagoacaramanamaracael";
        expected = "acaramanamaraca";
        assertThat(LongestPalindromeSubstring.longestPalindrome(input)).isEqualTo(expected);

    }

    @Test
    public void should_detect_single_letter_palindrome_containing_string() {
        String input = "ac";
        String expected = "a";

        assertThat(LongestPalindromeSubstring.longestPalindrome(input)).isEqualTo(expected);
    }

    @Test
    public void should_detect_palindrome() {
        String input = "aba";
        assertThat(LongestPalindromeSubstring.isPalindrome(input)).isTrue();

        input = "acaramanamaraca";
        assertThat(LongestPalindromeSubstring.isPalindrome(input)).isTrue();

        input = "bb";
        assertThat(LongestPalindromeSubstring.isPalindrome(input)).isTrue();

        input = "baab";
        assertThat(LongestPalindromeSubstring.isPalindrome(input)).isTrue();

        input = "bbbb";
        assertThat(LongestPalindromeSubstring.isPalindrome(input)).isTrue();
    }

    @Test
    public void should_return_input_string_if_blank() {
        String input = "                   ";
        assertThat(LongestPalindromeSubstring.longestPalindrome(input)).isEqualTo(input);
    }

    @Test
    public void expand_around_center() {
        String input = "baab";
        System.out.println(expandAroundCenter(input, 0, 1));
    }
}