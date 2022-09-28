package com.algo.expert.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class CaesarCipherEncryptorTest {

    private void internalTestCases(CaesarCipherEncryptor impl, String str, int key, String expected) {
        String result = impl.caesarCypherEncryptor(str, key);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCases(String str, int key, String expected) {
        internalTestCases(new CaesarCipherEncryptor.Solution1(), str, key, expected);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of("xyz", 2, "zab"),
                Arguments.of("abc", 0, "abc"),
                Arguments.of("abc", 3, "def"),
                Arguments.of("xyz", 5, "cde"),
                Arguments.of("abc", 26, "abc"),
                Arguments.of("abc", 52, "abc"),
                Arguments.of("abc", 57, "fgh"),
                Arguments.of("xyz", 25, "wxy"),
                Arguments.of("iwufqnkqkqoolxzzlzihqfm", 25, "hvtepmjpjpnnkwyykyhgpel"),
                Arguments.of("ovmqkwtujqmfkao", 52, "ovmqkwtujqmfkao"),
                Arguments.of("mvklahvjcnbwqvtutmfafkwiuagjkzmzwgf", 7, "tcrshocqjuidxcabatmhmrdpbhnqrgtgdnm"),
                Arguments.of("kjwmntauvjjnmsagwgawkagfuaugjhawgnawgjhawjgawbfawghesh", 15, "zylbcipjkyycbhpvlvplzpvujpjvywplvcplvywplyvplquplvwthw")
        );
    }
}
