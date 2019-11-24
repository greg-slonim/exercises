package com.gslonim.coding.algo;

public class FindLongestArrayOfOneAfterReplacement {
    public static int findLength(int[] arr, int k) {
        int left = 0, zeroCount = 0, maxLength = 0;

        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) {
                zeroCount++;
            }
            while(zeroCount > k) {
                if(arr[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(right - left + 1, maxLength);
        }
        return maxLength;
    }
}
