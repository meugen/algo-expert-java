package com.algo.expert.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class SortedSquaredArrayTest {

    private void internalTestCases(SortedSquaredArray impl, int[] array, int[] expected) {
        int[] result = impl.sortedSquaredArray(array);
        Assertions.assertArrayEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCasesSolution1(int[] array, int[] expected) {
        internalTestCases(new SortedSquaredArray.Solution1(), array, expected);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(new int[] {1, 2, 3, 5, 6, 8, 9}, new int[] {1, 4, 9, 25, 36, 64, 81}),
                Arguments.of(new int[] {1}, new int[] {1}),
                Arguments.of(new int[] {1, 2}, new int[] {1, 4}),
                Arguments.of(new int[] {1, 2, 3, 4, 5}, new int[] {1, 4, 9, 16, 25}),
                Arguments.of(new int[] {0}, new int[] {0}),
                Arguments.of(new int[] {10}, new int[] {100}),
                Arguments.of(new int[] {-1}, new int[] {1}),
                Arguments.of(new int[] {-2, -1}, new int[] {1, 4}),
                Arguments.of(new int[] {-5, -4, -3, -2, -1}, new int[] {1, 4, 9, 16, 25}),
                Arguments.of(new int[] {-10}, new int[] {100}),
                Arguments.of(new int[] {-10, -5, 0, 5, 10}, new int[] {0, 25, 25, 100, 100}),
                Arguments.of(new int[] {-7, -3, 1, 9, 22, 30}, new int[] {1, 9, 49, 81, 484, 900}),
                Arguments.of(new int[] {-50, -13, -2, -1, 0, 0, 1, 1, 2, 3, 19, 20}, new int[] {0, 0, 1, 1, 1, 4, 4, 9, 169, 361, 400, 2500}),
                Arguments.of(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}),
                Arguments.of(new int[] {-1, -1, 2, 3, 3, 3, 4}, new int[] {1, 1, 4, 9, 9, 9, 16}),
                Arguments.of(new int[] {-3, -2, -1}, new int[] {1, 4, 9})
        );
    }
}
