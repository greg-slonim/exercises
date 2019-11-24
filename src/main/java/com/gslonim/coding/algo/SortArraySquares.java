package com.gslonim.coding.algo;

public class SortArraySquares {

    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int left = 0, right = arr.length - 1, highIndex = right;

        while(left <= right) {
            if (square(arr[left]) > square(arr[right])) {
                squares[highIndex--] = square(arr[left]);
                left++;
            } else {
                squares[highIndex--] = square(arr[right]);
                right--;
            }
        }

        return squares;
    }

    private static int square(int num) {
        return num * num;
    }
}
