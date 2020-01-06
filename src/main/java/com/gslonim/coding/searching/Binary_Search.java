package com.gslonim.coding.searching;

public class Binary_Search {
    public static int find_if_present_in_array_return_index(int[] arr, int key) {
        // USE CASE: array is sorted in ascending order
        int left = 0, right  = arr.length - 1;
        while (left <= right) {
            //find middle
            int middle = left + (right - left)/2;
            if (arr[middle] == key) {
                return middle;
            }
            if (arr[middle] < key) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static int find_if_present_in_array_unknown_sort_order(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        boolean ascending = arr[left] < arr[right];

        while(left <= right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] == key) {
                return middle;
            }
            if (ascending) {
                if (arr[middle] < key) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            } else {
                if (arr[middle] < key) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return -1;
    }

    public static int find_ceiling_of_a_number(int[] arr, int key) {
        if (key > arr[arr.length - 1]) {
            return -1;
        }
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (key > arr[middle]) {
                left = middle + 1;
            } else if (key < arr[middle]) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return left;
    }
}
