package com.gslonim.coding.pattern_find_missing_number;

import java.util.Arrays;

public class Measure_Median_Expenditures {

    public static int activityNotifications(int[] expenditure, int d) {
        if (expenditure.length <= d) {
            return 0;
        }
        int left = 0, right = d - 1, current = d;
        double median;
        int notificiations = 0;
        for (;current < expenditure.length; left++, right++, current++) {
            median = calculateMedian(expenditure, left, right);
            if (exceeds(expenditure[current], median)) {
                notificiations++;
            }
        }
        return notificiations;
    }

    private static double calculateMedian(int[] expenditure, int left, int right) {
        int[] window = Arrays.copyOfRange(expenditure, left, right + 1);
        Arrays.sort(window);
        if (window.length % 2 == 0) {
            int leftMid = window.length / 2 - 1;
            int rightMid = window.length / 2;
            return (window[leftMid] + window[rightMid]) / 2.0;
        }
        return window[window.length / 2];
    }

    private static boolean exceeds(int current, double median) {
        return current >= median * 2;
    }
}
