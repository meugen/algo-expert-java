package com.algo.expert.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.algo.expert.dynamicprogreamming.LevenshteinDistance;

public class LevenshteinDistanceTest {

    private void internalTestCaseSolution(LevenshteinDistance solution, String str1, String str2, int expected) {
        int result = solution.levenshteinDistance(str1, str2);
        assertEquals(expected, result);
    }
    
    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution(String str1, String str2, int expected) {
        internalTestCaseSolution(new LevenshteinDistance.Solution1(), str1, str2, expected);
    }

    static List<Arguments> params() {
        return List.of(
            Arguments.of("abc",  "yabd", 2),
            Arguments.of("", "", 0),
            Arguments.of("", "abc", 3),
            Arguments.of("abc", "abc", 0),
            Arguments.of("abc", "abx", 1),
            Arguments.of("abc", "yabcx", 2),
            Arguments.of("algoexpert", "algozexpert", 1),
            Arguments.of("abcdefghij", "1234567890", 10),
            Arguments.of("abcdefghij", "a234567890", 9),
            Arguments.of("biting", "mitten", 4),
            Arguments.of("cereal", "saturday", 6),
            Arguments.of("cereal", "saturdzz", 7),
            Arguments.of("abbbbbbbbb", "bbbbbbbbba", 2),
            Arguments.of("xabc", "abcx", 2),
            Arguments.of("table", "bal", 4),
            Arguments.of("gumbo", "gambol", 2)
        );
    }
}
