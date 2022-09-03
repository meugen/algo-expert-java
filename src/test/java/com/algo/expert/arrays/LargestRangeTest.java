package com.algo.expert.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class LargestRangeTest {

    @ParameterizedTest
    @MethodSource("params")
    void testCases(int[] array, int[] expected) {
        implTestCases(new LargestRange.Solution1(), array, expected);
        implTestCases(new LargestRange.Solution2(), array, expected);
        implTestCases(new LargestRange.Solution3(), array, expected);
    }

    private void implTestCases(LargestRange impl, int[] array, int[] expected) {
        int[] result = impl.largestRange(array);
        Assertions.assertArrayEquals(expected, result);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(new int[] {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6}, new int[] {0, 7}),
                Arguments.of(new int[] {1}, new int[] {1, 1}),
                Arguments.of(new int[] {1, 2}, new int[] {1, 2}),
                Arguments.of(new int[] {4, 2, 1, 3}, new int[] {1, 4}),
                Arguments.of(new int[] {4, 2, 1, 3, 6}, new int[] {1, 4}),
                Arguments.of(new int[] {8, 4, 2, 10, 3, 6, 7, 9, 1}, new int[] {6, 10}),
                Arguments.of(new int[] {19, -1, 18, 17, 2, 10, 3, 12, 5, 16, 4, 11, 8, 7, 6, 15, 12, 12, 2, 1, 6, 13, 14}, new int[] {10, 19}),
                Arguments.of(new int[] {0, 9, 19, -1, 18, 17, 2, 10, 3, 12, 5, 16, 4, 11, 8, 7, 6, 15, 12, 12, 2, 1, 6, 13, 14}, new int[] {-1, 19}),
                Arguments.of(new int[] {0, -5, 9, 19, -1, 18, 17, 2, -4, -3, 10, 3, 12, 5, 16, 4, 11, 7, -6, -7, 6, 15, 12, 12, 2, 1, 6, 13, 14, -2}, new int[] {-7, 7}),
                Arguments.of(new int[] {-7, -7, -7, -7, 8, -8, 0, 9, 19, -1, -3, 18, 17, 2, 10, 3, 12, 5, 16, 4, 11, -6, 8, 7, 6, 15, 12, 12, -5, 2, 1, 6, 13, 14, -4, -2}, new int[] {-8, 19}),
                Arguments.of(new int[] {1, 1, 1, 3, 4}, new int[] {3, 4}),
                Arguments.of(new int[] {-1, 0, 1}, new int[] {-1, 1}),
                Arguments.of(new int[] {10, 0, 1}, new int[] {0, 1})
        );
    }
}
