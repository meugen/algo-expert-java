package com.algo.expert.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class ValidateSubsequenceTest {

    @ParameterizedTest
    @MethodSource("params")
    void testCases(List<Integer> array, List<Integer> sequence, boolean expected) {
        boolean result = ValidateSubsequence.isValidSubsequence(array, sequence);
        Assertions.assertEquals(expected, result);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(1, 6, -1, 10), true),
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(5, 1, 22, 25, 6, -1, 8, 10), true),
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(5, 1, 22, 6, -1, 8, 10), true),
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(22, 25, 6), true),
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(1, 6, 10), true),
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(5, 1, 22, 10), true),
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(5, -1, 8, 10), true),
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(25), true),
                Arguments.of(List.of(1, 1, 1, 1, 1), List.of(1, 1, 1), true),
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(5, 1, 22, 25, 6, -1, 8, 10, 12), false),
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(4, 5, 1, 22, 25, 6, -1, 8, 10), false),
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(5, 1, 22, 23, 6, -1, 8, 10), false),
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(5, 1, 22, 22, 25, 6, -1, 8, 10), false),
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(5, 1, 22, 22, 6, -1, 8, 10), false),
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(1, 6, -1, -1), false),
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(1, 6, -1, -1, 10), false),
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(1, 6, -1, -2), false),
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(26), false),
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(5, 1, 25, 22, 6, -1, 8, 10), false),
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(5, 26, 22, 8), false),
                Arguments.of(List.of(1, 1, 6, 1), List.of(1, 1, 1, 6), false),
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(1, 6, -1, 10, 11, 11, 11, 11), false),
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(5, 1, 22, 25, 6, -1, 8, 10, 10), false),
                Arguments.of(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(1, 6, -1, 5), false)
        );
    }
}
