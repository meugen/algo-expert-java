package com.algo.expert.recurtion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class NthFibonacciTest {

    private void internalTestCases(NthFibonacci impl, int n, int expected) {
        int result = impl.getNthFib(n);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCasesSolution1(int n, int expected) {
        internalTestCases(new NthFibonacci.Solution1(), n, expected);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCasesSolution2(int n, int expected) {
        internalTestCases(new NthFibonacci.Solution2(), n, expected);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCasesSolution3(int n, int expected) {
        internalTestCases(new NthFibonacci.Solution3(), n, expected);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(6, 5),
                Arguments.of(1, 0),
                Arguments.of(2, 1),
                Arguments.of(3, 1),
                Arguments.of(4, 2),
                Arguments.of(5, 3),
                Arguments.of(7, 8),
                Arguments.of(8, 13),
                Arguments.of(9, 21),
                Arguments.of(10, 34),
                Arguments.of(11, 55),
                Arguments.of(12, 89),
                Arguments.of(13, 144),
                Arguments.of(14, 233),
                Arguments.of(15, 377),
                Arguments.of(16, 610),
                Arguments.of(17, 987),
                Arguments.of(18, 1597)
        );
    }
}
