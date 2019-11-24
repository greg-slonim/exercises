package com.gslonim.coding.algo;

public class RemoveSortedArrayDuplicates {
    public static int removeDuplicates(int[] arr) {
        int left = 0, minLength = arr.length;

        for (int right = 1; right < arr.length; right++) {
            if (arr[left] != arr[right]) {
                left = right;
            } else {
                minLength--;
            }
        }
        return minLength;
    }
}
