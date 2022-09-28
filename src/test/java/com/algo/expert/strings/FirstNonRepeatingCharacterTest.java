package com.algo.expert.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class FirstNonRepeatingCharacterTest {

    private void internalTestCases(FirstNonRepeatingCharacter impl, String string, int expected) {
        int result = impl.firstNonRepeatingCharacter(string);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCases(String string, int expected) {
        internalTestCases(new FirstNonRepeatingCharacter.Solution1(), string, expected);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of("abcdcaf", 1),
                Arguments.of("faadabcbbebdf", 6),
                Arguments.of("a", 0),
                Arguments.of("ab", 0),
                Arguments.of("abc", 0),
                Arguments.of("abac", 1),
                Arguments.of("ababac", 5),
                Arguments.of("ababacc", -1),
                Arguments.of("lmnopqldsafmnopqsa", 7),
                Arguments.of("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxy", 25),
                Arguments.of("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz", -1),
                Arguments.of("", -1),
                Arguments.of("ggyllaylacrhdzedddjsc", 10),
                Arguments.of("aaaaaaaaaaaaaaaaaaaabbbbbbbbbbcccccccccccdddddddddddeeeeeeeeffghgh", -1),
                Arguments.of("aabbccddeeff", -1)
        );
    }
}
