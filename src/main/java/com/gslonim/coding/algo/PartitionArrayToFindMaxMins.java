package com.gslonim.coding.algo;

import com.gslonim.coding.Harness;

import java.util.Arrays;
import java.util.function.Function;

public class PartitionArrayToFindMaxMins implements Harness<int[], Integer> {
    @Override
    public Function<int[], Integer> solution() {
        return input -> {
            Arrays.sort(input);
            int sum = 0;
            for (int i = 0; i < (input.length - 1); i += 2) {
                sum += input[i];
            }
            return sum;
        };
    }
}
