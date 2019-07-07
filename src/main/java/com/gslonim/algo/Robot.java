package com.gslonim.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

class Robot {

    private static final Map<String, Consumer<Integer>> moveTranslator = initialize();
    private static int vCounter;
    private static int hCounter;

    private boolean judgeCircle(String moves) {
        if (moves.length() % 2 != 0) {
            return false;
        }
        String[] moveMatrix = moves.split("");

        for(int i = 0; i < moves.length(); i++) {
            String move = moveMatrix[i];
            moveTranslator.get(move).accept(0);
        }
        return vCounter == 0 && hCounter == 0;
    }

    private static Map<String, Consumer<Integer>> initialize() {
        Map<String, Consumer<Integer>> moves = new HashMap<>();
        moves.put("U", c -> vCounter = vCounter + 1);
        moves.put("D", c -> vCounter = vCounter - 1);
        moves.put("R", c -> hCounter = hCounter + 1);
        moves.put("L", c -> hCounter = hCounter - 1);

        return moves;
    }

    public static void main(String[] args) {
        System.out.println("5 shifted 1 " + (5 >> 1));
        System.out.println("Distance = " + calculateHammingDistance(1, 4));
    }

    private static int calculateHammingDistance(int left, int right) {
        int xor = left ^ right;
        System.out.println("XOR between " + left + " and " + right + " is " + xor);
        System.out.println("Binary representation of xor is " + Integer.toBinaryString(xor));
        int setBits = 0;

        while (xor > 0) {
            setBits += xor & 1;
            System.out.println("xor & 1 = " + (xor & 1));
            System.out.println("setBits after " + xor + " & 1 = " + setBits);
            xor >>= 1;
            System.out.println("xor after >> 1 = " + xor);
        }
        return setBits;
    }

    private static void arrayToString(String[] array) {
        for (String a : array) {
            System.out.print(a);
        }
        System.out.println();
    }
}
