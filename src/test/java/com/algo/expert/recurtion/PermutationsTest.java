package com.algo.expert.recurtion;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class PermutationsTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"array\": [1, 2, 3]\n" +
            "}";
    private static final String EXPECTED1 = "[\n" +
            "  [1, 2, 3],\n" +
            "  [1, 3, 2],\n" +
            "  [2, 1, 3],\n" +
            "  [2, 3, 1],\n" +
            "  [3, 1, 2],\n" +
            "  [3, 2, 1]\n" +
            "]";
    private static final String TEST_CASE2 = "{\n" +
            "  \"array\": []\n" +
            "}";
    private static final String EXPECTED2 = "[]";
    private static final String TEST_CASE3 = "{\n" +
            "  \"array\": [1]\n" +
            "}";
    private static final String EXPECTED3 = "[\n" +
            "  [1]\n" +
            "]";
    private static final String TEST_CASE4 = "{\n" +
            "  \"array\": [1, 2]\n" +
            "}";
    private static final String EXPECTED4 = "[\n" +
            "  [1, 2],\n" +
            "  [2, 1]\n" +
            "]";
    private static final String TEST_CASE5 = "{\n" +
            "  \"array\": [1, 2, 3, 4]\n" +
            "}";
    private static final String EXPECTED5 = "[\n" +
            "  [1, 2, 3, 4],\n" +
            "  [1, 2, 4, 3],\n" +
            "  [1, 3, 2, 4],\n" +
            "  [1, 3, 4, 2],\n" +
            "  [1, 4, 2, 3],\n" +
            "  [1, 4, 3, 2],\n" +
            "  [2, 1, 3, 4],\n" +
            "  [2, 1, 4, 3],\n" +
            "  [2, 3, 1, 4],\n" +
            "  [2, 3, 4, 1],\n" +
            "  [2, 4, 1, 3],\n" +
            "  [2, 4, 3, 1],\n" +
            "  [3, 1, 2, 4],\n" +
            "  [3, 1, 4, 2],\n" +
            "  [3, 2, 1, 4],\n" +
            "  [3, 2, 4, 1],\n" +
            "  [3, 4, 1, 2],\n" +
            "  [3, 4, 2, 1],\n" +
            "  [4, 1, 2, 3],\n" +
            "  [4, 1, 3, 2],\n" +
            "  [4, 2, 1, 3],\n" +
            "  [4, 2, 3, 1],\n" +
            "  [4, 3, 1, 2],\n" +
            "  [4, 3, 2, 1]\n" +
            "]";
    private static final String TEST_CASE6 = "{\n" +
            "  \"array\": [1, 2, 3, 4, 5]\n" +
            "}";
    private static final String EXPECTED6 = "[\n" +
            "  [1, 2, 3, 4, 5],\n" +
            "  [1, 2, 3, 5, 4],\n" +
            "  [1, 2, 4, 3, 5],\n" +
            "  [1, 2, 4, 5, 3],\n" +
            "  [1, 2, 5, 3, 4],\n" +
            "  [1, 2, 5, 4, 3],\n" +
            "  [1, 3, 2, 4, 5],\n" +
            "  [1, 3, 2, 5, 4],\n" +
            "  [1, 3, 4, 2, 5],\n" +
            "  [1, 3, 4, 5, 2],\n" +
            "  [1, 3, 5, 2, 4],\n" +
            "  [1, 3, 5, 4, 2],\n" +
            "  [1, 4, 2, 3, 5],\n" +
            "  [1, 4, 2, 5, 3],\n" +
            "  [1, 4, 3, 2, 5],\n" +
            "  [1, 4, 3, 5, 2],\n" +
            "  [1, 4, 5, 2, 3],\n" +
            "  [1, 4, 5, 3, 2],\n" +
            "  [1, 5, 2, 3, 4],\n" +
            "  [1, 5, 2, 4, 3],\n" +
            "  [1, 5, 3, 2, 4],\n" +
            "  [1, 5, 3, 4, 2],\n" +
            "  [1, 5, 4, 2, 3],\n" +
            "  [1, 5, 4, 3, 2],\n" +
            "  [2, 1, 3, 4, 5],\n" +
            "  [2, 1, 3, 5, 4],\n" +
            "  [2, 1, 4, 3, 5],\n" +
            "  [2, 1, 4, 5, 3],\n" +
            "  [2, 1, 5, 3, 4],\n" +
            "  [2, 1, 5, 4, 3],\n" +
            "  [2, 3, 1, 4, 5],\n" +
            "  [2, 3, 1, 5, 4],\n" +
            "  [2, 3, 4, 1, 5],\n" +
            "  [2, 3, 4, 5, 1],\n" +
            "  [2, 3, 5, 1, 4],\n" +
            "  [2, 3, 5, 4, 1],\n" +
            "  [2, 4, 1, 3, 5],\n" +
            "  [2, 4, 1, 5, 3],\n" +
            "  [2, 4, 3, 1, 5],\n" +
            "  [2, 4, 3, 5, 1],\n" +
            "  [2, 4, 5, 1, 3],\n" +
            "  [2, 4, 5, 3, 1],\n" +
            "  [2, 5, 1, 3, 4],\n" +
            "  [2, 5, 1, 4, 3],\n" +
            "  [2, 5, 3, 1, 4],\n" +
            "  [2, 5, 3, 4, 1],\n" +
            "  [2, 5, 4, 1, 3],\n" +
            "  [2, 5, 4, 3, 1],\n" +
            "  [3, 1, 2, 4, 5],\n" +
            "  [3, 1, 2, 5, 4],\n" +
            "  [3, 1, 4, 2, 5],\n" +
            "  [3, 1, 4, 5, 2],\n" +
            "  [3, 1, 5, 2, 4],\n" +
            "  [3, 1, 5, 4, 2],\n" +
            "  [3, 2, 1, 4, 5],\n" +
            "  [3, 2, 1, 5, 4],\n" +
            "  [3, 2, 4, 1, 5],\n" +
            "  [3, 2, 4, 5, 1],\n" +
            "  [3, 2, 5, 1, 4],\n" +
            "  [3, 2, 5, 4, 1],\n" +
            "  [3, 4, 1, 2, 5],\n" +
            "  [3, 4, 1, 5, 2],\n" +
            "  [3, 4, 2, 1, 5],\n" +
            "  [3, 4, 2, 5, 1],\n" +
            "  [3, 4, 5, 1, 2],\n" +
            "  [3, 4, 5, 2, 1],\n" +
            "  [3, 5, 1, 2, 4],\n" +
            "  [3, 5, 1, 4, 2],\n" +
            "  [3, 5, 2, 1, 4],\n" +
            "  [3, 5, 2, 4, 1],\n" +
            "  [3, 5, 4, 1, 2],\n" +
            "  [3, 5, 4, 2, 1],\n" +
            "  [4, 1, 2, 3, 5],\n" +
            "  [4, 1, 2, 5, 3],\n" +
            "  [4, 1, 3, 2, 5],\n" +
            "  [4, 1, 3, 5, 2],\n" +
            "  [4, 1, 5, 2, 3],\n" +
            "  [4, 1, 5, 3, 2],\n" +
            "  [4, 2, 1, 3, 5],\n" +
            "  [4, 2, 1, 5, 3],\n" +
            "  [4, 2, 3, 1, 5],\n" +
            "  [4, 2, 3, 5, 1],\n" +
            "  [4, 2, 5, 1, 3],\n" +
            "  [4, 2, 5, 3, 1],\n" +
            "  [4, 3, 1, 2, 5],\n" +
            "  [4, 3, 1, 5, 2],\n" +
            "  [4, 3, 2, 1, 5],\n" +
            "  [4, 3, 2, 5, 1],\n" +
            "  [4, 3, 5, 1, 2],\n" +
            "  [4, 3, 5, 2, 1],\n" +
            "  [4, 5, 1, 2, 3],\n" +
            "  [4, 5, 1, 3, 2],\n" +
            "  [4, 5, 2, 1, 3],\n" +
            "  [4, 5, 2, 3, 1],\n" +
            "  [4, 5, 3, 1, 2],\n" +
            "  [4, 5, 3, 2, 1],\n" +
            "  [5, 1, 2, 3, 4],\n" +
            "  [5, 1, 2, 4, 3],\n" +
            "  [5, 1, 3, 2, 4],\n" +
            "  [5, 1, 3, 4, 2],\n" +
            "  [5, 1, 4, 2, 3],\n" +
            "  [5, 1, 4, 3, 2],\n" +
            "  [5, 2, 1, 3, 4],\n" +
            "  [5, 2, 1, 4, 3],\n" +
            "  [5, 2, 3, 1, 4],\n" +
            "  [5, 2, 3, 4, 1],\n" +
            "  [5, 2, 4, 1, 3],\n" +
            "  [5, 2, 4, 3, 1],\n" +
            "  [5, 3, 1, 2, 4],\n" +
            "  [5, 3, 1, 4, 2],\n" +
            "  [5, 3, 2, 1, 4],\n" +
            "  [5, 3, 2, 4, 1],\n" +
            "  [5, 3, 4, 1, 2],\n" +
            "  [5, 3, 4, 2, 1],\n" +
            "  [5, 4, 1, 2, 3],\n" +
            "  [5, 4, 1, 3, 2],\n" +
            "  [5, 4, 2, 1, 3],\n" +
            "  [5, 4, 2, 3, 1],\n" +
            "  [5, 4, 3, 1, 2],\n" +
            "  [5, 4, 3, 2, 1]\n" +
            "]";

    private void internalTestCases(Permutations impl, List<Integer> array, List<List<Integer>> expected) {
        List<List<Integer>> result = impl.getPermutations(array);
        assertListEquals(expected, result);
    }

    private void assertListEquals(List<?> expected, List<?> actual) {
        Assertions.assertEquals(expected.size(), actual.size());
        for (int index = 0; index < expected.size(); index++) {
            Object itemExpected = expected.get(index);
            Object itemActual = actual.get(index);
            if (itemExpected instanceof List) {
                Assertions.assertInstanceOf(List.class, itemActual);
                assertListEquals((List<?>) itemExpected, (List<?>) itemActual);
            } else {
                Assertions.assertEquals(itemExpected, itemActual);
            }
        }
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCases(List<Integer> array, List<List<Integer>> expected) {
        internalTestCases(new Permutations.Solution1(), array, expected);
    }

    static List<Arguments> params() {
        return List.of(
                parseArguments(TEST_CASE1, EXPECTED1),
                parseArguments(TEST_CASE2, EXPECTED2),
                parseArguments(TEST_CASE3, EXPECTED3),
                parseArguments(TEST_CASE4, EXPECTED4),
                parseArguments(TEST_CASE5, EXPECTED5),
                parseArguments(TEST_CASE6, EXPECTED6)
        );
    }

    static Arguments parseArguments(String testCase, String expected) {
        JsonArray jsonArray = new Gson().fromJson(testCase, JsonElement.class)
                .getAsJsonObject().getAsJsonArray("array");
        List<Integer> array = new ArrayList<>();
        for (JsonElement item : jsonArray) {
            array.add(item.getAsInt());
        }
        JsonArray jsonExpected = new Gson().fromJson(expected, JsonElement.class).getAsJsonArray();
        List<List<Integer>> permutations = new ArrayList<>();
        for (JsonElement item : jsonExpected) {
            List<Integer> permutation = new ArrayList<>();
            for (JsonElement value : item.getAsJsonArray()) {
                permutation.add(value.getAsInt());
            }
            permutations.add(permutation);
        }
        return Arguments.of(array, permutations);
    }
}
