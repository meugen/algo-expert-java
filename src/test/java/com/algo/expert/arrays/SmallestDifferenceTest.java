package com.algo.expert.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class SmallestDifferenceTest {

    private void internalTestCases(SmallestDifference impl, int[] arrayOne, int[] arrayTwo, int[] expected) {
        int[] result = impl.smallestDifference(arrayOne, arrayTwo);
        Assertions.assertArrayEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCases(int[] arrayOne, int[] arrayTwo, int[] expected) {
        internalTestCases(new SmallestDifference.Solution1(), arrayOne, arrayTwo, expected);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(new int[] {-1, 5, 10, 20, 28, 3}, new int[] {26, 134, 135, 15, 17}, new int[] {28, 26}),
                Arguments.of(new int[] {-1, 5, 10, 20, 3}, new int[] {26, 134, 135, 15, 17}, new int[] {20, 17}),
                Arguments.of(new int[] {10, 0, 20, 25}, new int[] {1005, 1006, 1014, 1032, 1031}, new int[] {25, 1005}),
                Arguments.of(new int[] {10, 0, 20, 25, 2200}, new int[] {1005, 1006, 1014, 1032, 1031}, new int[] {25, 1005}),
                Arguments.of(new int[] {10, 0, 20, 25, 2000}, new int[] {1005, 1006, 1014, 1032, 1031}, new int[] {2000, 1032}),
                Arguments.of(new int[] {240, 124, 86, 111, 2, 84, 954, 27, 89}, new int[] {1, 3, 954, 19, 8}, new int[] {954, 954}),
                Arguments.of(new int[] {0, 20}, new int[] {21, -2}, new int[] {20, 21}),
                Arguments.of(new int[] {10, 1000}, new int[] {-1441, -124, -25, 1014, 1500, 660, 410, 245, 530}, new int[] {1000, 1014}),
                Arguments.of(new int[] {10, 1000, 9124, 2142, 59, 24, 596, 591, 124, -123}, new int[] {-1441, -124, -25, 1014, 1500, 660, 410, 245, 530}, new int[] {-123, -124}),
                Arguments.of(new int[] {10, 1000, 9124, 2142, 59, 24, 596, 591, 124, -123, 530}, new int[] {-1441, -124, -25, 1014, 1500, 660, 410, 245, 530}, new int[] {530, 530})
        );
    }
}
