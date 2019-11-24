package com.gslonim.coding.algo;

public class FindMaximumSumOfSubarray {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int left = 0, currSum = 0, maxSum = 0;

        for (int right = 0; right < arr.length; right++) {
            currSum = currSum + arr[right];

            if (right >= k - 1) {
                maxSum = Math.max(currSum, maxSum);
                currSum = currSum - arr[left];
                left++;
            }
        }
        return maxSum;
    }
}
