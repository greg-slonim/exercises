package com.gslonim.coding.pattern_merge_intervals;

import com.gslonim.coding.BaseAlgoTest;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class TestMergeIntervalsAlgorithm extends BaseAlgoTest {
    private List<Interval> inputIntervals;
    private Interval newInterval;

    @Test
    public void should_merge_all_overlapping_intervals_and_return_mutually_exclusive_intervals() {
        whenInputIntervalsAre("1, 4", "2, 5", "7, 9");
        then_Mutually_Exclusive_Intervals_Are("1, 5", "7, 9");

        whenInputIntervalsAre("1, 10", "5, 8", "2, 4", "8, 9");
        then_Mutually_Exclusive_Intervals_Are("1, 10");
    }

    @Test
    public void should_determine_if_intervals_overlap() {
        whenInputIntervalsAre("1, 4", "2, 5", "7, 9");
        thenSomeIntervalsOverlap();

        whenInputIntervalsAre("2, 5", "7, 10");
        thenIntervalsDoNotOverlap();
    }

    @Test
    public void should_insert_interval_into_ordered_list_of_intervals_and_merge_overlapping() {
        whenInputIntervalsAre("1, 3", "5, 7", "8, 12");
        whenIntervalToAddIs("4, 6");

        then_New_Mutually_Exclusive_Intervals_Are("1, 3", "4, 7", "8, 12");
    }

    private void then_New_Mutually_Exclusive_Intervals_Are(String ... intervals) {
        List<Interval> expected = parseInput(intervals);
        assertThat(MergeIntervalsProblems.insert(inputIntervals, newInterval))
                .hasSameElementsAs(expected);
    }

    private void thenSomeIntervalsOverlap() {
        assertThat(MergeIntervalsProblems.doIntervalsOverlap(inputIntervals)).isTrue();
    }

    private void thenIntervalsDoNotOverlap() {
        assertThat(MergeIntervalsProblems.doIntervalsOverlap(inputIntervals)).isFalse();
    }

    private void then_Mutually_Exclusive_Intervals_Are(String... mergedIntervals) {
        List<Interval> expected = parseInput(mergedIntervals);

        assertThat(MergeIntervalsProblems.mergeOverlappingIntervals(inputIntervals))
                .hasSameElementsAs(expected);
    }

    @NotNull
    private static List<Interval> parseInput(String[] mergedIntervals) {
        List<Interval> expected = new ArrayList<>();
        for (String interval : mergedIntervals) {
            expected.add(Interval.fromString(interval));
        }
        return expected;
    }

    private void whenIntervalToAddIs(String interval) {
        newInterval = Interval.fromString(interval);
    }

    private void whenInputIntervalsAre(String... intervals) {
        inputIntervals = parseInput(intervals);
    }

    private static final class MergeIntervalsProblems {
        static List<Interval> mergeOverlappingIntervals(List<Interval> input) {
            //sort intervals on start
            input.sort(Comparator.comparingInt(i -> i.start));
            List<Interval> mergedIntervals = new ArrayList<>();
            Interval currentInterval = input.get(0);
            int start = currentInterval.start, end = currentInterval.end;

            for (int i = 1; i < input.size(); i++) {
                currentInterval = input.get(i);
                if (currentInterval.start < end) {
                    end = Math.max(currentInterval.end, end);
                } else {
                    mergedIntervals.add(Interval.from(start, end));
                    start = currentInterval.start;
                    end = currentInterval.end;
                }
            }
            mergedIntervals.add(Interval.from(start, end));
            return mergedIntervals;
        }

        static boolean doIntervalsOverlap(List<Interval> input) {
            Interval currentInterval = input.get(0);
            int end = currentInterval.end;
            for (int i = 1; i < input.size(); i++) {
                currentInterval = input.get(i);
                if (currentInterval.start < end) {
                    return true;
                }
                end = currentInterval.end;
            }
            return false;
        }

        static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            List<Interval> mergedIntervals = new ArrayList<>();
            int i = 0;

            while(i < intervals.size() && intervals.get(i).start < newInterval.start) {
                mergedIntervals.add(intervals.get(i));
                i++;
            }

            while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
                newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
                newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
                i++;
            }
            mergedIntervals.add(newInterval);

            while (i < intervals.size()) {
                mergedIntervals.add(intervals.get(i++));
            }

            return mergedIntervals;
        }
    }

    private static final class Interval {
        int start;
        int end;
        private Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public static Interval fromString(String interval) {
            String[] pair = interval.split(",", -1);
            return new Interval(Integer.parseInt(pair[0].trim()), Integer.parseInt(pair[1].trim()));
        }

        public static Interval from(int start, int end) {
            return new Interval(start, end);
        }

        @Override
        public String toString() {
            return "{"
                    + start
                    + ", "
                    + end
                    + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            return start == interval.start &&
                    end == interval.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
}
