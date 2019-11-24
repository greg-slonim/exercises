package com.gslonim.coding.algo;

public class MaxSubarraySum {
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     *
     * Example:
     *
     * Input: [-2,1,-3,4,-1,2,1,-5,4],
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0], runningSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > runningSum + nums[i]) {
                runningSum = nums[i];
            } else {
                runningSum += nums[i];
            }
            if (runningSum > max) {
                max = runningSum;
            }
        }
        return max;
    }
}
