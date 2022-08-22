package com.algo.expert.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class ThreeNumberSumTest {

    @ParameterizedTest
    @MethodSource("params")
    void testCases(int[] array, int targetSum, List<Integer[]> expected) {
        List<Integer[]> result = ThreeNumberSum.threeNumberSum(array, targetSum);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i=0; i<result.size(); i++) {
            Assertions.assertArrayEquals(expected.get(i), result.get(i));
        }
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0, List.of(
                        new Integer[] {-8, 2, 6}, new Integer[] {-8, 3, 5}, new Integer[] {-6, 1, 5}
                )),
                Arguments.of(new int[] {1, 2, 3}, 6, List.<Integer[]>of(
                        new Integer[] {1, 2, 3}
                )),
                Arguments.of(new int[] {1, 2, 3}, 7, List.of()),
                Arguments.of(new int[] {8, 10, -2, 49, 14}, 57, List.<Integer[]>of(
                        new Integer[] {-2, 10, 49}
                )),
                Arguments.of(new int[] {12, 3, 1, 2, -6, 5, 0, -8, -1}, 0, List.of(
                        new Integer[] {-8, 3, 5}, new Integer[] {-6, 1, 5}, new Integer[] {-1, 0, 1}
                )),
                Arguments.of(new int[] {12, 3, 1, 2, -6, 5, 0, -8, -1, 6}, 0, List.of(
                        new Integer[] {-8, 2, 6}, new Integer[] {-8, 3, 5}, new Integer[] {-6, 0, 6},
                        new Integer[] {-6, 1, 5}, new Integer[] {-1, 0, 1}
                )),
                Arguments.of(new int[] {12, 3, 1, 2, -6, 5, 0, -8, -1, 6, -5}, 0, List.of(
                        new Integer[] {-8, 2, 6}, new Integer[] {-8, 3, 5}, new Integer[] {-6, 0, 6},
                        new Integer[] {-6, 1, 5}, new Integer[] {-5, -1, 6}, new Integer[] {-5, 0, 5},
                        new Integer[] {-5, 2, 3}, new Integer[] {-1, 0, 1}
                )),
                Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 15}, 18, List.of(
                        new Integer[] {1, 2, 15}, new Integer[] {1, 8, 9}, new Integer[] {2, 7, 9},
                        new Integer[] {3, 6, 9}, new Integer[] {3, 7, 8}, new Integer[] {4, 5, 9},
                        new Integer[] {4, 6, 8}, new Integer[] {5, 6, 7}
                )),
                Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 15}, 32, List.<Integer[]>of(
                        new Integer[] {8, 9, 15}
                )),
                Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 15}, 33, List.of()),
                Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 15}, 5, List.of())
        );
    }
}
