package com.algo.expert.dynamicprogramming;

import com.algo.expert.dynamicprogreamming.MaxSubsetSumNoAdjacent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class MaxSubsetSumNoAdjacentTest {

    private static void internalTestCases(MaxSubsetSumNoAdjacent impl, int[] array, int expected) {
        int result = impl.maxSubsetSumNoAdjacent(array);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCasesSolution1(int[] array, int expected) {
        internalTestCases(new MaxSubsetSumNoAdjacent.Solution1(), array, expected);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(new int[] {75, 105, 120, 75, 90, 135}, 330),
                Arguments.of(new int[] {}, 0),
                Arguments.of(new int[] {1}, 1),
                Arguments.of(new int[] {1, 2}, 2),
                Arguments.of(new int[] {1, 2, 3}, 4),
                Arguments.of(new int[] {1, 15, 3}, 15),
                Arguments.of(new int[] {7, 10, 12, 7, 9, 14}, 33),
                Arguments.of(new int[] {4, 3, 5, 200, 5, 3}, 207),
                Arguments.of(new int[] {10, 5, 20, 25, 15, 5, 5, 15}, 60),
                Arguments.of(new int[] {10, 5, 20, 25, 15, 5, 5, 15, 3, 15, 5, 5, 15}, 90),
                Arguments.of(new int[] {125, 210, 250, 120, 150, 300}, 675),
                Arguments.of(new int[] {30, 25, 50, 55, 100}, 180),
                Arguments.of(new int[] {30, 25, 50, 55, 100, 120}, 205),
                Arguments.of(new int[] {7, 10, 12, 7, 9, 14, 15, 16, 25, 20, 4}, 72)
        );
    }
}
