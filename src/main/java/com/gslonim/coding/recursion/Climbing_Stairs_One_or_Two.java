package com.gslonim.coding.recursion;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Climbing_Stairs_One_or_Two {
    public static int climb_recursively(int totalSteps) {
        Instant start = Instant.now();
        int answer = do_climb(totalSteps, new HashMap<>());
        Instant stop = Instant.now();
        System.out.println("Took " + Duration.between(start, stop).toNanos());
        return answer;
    }

    public static int climb_iteratively(int totalSteps) {
        Instant start = Instant.now();
        int[] steps = new int[totalSteps];
        steps[0] = 1;
        steps[1] = 2;

        for (int i = 2; i < totalSteps; i++) {
            steps[i] = steps[i - 1] + steps[i-2];
        }
        Instant stop = Instant.now();
        System.out.println("Took " + Duration.between(start, stop).toNanos());
        return steps[totalSteps - 1];
    }

    private static int do_climb(int totalSteps, Map<Integer, Integer> lookup) {
        if (totalSteps == 0) {
            return 1;
        }
        if (totalSteps <= 0) {
            return 0;
        }
        if (!lookup.containsKey(totalSteps)) {
            lookup.put(totalSteps,
                    do_climb(totalSteps - 1, lookup)
                            + do_climb(totalSteps - 2, lookup));
        }
        return lookup.get(totalSteps);
    }
}
