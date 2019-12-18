package com.gslonim.coding.kth_number;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Find_K_Smallest_Number {
    public static int findKthSmallestNumber(int[] nums, int k) {
        if (k > nums.length) {
            throw new IllegalArgumentException("exceeds");
        }
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] < maxHeap.peek()) {
                maxHeap.remove();
                maxHeap.offer(nums[i]);
            }
        }
        return maxHeap.peek();
    }
}
