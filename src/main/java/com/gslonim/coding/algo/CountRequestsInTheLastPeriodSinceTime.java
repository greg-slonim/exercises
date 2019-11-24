package com.gslonim.coding.algo;

import com.gslonim.coding.Harness;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Function;

public class CountRequestsInTheLastPeriodSinceTime implements Harness<Integer, Integer> {
    private final Queue<Integer> requestQueue = new LinkedList<>();
    
    @Override
    public Function<Integer, Integer> solution() {
        return timeNow -> {
            if (timeNow == null) {
                return null;
            }
            requestQueue.add(timeNow);
            while (requestQueue.peek() < (timeNow - 3000)) {
                requestQueue.poll();
            }
            return requestQueue.size();
        };
    }
}
