package com.algo.expert.recurtion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class PowersetTest {
    
    private static final String TEST_CASE1 = """
            {
              "array": [1, 2, 3],
              "expected": [
                [],
                [1],
                [2],
                [1, 2],
                [3],
                [1, 3],
                [2, 3],
                [1, 2, 3]
              ]
            }
            """;
    private static final String TEST_CASE2 = """
            {
              "array": [],
              "expected": [ [] ]
            }
            """;
    private static final String TEST_CASE3 = """
            {
              "array": [1],
              "expected": [
                [],
                [1]
              ]
            }
            """;
    private static final String TEST_CASE4 = """
            {
              "array": [1, 2],
              "expected": [
                [],
                [1],
                [2],
                [1, 2]
              ]
            }
            """;
    private static final String TEST_CASE5 = """
            {
              "array": [1, 2, 3, 4],
              "expected": [
                [],
                [1],
                [2],
                [1, 2],
                [3],
                [1, 3],
                [2, 3],
                [1, 2, 3],
                [4],
                [1, 4],
                [2, 4],
                [1, 2, 4],
                [3, 4],
                [1, 3, 4],
                [2, 3, 4],
                [1, 2, 3, 4]
              ]
            }
            """;
    private static final String TEST_CASE6 = """
            {
              "array": [1, 2, 3, 4, 5],
              "expected": [
                [],
                [1],
                [2],
                [1, 2],
                [3],
                [1, 3],
                [2, 3],
                [1, 2, 3],
                [4],
                [1, 4],
                [2, 4],
                [1, 2, 4],
                [3, 4],
                [1, 3, 4],
                [2, 3, 4],
                [1, 2, 3, 4],
                [5],
                [1, 5],
                [2, 5],
                [1, 2, 5],
                [3, 5],
                [1, 3, 5],
                [2, 3, 5],
                [1, 2, 3, 5],
                [4, 5],
                [1, 4, 5],
                [2, 4, 5],
                [1, 2, 4, 5],
                [3, 4, 5],
                [1, 3, 4, 5],
                [2, 3, 4, 5],
                [1, 2, 3, 4, 5]
              ]
            }
            """;
    private static final String TEST_CASE7 = """
            {
              "array": [1, 2, 3, 4, 5, 6],
              "expected": [
                [],
                [1],
                [2],
                [1, 2],
                [3],
                [1, 3],
                [2, 3],
                [1, 2, 3],
                [4],
                [1, 4],
                [2, 4],
                [1, 2, 4],
                [3, 4],
                [1, 3, 4],
                [2, 3, 4],
                [1, 2, 3, 4],
                [5],
                [1, 5],
                [2, 5],
                [1, 2, 5],
                [3, 5],
                [1, 3, 5],
                [2, 3, 5],
                [1, 2, 3, 5],
                [4, 5],
                [1, 4, 5],
                [2, 4, 5],
                [1, 2, 4, 5],
                [3, 4, 5],
                [1, 3, 4, 5],
                [2, 3, 4, 5],
                [1, 2, 3, 4, 5],
                [6],
                [1, 6],
                [2, 6],
                [1, 2, 6],
                [3, 6],
                [1, 3, 6],
                [2, 3, 6],
                [1, 2, 3, 6],
                [4, 6],
                [1, 4, 6],
                [2, 4, 6],
                [1, 2, 4, 6],
                [3, 4, 6],
                [1, 3, 4, 6],
                [2, 3, 4, 6],
                [1, 2, 3, 4, 6],
                [5, 6],
                [1, 5, 6],
                [2, 5, 6],
                [1, 2, 5, 6],
                [3, 5, 6],
                [1, 3, 5, 6],
                [2, 3, 5, 6],
                [1, 2, 3, 5, 6],
                [4, 5, 6],
                [1, 4, 5, 6],
                [2, 4, 5, 6],
                [1, 2, 4, 5, 6],
                [3, 4, 5, 6],
                [1, 3, 4, 5, 6],
                [2, 3, 4, 5, 6],
                [1, 2, 3, 4, 5, 6]
              ]
            }
            """;

    private void internalTestCaseSolution(Powerset soluion, List<Integer> array, List<List<Integer>> expected) {
        var result = soluion.powerset(array);
        sortResults(result);
        sortResults(expected);
        assertResultsEquals(expected, result);
    }

    private void sortResults(List<List<Integer>> results) {
        Collections.sort(results, new Comparator<>() {
            @Override
            public int compare(List<Integer> val1, List<Integer> val2) {
                var result = Integer.compare(val1.size(), val2.size());
                if (result != 0) return result;
                for (int i = 0; i < val1.size(); i++) {
                    result = val1.get(i).compareTo(val2.get(i));
                    if (result != 0) return result;
                }
                return 0;
            }
        });
    }

    private void assertResultsEquals(List<List<Integer>> expected, List<List<Integer>> result) {
        assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).size(), result.get(i).size());
            for (int j = 0; j < expected.get(i).size(); j++) {
                assertEquals(expected.get(i).get(j), result.get(i).get(j));
            }
        }
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution(List<Integer> array, List<List<Integer>> expected) {
        internalTestCaseSolution(new Powerset.Solution(), array, expected);
    }

    static List<Arguments> params() {
        return List.of(
            parseArguments(TEST_CASE1),
            parseArguments(TEST_CASE2),
            parseArguments(TEST_CASE3),
            parseArguments(TEST_CASE4),
            parseArguments(TEST_CASE5),
            parseArguments(TEST_CASE6),
            parseArguments(TEST_CASE7)
        );
    }

    private static Arguments parseArguments(String json) {
        var obj = new Gson().fromJson(json, JsonElement.class).getAsJsonObject();
        var array = parseArray(obj.get("array").getAsJsonArray());
        var expected = new ArrayList<List<Integer>>();
        for (JsonElement element : obj.get("expected").getAsJsonArray()) {
            expected.add(parseArray(element.getAsJsonArray()));
        }
        return Arguments.of(array, expected);
    }

    private static List<Integer> parseArray(JsonArray array) {
        var result = new ArrayList<Integer>();
        for (JsonElement element : array) {
            result.add(element.getAsInt());
        }
        return result;
    } 
}
