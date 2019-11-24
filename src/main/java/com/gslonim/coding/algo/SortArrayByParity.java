package com.gslonim.coding.algo;

import com.gslonim.coding.Harness;

import java.util.function.Function;

public class SortArrayByParity implements Harness<int[], int[]> {
    @Override
    public Function<int[], int[]> solution() {
        return array -> {
            int[] sortedByParity = new int[array.length];
            int even = 0;
            int odd = 1;

            for (int number : array) {
                if (number % 2 == 0) {
                    sortedByParity[even] = number;
                    even += 2;
                } else {
                    sortedByParity[odd] = number;
                    odd += 2;
                }

            }
            return sortedByParity;
        };
    }
}
