package com.algo.expert.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class LongestPeakTest {

    @ParameterizedTest
    @MethodSource("params")
    void testCases(int[] array, int expected) {
        int result = LongestPeak.longestPeak(array);
        Assertions.assertEquals(expected, result);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(new int[] {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3}, 6),
                Arguments.of(new int[0], 0),
                Arguments.of(new int[] {1, 3, 2}, 3),
                Arguments.of(new int[] {1, 2, 3, 4, 5, 1}, 6),
                Arguments.of(new int[] {5, 4, 3, 2, 1, 2, 1}, 3),
                Arguments.of(new int[] {5, 4, 3, 2, 1, 2, 10, 12, -3, 5, 6, 7, 10}, 5),
                Arguments.of(new int[] {5, 4, 3, 2, 1, 2, 10, 12}, 0),
                Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 10, 100, 1000}, 0),
                Arguments.of(new int[] {1, 2, 3, 3, 2, 1}, 0),
                Arguments.of(new int[] {1, 1, 3, 2, 1}, 4),
                Arguments.of(new int[] {1, 2, 3, 2, 1, 1}, 5),
                Arguments.of(new int[] {1, 1, 1, 2, 3, 10, 12, -3, -3, 2, 3, 45, 800, 99, 98, 0, -1, -1, 2, 3, 4, 5, 0, -1, -1}, 9),
                Arguments.of(new int[] {1, 2, 3, 3, 4, 0, 10}, 3)
        );
    }
}
