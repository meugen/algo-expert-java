package com.algo.expert.arrays;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class ZeroSumSubarrayTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"nums\": []\n" +
            "}";
    private static final boolean EXPECTED1 = false;

    private static final String TEST_CASE2 = "{\n" +
            "  \"nums\": [0]\n" +
            "}";
    private static final boolean EXPECTED2 = true;

    private static final String TEST_CASE3 = "{\n" +
            "  \"nums\": [1]\n" +
            "}";
    private static final boolean EXPECTED3 = false;

    private static final String TEST_CASE4 = "{\n" +
            "  \"nums\": [1, 2, 3]\n" +
            "}";
    private static final boolean EXPECTED4 = false;

    private static final String TEST_CASE5 = "{\n" +
            "  \"nums\": [1, 1, 1]\n" +
            "}";
    private static final boolean EXPECTED5 = false;

    private static final String TEST_CASE6 = "{\n" +
            "  \"nums\": [-1, -1, -1]\n" +
            "}";
    private static final boolean EXPECTED6 = false;

    private static final String TEST_CASE7 = "{\n" +
            "  \"nums\": [0, 0, 0]\n" +
            "}";
    private static final boolean EXPECTED7 = true;

    private static final String TEST_CASE8 = "{\n" +
            "  \"nums\": [1, 2, -2, 3]\n" +
            "}";
    private static final boolean EXPECTED8 = true;

    private static final String TEST_CASE9 = "{\n" +
            "  \"nums\": [2, -2]\n" +
            "}";
    private static final boolean EXPECTED9 = true;

    private static final String TEST_CASE10 = "{\n" +
            "  \"nums\": [-1, 2, 3, 4, -5, -3, 1, 2]\n" +
            "}";
    private static final boolean EXPECTED10 = true;

    private static final String TEST_CASE11 = "{\n" +
            "  \"nums\": [-2, -3, -1, 2, 3, 4, -5, -3, 1, 2]\n" +
            "}";
    private static final boolean EXPECTED11 = true;

    private static final String TEST_CASE12 = "{\n" +
            "  \"nums\": [2, 3, 4, -5, -3, 4, 5]\n" +
            "}";
    private static final boolean EXPECTED12 = true;

    private static final String TEST_CASE13 = "{\n" +
            "  \"nums\": [2, 3, 4, -5, -3, 5, 5]\n" +
            "}";
    private static final boolean EXPECTED13 = false;

    private static final String TEST_CASE14 = "{\n" +
            "  \"nums\": [1, 2, 3, 4, 0, 5, 6, 7]\n" +
            "}";
    private static final boolean EXPECTED14 = true;

    private static final String TEST_CASE15 = "{\n" +
            "  \"nums\": [1, 2, 3, -2, -1]\n" +
            "}";
    private static final boolean EXPECTED15 = true;

    private static final String TEST_CASE16 = "{\n" +
            "  \"nums\": [-8, -22, 104, 73, -120, 53, 22, -12, 1, 14, -90, 13, -22]\n" +
            "}";
    private static final boolean EXPECTED16 = false;

    private static final String TEST_CASE17 = "{\n" +
            "  \"nums\": [-8, -22, 104, 73, -120, 53, 22, 20, 25, -12, 1, 14, -90, 13, -22]\n" +
            "}";
    private static final boolean EXPECTED17 = true;

    private static int[] parseNums(String json) {
        var object = new Gson().fromJson(json, JsonObject.class);
        var nums = object.getAsJsonArray("nums");

        var result = new int[nums.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = nums.get(i).getAsInt();
        }
        return result;
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(parseNums(TEST_CASE1), EXPECTED1),
                Arguments.of(parseNums(TEST_CASE2), EXPECTED2),
                Arguments.of(parseNums(TEST_CASE3), EXPECTED3),
                Arguments.of(parseNums(TEST_CASE4), EXPECTED4),
                Arguments.of(parseNums(TEST_CASE5), EXPECTED5),
                Arguments.of(parseNums(TEST_CASE6), EXPECTED6),
                Arguments.of(parseNums(TEST_CASE7), EXPECTED7),
                Arguments.of(parseNums(TEST_CASE8), EXPECTED8),
                Arguments.of(parseNums(TEST_CASE9), EXPECTED9),
                Arguments.of(parseNums(TEST_CASE10), EXPECTED10),
                Arguments.of(parseNums(TEST_CASE11), EXPECTED11),
                Arguments.of(parseNums(TEST_CASE12), EXPECTED12),
                Arguments.of(parseNums(TEST_CASE13), EXPECTED13),
                Arguments.of(parseNums(TEST_CASE14), EXPECTED14),
                Arguments.of(parseNums(TEST_CASE15), EXPECTED15),
                Arguments.of(parseNums(TEST_CASE16), EXPECTED16),
                Arguments.of(parseNums(TEST_CASE17), EXPECTED17)
        );
    }

    private static void internalTestCase(ZeroSumSubarray solution, int[] nums, boolean expected) {
        var result = solution.zeroSumSubarray(nums);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution1(int[] nums, boolean expected) {
        internalTestCase(new ZeroSumSubarray.Solution1(), nums, expected);
    }
}
