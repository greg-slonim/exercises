package com.gslonim.coding.kth_number;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Find_K_Largest_Number {
    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return new ArrayList<>(minHeap);
    }
}
