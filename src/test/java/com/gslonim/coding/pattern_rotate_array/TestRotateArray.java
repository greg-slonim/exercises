package com.gslonim.coding.pattern_rotate_array;

import com.gslonim.coding.BaseAlgoTest;
import org.junit.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class TestRotateArray extends BaseAlgoTest {

    private int numberOfSteps;

    @Test
    public void should_rotate_array_right_given_number_of_steps() {
        whenArrayIs(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        whenNumberOfStepsIs(4);
        thenRotatedArrayIs(new int[] {6, 7, 8, 9, 1, 2, 3, 4, 5});

        whenArrayIs(new int[] {1});
        whenNumberOfStepsIs(4);
        thenRotatedArrayIs(new int[] {1});

        whenArrayIs(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        whenNumberOfStepsIs(10);
        thenRotatedArrayIs(new int[] {9, 1, 2, 3, 4, 5, 6, 7, 8});

        whenArrayIs(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        whenNumberOfStepsIs(1);
        thenRotatedArrayIs(new int[] {9, 1, 2, 3, 4, 5, 6, 7, 8});

        whenArrayIs(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        whenNumberOfStepsIs(9);
        thenRotatedArrayIs(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    private void thenRotatedArrayIs(int[] rotatedArray) {
        assertThat(Solution.rotateArrayRight(input, numberOfSteps)).containsExactly(rotatedArray);
    }

    private void whenNumberOfStepsIs(int steps) {
        numberOfSteps = steps;
    }

    @Test
    public void should_rotate_array_left_given_number_of_steps() {

    }

    private static class Solution {
        static int[] rotateArrayRight(int[] array, int steps) {
            return rotateArray(array, steps, (oldI, length, numSteps) -> (oldI + numSteps) % length);
        }

        static int[] rotateArrayLeft(int[] array, int steps) {
            return rotateArray(array, steps, (oldI, length, numSteps) -> (oldI + length - numSteps) % length);
        }

        static int[] rotateArray(int[] array, int steps, IndexComputer computer) {
            if (array.length <= 1) {
                return array;
            }

            int [] rotated = new int[array.length];

            for(int oldIndex = 0; oldIndex < array.length; oldIndex++) {
                int newIndex = computer.computeIndex(oldIndex, array.length, steps);
                rotated[newIndex] = array[oldIndex];
            }
            return rotated;
        }
    }

    @FunctionalInterface
    interface IndexComputer {
        int computeIndex(int oldIndex, int arrayLength, int steps);
    }
}
