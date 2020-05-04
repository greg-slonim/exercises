package com.gslonim.coding.pattern_binary;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestBinaryNumbers {
    private int input;
    @Test
    public void should_find_the_longest_sequence_of_zeroes_in_binary() {
        whenInputIs(14);
        thenTheLongestSequenceOfZeroesIs(0);

        whenInputIs(9);
        thenTheLongestSequenceOfZeroesIs(2);

        whenInputIs(12345);
        thenTheLongestSequenceOfZeroesIs(6);

        whenInputIs(2345678);
        thenTheLongestSequenceOfZeroesIs(3);

        whenInputIs(8);
        thenTheLongestSequenceOfZeroesIs(0);
    }

    private void thenTheLongestSequenceOfZeroesIs(int longestSequence) {
        assertThat(Solution.getLongestNumberOfZeroesInBinaryRepresentation(input)).isEqualTo(longestSequence);
    }

    private void whenInputIs(int number) {
        input = number;
    }

    private static class Solution {
        static int getLongestNumberOfZeroesInBinaryRepresentation(int number) {
            String binary = Integer.toBinaryString(number);
            int count = 0, maxCount = 0;
            for (int i = 0; i < binary.length(); i++) {
                if (binary.charAt(i) == '0') {
                    count++;
                } else if (binary.charAt(i) == '1'){
                    maxCount = Math.max(maxCount, count);
                    count = 0;
                }
            }
            return maxCount;
        }
    }
}
