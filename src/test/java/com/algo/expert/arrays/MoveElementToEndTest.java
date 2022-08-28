package com.algo.expert.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class MoveElementToEndTest {

    @ParameterizedTest
    @MethodSource("params")
    void testCases(List<Integer> array, int toMove) {
        List<Integer> result = MoveElementToEnd.moveElementToEnd(array, toMove);
        int count = 0;
        for (Integer item : array) {
            if (Objects.equals(item, toMove)) count++;
        }
        ListIterator<Integer> iterator = result.listIterator(result.size());
        while (count > 0) {
            Integer item = iterator.previous();
            Assertions.assertEquals(toMove, item);
            count--;
        }
        while (iterator.hasPrevious()) {
            Integer item = iterator.previous();
            Assertions.assertNotEquals(toMove, item);
        }
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(List.of(2, 1, 2, 2, 2, 3, 4, 2), 2),
                Arguments.of(List.of(), 3),
                Arguments.of(List.of(1, 2, 4, 5, 6), 3),
                Arguments.of(List.of(3, 3, 3, 3, 3), 3),
                Arguments.of(List.of(1, 2, 4, 5, 3), 3),
                Arguments.of(List.of(1, 2, 3, 4, 5), 3),
                Arguments.of(List.of(2, 4, 2, 5, 6, 2, 2), 2),
                Arguments.of(List.of(5, 5, 5, 5, 5, 5, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12), 5),
                Arguments.of(List.of(1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 5, 5, 5, 5, 5, 5), 5),
                Arguments.of(List.of(5, 1, 2, 5, 5, 3, 4, 6, 7, 5, 8, 9, 10, 11, 5, 5, 12), 5)
        );
    }
}
