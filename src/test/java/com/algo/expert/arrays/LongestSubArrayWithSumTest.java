package com.algo.expert.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class LongestSubArrayWithSumTest {
    
    private static final String TEST_CASE1 = """
            {
              "array":  [1, 2, 3, 4, 3, 3, 1, 2, 1],
              "targetSum": 10,
              "expected": [4, 8]
            }
            """;
    private static final String TEST_CASE2 = """
            {
              "array": [1, 2, 3, 4, 0, 0, 0, 0, 0, 3, 3, 1, 2, 1],
              "targetSum": 10,
              "expected": [4, 13]
            }
            """;
    private static final String TEST_CASE3 = """
            {
              "array": [0, 0, 0, 0, 0, 0, 0, 0, 0, 1],
              "targetSum": 1,
              "expected": [0, 9]
            }
            """;
    private static final String TEST_CASE4 = """
            {
              "array": [0, 0, 0, 0, 0, 1, 0, 0, 0, 0],
              "targetSum": 1,
              "expected": [0, 9]
            }
            """;
    private static final String TEST_CASE5 = """
            {
              "array": [25, 25, 25, 25, 100, 0, 0, 0, 0, 0, 0, 0],
              "targetSum": 100,
              "expected": [4, 11]
            }
            """;
    private static final String TEST_CASE6 = """
            {
              "array": [1, 2, 3, 4, 5, 5, 5, 5],
              "targetSum": 15,
              "expected": [0, 4]
            }
            """;
    private static final String TEST_CASE7 = """
            {
              "array": [0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 5, 5, 5, 5, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1],
              "targetSum": 20,
              "expected": [11, 23]
            }
            """;
    private static final String TEST_CASE8 = """
            {
              "array": [1, 2, 3, 4, 5, 0, 0, 0, 6, 7, 8, 9, 10],
              "targetSum": 15,
              "expected": [0, 7]
            }
            """;
    private static final String TEST_CASE9 = """
            {
              "array": [61, 54, 1, 499, 2212, 4059, 1, 2, 3, 1, 3],
              "targetSum": 19,
              "expected": []
            }
            """;
    private static final String TEST_CASE10 = """
            {
              "array": [0],
              "targetSum": 0,
              "expected": [0, 0]
            }
            """;
    private static final String TEST_CASE11 = """
            {
              "array": [10],
              "targetSum": 10,
              "expected": [0, 0]
            }
            """;
    private static final String TEST_CASE12 = """
            {
              "array": [5],
              "targetSum": 0,
              "expected": []
            }
            """;
    private static final String TEST_CASE13 = """
            {
              "array": [5],
              "targetSum": 10,
              "expected": []
            }
            """;
    private static final String TEST_CASE14 = """
            {
              "array": [0, 1, 0, 1],
              "targetSum": 3,
              "expected": []
            }
            """;
    private static final String TEST_CASE15 = """
            {
              "array": [0, 0, 0, 0, 39, 0, 0, 0, 0, 0, 28, 10],
              "targetSum": 39,
              "expected": [0, 9]
            }
            """;
    private static final String TEST_CASE16 = """
            {
              "array": [1, 4, 10, 15, 31, 7, 1, 40, 0, 20, 1, 1, 1, 1, 2, 1],
              "targetSum": 68,
              "expected": [6, 15]
            }
            """;
    private static final String TEST_CASE17 = """
            {
              "array": [1, 4, 10, 15, 31, 7, 1, 40, 0, 20, 1, 1, 1, 1, 2, 1],
              "targetSum": 0,
              "expected": [8, 8]
            }
            """;
    private static final String TEST_CASE18 = """
            {
              "array": [1, 4, 10, 15, 31, 7, 1, 40, 5, 20, 1, 1, 1, 1, 2, 1],
              "targetSum": 0,
              "expected": []
            }
            """;
    private static final String TEST_CASE19 = """
            {
              "array": [1, 2, 3, 4, 5],
              "targetSum": 0,
              "expected": []
            }
            """;

    private void internalTestCaseSolution(LongestSubarrayWithSum solution, int[] array, int targetSum, int[] expected) {
        int[] result = solution.longestSubarrayWithSum(array, targetSum);
        assertArrayEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution(int[] array, int targetSum, int[] expected) {
        internalTestCaseSolution(new LongestSubarrayWithSum.Solution1(), array, targetSum, expected);
    }

    static List<Arguments> params() {
        return List.of(
            parseArguments(TEST_CASE1),
            parseArguments(TEST_CASE2),
            parseArguments(TEST_CASE3),
            parseArguments(TEST_CASE4),
            parseArguments(TEST_CASE5),
            parseArguments(TEST_CASE6),
            parseArguments(TEST_CASE7),
            parseArguments(TEST_CASE8),
            parseArguments(TEST_CASE9),
            parseArguments(TEST_CASE10),
            parseArguments(TEST_CASE11),
            parseArguments(TEST_CASE12),
            parseArguments(TEST_CASE13),
            parseArguments(TEST_CASE14),
            parseArguments(TEST_CASE15),
            parseArguments(TEST_CASE16),
            parseArguments(TEST_CASE17),
            parseArguments(TEST_CASE18),
            parseArguments(TEST_CASE19)
        );
    }

    private static Arguments parseArguments(String json) {
        var obj = new Gson().fromJson(json, JsonElement.class).getAsJsonObject();
        return Arguments.of(
            parseArray(obj.get("array").getAsJsonArray()),
            obj.get("targetSum").getAsInt(),
            parseArray(obj.get("expected").getAsJsonArray())
        );
    }

    private static int[] parseArray(JsonArray array) {
        int[] result = new int[array.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = array.get(i).getAsInt();
        }
        return result;
    }
}
