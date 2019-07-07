package com.gslonim.coding.algo;

public class MinSubarraySum {

    public int minSubArrayLen(int targetSum, int[] numberArray) {

        int arrayLength = 0;
        int totalSum = 0;
        int runningSum;
        int smallestArrayLength = numberArray.length;

        if (numberArray.length == 0) {
            return 0;
        }

        for(int i = 0; i < numberArray.length; i++) {
            runningSum = numberArray[i];
            arrayLength++;
            totalSum += runningSum;

            if ((targetSum - runningSum) <= 0 ) {
                if (arrayLength < smallestArrayLength) {
                    smallestArrayLength = arrayLength;
                }
                break;
            }

            for(int j = i + 1; j < numberArray.length; j++) {
                runningSum += numberArray[j];
                arrayLength++;

                if ((targetSum - runningSum) <= 0 ) {
                    if (arrayLength < smallestArrayLength) {
                        smallestArrayLength = arrayLength;
                    }
                    break;
                }
            }
            arrayLength = 0;
        }

        if (totalSum < targetSum) {
            return 0;
        }

        return smallestArrayLength;
    }

    public static void main(String[] args) {
        MinSubarraySum minSubarraySum = new MinSubarraySum();
        int[] array = {2,3,1,2,4,3};
        int sum = 7;

        System.out.println("min array length " + minSubarraySum.minSubArrayLen(sum, array));

        array = new int[] {1,2,3,4,5};
        sum = 11;

        System.out.println("min array length " + minSubarraySum.minSubArrayLen(sum, array));

        array = new int[] {12,28,83,4,25,26,25,2,25,25,25,12};
        sum = 213;
        System.out.println("min array length " + minSubarraySum.minSubArrayLen(sum, array));

        array = new int[] {1, 4, 4};
        sum = 4;
        System.out.println("min array length " + minSubarraySum.minSubArrayLen(sum, array));

        array = new int[] {1, 1};
        sum = 3;
        System.out.println("min array length " + minSubarraySum.minSubArrayLen(sum, array));

        array = new int[] {2,3,1,2,4,3};
        sum = 7;
        System.out.println("min array length " + minSubarraySum.minSubArrayLen(sum, array));
    }
}
