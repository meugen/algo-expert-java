package com.algo.expert.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class RunLengthEncodingTest {

    @ParameterizedTest
    @MethodSource("params")
    void testCases(String string, String expected) {
        String result = RunLengthEncoding.runLengthEncoding(string);
        Assertions.assertEquals(expected, result);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of("AAAAAAAAAAAAABBCCCCDD", "9A4A2B4C2D"),
                Arguments.of("aA", "1a1A"),
                Arguments.of("122333", "112233"),
                Arguments.of("************^^^^^^^$$$$$$%%%%%%%!!!!!!AAAAAAAAAAAAAAAAAAAA", "9*3*7^6$7%6!9A9A2A"),
                Arguments.of("aAaAaaaaaAaaaAAAABbbbBBBB", "1a1A1a1A5a1A3a4A1B3b4B"),
                Arguments.of("                          ", "9 9 8 "),
                Arguments.of("1  222 333    444  555", "112 321 334 342 35"),
                Arguments.of("1A2BB3CCC4DDDD", "111A122B133C144D"),
                Arguments.of("........______=========AAAA   AAABBBB   BBB", "8.6_9=4A3 3A4B3 3B"),
                Arguments.of("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "9a9a9a9a9a9a9a9a9a9a9a9a9a9a9a9a9a9a9a9a9a9a9a1a"),
                Arguments.of("        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "8 9a9a9a9a9a4a"),
                Arguments.of(" ", "1 "),
                Arguments.of("[(aaaaaaa,bbbbbbb,ccccc,dddddd)]", "1[1(7a1,7b1,5c1,6d1)1]"),
                Arguments.of(";;;;;;;;;;;;''''''''''''''''''''1233333332222211112222111s", "9;3;9'9'2'111273524142311s"),
                Arguments.of("AAAAAAAAAAAAABBCCCCDDDDDDDDDDD", "9A4A2B4C9D2D")
        );
    }
}
