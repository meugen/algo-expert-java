package com.algo.expert.dynamicprogramming;

import com.algo.expert.dynamicprogreamming.NumberWaysMakeChange;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class NumberWaysMakeChangeTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"denoms\": [1, 5],\n" +
            "  \"n\": 6\n" +
            "}";
    private static final String TEST_CASE2 = "{\n" +
            "  \"denoms\": [2, 3, 4, 7],\n" +
            "  \"n\": 0\n" +
            "}";
    private static final String TEST_CASE3 = "{\n" +
            "  \"denoms\": [5],\n" +
            "  \"n\": 9\n" +
            "}";
    private static final String TEST_CASE4 = "{\n" +
            "  \"denoms\": [2, 4],\n" +
            "  \"n\": 7\n" +
            "}";
    private static final String TEST_CASE5 = "{\n" +
            "  \"denoms\": [1, 5, 10, 25],\n" +
            "  \"n\": 4\n" +
            "}";
    private static final String TEST_CASE6 = "{\n" +
            "  \"denoms\": [1, 5, 10, 25],\n" +
            "  \"n\": 5\n" +
            "}";
    private static final String TEST_CASE7 = "{\n" +
            "  \"denoms\": [1, 5, 10, 25],\n" +
            "  \"n\": 10\n" +
            "}";
    private static final String TEST_CASE8 = "{\n" +
            "  \"denoms\": [1, 5, 10, 25],\n" +
            "  \"n\": 25\n" +
            "}";
    private static final String TEST_CASE9 = "{\n" +
            "  \"denoms\": [2, 3, 7],\n" +
            "  \"n\": 12\n" +
            "}";
    private static final String TEST_CASE10 = "{\n" +
            "  \"denoms\": [2, 3, 4, 7],\n" +
            "  \"n\": 7\n" +
            "}";

    private void internalTestCases(NumberWaysMakeChange impl, int n, int[] denoms, int expected) {
        int result = impl.numberOfWaysToMakeChange(n, denoms);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCases(int n, int[] denoms, int expected) {
        internalTestCases(new NumberWaysMakeChange.Solution1(), n, denoms, expected);
    }

    static List<Arguments> params() {
        return List.of(
                parseArguments(TEST_CASE1, 2),
                parseArguments(TEST_CASE2, 1),
                parseArguments(TEST_CASE3, 0),
                parseArguments(TEST_CASE4, 0),
                parseArguments(TEST_CASE5, 1),
                parseArguments(TEST_CASE6, 2),
                parseArguments(TEST_CASE7, 4),
                parseArguments(TEST_CASE8, 13),
                parseArguments(TEST_CASE9, 4),
                parseArguments(TEST_CASE10, 3)
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
