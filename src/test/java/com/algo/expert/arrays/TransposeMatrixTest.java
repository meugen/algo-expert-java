package com.algo.expert.arrays;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class TransposeMatrixTest {
    
    private static final String TEST_CASE1 = """
            {
              "matrix": [
                [1]
              ],
              "expected": [
                [1]
              ]
            }
            """;
    private static final String TEST_CASE2 = """
            {
              "matrix": [
                [1],
                [-1]
              ],
              "expected": [
                [1, -1]
              ]
            }
            """;
    private static final String TEST_CASE3 = """
            {
              "matrix": [
                [1, 2, 3]
              ],
              "expected": [
                [1],
                [2],
                [3]
              ]  
            }
            """;
    private static final String TEST_CASE4 = """
            {
              "matrix": [
                [1],
                [2],
                [3]
              ],
              "expected": [
                [1, 2, 3]
              ]
            }
            """;
    private static final String TEST_CASE5 = """
            {
              "matrix": [
                [1, 2, 3],
                [4, 5, 6]
              ],
              "expected": [
                [1, 4],
                [2, 5],
                [3, 6]
              ]
            }
            """;
    private static final String TEST_CASE6 = """
            {
              "matrix": [
                [0, 0, 0],
                [1, 1, 1]
              ],
              "expected": [
                [0, 1],
                [0, 1],
                [0, 1]
              ]
            }
            """;
    private static final String TEST_CASE7 = """
            {
              "matrix": [
                [0, 1],
                [0, 1],
                [0, 1]
              ],
              "expected": [
                [0, 0, 0],
                [1, 1, 1]
              ]
            }
            """;
    private static final String TEST_CASE8 = """
            {
              "matrix": [
                [0, 0, 0],
                [0, 0, 0]
              ],
              "expected": [
                [0, 0],
                [0, 0],
                [0, 0]
              ]
            }
            """;
    private static final String TEST_CASE9 = """
            {
              "matrix": [
                [1, 4],
                [2, 5],
                [3, 6]
              ],
              "expected": [
                [1, 2, 3],
                [4, 5, 6]
              ]
            }
            """;
    private static final String TEST_CASE10 = """
            {
              "matrix": [
                [-7, -7],
                [100, 12],
                [-33, 17]
              ],
              "expected": [
                [-7, 100, -33],
                [-7, 12, 17]
              ]
            }
            """;
    private static final String TEST_CASE11 = """
            {
              "matrix": [
                [1, 2, 3],
                [4, 5, 6],
                [7, 8, 9]
              ],
              "expected": [
                [1, 4, 7],
                [2, 5, 8],
                [3, 6, 9]
              ]
            }
            """;
    private static final String TEST_CASE12 = """
            {
              "matrix": [
                [1, 4, 7],
                [2, 5, 8],
                [3, 6, 9]
              ],
              "expected": [
                [1, 2, 3],
                [4, 5, 6],
                [7, 8, 9]
              ]
            }
            """;
    private static final String TEST_CASE13 = """
            {
              "matrix": [
                [5, 6, 3, -3, 12],
                [-3, 6, 5, 2, -1],
                [0, 0, 3, 12, 3]
              ],
              "expected": [
                [5, -3, 0],
                [6, 6, 0],
                [3, 5, 3],
                [-3, 2, 12],
                [12, -1, 3]
              ]
            }
            """;
    private static final String TEST_CASE14 = """
            {
              "matrix": [
                [5, 6, 3, -3, 12],
                [-3, 6, 5, 2, -1],
                [0, 0, 3, 12, 3]
              ],
              "expected": [
                [5, -3, 0],
                [6, 6, 0],
                [3, 5, 3],
                [-3, 2, 12],
                [12, -1, 3]
              ]
            }
            """;
    private static final String TEST_CASE15 = """
            {
              "matrix": [
                [1234, 6935, 4205],
                [-23459, 314159, 0],
                [100, 3, 987654]
              ],
              "expected": [
                [1234, -23459, 100],
                [6935, 314159, 3],
                [4205, 0, 987654]
              ]
            }
            """;

    private void internalTestCases(TransposeMatrix solution, int[][] matrix, int[][] expected) {
        int[][] result = solution.transposeMatrix(matrix);

        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertArrayEquals(expected[i], result[i]);
        }
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCasesSolution1(int[][] matrix, int[][] expected) {
        internalTestCases(new TransposeMatrix.Slution1(), matrix, expected);
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
            parseArguments(TEST_CASE15)
        );
    }

    private static Arguments parseArguments(String testCase) {
        JsonObject json = new Gson().fromJson(testCase, JsonElement.class).getAsJsonObject();
        return Arguments.of(
            parseMatrix(json.get("matrix").getAsJsonArray()),
            parseMatrix(json.get("expected").getAsJsonArray())
        );
    }

    private static int[][] parseMatrix(JsonArray array) {
        int[][] result = new int[array.size()][];

        int i = 0;
        for (JsonElement rowElement : array) {
            JsonArray row = rowElement.getAsJsonArray();
            result[i] = new int[row.size()];
            int j = 0;
            for (JsonElement value : row) {
                result[i][j] = value.getAsInt();
                j++;
            }
            i++;
        }
        return result;
    }
}
