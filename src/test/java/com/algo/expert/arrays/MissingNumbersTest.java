package com.algo.expert.arrays;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class MissingNumbersTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"nums\": []\n" +
            "}";
    private static final int[] EXPECTED1 = new int[] {1, 2};

    private static final String TEST_CASE2 = "{\n" +
            "  \"nums\": [1]\n" +
            "}";
    private static final int[] EXPECTED2 = new int[] {2, 3};

    private static final String TEST_CASE3 = "{\n" +
            "  \"nums\": [2]\n" +
            "}";
    private static final int[] EXPECTED3 = new int[] {1, 3};

    private static final String TEST_CASE4 = "{\n" +
            "  \"nums\": [3]\n" +
            "}";
    private static final int[] EXPECTED4 = new int[] {1, 2};

    private static final String TEST_CASE5 = "{\n" +
            "  \"nums\": [1, 3]\n" +
            "}";
    private static final int[] EXPECTED5 = new int[] {2, 4};

    private static final String TEST_CASE6 = "{\n" +
            "  \"nums\": [3, 1]\n" +
            "}";
    private static final int[] EXPECTED6 = new int[] {2, 4};

    private static final String TEST_CASE7 = "{\n" +
            "  \"nums\": [1, 2, 3]\n" +
            "}";
    private static final int[] EXPECTED7 = new int[] {4, 5};

    private static final String TEST_CASE8 = "{\n" +
            "  \"nums\": [3, 2, 1]\n" +
            "}";
    private static final int[] EXPECTED8 = new int[] {4, 5};

    private static final String TEST_CASE9 = "{\n" +
            "  \"nums\": [3, 1, 2]\n" +
            "}";
    private static final int[] EXPECTED9 = new int[] {4, 5};

    private static final String TEST_CASE10 = "{\n" +
            "  \"nums\": [3, 4, 5]\n" +
            "}";
    private static final int[] EXPECTED10 = new int[] {1, 2};

    private static final String TEST_CASE11 = "{\n" +
            "  \"nums\": [4, 5, 3]\n" +
            "}";
    private static final int[] EXPECTED11 = new int[] {1, 2};

    private static final String TEST_CASE12 = "{\n" +
            "  \"nums\": [1, 3, 4, 5]\n" +
            "}";
    private static final int[] EXPECTED12 = new int[] {2, 6};

    private static final String TEST_CASE13 = "{\n" +
            "  \"nums\": [4, 5, 1, 3]\n" +
            "}";
    private static final int[] EXPECTED13 = new int[] {2, 6};

    private static final String TEST_CASE14 = "{\n" +
            "  \"nums\": [1, 2, 4, 5, 7]\n" +
            "}";
    private static final int[] EXPECTED14 = new int[] {3, 6};

    private static final String TEST_CASE15 = "{\n" +
            "  \"nums\": [1, 2, 7, 5, 4]\n" +
            "}";
    private static final int[] EXPECTED15 = new int[] {3, 6};

    private static final String TEST_CASE16 = "{\n" +
            "  \"nums\": [1, 2, 3, 4, 5, 6, 7]\n" +
            "}";
    private static final int[] EXPECTED16 = new int[] {8, 9};

    private static final String TEST_CASE17 = "{\n" +
            "  \"nums\": [7, 6, 5, 4, 3, 2, 1]\n" +
            "}";
    private static final int[] EXPECTED17 = new int[] {8, 9};

    private static final String TEST_CASE18 = "{\n" +
            "  \"nums\": [3, 5, 1, 2, 4, 7, 6]\n" +
            "}";
    private static final int[] EXPECTED18 = new int[] {8, 9};

    private static final String TEST_CASE19 = "{\n" +
            "  \"nums\": [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 18, 20, 21, 22]\n" +
            "}";
    private static final int[] EXPECTED19 = new int[] {14, 19};

    private static final String TEST_CASE20 = "{\n" +
            "  \"nums\": [3, 5, 7, 8, 1, 10, 11, 2, 4, 13, 17, 22, 18, 21, 16, 20, 6, 9, 15, 12]\n" +
            "}";
    private static final int[] EXPECTED20 = new int[] {14, 19};

    private static final String TEST_CASE21 = "{\n" +
            "  \"nums\": [3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22]\n" +
            "}";
    private static final int[] EXPECTED21 = new int[] {1, 2};

    private static final String TEST_CASE22 = "{\n" +
            "  \"nums\": [14, 15, 16, 17, 18, 19, 20, 21, 22, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]\n" +
            "}";
    private static final int[] EXPECTED22 = new int[] {1, 2};

    private static final String TEST_CASE23 = "{\n" +
            "  \"nums\": [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22]\n" +
            "}";
    private static final int[] EXPECTED23 = new int[] {23, 24};

    private static final String TEST_CASE24 = "{\n" +
            "  \"nums\": [11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]\n" +
            "}";
    private static final int[] EXPECTED24 = new int[] {23, 24};

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
                Arguments.of(parseNums(TEST_CASE17), EXPECTED17),
                Arguments.of(parseNums(TEST_CASE18), EXPECTED18),
                Arguments.of(parseNums(TEST_CASE19), EXPECTED19),
                Arguments.of(parseNums(TEST_CASE20), EXPECTED20),
                Arguments.of(parseNums(TEST_CASE21), EXPECTED21),
                Arguments.of(parseNums(TEST_CASE22), EXPECTED22),
                Arguments.of(parseNums(TEST_CASE23), EXPECTED23),
                Arguments.of(parseNums(TEST_CASE24), EXPECTED24)
        );
    }

    private static void internalTestCase(MissingNumbers solution, int[] nums, int[] expected) {
        var result = solution.missingNumbers(nums);
        Assertions.assertArrayEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution1(int[] nums, int[] expected) {
        internalTestCase(new MissingNumbers.Solution1(), nums, expected);
    }
}
