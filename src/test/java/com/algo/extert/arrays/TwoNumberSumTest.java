package com.algo.extert.arrays;

import com.algo.expert.arrays.TwoNumberSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

public class TwoNumberSumTest {

    @ParameterizedTest
    @MethodSource("params")
    void testCases(int[] array, int targetSum, int[] answer) {
        int[] result = TwoNumberSum.twoNumberSum(array, targetSum);
        Assertions.assertTrue(Arrays.equals(result, answer) ||
                (result.length == 2 && result[0] + result[1] == targetSum));
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10, new int[] {11, -1}),
                Arguments.of(new int[] {4, 6}, 10, new int[] {4, 6}),
                Arguments.of(new int[] {4, 6, 1}, 5, new int[] {4, 1}),
                Arguments.of(new int[] {4, 6, 1, -3}, 3, new int[] {6, -3}),
                Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 17, new int[] {8, 9}),
                Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 15}, 18, new int[] {3, 15}),
                Arguments.of(new int[] {-7, -5, -3, -1, 0, 1, 3, 5, 7}, -5, new int[] {-5, 0}),
                Arguments.of(new int[] {-21, 301, 12, 4, 65, 56, 210, 356, 9, -47}, 163, new int[] {210, -47}),
                Arguments.of(new int[] {-21, 301, 12, 4, 65, 56, 210, 356, 9, -47}, 164, new int[] {}),
                Arguments.of(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 15, new int[] {}),
                Arguments.of(new int[] {14}, 15, new int[] {}),
                Arguments.of(new int[] {15}, 15, new int[] {})
        );
    }
}
