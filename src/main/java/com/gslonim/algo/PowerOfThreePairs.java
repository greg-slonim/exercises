package com.gslonim.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PowerOfThreePairs {
    public void displayEqualPairs(int max) {
        Map<Long, List<ValuePair>> resultPairs = new HashMap<>();

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                long result = (long) (Math.pow(i, 3) + Math.pow(j, 3));
                ValuePair pair =  new ValuePair(i, j);
                if (resultPairs.containsKey(result)) {
                    resultPairs.get(result).add(pair);
                } else {
                    List<ValuePair> valuePairs = new ArrayList<>();
                    valuePairs.add(pair);
                    resultPairs.put(result, valuePairs);
                }
            }
        }

        resultPairs.values().forEach(pairs -> {
            if (pairs.size() > 1) {
                System.out.println(pairs);
            }
        });
    }

    public static void main(String[] args) {
        PowerOfThreePairs solution = new PowerOfThreePairs();
        solution.displayEqualPairs(10);
    }

    class ValuePair {
        private final int a;
        private final int b;

        ValuePair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public String toString() {
            return "[" + a + ", " + b + "]";
        }
    }
}
