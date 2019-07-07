package com.gslonim.coding.algo;

import java.util.concurrent.atomic.AtomicInteger;

public class Permutations {
    private static final AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        permutations.permutation("hello", "");
        System.out.println("CALLED " + count.get() + " times");
    }

    void permutation(String string, String prefix) {
        count.incrementAndGet();
        if (string.length() == 0) {
            System.out.println("PREFIX: " + prefix);
        } else {
            for (int i = 0; i < string.length(); i++) {
                String remainder = string.substring(0, i) + string.substring(i + 1);
                System.out.println("Calling recursively with " + remainder + " and " + (prefix + string.charAt(i)));
                permutation(remainder, prefix + string.charAt(i));
            }
        }
    }
}
