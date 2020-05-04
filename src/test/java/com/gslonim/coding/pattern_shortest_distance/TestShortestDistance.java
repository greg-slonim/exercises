package com.gslonim.coding.pattern_shortest_distance;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestShortestDistance {

    @Test
    public void should_find_the_smallest_number_of_steps_between_x_and_y() {
        assertThat(Solution.findSmallestNumberOfJumpsBetweenXandYUsingLoop(10, 85, 30)).isEqualTo(3);
        assertThat(Solution.findSmallestNumberOfJumpsBetweenXandYUsingLoop(1, 1, 10)).isEqualTo(0);
        assertThat(Solution.findSmallestNumberOfJumpsBetweenXandYUsingLoop(1, 300, 10)).isEqualTo(30);
        assertThat(Solution.findSmallestNumberOfJumpsBetweenXandYUsingLoop(15, 33, 11)).isEqualTo(2);
        assertThat(Solution.findSmallestNumberOfJumpsBetweenXandYUsingLoop(34, 99, 2)).isEqualTo(33);

        assertThat(Solution.findSmallestNumberOfJumpsBetweenXandYUsingDivision(10, 85, 30)).isEqualTo(3);
        assertThat(Solution.findSmallestNumberOfJumpsBetweenXandYUsingDivision(1, 1, 10)).isEqualTo(0);
        assertThat(Solution.findSmallestNumberOfJumpsBetweenXandYUsingDivision(1, 300, 10)).isEqualTo(30);
        assertThat(Solution.findSmallestNumberOfJumpsBetweenXandYUsingDivision(15, 33, 11)).isEqualTo(2);
        assertThat(Solution.findSmallestNumberOfJumpsBetweenXandYUsingDivision(34, 99, 2)).isEqualTo(33);
    }

    private static class Solution {
        static int findSmallestNumberOfJumpsBetweenXandYUsingLoop(int posX, int posY, int jumpWidth) {
            int currentPosition = posX, jumps = 0;
            while(currentPosition < posY) {
                currentPosition += jumpWidth;
                jumps++;
            }
            return jumps;
        }

        static int findSmallestNumberOfJumpsBetweenXandYUsingDivision(int posX, int posY, int jumpWidth) {
            return (int) Math.ceil((posY - posX) / (double) jumpWidth);
        }
    }
}
