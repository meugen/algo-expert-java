package com.algo.expert.dynamicprogramming;

import com.algo.expert.dynamicprogreamming.MinNumberCoinsChange;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class MinNumberCoinsChangeTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"denoms\": [1, 5, 10],\n" +
            "  \"n\": 7\n" +
            "}";
    private static final String TEST_CASE2 = "{\n" +
            "  \"denoms\": [1, 10, 5],\n" +
            "  \"n\": 7\n" +
            "}";
    private static final String TEST_CASE3 = "{\n" +
            "  \"denoms\": [10, 1, 5],\n" +
            "  \"n\": 7\n" +
            "}";
    private static final String TEST_CASE4 = "{\n" +
            "  \"denoms\": [1, 2, 3],\n" +
            "  \"n\": 0\n" +
            "}";
    private static final String TEST_CASE5 = "{\n" +
            "  \"denoms\": [2, 1],\n" +
            "  \"n\": 3\n" +
            "}";
    private static final String TEST_CASE6 = "{\n" +
            "  \"denoms\": [1, 5, 10],\n" +
            "  \"n\": 4\n" +
            "}";
    private static final String TEST_CASE7 = "{\n" +
            "  \"denoms\": [1, 5, 10],\n" +
            "  \"n\": 10\n" +
            "}";
    private static final String TEST_CASE8 = "{\n" +
            "  \"denoms\": [1, 5, 10],\n" +
            "  \"n\": 11\n" +
            "}";
    private static final String TEST_CASE9 = "{\n" +
            "  \"denoms\": [1, 5, 10],\n" +
            "  \"n\": 24\n" +
            "}";
    private static final String TEST_CASE10 = "{\n" +
            "  \"denoms\": [1, 5, 10],\n" +
            "  \"n\": 25\n" +
            "}";
    private static final String TEST_CASE11 = "{\n" +
            "  \"denoms\": [2, 4],\n" +
            "  \"n\": 7\n" +
            "}";
    private static final String TEST_CASE12 = "{\n" +
            "  \"denoms\": [3, 7],\n" +
            "  \"n\": 7\n" +
            "}";
    private static final String TEST_CASE13 = "{\n" +
            "  \"denoms\": [3, 5],\n" +
            "  \"n\": 9\n" +
            "}";
    private static final String TEST_CASE14 = "{\n" +
            "  \"denoms\": [3, 4, 5],\n" +
            "  \"n\": 9\n" +
            "}";
    private static final String TEST_CASE15 = "{\n" +
            "  \"denoms\": [39, 45, 130, 40, 4, 1],\n" +
            "  \"n\": 135\n" +
            "}";
    private static final String TEST_CASE16 = "{\n" +
            "  \"denoms\": [39, 45, 130, 40, 4, 1, 60, 75],\n" +
            "  \"n\": 135\n" +
            "}";
    private static final String TEST_CASE17 = "{\n" +
            "  \"denoms\": [1, 3, 4],\n" +
            "  \"n\": 10\n" +
            "}";

    private void internalTestCases(MinNumberCoinsChange impl, int n, int[] denoms, int expected) {
        int result = impl.minNumberOfCoinsForChange(n, denoms);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCasesSolution1(int n, int[] denoms, int expected) {
        internalTestCases(new MinNumberCoinsChange.Solution1(), n, denoms, expected);
    }

    static List<Arguments> params() {
        return List.of(
                parseArguments(TEST_CASE1, 3),
                parseArguments(TEST_CASE2, 3),
                parseArguments(TEST_CASE3, 3),
                parseArguments(TEST_CASE4, 0),
                parseArguments(TEST_CASE5, 2),
                parseArguments(TEST_CASE6, 4),
                parseArguments(TEST_CASE7, 1),
                parseArguments(TEST_CASE8, 2),
                parseArguments(TEST_CASE9, 6),
                parseArguments(TEST_CASE10, 3),
                parseArguments(TEST_CASE11, -1),
                parseArguments(TEST_CASE12, 1),
                parseArguments(TEST_CASE13, 3),
                parseArguments(TEST_CASE14, 2),
                parseArguments(TEST_CASE15, 3),
                parseArguments(TEST_CASE16, 2),
                parseArguments(TEST_CASE17, 3)
        );
    }

    private static Arguments parseArguments(String json, int expected) {
        JsonObject object = new Gson().fromJson(json, JsonElement.class).getAsJsonObject();
        JsonArray jsonDenoms = object.getAsJsonArray("denoms");
        int[] denoms = new int[jsonDenoms.size()];
        for (int i = 0; i < denoms.length; i++) {
            denoms[i] = jsonDenoms.get(i).getAsInt();
        }
        int n = object.get("n").getAsInt();
        return Arguments.of(n, denoms, expected);
    }
}
