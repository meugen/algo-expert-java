package com.algo.expert.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class SubarraySortTest {

    @ParameterizedTest
    @MethodSource("params")
    void testCases(int[] array, int[] expected) {
        int[] result = SubarraySort.subarraySort(array);
        Assertions.assertArrayEquals(expected, result);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(new int[] {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19}, new int[] {3, 9}),
                Arguments.of(new int[] {1, 2}, new int[] {-1, -1}),
                Arguments.of(new int[] {2, 1}, new int[] {0, 1}),
                Arguments.of(new int[] {1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19}, new int[] {4, 9}),
                Arguments.of(new int[] {1, 2, 4, 7, 10, 11, 7, 12, 13, 14, 16, 18, 19}, new int[] {4, 6}),
                Arguments.of(new int[] {1, 2, 8, 4, 5}, new int[] {2, 4}),
                Arguments.of(new int[] {4, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 51, 7}, new int[] {0, 12}),
                Arguments.of(new int[] {4, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 11, 57}, new int[] {0, 11}),
                Arguments.of(new int[] {-41, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 11, 57}, new int[] {1, 11}),
                Arguments.of(new int[] {-41, 8, 7, 12, 11, 9, -1, 3, 9, 16, -15, 51, 7}, new int[] {1, 12}),
                Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 8, 7, 9, 10, 11}, new int[] {6, 7}),
                Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 18, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19}, new int[] {6, 16}),
                Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 18, 21, 22, 7, 14, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19, 4, 14, 11, 6, 33, 35, 41, 55}, new int[] {4, 24}),
                Arguments.of(new int[] {1, 2, 20, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, new int[] {2, 19}),
                Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2}, new int[] {2, 19}),
                Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, new int[] {-1, -1}),
                Arguments.of(new int[] {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89}, new int[] {-1, -1})
        );
    }
}
