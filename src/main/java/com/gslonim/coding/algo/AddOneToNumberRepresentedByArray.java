package com.gslonim.coding.algo;

import com.gslonim.coding.Harness;

import java.util.function.Function;

/**
 * Given array representing a number (ex [9,9,9,8])
 * add 1 to it. You must account for any possible carryovers.
 */
public class AddOneToNumberRepresentedByArray implements Harness<int[], int[]> {
    @Override
    public Function<int[], int[]> solution() {
        return inputArray -> {
            int rightPointer = inputArray.length - 1;
            int numberToAdd = 1;

            for (int i = rightPointer; i >= 0; --i) {
                inputArray[i] = inputArray[i] + numberToAdd;

                if (i == 0 && inputArray[i] > 9) {
                    return expandArray(inputArray);
                }

                if (inputArray[i] > 9) {
                    inputArray[i] = inputArray[i] % 10;
                    numberToAdd = 1;
                } else {
                    numberToAdd = 0;
                }
            }

            return inputArray;
        };
    }

    private int[] expandArray(int[] inputArray) {
        int[] expandedArray = new int[inputArray.length + 1];
        expandedArray[0] = 1;
        for (int i = 1; i < inputArray.length; i++) {
            expandedArray[i] = inputArray[i];
        }
        return expandedArray;
    }
}
