package com.algo.expert.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class NonConstructibleChangeTest {

    private void internalTestCases(NonConstructibleChange impl, int[] coins, int expected) {
        int result = impl.nonConstructibleChange(coins);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCasesSolution1(int[] coins, int expected) {
        internalTestCases(new NonConstructibleChange.Solution1(), coins, expected);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(new int[] {5, 7, 1, 1, 2, 3, 22}, 20),
                Arguments.of(new int[] {1, 1, 1, 1, 1}, 6),
                Arguments.of(new int[] {1, 5, 1, 1, 1, 10, 15, 20, 100}, 55),
                Arguments.of(new int[] {6, 4, 5, 1, 1, 8, 9}, 3),
                Arguments.of(new int[] {}, 1),
                Arguments.of(new int[] {87}, 1),
                Arguments.of(new int[] {5, 6, 1, 1, 2, 3, 4, 9}, 32),
                Arguments.of(new int[] {5, 6, 1, 1, 2, 3, 43}, 19),
                Arguments.of(new int[] {1, 1}, 3),
                Arguments.of(new int[] {2}, 1),
                Arguments.of(new int[] {1}, 2),
                Arguments.of(new int[] {109, 2000, 8765, 19, 18, 17, 16, 8, 1, 1, 2, 4}, 87),
                Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7}, 29)
        );
    }
}
