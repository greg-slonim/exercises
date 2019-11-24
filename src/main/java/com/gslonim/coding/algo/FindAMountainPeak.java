package com.gslonim.coding.algo;

import com.gslonim.coding.Harness;

import java.util.function.Function;

public class FindAMountainPeak implements Harness<int[], Integer> {
    /**
     * Let's call an array A a mountain if the following properties hold:
     *
     * A.length >= 3
     * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
     * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
     */
    @Override
    public Function<int[], Integer> solution() {
        return input -> {
            int max = 0, maxIndex = 0;
            for  (int i = 0; i < input.length; i++) {
                if (input[i] > max) {
                    max = input[i];
                    maxIndex = i;
                }
            }
            return maxIndex;
        };
    }
}
