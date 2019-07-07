package com.gslonim.coding.algo;

public class ReverseString {
    public static void main(String[] args) {
        char[] value = new char[] {'h','e','l','l','o', ' ', 'w', 'o', 'r', 'l', 'd'};
        int count = value.length;

        int lastIndex = count - 1;
        System.out.println("Starting: count: "+count+" lastIndex: "+lastIndex);
        for (int j = (lastIndex-1) >> 1; j >= 0; j--) {
            int k = lastIndex - j;
            char cj = value[j];
            char ck = value[k];
            value[j] = ck;
            value[k] = cj;

            System.out.print("k:"+k+" j:"+j+" value: ");
            for (char character : value) {
                System.out.print(character);
            }
            System.out.println();
        }
    }
}
