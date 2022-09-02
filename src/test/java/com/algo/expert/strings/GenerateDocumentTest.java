package com.algo.expert.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class GenerateDocumentTest {

    @ParameterizedTest
    @MethodSource("params")
    void testCases(String characters, String document, boolean expected) {
        boolean result = GenerateDocument.generateDocument(characters, document);
        Assertions.assertEquals(expected, result);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of("Bste!hetsi ogEAxpelrt x ", "AlgoExpert is the Best!", true),
                Arguments.of("A", "a", false),
                Arguments.of("a", "a", true),
                Arguments.of("a hsgalhsa sanbjksbdkjba kjx", "", true),
                Arguments.of(" ", "hello", false),
                Arguments.of("     ", "     ", true),
                Arguments.of("aheaollabbhb", "hello", true),
                Arguments.of("aheaolabbhb", "hello", false),
                Arguments.of("estssa", "testing", false),
                Arguments.of("Bste!hetsi ogEAxpert", "AlgoExpert is the Best!", false),
                Arguments.of("helloworld ", "hello wOrld", false),
                Arguments.of("helloworldO", "hello wOrld", false),
                Arguments.of("helloworldO ", "hello wOrld", true),
                Arguments.of("&*&you^a%^&8766 _=-09     docanCMakemthisdocument", "Can you make this document &", true),
                Arguments.of("abcabcabcacbcdaabc", "bacaccadac", true)
        );
    }
}
