package com.gslonim.coding.hashtables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Frequency_Queries {
    public static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> dataStore = new HashMap<>();
        Map<Integer, Function<Integer, Integer>> operators = new HashMap<>();
        List<Integer> output = new ArrayList<>();

        operators.put(1, number -> dataStore.merge(number, 1, Integer::sum));
        operators.put(2, number -> {
                    dataStore.computeIfPresent(number, (key, oldVal) -> oldVal - 1);
                    if (dataStore.get(number) == 0) {
                        dataStore.remove(number);
                    }
                    return 0;
                });
        operators.put(3, number -> dataStore.containsValue(number) ? 1 : 0);

        for (List<Integer> command : queries) {
            int operation = command.get(0);
            int operand = command.get(1);
            if (operation == 3) {
                output.add(operators.get(operation).apply(operand));
            } else {
                operators.get(operation).apply(operand);
            }
        }
        return output;
    }
}
