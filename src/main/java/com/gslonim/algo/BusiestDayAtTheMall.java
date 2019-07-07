package com.gslonim.algo;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class BusiestDayAtTheMall {
    private static final long JANUARY_1_2018 = OffsetDateTime.parse("2017-01-01T00:00:00+00").toEpochSecond();
    private static final long DECEMBER_31_2018 = OffsetDateTime.parse("2017-12-31T23:59:59+00").toEpochSecond();

    int findBusiestPeriod(int[][] data) {
        if (data.length == 0) {
            return -1;
        }
        List<VisitorDataMetric> metrics = new ArrayList<>();

        for (int[] metric : data) {
            metrics.add(new VisitorDataMetric(metric[0], metric[1], metric[2]));
        }
        int maxVisitors = 0;
        long timestampAtMax = 0;
        int counter = 0;

        for(VisitorDataMetric metric : metrics) {
            if (!metric.withinLastYear()) {
                continue;
            }
            if (metric.entered) {
                counter += metric.numberOfVisitors;
                if (maxVisitors < counter) {
                    maxVisitors = counter;
                    timestampAtMax = metric.timestamp;
                }
            } else {
                counter -= metric.numberOfVisitors;
            }
        }
        return (int) timestampAtMax;
    }

    public static void main(String[] args) {
        BusiestDayAtTheMall solution = new BusiestDayAtTheMall();
        int[][] data = new int[][]{
                {1487799425, 14, 1},
                {1487799425, 4, 0},
                {1487799425, 2, 0},
                {1487800378, 10, 1},
                {1487801478, 18, 0},
                {1487801478, 18, 1},
                {1487901013, 1, 0},
                {1487901211, 7, 1},
                {1487901211, 7, 0}
        };
        System.out.println("solution = " + solution.findBusiestPeriod(data));
    }

    class VisitorDataMetric {
        private final long timestamp;
        private final int numberOfVisitors;
        private final boolean entered;

        VisitorDataMetric(long timestamp, int numberOfVisitors, int entered) {
            this.timestamp = timestamp;
            this.numberOfVisitors = numberOfVisitors;
            this.entered = (entered == 1);
        }

        boolean withinLastYear() {
            return timestamp >= JANUARY_1_2018 && timestamp <= DECEMBER_31_2018;
        }
    }
}
