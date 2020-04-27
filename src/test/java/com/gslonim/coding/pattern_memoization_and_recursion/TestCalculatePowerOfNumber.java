package com.gslonim.coding.pattern_memoization_and_recursion;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCalculatePowerOfNumber {
    private long base;
    private int power;

    @Test
    public void test_raise_number_to_power_manually() {
        when_raising_x_to_y(2, 3);
        then_answer_is(8);

        when_raising_x_to_y(2, 4);
        then_answer_is(16);

        when_raising_x_to_y(2, 5);
        then_answer_is(32);

        when_raising_x_to_y(2, 6);
        then_answer_is(64);

        when_raising_x_to_y(2, 7);
        then_answer_is(128);

        when_raising_x_to_y(2, 12);
        then_answer_is(4096);

    }

    private void then_answer_is(long answer) {
        assertThat(MathsProblems.power_of_number(base, power))
                .isEqualTo(answer);
    }

    private void when_raising_x_to_y(long base, int power) {
        this.base = base;
        this.power = power;
    }

    private static final class MathsProblems {
        static long power_of_number(long base, int power) {
            long result = power(base, power/2);
            if (power % 2 == 0) {
                return result * result;
            }
            return base * result * result;
        }
        private static long power(long base, int power) {
            if (power == 1) {
                return base;
            }
            long answer = base;
            for (int i = 2; i <= power; i++) {
                answer *= base;
            }
            return answer;
        }
    }
}
