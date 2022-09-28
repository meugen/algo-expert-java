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

public class BinarySearchTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"array\": [0, 1, 21, 33, 45, 45, 61, 71, 72, 73],\n" +
            "  \"target\": 33\n" +
            "}";
    private static final String TEST_CASE2 = "{\n" +
            "  \"array\": [1, 5, 23, 111],\n" +
            "  \"target\": 111\n" +
            "}";
    private static final String TEST_CASE3 = "{\n" +
            "  \"array\": [1, 5, 23, 111],\n" +
            "  \"target\": 5\n" +
            "}";
    private static final String TEST_CASE4 = "{\n" +
            "  \"array\": [1, 5, 23, 111],\n" +
            "  \"target\": 35\n" +
            "}";
    private static final String TEST_CASE5 = "{\n" +
            "  \"array\": [0, 1, 21, 33, 45, 45, 61, 71, 72, 73],\n" +
            "  \"target\": 0\n" +
            "}";
    private static final String TEST_CASE6 = "{\n" +
            "  \"array\": [0, 1, 21, 33, 45, 45, 61, 71, 72, 73],\n" +
            "  \"target\": 1\n" +
            "}";
    private static final String TEST_CASE7 = "{\n" +
            "  \"array\": [0, 1, 21, 33, 45, 45, 61, 71, 72, 73],\n" +
            "  \"target\": 21\n" +
            "}";
    private static final String TEST_CASE8 = "{\n" +
            "  \"array\": [0, 1, 21, 33, 45, 45, 61, 71, 72, 73],\n" +
            "  \"target\": 45\n" +
            "}";
    private static final String TEST_CASE9 = "{\n" +
            "  \"array\": [0, 1, 21, 33, 45, 45, 61, 71, 72, 73],\n" +
            "  \"target\": 61\n" +
            "}";
    private static final String TEST_CASE10 = "{\n" +
            "  \"array\": [0, 1, 21, 33, 45, 45, 61, 71, 72, 73],\n" +
            "  \"target\": 71\n" +
            "}";
    private static final String TEST_CASE11 = "{\n" +
            "  \"array\": [0, 1, 21, 33, 45, 45, 61, 71, 72, 73],\n" +
            "  \"target\": 72\n" +
            "}";
    private static final String TEST_CASE12 = "{\n" +
            "  \"array\": [0, 1, 21, 33, 45, 45, 61, 71, 72, 73],\n" +
            "  \"target\": 73\n" +
            "}";
    private static final String TEST_CASE13 = "{\n" +
            "  \"array\": [0, 1, 21, 33, 45, 45, 61, 71, 72, 73],\n" +
            "  \"target\": 70\n" +
            "}";
    private static final String TEST_CASE14 = "{\n" +
            "  \"array\": [0, 1, 21, 33, 45, 45, 61, 71, 72, 73, 355],\n" +
            "  \"target\": 355\n" +
            "}";
    private static final String TEST_CASE15 = "{\n" +
            "  \"array\": [0, 1, 21, 33, 45, 45, 61, 71, 72, 73, 355],\n" +
            "  \"target\": 354\n" +
            "}";
    private static final String TEST_CASE16 = "{\n" +
            "  \"array\": [1, 5, 23, 111],\n" +
            "  \"target\": 120\n" +
            "}";
    private static final String TEST_CASE17 = "{\n" +
            "  \"array\": [5, 23, 111],\n" +
            "  \"target\": 3\n" +
            "}";

    private void internalTestCases(BinarySearch impl, int[] array, int target, int expected) {
        int result = impl.binarySearch(array, target);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCases(int[] array, int target, int expected) {
        internalTestCases(new BinarySearch.Solution1(), array, target, expected);
    }

    static List<Arguments> params() {
        return List.of(
                parseArguments(TEST_CASE1, 3),
                parseArguments(TEST_CASE2, 3),
                parseArguments(TEST_CASE3, 1),
                parseArguments(TEST_CASE4, -1),
                parseArguments(TEST_CASE5, 0),
                parseArguments(TEST_CASE6, 1),
                parseArguments(TEST_CASE7, 2),
                parseArguments(TEST_CASE8, 4),
                parseArguments(TEST_CASE9, 6),
                parseArguments(TEST_CASE10, 7),
                parseArguments(TEST_CASE11, 8),
                parseArguments(TEST_CASE12, 9),
                parseArguments(TEST_CASE13, -1),
                parseArguments(TEST_CASE14, 10),
                parseArguments(TEST_CASE15, -1),
                parseArguments(TEST_CASE16, -1),
                parseArguments(TEST_CASE17, -1)
        );
    }

    static Arguments parseArguments(String json, int expected) {
        JsonObject object = new Gson().fromJson(json, JsonElement.class).getAsJsonObject();
        JsonArray jsonArray = object.getAsJsonArray("array");
        int[] array = new int[jsonArray.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = jsonArray.get(i).getAsInt();
        }
        int target = object.get("target").getAsInt();
        return Arguments.of(array, target, expected);
    }
}
