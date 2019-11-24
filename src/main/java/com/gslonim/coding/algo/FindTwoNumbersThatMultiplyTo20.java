package com.gslonim.coding.algo;

import com.gslonim.coding.Harness;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTwoNumbersThatMultiplyTo20 implements Harness<int[], Set<Integer>> {

    @Override
    public Function<int[], Set<Integer>> solution() {
        return input -> {
            Map<Integer, Integer> multipliers = createMultipliers(input);

            return multipliers.keySet().stream()
                    .filter(multipliers::containsKey)
                    .collect(Collectors.toSet());
        };
    }

    private Map<Integer, Integer> createMultipliers(int[] input) {
        Map<Integer, Integer> multipliers = new HashMap<>();
        for (int value : input) {
            multipliers.put(value, value < 20 ? 20 / value : -1111);
        }
        return multipliers;
    }
}
