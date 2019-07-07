package com.gslonim.coding.algo;

import java.util.concurrent.ThreadLocalRandom;

public class CalculateHourGlass {
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();
    private final int[][] array;
    private final int size;

    public CalculateHourGlass(int[][] array, int size) {
        this.array = array;
        this.size = size;
    }

    static int[][] initializeArray(int size) {
        int[][] array = new int[size][size];
            for (int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    array[i][j] = random.nextInt(0, 4);
                }
            }
        return array;
    }

    public int sumHourGlass() {
        int maxSum =  Integer.MIN_VALUE;

        for (int i = 0; i <= size - 3; i++) {
            for (int j = 0; j <= size - 3; j++) {
                int sum = 0;
                sum += sumRow(array[i], j);
                sum += array[i + 1][j + 1];
                sum += sumRow(array[i + 2], j);

                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    private int sumRow(int[] row, int index) {
        if (index + 2 > this.size) {
            throw new IllegalArgumentException("Row size not big enough");
        }

        return row[index] + row[index + 1] + row[index + 2];
    }
}
