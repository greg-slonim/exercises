package com.gslonim.coding.algo;

public class MoveAllZeroesToTheEndOfTheArray {
    public static int[] moveZeroes(int[] arr) {
        int left = 0, right = 0;
        for (; left < arr.length; left++) {
            if (arr[left] == 0) {
                while (right < arr.length - 1 && arr[right] == 0) {
                    right++;
                }
                arr[left] = arr[right];
                arr[right] = 0;
            } else {
                right++;
            }
        }
        return arr;
    }
}
