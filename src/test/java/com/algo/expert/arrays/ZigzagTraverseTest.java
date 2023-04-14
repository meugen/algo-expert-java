package com.algo.expert.arrays;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ZigzagTraverseTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"array\": [\n" +
            "    [1, 3, 4, 10],\n" +
            "    [2, 5, 9, 11],\n" +
            "    [6, 8, 12, 15],\n" +
            "    [7, 13, 14, 16]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE2 = "{\n" +
            "  \"array\": [\n" +
            "    [1]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE3 = "{\n" +
            "  \"array\": [\n" +
            "    [1, 2, 3, 4, 5]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE4 = "{\n" +
            "  \"array\": [\n" +
            "    [1],\n" +
            "    [2],\n" +
            "    [3],\n" +
            "    [4],\n" +
            "    [5]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE5 = "{\n" +
            "  \"array\": [\n" +
            "    [1, 3],\n" +
            "    [2, 4],\n" +
            "    [5, 7],\n" +
            "    [6, 8],\n" +
            "    [9, 10]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE6 = "{\n" +
            "  \"array\": [\n" +
            "    [1, 3, 4, 7, 8],\n" +
            "    [2, 5, 6, 9, 10]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE7 = "{\n" +
            "  \"array\": [\n" +
            "    [1, 3, 4, 10, 11],\n" +
            "    [2, 5, 9, 12, 19],\n" +
            "    [6, 8, 13, 18, 20],\n" +
            "    [7, 14, 17, 21, 24],\n" +
            "    [15, 16, 22, 23, 25]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE8 = "{\n" +
            "  \"array\": [\n" +
            "    [1, 3, 4, 10, 11, 20],\n" +
            "    [2, 5, 9, 12, 19, 21],\n" +
            "    [6, 8, 13, 18, 22, 27],\n" +
            "    [7, 14, 17, 23, 26, 28],\n" +
            "    [15, 16, 24, 25, 29, 30]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE9 = "{\n" +
            "  \"array\": [\n" +
            "    [1, 3, 4, 10, 11],\n" +
            "    [2, 5, 9, 12, 20],\n" +
            "    [6, 8, 13, 19, 21],\n" +
            "    [7, 14, 18, 22, 27],\n" +
            "    [15, 17, 23, 26, 28],\n" +
            "    [16, 24, 25, 29, 30]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE10 = "{\n" +
            "  \"array\": [\n" +
            "    [1, 21, -3, 4, 15, 6, -7, 88, 9],\n" +
            "    [10, 11, 112, 12, 20, -1, -2, -3, -4],\n" +
            "    [6, 8, 113, 19, 21, 0, 0, 0, 0],\n" +
            "    [7, 2, 18, 22, -27, 12, 32, -111, 66],\n" +
            "    [15, 17, 23, 226, 28, -28, -226, -23, -17],\n" +
            "    [16, 24, 27, 299, 30, 29, 32, 31, 88]\n" +
            "  ]\n" +
            "}";

    @ParameterizedTest
    @MethodSource("params")
    void testCasesSolution1(List<List<Integer>> array, List<Integer> expected) {
        implTestCases(new ZigzagTraverse.Solution1(), array, expected);
    }

    private void implTestCases(ZigzagTraverse impl, List<List<Integer>> array, List<Integer> expected) {
        List<Integer> result = impl.zigzagTraverse(array);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(parseArray(TEST_CASE1), List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)),
                Arguments.of(parseArray(TEST_CASE2), List.of(1)),
                Arguments.of(parseArray(TEST_CASE3), List.of(1, 2, 3, 4, 5)),
                Arguments.of(parseArray(TEST_CASE4), List.of(1, 2, 3, 4, 5)),
                Arguments.of(parseArray(TEST_CASE5), List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)),
                Arguments.of(parseArray(TEST_CASE6), List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)),
                Arguments.of(parseArray(TEST_CASE7), List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25)),
                Arguments.of(parseArray(TEST_CASE8), List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30)),
                Arguments.of(parseArray(TEST_CASE9), List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30)),
                Arguments.of(parseArray(TEST_CASE10), List.of(1, 10, 21, -3, 11, 6, 7, 8, 112, 4, 15, 12, 113, 2, 15, 16, 17, 18, 19, 20, 6, -7, -1, 21, 22, 23, 24, 27, 226, -27, 0, -2, 88, 9, -3, 0, 12, 28, 299, 30, -28, 32, 0, -4, 0, -111, -226, 29, 32, -23, 66, -17, 31, 88))
        );
    }

    private static List<List<Integer>> parseArray(String json) {
        JsonArray jsonArray = new Gson().fromJson(json, JsonElement.class)
                .getAsJsonObject().getAsJsonArray("array");
        List<List<Integer>> array = new ArrayList<>();
        for (JsonElement element : jsonArray) {
            List<Integer> row = new ArrayList<>();
            for (JsonElement item : element.getAsJsonArray()) {
                row.add(item.getAsInt());
            }
            array.add(row);
        }
        return array;
    }
}
