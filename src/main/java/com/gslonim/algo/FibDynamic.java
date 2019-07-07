package com.gslonim.algo;

public class FibDynamic {
    public static final int MAX_NUMBER = 46;
    private static int cache[] = new int[MAX_NUMBER];

    private int fibMemoised(int nNumber) {
        int maybeCached = cache[nNumber];
        if (maybeCached == -1) {
            cache[nNumber] = fibMemoised(nNumber - 1) + fibMemoised(nNumber - 2);
        }
        return cache[nNumber];
    }

    private int fibMemoisedDriver(int nNumber) {
        initialiseCache();
        return fibMemoised(nNumber);
    }

    private static void initialiseCache() {
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i < MAX_NUMBER; i++) {
            cache[i] = -1;
        }
    }

    private int fibRecursive(int nNumber) {
        if (nNumber == 0 || nNumber == 1) {
            return nNumber;
        }
        return fibRecursive(nNumber - 1) + fibRecursive(nNumber - 2);
    }

    private int fibNoRecursion(int nNumber) {
        int[] results = new int[MAX_NUMBER];
        results[0] = 0;
        results[1] = 1;

        for (int i = 2; i <= nNumber; i++) {
            results[i] = results[i - 1] + results[i - 2];
        }
        return results[nNumber];
    }

    public static void main(String[] args) {
        FibDynamic fib = new FibDynamic();
        long start = System.nanoTime();
        System.out.println(fib.fibMemoisedDriver(6));
        long finish = System.nanoTime();
        System.out.println("Cached in " + (finish - start)/1000 + " macroseconds or " + (finish - start)/1000000
                + " milliseconds");

        start = System.nanoTime();
        System.out.println(fib.fibRecursive(6));
        finish = System.nanoTime();
        System.out.println("Recursive in " + (finish - start)/1000 + " macroseconds or " + (finish - start)/1000000
                + " milliseconds");

        start = System.nanoTime();
        System.out.println(fib.fibNoRecursion(6));
        finish = System.nanoTime();
        System.out.println("No recursion in " + (finish - start)/1000 + " macroseconds or " + (finish - start)/1000000
                + " milliseconds");
    }
}
