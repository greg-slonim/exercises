package com.gslonim.coding.algo;

public class RecursiveMaths {
    public long factorial(int number) {
        if (number == 1) {
            return 1;
        }

        return number * (factorial(number - 1));
    }

    public long fibonacci(long nthNumber) {
        if (nthNumber == 0 || nthNumber == 1) {
            return nthNumber;
        }

        return fibonacci(nthNumber - 1) + fibonacci(nthNumber - 2);
    }

    public long iterativeFibonacci(long nthNumber) {
        if (nthNumber == 0 || nthNumber == 1) {
            return nthNumber;
        }

        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= nthNumber; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public long calculatePower(int base, int power) {
        if (power == 1) {
            return base;
        }
        return base * calculatePower(base, power - 1);
    }

    public long calculateDivision(int number, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("invalid");
        }
        if (divisor == 1) {
            return number;
        }
        if (number <= 0) {
            return 0;
        }

        return 1 + calculateDivision(number - divisor, divisor);
    }
}
