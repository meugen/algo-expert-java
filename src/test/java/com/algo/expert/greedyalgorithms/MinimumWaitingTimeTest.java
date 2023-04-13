package com.algo.expert.greedyalgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class MinimumWaitingTimeTest {

    private void internalTestCases(MinimumWaitingTime impl, int[] queries, int expected) {
        int result = impl.minimumWaitingTime(queries);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCasesSolution1(int[] queries, int expected) {
        internalTestCases(new MinimumWaitingTime.Solution1(), queries, expected);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(new int[] {3, 2, 1, 2, 6}, 17),
                Arguments.of(new int[] {2, 1, 1, 1}, 6),
                Arguments.of(new int[] {1, 2, 4, 5, 2, 1}, 23),
                Arguments.of(new int[] {25, 30, 2, 1}, 32),
                Arguments.of(new int[] {1, 1, 1, 1, 1}, 10),
                Arguments.of(new int[] {7, 9, 2, 3}, 19),
                Arguments.of(new int[] {4, 3, 1, 1, 3, 2, 1, 8}, 45),
                Arguments.of(new int[] {2}, 0),
                Arguments.of(new int[] {7}, 0),
                Arguments.of(new int[] {8, 9}, 8),
                Arguments.of(new int[] {1, 9}, 1),
                Arguments.of(new int[] {5, 4, 3, 2, 1}, 20),
                Arguments.of(new int[] {1, 2, 3, 4, 5}, 20),
                Arguments.of(new int[] {1, 1, 1, 4, 5, 6, 8, 1, 1, 2, 1}, 81),
                Arguments.of(new int[] {17, 4, 3}, 10)
        );
    }
}
