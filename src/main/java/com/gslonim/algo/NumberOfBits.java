package com.gslonim.algo;

public class NumberOfBits {
    public static void main(String[] args) {
        System.out.println(countOneBits(00000000000000000000000000001011));
        System.out.println(numberOneBitsByHand(00000000000000000000000000001011));
        System.out.println(bitCount(00000000000000000000000000001011));

    }
    static int countOneBits(long number) {
        return Long.bitCount(number);
    }

    static int numberOneBitsByHand(long number) {
        System.out.println(number);
        System.out.println("Divided by 2 " + (number >>> 1));
        System.out.println("Divided by 4 " + (number >>> 2));
        System.out.println("Divided by 16 " + (number >>> 4));
        System.out.println("Divided by 256 " + (number >>> 8));
        System.out.println("Divided by 512 " + (number >>> 16));
        System.out.println("Divided by 1024 " + (number >>> 32));

        number = number - (number >>> 1);
        System.out.println("step 1 " + number);
        number = number + (number >>> 2);
        System.out.println("step 2 " + number);
        number = (number + (number >>> 4));
        System.out.println("step 3 " + number);
        number = (number + (number >>> 8));
        System.out.println("step 4 " + number);
        number = (number + (number >>> 16));
        System.out.println("step 5 " + number);
        number = (number + (number >>> 32));
        System.out.println("step 6 " + number);

        System.out.println((int)number & 0x7f);
        return 1;
    }

    private static int bitCount(long i) {
        long count = 0;

        while (i != 0) {
            System.out.println("i="+ i);
            count = count + i & 1;
            System.out.println("count="+count);
            i = i >>> 2;
            System.out.println("i="+i);
        }
        System.out.println("Answer is " + count);
        return (int)count;
    }
}
