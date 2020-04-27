package com.gslonim.coding.two_dimensional_arrays;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HourGlassCalculatorTest {
    @Test
    public void should_sum_hourglass_with_positive_numbers() {
        int[][] matrix = new int[6][6];
        matrix[0][0] = 0; matrix[0][1] = 1; matrix[0][2] = 5; matrix[0][3] = 0; matrix[0][4] = 1; matrix[0][5] = 0;
        matrix[1][0] = 0; matrix[1][1] = 1; matrix[1][2] = 0; matrix[1][3] = 0; matrix[1][4] = 1; matrix[1][5] = 0;
        matrix[2][0] = 0; matrix[2][1] = 1; matrix[2][2] = 0; matrix[2][3] = 0; matrix[2][4] = 1; matrix[2][5] = 0;
        matrix[3][0] = 0; matrix[3][1] = 1; matrix[3][2] = 0; matrix[3][3] = 0; matrix[3][4] = 1; matrix[3][5] = 0;
        matrix[4][0] = 0; matrix[4][1] = 1; matrix[4][2] = 0; matrix[4][3] = 0; matrix[4][4] = 1; matrix[4][5] = 0;
        matrix[5][0] = 1; matrix[5][1] = 1; matrix[5][2] = 0; matrix[5][3] = 1; matrix[5][4] = 1; matrix[5][5] = 1;
        int sum = HourGlassCalculator.sumHourGlass(matrix, 6);
        assertThat(sum).isEqualTo(8);
    }

    //There is something wrong here. FIXME
    @Test
    public void should_sum_hourglass_with_negative_numbers() {
        int[][] actual = new int[6][6];
        actual[0][0] = -1; actual[0][1] = -1; actual[0][2] = 0; actual[0][3] = -9; actual[0][4] = -2; actual[0][5] = -2;
        actual[1][0] = -2; actual[1][1] = -1; actual[1][2] = -6; actual[1][3] = -8; actual[1][4] = -2; actual[1][5] = -5;
        actual[2][0] = -1; actual[2][1] = -1; actual[2][2] = -1; actual[2][3] = -2; actual[2][4] = -3; actual[2][5] = -4;
        actual[3][0] = -1; actual[3][1] = -9; actual[3][2] = -2; actual[3][3] = -4; actual[3][4] = -4; actual[3][5] = -5;
        actual[4][0] = -7; actual[4][1] = -3; actual[4][2] = -3; actual[4][3] = -2; actual[4][4] = -9; actual[4][5] = -9;
        actual[5][0] = -1; actual[5][1] = -3; actual[5][2] = -1; actual[5][3] = -2; actual[5][4] = -4; actual[5][5] = -5;
        int sum = HourGlassCalculator.sumHourGlass(actual, 6);
        assertThat(sum).isEqualTo(8);
    }

    private static final class HourGlassCalculator {
        public static int sumHourGlass(int[][] array, int size) {
            int maxSum =  Integer.MIN_VALUE;
            for (int i = 0; i <= size - 3; i++) {
                for (int j = 0; j <= size - 3; j++) {
                    int sum = 0;
                    sum += sumRow(array[i], j, size);
                    sum += array[i + 1][j + 1];
                    sum += sumRow(array[i + 2], j, size);

                    maxSum = Math.max(maxSum, sum);
                }
            }
            return maxSum;
        }

        private static int sumRow(int[] row, int index, int size) {
            if (index + 2 > size) {
                throw new IllegalArgumentException("Row size not big enough");
            }

            return row[index] + row[index + 1] + row[index + 2];
        }
    }
}
