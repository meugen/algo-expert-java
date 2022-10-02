package com.algo.expert.searching;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class SearchInSortedMatrixTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"matrix\": [\n" +
            "    [1, 4, 7, 12, 15, 1000],\n" +
            "    [2, 5, 19, 31, 32, 1001],\n" +
            "    [3, 8, 24, 33, 35, 1002],\n" +
            "    [40, 41, 42, 44, 45, 1003],\n" +
            "    [99, 100, 103, 106, 128, 1004]\n" +
            "  ],\n" +
            "  \"target\": 44\n" +
            "}";
    private static final String TEST_CASE2 = "{\n" +
            "  \"matrix\": [\n" +
            "    [1, 4, 7, 12, 15, 1000],\n" +
            "    [2, 5, 19, 31, 32, 1001],\n" +
            "    [3, 8, 24, 33, 35, 1002],\n" +
            "    [40, 41, 42, 44, 45, 1003],\n" +
            "    [99, 100, 103, 106, 128, 1004]\n" +
            "  ],\n" +
            "  \"target\": 1\n" +
            "}";
    private static final String TEST_CASE3 = "{\n" +
            "  \"matrix\": [\n" +
            "    [1, 4, 7, 12, 15, 1000],\n" +
            "    [2, 5, 19, 31, 32, 1001],\n" +
            "    [3, 8, 24, 33, 35, 1002],\n" +
            "    [40, 41, 42, 44, 45, 1003],\n" +
            "    [99, 100, 103, 106, 128, 1004]\n" +
            "  ],\n" +
            "  \"target\": 2\n" +
            "}";
    private static final String TEST_CASE4 = "{\n" +
            "  \"matrix\": [\n" +
            "    [1, 4, 7, 12, 15, 1000],\n" +
            "    [2, 5, 19, 31, 32, 1001],\n" +
            "    [3, 8, 24, 33, 35, 1002],\n" +
            "    [40, 41, 42, 44, 45, 1003],\n" +
            "    [99, 100, 103, 106, 128, 1004]\n" +
            "  ],\n" +
            "  \"target\": 4\n" +
            "}";
    private static final String TEST_CASE5 = "{\n" +
            "  \"matrix\": [\n" +
            "    [1, 4, 7, 12, 15, 1000],\n" +
            "    [2, 5, 19, 31, 32, 1001],\n" +
            "    [3, 8, 24, 33, 35, 1002],\n" +
            "    [40, 41, 42, 44, 45, 1003],\n" +
            "    [99, 100, 103, 106, 128, 1004]\n" +
            "  ],\n" +
            "  \"target\": 15\n" +
            "}";
    private static final String TEST_CASE6 = "{\n" +
            "  \"matrix\": [\n" +
            "    [1, 4, 7, 12, 15, 1000],\n" +
            "    [2, 5, 19, 31, 32, 1001],\n" +
            "    [3, 8, 24, 33, 35, 1002],\n" +
            "    [40, 41, 42, 44, 45, 1003],\n" +
            "    [99, 100, 103, 106, 128, 1004]\n" +
            "  ],\n" +
            "  \"target\": 12\n" +
            "}";
    private static final String TEST_CASE7 = "{\n" +
            "  \"matrix\": [\n" +
            "    [1, 4, 7, 12, 15, 1000],\n" +
            "    [2, 5, 19, 31, 32, 1001],\n" +
            "    [3, 8, 24, 33, 35, 1002],\n" +
            "    [40, 41, 42, 44, 45, 1003],\n" +
            "    [99, 100, 103, 106, 128, 1004]\n" +
            "  ],\n" +
            "  \"target\": 32\n" +
            "}";
    private static final String TEST_CASE8 = "{\n" +
            "  \"matrix\": [\n" +
            "    [1, 4, 7, 12, 15, 1000],\n" +
            "    [2, 5, 19, 31, 32, 1001],\n" +
            "    [3, 8, 24, 33, 35, 1002],\n" +
            "    [40, 41, 42, 44, 45, 1003],\n" +
            "    [99, 100, 103, 106, 128, 1004]\n" +
            "  ],\n" +
            "  \"target\": 99\n" +
            "}";
    private static final String TEST_CASE9 = "{\n" +
            "  \"matrix\": [\n" +
            "    [1, 4, 7, 12, 15, 1000],\n" +
            "    [2, 5, 19, 31, 32, 1001],\n" +
            "    [3, 8, 24, 33, 35, 1002],\n" +
            "    [40, 41, 42, 44, 45, 1003],\n" +
            "    [99, 100, 103, 106, 128, 1004]\n" +
            "  ],\n" +
            "  \"target\": 100\n" +
            "}";
    private static final String TEST_CASE10 = "{\n" +
            "  \"matrix\": [\n" +
            "    [1, 4, 7, 12, 15, 1000],\n" +
            "    [2, 5, 19, 31, 32, 1001],\n" +
            "    [3, 8, 24, 33, 35, 1002],\n" +
            "    [40, 41, 42, 44, 45, 1003],\n" +
            "    [99, 100, 103, 106, 128, 1004]\n" +
            "  ],\n" +
            "  \"target\": 40\n" +
            "}";
    private static final String TEST_CASE11 = "{\n" +
            "  \"matrix\": [\n" +
            "    [1, 4, 7, 12, 15, 1000],\n" +
            "    [2, 5, 19, 31, 32, 1001],\n" +
            "    [3, 8, 24, 33, 35, 1002],\n" +
            "    [40, 41, 42, 44, 45, 1003],\n" +
            "    [99, 100, 103, 106, 128, 1004]\n" +
            "  ],\n" +
            "  \"target\": 128\n" +
            "}";
    private static final String TEST_CASE12 = "{\n" +
            "  \"matrix\": [\n" +
            "    [1, 4, 7, 12, 15, 1000],\n" +
            "    [2, 5, 19, 31, 32, 1001],\n" +
            "    [3, 8, 24, 33, 35, 1002],\n" +
            "    [40, 41, 42, 44, 45, 1003],\n" +
            "    [99, 100, 103, 106, 128, 1004]\n" +
            "  ],\n" +
            "  \"target\": 106\n" +
            "}";
    private static final String TEST_CASE13 = "{\n" +
            "  \"matrix\": [\n" +
            "    [1, 4, 7, 12, 15, 1000],\n" +
            "    [2, 5, 19, 31, 32, 1001],\n" +
            "    [3, 8, 24, 33, 35, 1002],\n" +
            "    [40, 41, 42, 44, 45, 1003],\n" +
            "    [99, 100, 103, 106, 128, 1004]\n" +
            "  ],\n" +
            "  \"target\": 45\n" +
            "}";
    private static final String TEST_CASE14 = "{\n" +
            "  \"matrix\": [\n" +
            "    [1, 4, 7, 12, 15, 1000],\n" +
            "    [2, 5, 19, 31, 32, 1001],\n" +
            "    [3, 8, 24, 33, 35, 1002],\n" +
            "    [40, 41, 42, 44, 45, 1003],\n" +
            "    [99, 100, 103, 106, 128, 1004]\n" +
            "  ],\n" +
            "  \"target\": 24\n" +
            "}";
    private static final String TEST_CASE15 = "{\n" +
            "  \"matrix\": [\n" +
            "    [1, 4, 7, 12, 15, 1000],\n" +
            "    [2, 5, 19, 31, 32, 1001],\n" +
            "    [3, 8, 24, 33, 35, 1002],\n" +
            "    [40, 41, 42, 44, 45, 1003],\n" +
            "    [99, 100, 103, 106, 128, 1004]\n" +
            "  ],\n" +
            "  \"target\": 43\n" +
            "}";
    private static final String TEST_CASE16 = "{\n" +
            "  \"matrix\": [\n" +
            "    [1, 4, 7, 12, 15, 1000],\n" +
            "    [2, 5, 19, 31, 32, 1001],\n" +
            "    [3, 8, 24, 33, 35, 1002],\n" +
            "    [40, 41, 42, 44, 45, 1003],\n" +
            "    [99, 100, 103, 106, 128, 1004]\n" +
            "  ],\n" +
            "  \"target\": -1\n" +
            "}";
    private static final String TEST_CASE17 = "{\n" +
            "  \"matrix\": [\n" +
            "    [1, 4, 7, 12, 15, 1000],\n" +
            "    [2, 5, 19, 31, 32, 1001],\n" +
            "    [3, 8, 24, 33, 35, 1002],\n" +
            "    [40, 41, 42, 44, 45, 1003],\n" +
            "    [99, 100, 103, 106, 128, 1004]\n" +
            "  ],\n" +
            "  \"target\": 1000\n" +
            "}";
    private static final String TEST_CASE18 = "{\n" +
            "  \"matrix\": [\n" +
            "    [1, 4, 7, 12, 15, 1000],\n" +
            "    [2, 5, 19, 31, 32, 1001],\n" +
            "    [3, 8, 24, 33, 35, 1002],\n" +
            "    [40, 41, 42, 44, 45, 1003],\n" +
            "    [99, 100, 103, 106, 128, 1004]\n" +
            "  ],\n" +
            "  \"target\": 1004\n" +
            "}";

    private void internalTestCases(SearchInSortedMatrix impl, int[][] matrix, int target, int[] expected) {
        int[] result = impl.searchInSortedMatrix(matrix, target);
        Assertions.assertArrayEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCases(int[][] matrix, int target, int[] expected) {
        internalTestCases(new SearchInSortedMatrix.Solution2(), matrix, target, expected);
    }

    static List<Arguments> params() {
        return List.of(
                parseArguments(TEST_CASE1, new int[] {3, 3}),
                parseArguments(TEST_CASE2, new int[] {0, 0}),
                parseArguments(TEST_CASE3, new int[] {1, 0}),
                parseArguments(TEST_CASE4, new int[] {0, 1}),
                parseArguments(TEST_CASE5, new int[] {0, 4}),
                parseArguments(TEST_CASE6, new int[] {0, 3}),
                parseArguments(TEST_CASE7, new int[] {1, 4}),
                parseArguments(TEST_CASE8, new int[] {4, 0}),
                parseArguments(TEST_CASE9, new int[] {4, 1}),
                parseArguments(TEST_CASE10, new int[] {3, 0}),
                parseArguments(TEST_CASE11, new int[] {4, 4}),
                parseArguments(TEST_CASE12, new int[] {4, 3}),
                parseArguments(TEST_CASE13, new int[] {3, 4}),
                parseArguments(TEST_CASE14, new int[] {2, 2}),
                parseArguments(TEST_CASE15, new int[] {-1, -1}),
                parseArguments(TEST_CASE16, new int[] {-1, -1}),
                parseArguments(TEST_CASE17, new int[] {0, 5}),
                parseArguments(TEST_CASE18, new int[] {4, 5})
        );
    }

    private static Arguments parseArguments(String json, int[] expected) {
        JsonObject object = new Gson().fromJson(json, JsonElement.class).getAsJsonObject();
        JsonArray jsonMatrix = object.getAsJsonArray("matrix");
        int[][] matrix = new int[jsonMatrix.size()][];
        for (int i = 0; i < matrix.length; i++) {
            JsonArray row = jsonMatrix.get(i).getAsJsonArray();
            matrix[i] = new int[row.size()];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = row.get(j).getAsInt();
            }
        }
        int target = object.get("target").getAsInt();
        return Arguments.of(matrix, target, expected);
    }
}
