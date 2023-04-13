package com.algo.expert.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class FirstDuplicateValueTest {

    private void internalTestCases(FirstDuplicateValue impl, int[] array, int expected) {
        int result = impl.firstDuplicateValue(array);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCasesSolution1(int[] array, int expected) {
        internalTestCases(new FirstDuplicateValue.Solution1(), array, expected);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(new int[] {2, 1, 5, 2, 3, 3, 4}, 2),
                Arguments.of(new int[] {2, 1, 5, 3, 3, 2, 4}, 3),
                Arguments.of(new int[] {1, 1, 2, 3, 3, 2, 2}, 1),
                Arguments.of(new int[] {3, 1, 3, 1, 1, 4, 4}, 3),
                Arguments.of(new int[0], -1),
                Arguments.of(new int[] {1}, -1),
                Arguments.of(new int[] {1, 1}, 1),
                Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10}, 10),
                Arguments.of(new int[] {2, 1, 1}, 1),
                Arguments.of(new int[] {2, 2, 2, 2, 2, 2, 2, 2, 2}, 2),
                Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, -1),
                Arguments.of(new int[] {7, 6, 5, 3, 6, 4, 3, 5, 2}, 6),
                Arguments.of(new int[] {9, 13, 6, 2, 3, 5, 5, 5, 3, 2, 2, 2, 2, 4, 3}, 5),
                Arguments.of(new int[] {23, 21, 22, 5, 3, 13, 11, 16, 5, 11, 9, 14, 23, 3, 2, 2, 5, 11, 6, 11, 23, 8, 1}, 5),
                Arguments.of(new int[] {8, 20, 4, 12, 14, 9, 19, 17, 14, 20, 22, 9, 6, 15, 1, 15, 10, 9, 17, 7, 22, 17}, 14),
                Arguments.of(new int[] {3, 3, 2}, 3),
                Arguments.of(new int[] {6, 6, 5, 1, 3, 7, 7, 8}, 6),
                Arguments.of(new int[] {23, 25, 9, 26, 2, 19, 24, 18, 25, 17, 13, 3, 14, 17, 9, 20, 26, 15, 21, 2, 6, 11, 2, 12, 23, 5, 4, 20}, 25),
                Arguments.of(new int[] {12, 22, 6, 18, 5, 17, 18, 22, 22, 4, 6, 14, 12, 8, 5, 6, 10, 7, 13, 22, 17, 18}, 18),
                Arguments.of(new int[] {16, 6, 6, 18, 6, 13, 28, 9, 3, 26, 10, 2, 23, 5, 20, 21, 11, 20, 6, 11, 26, 20, 26, 25, 13, 3, 12, 4}, 6),
                Arguments.of(new int[] {15, 2, 6, 3, 3, 22, 14, 16, 6, 21, 4, 16, 2, 17, 9, 13, 1, 3, 5, 6, 1, 2, 23, 16, 16}, 3),
                Arguments.of(new int[] {4, 7, 9, 7, 1, 3, 2, 3, 1, 12, 12, 5}, 7),
                Arguments.of(new int[] {9, 21, 9, 22, 3, 23, 4, 26, 7, 11, 25, 25, 19, 13, 23, 28, 5, 23, 19, 13, 10, 26, 28, 9, 28, 16, 7, 13, 22}, 9),
                Arguments.of(new int[] {29, 3, 23, 16, 1, 22, 21, 14, 15, 21, 12, 27, 9, 12, 11, 3, 22, 5, 21, 24, 14, 26, 11, 5, 21, 25, 15, 19, 13, 4}, 21),
                Arguments.of(new int[] {13, 2, 8, 8, 10, 11, 13, 11, 9, 13, 4, 5, 7}, 8),
                Arguments.of(new int[] {4, 7, 7, 14, 14, 10, 15, 14, 14, 16, 14, 11, 5, 12, 17, 7, 1, 6, 13}, 7),
                Arguments.of(new int[] {2, 5, 1, 4, 1}, 1),
                Arguments.of(new int[] {11, 10, 5, 3, 1, 7, 10, 6, 10, 11, 7}, 10),
                Arguments.of(new int[] {2, 13, 3, 9, 1, 9, 1, 11, 11, 5, 3, 1, 9, 12}, 9),
                Arguments.of(new int[] {3, 3, 1, 1}, 3),
                Arguments.of(new int[] {26, 18, 21, 26, 26, 16, 16, 3, 19, 9, 10, 24, 21, 9, 8, 11, 17, 21, 18, 22, 17, 27, 6, 7, 6, 10, 4}, 26),
                Arguments.of(new int[] {27, 16, 15, 21, 10, 21, 3, 21, 5, 12, 27, 24, 20, 26, 5, 13, 26, 22, 26, 8, 23, 10, 14, 17, 7, 5, 3}, 21),
                Arguments.of(new int[] {11, 6, 1, 1, 4, 19, 10, 12, 19, 8, 12, 15, 26, 9, 6, 20, 17, 12, 26, 15, 25, 18, 26, 5, 3, 5, 16, 5}, 1),
                Arguments.of(new int[] {16, 22, 20, 22, 26, 19, 8, 17, 18, 24, 17, 19, 19, 11, 18, 13, 10, 20, 6, 23, 20, 19, 21, 6, 17, 7}, 22),
                Arguments.of(new int[] {11, 13, 6, 12, 4, 15, 4, 9, 3, 10, 5, 8, 15, 5, 8}, 4),
                Arguments.of(new int[] {7, 9, 5, 6, 4, 11, 2, 8, 2, 5, 1}, 2),
                Arguments.of(new int[] {8, 1, 5, 2, 9, 12, 9, 6, 9, 9, 5, 13, 5, 9}, 9),
                Arguments.of(new int[] {11, 5, 2, 7, 11, 11, 3, 11, 4, 2, 9}, 11),
                Arguments.of(new int[] {2, 22, 3, 20, 18, 8, 29, 25, 7, 12, 12, 17, 1, 28, 3, 6, 11, 2, 28, 16, 23, 27, 8, 28, 4, 29, 24, 12, 29}, 12),
                Arguments.of(new int[] {5, 1, 3, 5, 1}, 5),
                Arguments.of(new int[] {20, 12, 3, 18, 9, 16, 4, 18, 6, 19, 14, 23, 10, 13, 6, 1, 22, 11, 11, 16, 13, 15, 17, 19, 14, 12, 20}, 18),
                Arguments.of(new int[] {23, 15, 11, 5, 13, 11, 9, 9, 13, 8, 22, 12, 2, 24, 6, 2, 15, 24, 12, 9, 13, 13, 22, 18}, 11),
                Arguments.of(new int[] {4, 1, 5, 1, 4}, 1),
                Arguments.of(new int[] {7, 14, 4, 6, 17, 17, 3, 14, 1, 16, 18, 4, 12, 13, 8, 19, 1, 2, 4, 14}, 17),
                Arguments.of(new int[] {5, 6, 6, 4, 3, 5}, 6),
                Arguments.of(new int[] {3, 2, 3, 1}, 3),
                Arguments.of(new int[] {9, 12, 14, 6, 14, 2, 4, 9, 13, 2, 10, 5, 7, 1}, 14),
                Arguments.of(new int[] {9, 2, 11, 5, 6, 8, 10, 15, 5, 7, 11, 6, 19, 19, 14, 15, 3, 9, 16}, 5),
                Arguments.of(new int[] {2, 6, 1, 7, 1, 6, 6}, 1),
                Arguments.of(new int[] {6, 3, 1, 8, 2, 2, 1, 7, 10, 8, 6, 4}, 2),
                Arguments.of(new int[] {21, 17, 1, 8, 22, 8, 22, 8, 23, 3, 21, 5, 18, 2, 8, 21, 21, 22, 10, 24, 13, 4, 20, 24}, 8),
                Arguments.of(new int[] {16, 9, 13, 10, 18, 17, 11, 5, 11, 4, 2, 16, 15, 6, 3, 7, 15, 10, 1}, 11),
                Arguments.of(new int[] {5, 5, 5, 4, 6, 6, 2}, 5),
                Arguments.of(new int[] {5, 3, 8, 2, 9, 6, 8, 1, 6}, 8),
                Arguments.of(new int[] {5, 5, 1, 5, 3, 7, 4, 4}, 5),
                Arguments.of(new int[] {19, 4, 1, 6, 2, 5, 20, 13, 8, 6, 11, 12, 12, 12, 11, 18, 7, 13, 6, 10}, 6),
                Arguments.of(new int[] {3, 11, 11, 10, 11, 8, 8, 11, 10, 11, 10, 8, 10}, 11),
                Arguments.of(new int[] {15, 3, 15, 6, 13, 3, 12, 10, 17, 8, 13, 1, 12, 9, 14, 7, 16}, 15),
                Arguments.of(new int[] {2, 2, 2}, 2),
                Arguments.of(new int[] {11, 6, 8, 8, 8, 9, 10, 6, 4, 1, 10, 1, 6}, 8),
                Arguments.of(new int[] {2, 3, 16, 9, 11, 14, 13, 1, 10, 12, 5, 17, 4, 16, 10, 5, 4}, 16),
                Arguments.of(new int[] {13, 4, 10, 10, 8, 13, 13, 7, 11, 6, 3, 2, 11}, 10),
                Arguments.of(new int[] {6, 15, 7, 10, 9, 14, 10, 1, 10, 1, 2, 11, 1, 6, 8}, 10)
        );
    }
}
