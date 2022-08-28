package com.algo.expert.arrays;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class SpiralTraverseTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"array\": [\n" +
            "    [1, 2, 3, 4],\n" +
            "    [12, 13, 14, 5],\n" +
            "    [11, 16, 15, 6],\n" +
            "    [10, 9, 8, 7]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE2 = "{\n" +
            "  \"array\": [\n" +
            "    [1]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE3 = "{\n" +
            "  \"array\": [\n" +
            "    [1, 2],\n" +
            "    [4, 3]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE4 = "{\n" +
            "  \"array\": [\n" +
            "    [1, 2, 3],\n" +
            "    [8, 9, 4],\n" +
            "    [7, 6, 5]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE5 = "{\n" +
            "  \"array\": [\n" +
            "    [19, 32, 33, 34, 25, 8],\n" +
            "    [16, 15, 14, 13, 12, 11],\n" +
            "    [18, 31, 36, 35, 26, 9],\n" +
            "    [1, 2, 3, 4, 5, 6],\n" +
            "    [20, 21, 22, 23, 24, 7],\n" +
            "    [17, 30, 29, 28, 27, 10]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE6 = "{\n" +
            "  \"array\": [\n" +
            "    [4, 2, 3, 6, 7, 8, 1, 9, 5, 10],\n" +
            "    [12, 19, 15, 16, 20, 18, 13, 17, 11, 14]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE7 = "{\n" +
            "  \"array\": [\n" +
            "    [27, 12, 35, 26],\n" +
            "    [25, 21, 94, 11],\n" +
            "    [19, 96, 43, 56],\n" +
            "    [55, 36, 10, 18],\n" +
            "    [96, 83, 31, 94],\n" +
            "    [93, 11, 90, 16]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE8 = "{\n" +
            "  \"array\": [\n" +
            "    [1, 2, 3, 4],\n" +
            "    [10, 11, 12, 5],\n" +
            "    [9, 8, 7, 6]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE9 = "{\n" +
            "  \"array\": [\n" +
            "    [1, 2, 3],\n" +
            "    [12, 13, 4],\n" +
            "    [11, 14, 5],\n" +
            "    [10, 15, 6],\n" +
            "    [9, 8, 7]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE10 = "{\n" +
            "  \"array\": [\n" +
            "    [1, 11],\n" +
            "    [2, 12],\n" +
            "    [3, 13],\n" +
            "    [4, 14],\n" +
            "    [5, 15],\n" +
            "    [6, 16],\n" +
            "    [7, 17],\n" +
            "    [8, 18],\n" +
            "    [9, 19],\n" +
            "    [10, 20]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE11 = "{\n" +
            "  \"array\": [\n" +
            "    [1, 3, 2, 5, 4, 7, 6]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE12 = "{\n" +
            "  \"array\": [\n" +
            "    [1],\n" +
            "    [3],\n" +
            "    [2],\n" +
            "    [5],\n" +
            "    [4],\n" +
            "    [7],\n" +
            "    [6]\n" +
            "  ]\n" +
            "}";

    @ParameterizedTest
    @MethodSource("params")
    void testCases(int[][] array, List<Integer> expected) {
        List<Integer> result = SpiralTraverse.spiralTraverse(array);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(parseArray(TEST_CASE1), List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)),
                Arguments.of(parseArray(TEST_CASE2), List.of(1)),
                Arguments.of(parseArray(TEST_CASE3), List.of(1, 2, 3, 4)),
                Arguments.of(parseArray(TEST_CASE4), List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)),
                Arguments.of(parseArray(TEST_CASE5), List.of(19, 32, 33, 34, 25, 8, 11, 9, 6, 7, 10, 27, 28, 29, 30, 17, 20, 1, 18, 16, 15, 14, 13, 12, 26, 5, 24, 23, 22, 21, 2, 31, 36, 35, 4, 3)),
                Arguments.of(parseArray(TEST_CASE6), List.of(4, 2, 3, 6, 7, 8, 1, 9, 5, 10, 14, 11, 17, 13, 18, 20, 16, 15, 19, 12)),
                Arguments.of(parseArray(TEST_CASE7), List.of(27, 12, 35, 26, 11, 56, 18, 94, 16, 90, 11, 93, 96, 55, 19, 25, 21, 94, 43, 10, 31, 83, 36, 96)),
                Arguments.of(parseArray(TEST_CASE8), List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)),
                Arguments.of(parseArray(TEST_CASE9), List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)),
                Arguments.of(parseArray(TEST_CASE10), List.of(1, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 10, 9, 8, 7, 6, 5, 4, 3, 2)),
                Arguments.of(parseArray(TEST_CASE11), List.of(1, 3, 2, 5, 4, 7, 6)),
                Arguments.of(parseArray(TEST_CASE12), List.of(1, 3, 2, 5, 4, 7, 6))
        );
    }

    static int[][] parseArray(String json) {
        int[][] result;

        JsonArray array = new Gson().fromJson(json, JsonElement.class)
                .getAsJsonObject()
                .getAsJsonArray("array");
        result = new int[array.size()][];
        for (int i = 0; i < array.size(); i++) {
            JsonArray subArray = array.get(i).getAsJsonArray();
            result[i] = new int[subArray.size()];
            for (int j = 0; j < subArray.size(); j++) {
                result[i][j] = subArray.get(j).getAsInt();
            }
        }
        return result;
    }
}
