package com.gslonim.coding.algo;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 */
public class MaxSubArrayProduct {
    public static int maxProduct(int[] nums) {
        int[] max= new int[nums.length];
        int[] min= new int[nums.length];
        int maxProduct = 0;

        max[0] = min[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            int currentTimesMaxPrevious = nums[i] * max[i - 1];
            int currentTimesMinPrevious = nums[i] * min[i - 1];

            int largerOf = Math.max(currentTimesMaxPrevious, currentTimesMinPrevious);
            max[i] = Math.max(largerOf, nums[i]);

            int smallerOf = Math.min(currentTimesMaxPrevious, currentTimesMinPrevious);
            min[i] = Math.min(smallerOf, nums[i]);

            maxProduct= Math.max(maxProduct, max[i]);
        }
        return maxProduct;
    }
}
