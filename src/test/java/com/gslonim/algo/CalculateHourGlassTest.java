package com.gslonim.algo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateHourGlassTest {
    @Test
    public void should_sum_hourglass_with_positive_numbers() {
        int[][] actual = new int[6][6];
        actual[0][0] = 0; actual[0][1] = 1; actual[0][2] = 5; actual[0][3] = 0; actual[0][4] = 1; actual[0][5] = 0;
        actual[1][0] = 0; actual[1][1] = 1; actual[1][2] = 0; actual[1][3] = 0; actual[1][4] = 1; actual[1][5] = 0;
        actual[2][0] = 0; actual[2][1] = 1; actual[2][2] = 0; actual[2][3] = 0; actual[2][4] = 1; actual[2][5] = 0;
        actual[3][0] = 0; actual[3][1] = 1; actual[3][2] = 0; actual[3][3] = 0; actual[3][4] = 1; actual[3][5] = 0;
        actual[4][0] = 0; actual[4][1] = 1; actual[4][2] = 0; actual[4][3] = 0; actual[4][4] = 1; actual[4][5] = 0;
        actual[5][0] = 1; actual[5][1] = 1; actual[5][2] = 0; actual[5][3] = 1; actual[5][4] = 1; actual[5][5] = 1;
        CalculateHourGlass calculator = new CalculateHourGlass(actual, 6);

        int sum = calculator.sumHourGlass();
        assertThat(sum).isEqualTo(8);
    }

    @Test
    public void should_sum_hourglass_with_negative_numbers() {
        int[][] actual = new int[6][6];
        actual[0][0] = -1; actual[0][1] = -1; actual[0][2] = 0; actual[0][3] = -9; actual[0][4] = -2; actual[0][5] = -2;
        actual[1][0] = -2; actual[1][1] = -1; actual[1][2] = -6; actual[1][3] = -8; actual[1][4] = -2; actual[1][5] = -5;
        actual[2][0] = -1; actual[2][1] = -1; actual[2][2] = -1; actual[2][3] = -2; actual[2][4] = -3; actual[2][5] = -4;
        actual[3][0] = -1; actual[3][1] = -9; actual[3][2] = -2; actual[3][3] = -4; actual[3][4] = -4; actual[3][5] = -5;
        actual[4][0] = -7; actual[4][1] = -3; actual[4][2] = -3; actual[4][3] = -2; actual[4][4] = -9; actual[4][5] = -9;
        actual[5][0] = -1; actual[5][1] = -3; actual[5][2] = -1; actual[5][3] = -2; actual[5][4] = -4; actual[5][5] = -5;
        CalculateHourGlass calculator = new CalculateHourGlass(actual, 6);

        int sum = calculator.sumHourGlass();
        assertThat(sum).isEqualTo(8);
    }


//            -1 -1  0 -9 -2 -2
//            -2 -1 -6 -8 -2 -5
//            -1 -1 -1 -2 -3 -4

//            -1 -9 -2 -4 -4 -5
//            -7 -3 -3 -2 -9 -9
//            -1 -3 -1 -2 -4 -5
}