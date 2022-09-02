package com.algo.expert.searching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class FindThreeLargestNumbersTest {

    @ParameterizedTest
    @MethodSource("params")
    void testCases(int[] array, int[] expected) {
        int[] result = FindThreeLargestNumbers.findThreeLargestNumbers(array);
        Assertions.assertArrayEquals(expected, result);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(new int[] {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7}, new int[] {18, 141, 541}),
                Arguments.of(new int[] {55, 7, 8}, new int[] {7, 8, 55}),
                Arguments.of(new int[] {55, 43, 11, 3, -3, 10}, new int[] {11, 43, 55}),
                Arguments.of(new int[] {7, 8, 3, 11, 43, 55}, new int[] {11, 43, 55}),
                Arguments.of(new int[] {55, 7, 8, 3, 43, 11}, new int[] {11, 43, 55}),
                Arguments.of(new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, new int[] {7, 7, 7}),
                Arguments.of(new int[] {7, 7, 7, 7, 7, 7, 8, 7, 7, 7, 7}, new int[] {7, 7, 8}),
                Arguments.of(new int[] {-1, -2, -3, -7, -17, -27, -18, -541, -8, -7, 7}, new int[] {-2, -1, 7})
        );
    }
}
