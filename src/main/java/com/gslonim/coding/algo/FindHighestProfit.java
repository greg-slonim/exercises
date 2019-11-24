package com.gslonim.coding.algo;

public class FindHighestProfit {
    public static int maxProfit(int[] prices) {
        int minNumber = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int number : prices) {
            if (number < minNumber) {
                minNumber = number;
            } else if (number - minNumber > maxProfit) {
                maxProfit = number - minNumber;
            }
        }
        return maxProfit;
    }
}
