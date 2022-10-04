package com.algo.expert.graphs;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

public class SingleCycleCheckTest {
    private static final String TEST_CASE1 = "{\n" +
            "  \"array\": [2, 3, 1, -4, -4, 2]\n" +
            "}";
    private static final String TEST_CASE2 = "{\n" +
            "  \"array\": [2, 2, -1]\n" +
            "}";
    private static final String TEST_CASE3 = "{\n" +
            "  \"array\": [2, 2, 2]\n" +
            "}";
    private static final String TEST_CASE4 = "{\n" +
            "  \"array\": [1, 1, 1, 1, 1]\n" +
            "}";
    private static final String TEST_CASE5 = "{\n" +
            "  \"array\": [-1, 2, 2]\n" +
            "}";
    private static final String TEST_CASE6 = "{\n" +
            "  \"array\": [0, 1, 1, 1, 1]\n" +
            "}";
    private static final String TEST_CASE7 = "{\n" +
            "  \"array\": [1, 1, 0, 1, 1]\n" +
            "}";
    private static final String TEST_CASE8 = "{\n" +
            "  \"array\": [1, 1, 1, 1, 2]\n" +
            "}";
    private static final String TEST_CASE9 = "{\n" +
            "  \"array\": [3, 5, 6, -5, -2, -5, -12, -2, -1, 2, -6, 1, 1, 2, -5, 2]\n" +
            "}";
    private static final String TEST_CASE10 = "{\n" +
            "  \"array\": [3, 5, 5, -5, -2, -5, -12, -2, -1, 2, -6, 1, 1, 2, -5, 2]\n" +
            "}";
    private static final String TEST_CASE11 = "{\n" +
            "  \"array\": [1, 2, 3, 4, -2, 3, 7, 8, 1]\n" +
            "}";
    private static final String TEST_CASE12 = "{\n" +
            "  \"array\": [1, 2, 3, 4, -2, 3, 7, 8, -8]\n" +
            "}";
    private static final String TEST_CASE13 = "{\n" +
            "  \"array\": [1, 2, 3, 4, -2, 3, 7, 8, -26]\n" +
            "}";
    private static final String TEST_CASE14 = "{\n" +
            "  \"array\": [10, 11, -6, -23, -2, 3, 88, 908, -26]\n" +
            "}";
    private static final String TEST_CASE15 = "{\n" +
            "  \"array\": [10, 11, -6, -23, -2, 3, 88, 909, -26]\n" +
            "}";
    private static final String TEST_CASE16 = "{\n" +
            "  \"array\": [1, -1, 1, -1]\n" +
            "}";

    private void internalTestCases(SingleCycleCheck impl, int[] array, boolean expected) {
        boolean result = impl.hasSingleCycle(Arrays.copyOf(array, array.length));
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCases(int[] array, boolean expected) {
        internalTestCases(new SingleCycleCheck.Solution1(), array, expected);
        internalTestCases(new SingleCycleCheck.Solution2(), array, expected);
    }

    static List<Arguments> params() {
        return List.of(
                parseArguments(TEST_CASE1, true),
                parseArguments(TEST_CASE2, true),
                parseArguments(TEST_CASE3, true),
                parseArguments(TEST_CASE4, true),
                parseArguments(TEST_CASE5, true),
                parseArguments(TEST_CASE6, false),
                parseArguments(TEST_CASE7, false),
                parseArguments(TEST_CASE8, false),
                parseArguments(TEST_CASE9, true),
                parseArguments(TEST_CASE10, false),
                parseArguments(TEST_CASE11, true),
                parseArguments(TEST_CASE12, true),
                parseArguments(TEST_CASE13, true),
                parseArguments(TEST_CASE14, true),
                parseArguments(TEST_CASE15, false),
                parseArguments(TEST_CASE16, false)
        );
    }

    private static Arguments parseArguments(String json, boolean expected) {
        JsonArray jsonArray = new Gson().fromJson(json, JsonElement.class)
                .getAsJsonObject().getAsJsonArray("array");
        int[] array = new int[jsonArray.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = jsonArray.get(i).getAsInt();
        }
        return Arguments.of(array, expected);
    }
}
