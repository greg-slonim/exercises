package com.gslonim.coding.maths;

public class Power_of_number {
//    A ^ B = A ^ (B/2) * A ^ (B/2) - EVEN
//    A ^ B = A ^ (B/2) * A ^ (B/2) * A - ODD
    public static int power(int base, int power) {
        if (power == 0) {
            return 1;
        }
        int temp = power(base, power/2);
        if (power % 2 == 0) {
            return temp * temp;
        } else {
            return base * temp * temp;
        }
    }
}
