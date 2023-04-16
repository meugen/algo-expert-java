package com.algo.expert.famousalgorithms;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class KadanesAlgorithmTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"array\": [3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]\n" +
            "}";
    private static final int EXPECTED1 = 19;

    private static final String TEST_CASE2 = "{\n" +
            "  \"array\": [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]\n" +
            "}";
    private static final int EXPECTED2 = 55;

    private static final String TEST_CASE3 = "{\n" +
            "  \"array\": [-1, -2, -3, -4, -5, -6, -7, -8, -9, -10]\n" +
            "}";
    private static final int EXPECTED3 = -1;

    private static final String TEST_CASE4 = "{\n" +
            "  \"array\": [-10, -2, -9, -4, -8, -6, -7, -1, -3, -5]\n" +
            "}";
    private static final int EXPECTED4 = -1;

    private static final String TEST_CASE5 = "{\n" +
            "  \"array\": [1, 2, 3, 4, 5, 6, -20, 7, 8, 9, 10]\n" +
            "}";
    private static final int EXPECTED5 = 35;

    private static final String TEST_CASE6 = "{\n" +
            "  \"array\": [1, 2, 3, 4, 5, 6, -22, 7, 8, 9, 10]\n" +
            "}";
    private static final int EXPECTED6 = 34;

    private static final String TEST_CASE7 = "{\n" +
            "  \"array\": [1, 2, -4, 3, 5, -9, 8, 1, 2]\n" +
            "}";
    private static final int EXPECTED7 = 11;

    private static final String TEST_CASE8 = "{\n" +
            "  \"array\": [3, 4, -6, 7, 8]\n" +
            "}";
    private static final int EXPECTED8 = 16;

    private static final String TEST_CASE9 = "{\n" +
            "  \"array\": [3, 4, -6, 7, 8, -18, 100]\n" +
            "}";
    private static final int EXPECTED9 = 100;

    private static final String TEST_CASE10 = "{\n" +
            "  \"array\": [3, 4, -6, 7, 8, -15, 100]\n" +
            "}";
    private static final int EXPECTED10 = 101;

    private static final String TEST_CASE11 = "{\n" +
            "  \"array\": [8, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]\n" +
            "}";
    private static final int EXPECTED11 = 23;

    private static final String TEST_CASE12 = "{\n" +
            "  \"array\": [8, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 6]\n" +
            "}";
    private static final int EXPECTED12 = 24;

    private static final String TEST_CASE13 = "{\n" +
            "  \"array\": [8, 5, -9, 1, 3, -2, 3, 4, 7, 2, -18, 6, 3, 1, -5, 6]\n" +
            "}";
    private static final int EXPECTED13 = 22;

    private static final String TEST_CASE14 = "{\n" +
            "  \"array\": [8, 5, -9, 1, 3, -2, 3, 4, 7, 2, -18, 6, 3, 1, -5, 6, 20, -23, 15, 1, -3, 4]\n" +
            "}";
    private static final int EXPECTED14 = 35;

    private static final String TEST_CASE15 = "{\n" +
            "  \"array\": [100, 8, 5, -9, 1, 3, -2, 3, 4, 7, 2, -18, 6, 3, 1, -5, 6, 20, -23, 15, 1, -3, 4]\n" +
            "}";
    private static final int EXPECTED15 = 135;

    private static final String TEST_CASE16 = "{\n" +
            "  \"array\": [-1000, -1000, 2, 4, -5, -6, -7, -8, -2, -100]\n" +
            "}";
    private static final int EXPECTED16 = 6;

    private static final String TEST_CASE17 = "{\n" +
            "  \"array\": [-2, -1]\n" +
            "}";
    private static final int EXPECTED17 = -1;

    private static final String TEST_CASE18 = "{\n" +
            "  \"array\": [-2, 1]\n" +
            "}";
    private static final int EXPECTED18 = 1;

    private static final String TEST_CASE19 = "{\n" +
            "  \"array\": [-10]\n" +
            "}";
    private static final int EXPECTED19 = -10;

    private static int[] parseArray(String json) {
        var object = new Gson().fromJson(json, JsonObject.class);
        var array = object.getAsJsonArray("array");

        var result = new int[array.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = array.get(i).getAsInt();
        }
        return result;
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(parseArray(TEST_CASE1), EXPECTED1),
                Arguments.of(parseArray(TEST_CASE2), EXPECTED2),
                Arguments.of(parseArray(TEST_CASE3), EXPECTED3),
                Arguments.of(parseArray(TEST_CASE4), EXPECTED4),
                Arguments.of(parseArray(TEST_CASE5), EXPECTED5),
                Arguments.of(parseArray(TEST_CASE6), EXPECTED6),
                Arguments.of(parseArray(TEST_CASE7), EXPECTED7),
                Arguments.of(parseArray(TEST_CASE8), EXPECTED8),
                Arguments.of(parseArray(TEST_CASE9), EXPECTED9),
                Arguments.of(parseArray(TEST_CASE10), EXPECTED10),
                Arguments.of(parseArray(TEST_CASE11), EXPECTED11),
                Arguments.of(parseArray(TEST_CASE12), EXPECTED12),
                Arguments.of(parseArray(TEST_CASE13), EXPECTED13),
                Arguments.of(parseArray(TEST_CASE14), EXPECTED14),
                Arguments.of(parseArray(TEST_CASE15), EXPECTED15),
                Arguments.of(parseArray(TEST_CASE16), EXPECTED16),
                Arguments.of(parseArray(TEST_CASE17), EXPECTED17),
                Arguments.of(parseArray(TEST_CASE18), EXPECTED18),
                Arguments.of(parseArray(TEST_CASE19), EXPECTED19)
        );
    }

    private static void internalTestCase(KadanesAlgorithm solution, int[] array, int expected) {
        var result = solution.kadanesAlgorithm(array);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution1(int[] array, int expected) {
        internalTestCase(new KadanesAlgorithm.Solution1(), array, expected);
    }
}
