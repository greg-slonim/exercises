package com.gslonim.coding.dynamic;

public class Fibonacci_Dynamic {
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 1, b = 2, c = 0;
        for (int i = 3; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
