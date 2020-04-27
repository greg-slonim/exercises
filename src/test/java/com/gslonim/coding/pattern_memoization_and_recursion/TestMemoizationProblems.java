package com.gslonim.coding.pattern_memoization_and_recursion;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestMemoizationProblems {
    private int nthNumber;

    @Test
    public void should_find_n_th_fibonacci_number() {
        when_nth_number_is(5);
        then_fibonacci_number_is(5);

        when_nth_number_is(8);
        then_fibonacci_number_is(21);
    }

    private void then_fibonacci_number_is(int answer) {
        assertThat(MemoizationProblems.solveNthFibonacciNumber(nthNumber))
                .isEqualTo(answer);
    }

    private void when_nth_number_is(int nthNumber) {
        this.nthNumber = nthNumber;
    }

    private static final class MemoizationProblems {
        public static int solveNthFibonacciNumber(int nthNumber) {
            if (nthNumber == 0 || nthNumber == 1) {
                return nthNumber;
            }
            int first = 0, second = 1, result = 0;
            for (int i = 2; i <= nthNumber; i++) {
                result = first + second;
                first = second;
                second = result;
            }
            return result;
        }
    }
}
