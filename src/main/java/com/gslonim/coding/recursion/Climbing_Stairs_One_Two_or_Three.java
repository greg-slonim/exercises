package com.gslonim.coding.recursion;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Climbing_Stairs_One_Two_or_Three {
    public static int climb_recursively(int totalSteps) {
        Instant start = Instant.now();
        int answer = do_climb(totalSteps, new HashMap<>()) % 10000000 + 7;
        Instant stop = Instant.now();
        System.out.println("Took " + Duration.between(start, stop).toNanos());
        return answer;
    }

    public static int climb_iteratively_without_array(int totalSteps) {
        int stepOne = 1, stepTwo = 2, stepThree = 4;
        int currentSteps = stepThree;
        for (int i = 3; i < totalSteps; i++) {
            currentSteps = stepOne + stepTwo + stepThree;
            stepOne = stepTwo;
            stepTwo = stepThree;
            stepThree = currentSteps;
        }
        return currentSteps;
    }

    public static int climb_iteratively(int totalSteps) {
        Instant start = Instant.now();
        if (totalSteps == 1) {
            return 1;
        }
        if (totalSteps == 2) {
            return 2;
        }

        int[] steps = new int[totalSteps];
        steps[0] = 1;
        steps[1] = 2;
        steps[2] = 4;

        for (int i = 3; i < totalSteps; i++) {
            steps[i] = steps[i - 1] + steps[i - 2] + steps[i - 3];
        }
        Instant stop = Instant.now();
        System.out.println("Took " + Duration.between(start, stop).toNanos());
        return steps[totalSteps - 1];
    }

    private static int do_climb(int totalSteps, Map<Integer, Integer> lookup) {
        if (totalSteps == 0 || totalSteps == 1) {
            return 1;
        }
        if (totalSteps <= 0) {
            return 0;
        }
        if (!lookup.containsKey(totalSteps)) {
            lookup.put(totalSteps,
                    do_climb(totalSteps - 1, lookup)
                            + do_climb(totalSteps - 2, lookup)
                            + do_climb(totalSteps - 3, lookup));
        }
        return lookup.get(totalSteps);
    }
}
