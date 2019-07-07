package com.gslonim.algo;

public class CommonElementsInTwoArrays {
    public static void main(String[] args) {
        int a[] = new int[] {13, 27, 35, 40, 49, 55, 59};
        int b[] = new int[] {17, 35, 39, 40, 55, 58, 60};
        CommonElementsInTwoArrays.findCommonElements(a, b);
    }

    private static void findCommonElements(int[] a, int[] b) {
        if (a.length == 0 || b.length == 0) {
            return;
        }
        int lastKnownIndex = 0;
        for (int currentNumber : a) {
            System.out.println("This iteration starts at " + lastKnownIndex);
            for (int j = lastKnownIndex; j < b.length; j++) {
                lastKnownIndex = j;
                if (b[j] > currentNumber) {
                    System.out.println(b[j] + " is greater than " + currentNumber + " continue to the next.");
                    break;
                }
                if (b[j] == currentNumber) {
                    System.out.println("Found match " + b[j]);
                    break;
                }
            }
        }
    }
}
