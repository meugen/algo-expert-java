package com.algo.expert.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class ArrayOfProductsTest {

    @ParameterizedTest
    @MethodSource("params")
    void testCases(int[] array, int[] expected) {
        int[] result = ArrayOfProducts.arrayOfProducts(array);
        Assertions.assertArrayEquals(expected, result);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(new int[] {5, 1, 4, 2}, new int[] {8, 40, 10, 20}),
                Arguments.of(new int[] {1, 8, 6, 2, 4}, new int[] {384, 48, 64, 192, 96}),
                Arguments.of(new int[] {-5, 2, -4, 14, -6}, new int[] {672, -1680, 840, -240, 560}),
                Arguments.of(new int[] {9, 3, 2, 1, 9, 5, 3, 2}, new int[] {1620, 4860, 7290, 14580, 1620, 2916, 4860, 7290}),
                Arguments.of(new int[] {4, 4}, new int[] {4, 4}),
                Arguments.of(new int[] {0, 0, 0, 0}, new int[] {0, 0, 0, 0}),
                Arguments.of(new int[] {1, 1, 1, 1}, new int[] {1, 1, 1, 1}),
                Arguments.of(new int[] {-1, -1, -1}, new int[] {1, 1, 1}),
                Arguments.of(new int[] {-1, -1, -1, -1}, new int[] {-1, -1, -1, -1}),
                Arguments.of(new int[] {0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}),
                Arguments.of(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[] {362880, 0, 0, 0, 0, 0, 0, 0, 0, 0})
        );
    }
}
