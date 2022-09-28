package com.algo.expert.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class PalindromeCheckTest {

    private void internalTestCases(PalindromeCheck impl, String str, boolean expected) {
        boolean result = impl.isPalindrome(str);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCases(String str, boolean expected) {
        internalTestCases(new PalindromeCheck.Solution1(), str, expected);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of("abcdcba", true),
                Arguments.of("a", true),
                Arguments.of("ab", false),
                Arguments.of("aba", true),
                Arguments.of("abb", false),
                Arguments.of("abba", true),
                Arguments.of("abcdefghhgfedcba", true),
                Arguments.of("abcdefghihgfedcba", true),
                Arguments.of("abcdefghihgfeddcba", false)
        );
    }
}
