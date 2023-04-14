package com.algo.expert.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class MinRewardsTest {

    @ParameterizedTest
    @MethodSource("params")
    void testCasesSolution1(int[] scores, int expected) {
        implTestCases(new MinRewards.Solution1(), scores, expected);
    }

    private void implTestCases(MinRewards impl, int[] scores, int expected) {
        int result = impl.minRewards(scores);
        Assertions.assertEquals(expected, result);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(new int[] {8, 4, 2, 1, 3, 6, 7, 9, 5}, 25),
                Arguments.of(new int[] {1}, 1),
                Arguments.of(new int[] {5, 10}, 3),
                Arguments.of(new int[] {10, 5}, 3),
                Arguments.of(new int[] {4, 2, 1, 3}, 8),
                Arguments.of(new int[] {0, 4, 2, 1, 3}, 9),
                Arguments.of(new int[] {2, 20, 13, 12, 11, 8, 4, 3, 1, 5, 6, 7, 9, 0}, 52),
                Arguments.of(new int[] {2, 1, 4, 3, 6, 5, 8, 7, 10, 9}, 15),
                Arguments.of(new int[] {800, 400, 20, 10, 30, 61, 70, 90, 17, 21, 22, 13, 12, 11, 8, 4, 2, 1, 3, 6, 7, 9, 0, 68, 55, 67, 57, 60, 51, 661, 50, 65, 53}, 93)
        );
    }
}
