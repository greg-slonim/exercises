package com.gslonim.algo;

public class BitShift {
    public static void main(String[] args) {
        for (int i = 16; i > 0; i--) {
            System.out.println("i:" + i + " shift:" + (i >> 1) + "    div:" + (i / 2));
        }
    }
}
