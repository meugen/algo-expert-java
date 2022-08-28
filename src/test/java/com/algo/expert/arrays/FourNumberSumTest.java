package com.algo.expert.arrays;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class FourNumberSumTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"array\": [7, 6, 4, -1, 1, 2],\n" +
            "  \"targetSum\": 16\n" +
            "}";
    private static final String TEST_CASE2 = "{\n" +
            "  \"array\": [1, 2, 3, 4, 5, 6, 7],\n" +
            "  \"targetSum\": 10\n" +
            "}";
    private static final String TEST_CASE3 = "{\n" +
            "  \"array\": [5, -5, -2, 2, 3, -3],\n" +
            "  \"targetSum\": 0\n" +
            "}";
    private static final String TEST_CASE4 = "{\n" +
            "  \"array\": [-2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9],\n" +
            "  \"targetSum\": 4\n" +
            "}";
    private static final String TEST_CASE5 = "{\n" +
            "  \"array\": [-1, 22, 18, 4, 7, 11, 2, -5, -3],\n" +
            "  \"targetSum\": 30\n" +
            "}";
    private static final String TEST_CASE6 = "{\n" +
            "  \"array\": [-10, -3, -5, 2, 15, -7, 28, -6, 12, 8, 11, 5],\n" +
            "  \"targetSum\": 20\n" +
            "}";
    private static final String TEST_CASE7 = "{\n" +
            "  \"array\": [1, 2, 3, 4, 5],\n" +
            "  \"targetSum\": 100\n" +
            "}";
    private static final String TEST_CASE8 = "{\n" +
            "  \"array\": [1, 2, 3, 4, 5, -5, 6, -6],\n" +
            "  \"targetSum\": 5\n" +
            "}";

    @ParameterizedTest
    @MethodSource("params")
    void testCases(TestCase testCase, int expectedSize) {
        List<Integer[]> result = FourNumberSum.fourNumberSum(testCase.array, testCase.targetSum);
        Assertions.assertEquals(expectedSize, result.size());
        for (Integer[] item : result) {
            Assertions.assertEquals(4, item.length);
            int sum = 0;
            for (Integer value : item) {
                sum += value;
            }
            Assertions.assertEquals(testCase.targetSum, sum);
        }
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(parseTestCase(TEST_CASE1), 2),
                Arguments.of(parseTestCase(TEST_CASE2), 1),
                Arguments.of(parseTestCase(TEST_CASE3), 3),
                Arguments.of(parseTestCase(TEST_CASE4), 4),
                Arguments.of(parseTestCase(TEST_CASE5), 5),
                Arguments.of(parseTestCase(TEST_CASE6), 7),
                Arguments.of(parseTestCase(TEST_CASE7), 0),
                Arguments.of(parseTestCase(TEST_CASE8), 6)
        );
    }

    static TestCase parseTestCase(String json) {
        JsonObject object = new Gson().fromJson(json, JsonElement.class).getAsJsonObject();
        JsonArray jsonArray = object.getAsJsonArray("array");
        int[] array = new int[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            array[i] = jsonArray.get(i).getAsInt();
        }
        int targetSum = object.getAsJsonPrimitive("targetSum").getAsInt();
        return new TestCase(array, targetSum);
    }

    static class TestCase {
        final int[] array;
        final int targetSum;

        public TestCase(int[] array, int targetSum) {
            this.array = array;
            this.targetSum = targetSum;
        }
    }
}
