package com.algo.expert.binarysearchtrees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class RightSmallerThanTest {

    private static final String TEST_CASE1 = """
            {
              "array": [8, 5, 11, -1, 3, 4, 2],
              "expected": [5, 4, 4, 0, 1, 1, 0]
            }
            """;
    private static final String TEST_CASE2 = """
            {
              "array": [],
              "expected": []
            }
            """;
    private static final String TEST_CASE3 = """
            {
              "array": [1],
              "expected": [0]
            }
            """;
    private static final String TEST_CASE4 = """
            {
              "array": [0, 1, 1, 2, 3, 5, 8, 13],
              "expected": [0, 0, 0, 0, 0, 0, 0, 0]
            }
            """;
    private static final String TEST_CASE5 = """
            {
              "array": [13, 8, 5, 3, 2, 1, 1, 0],
              "expected": [7,6, 5, 4, 3, 1, 1, 0]
            }
            """;
    private static final String TEST_CASE6 = """
            {
              "array": [8, 5, 2, 9, 5, 6, 3],
              "expected": [5, 2, 0, 3, 1, 1, 0]
            }
            """;
    private static final String TEST_CASE7 = """
            {
              "array": [991, -731, -882, 100, 280, -43, 432, 771, -581, 180, -382, -998, 847, 80, -220, 680, 769, -75, -817, 366, 956, 749, 471, 228, -435, -269, 652, -331, -387, -657, -255, 382, -216, -6, -163, -681, 980, 913, -169, 972, -523, 354, 747, 805, 382, -827, -796, 372, 753, 519, 906],
              "expected": [50, 5, 1, 22, 24, 19, 28, 36, 6, 20, 9, 0, 33, 17, 11, 25, 28, 14, 1, 16, 28, 23, 19, 14, 5, 7, 17, 6, 5, 3, 4, 10, 4, 6, 5, 2, 14, 12, 3, 11, 2, 2, 5, 6, 3, 0, 0, 0, 1, 0, 0]
            }
            """;
    private static final String TEST_CASE8 = """
            {
              "array": [384, -67, 120, 759, 697, 232, -7, -557, -772, -987, 687, 397, -763, -86, -491, 947, 921, 421, 825, -679, 946, -562, -626, -898, 204, 776, -343, 393, 51, -796, -425, 31, 165, 975, -720, 878, -785, -367, -609, 662, -79, -112, -313, -94, 187, 260, 43, 85, -746, 612, 67, -389, 508, 777, 624, 993, -581, 34, 444, -544, 243, -995, 432, -755, -978, 515, -68, -559, 489, 732, -19, -489, 737, 924],
              "expected": [47, 31, 39, 60, 57, 42, 32, 17, 6, 1, 51, 41, 5, 24, 15, 56, 53, 38, 50, 8, 51, 11, 8, 2, 30, 43, 15, 31, 24, 2, 11, 19, 23, 39, 5, 36, 2, 10, 4, 29, 12, 10, 9, 9, 15, 16, 12, 13, 3, 18, 11, 7, 14, 18, 15, 18, 3, 8, 10, 4, 7, 0, 6, 1, 0, 5, 2, 0, 2, 2, 1, 0, 0, 0]
            }
            """;
    private static final String TEST_CASE9 = """
            {
              "array": [-823, 164, 48, -987, 323, 399, -293, 183, -908, -376, 14, 980, 965, 842, 422, 829, 59, 724, -415, -733, 356, -855, -155, 52, 328, -544, -371, -160, -942, -51, 700, -363, -353, -359, 238, 892, -730, -575, 892, 490, 490, 995, 572, 888, -935, 919, -191, 646, -120, 125, -817, 341, -575, 372, -874, 243, 610, -36, -685, -337, -13, 295, 800, -950, -949, -257, 631, -542, 201, -796, 157, 950, 540, -846, -265, 746, 355, -578, -441, -254, -941, -738, -469, -167, -420, -126, -410, 59],
              "expected": [10, 52, 46, 0, 55, 60, 31, 49, 5, 24, 41, 75, 74, 68, 55, 66, 42, 62, 22, 11, 50, 6, 32, 37, 44, 15, 20, 29, 2, 30, 49, 19, 20, 19, 33, 48, 9, 11, 46, 36, 36, 46, 37, 42, 3, 41, 20, 37, 22, 25, 5, 28, 9, 28, 3, 24, 27, 19, 6, 12, 17, 20, 24, 0, 0, 11, 19, 5, 15, 2, 13, 16, 14, 1, 7, 12, 11, 2, 3, 5, 0, 0, 0, 2, 0, 1, 0, 0]
            }
            """;
    
    private void internalTestCaseSolution(RightSmallerThan solution, List<Integer> array, List<Integer> expected) {
        var result = solution.rightSmallerThan(array);
        assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution(List<Integer> array, List<Integer> expected) {
        internalTestCaseSolution(new RightSmallerThan.Solution(), array, expected);
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
            parseArguments(TEST_CASE9)
        );
    }

    private static Arguments parseArguments(String json) {
        var obj = new Gson().fromJson(json, JsonElement.class).getAsJsonObject();
        var array = parseArray(obj.get("array").getAsJsonArray());
        var expected = parseArray(obj.get("expected").getAsJsonArray());
        return Arguments.of(array, expected);
    }

    private static List<Integer> parseArray(JsonArray array) {
        var result = new ArrayList<Integer>(array.size());
        for (JsonElement element : array) {
            result.add(element.getAsInt());
        }
        return result;
    }
}
