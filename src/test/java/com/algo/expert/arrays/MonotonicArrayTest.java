package com.algo.expert.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class MonotonicArrayTest {

    private void internalTestCases(MonotonicArray impl, int[] array, boolean expected) {
        boolean result = impl.isMonotonic(array);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCasesSolution1(int[] array, boolean expected) {
        internalTestCases(new MonotonicArray.Solution1(), array, expected);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(new int[] {-1, -5, -10, -1100, -1100, -1101, -1102, -9001}, true),
                Arguments.of(new int[0], true),
                Arguments.of(new int[] {1}, true),
                Arguments.of(new int[] {1, 2}, true),
                Arguments.of(new int[] {2, 1}, true),
                Arguments.of(new int[] {1, 5, 10, 1100, 1101, 1102, 9001}, true),
                Arguments.of(new int[] {-1, -5, -10, -1100, -1101, -1102, -9001}, true),
                Arguments.of(new int[] {-1, -5, -10, -1100, -900, -1101, -1102, -9001}, false),
                Arguments.of(new int[] {1, 2, 0}, false),
                Arguments.of(new int[] {1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 7, 9, 10, 11}, false),
                Arguments.of(new int[] {1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 11}, true),
                Arguments.of(new int[] {-1, -1, -2, -3, -4, -5, -5, -5, -6, -7, -8, -7, -9, -10, -11}, false),
                Arguments.of(new int[] {-1, -1, -2, -3, -4, -5, -5, -5, -6, -7, -8, -8, -9, -10, -11}, true),
                Arguments.of(new int[] {-1, -1, -1, -1, -1, -1, -1, -1}, true),
                Arguments.of(new int[] {1, 2, -1, -2, -5}, false),
                Arguments.of(new int[] {-1, -5, 10}, false),
                Arguments.of(new int[] {2, 2, 2, 1, 4, 5}, false),
                Arguments.of(new int[] {1, 1, 1, 2, 3, 4, 1}, false),
                Arguments.of(new int[] {1, 2, 3, 3, 2, 1}, false)
        );
    }
}
