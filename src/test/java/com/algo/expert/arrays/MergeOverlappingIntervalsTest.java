package com.algo.expert.arrays;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class MergeOverlappingIntervalsTest {

    private static final String TEST_CASE1 = "[\n" +
            "    [1, 2],\n" +
            "    [3, 5],\n" +
            "    [4, 7],\n" +
            "    [6, 8],\n" +
            "    [9, 10]\n" +
            "  ]";
    private static final String EXPECTED1 = "[\n" +
            "  [1, 2],\n" +
            "  [3, 8],\n" +
            "  [9, 10]\n" +
            "]";
    private static final String TEST_CASE2 = "[\n" +
            "    [1, 3],\n" +
            "    [2, 8],\n" +
            "    [9, 10]\n" +
            "  ]";
    private static final String EXPECTED2 = "[\n" +
            "  [1, 8],\n" +
            "  [9, 10]\n" +
            "]";
    private static final String TEST_CASE3 = "[\n" +
            "    [1, 10],\n" +
            "    [10, 20],\n" +
            "    [20, 30],\n" +
            "    [30, 40],\n" +
            "    [40, 50],\n" +
            "    [50, 60],\n" +
            "    [60, 70],\n" +
            "    [70, 80],\n" +
            "    [80, 90],\n" +
            "    [90, 100]\n" +
            "  ]";
    private static final String EXPECTED3 = "[\n" +
            "  [1, 100]\n" +
            "]";
    private static final String TEST_CASE4 = "[\n" +
            "    [1, 10],\n" +
            "    [11, 20],\n" +
            "    [21, 30],\n" +
            "    [31, 40],\n" +
            "    [41, 50],\n" +
            "    [51, 60],\n" +
            "    [61, 70],\n" +
            "    [71, 80],\n" +
            "    [81, 90],\n" +
            "    [91, 100]\n" +
            "  ]";
    private static final String EXPECTED4 = "[\n" +
            "  [1, 10],\n" +
            "  [11, 20],\n" +
            "  [21, 30],\n" +
            "  [31, 40],\n" +
            "  [41, 50],\n" +
            "  [51, 60],\n" +
            "  [61, 70],\n" +
            "  [71, 80],\n" +
            "  [81, 90],\n" +
            "  [91, 100]\n" +
            "]";
    private static final String TEST_CASE5 = "[\n" +
            "    [100, 105],\n" +
            "    [1, 104]\n" +
            "  ]";
    private static final String EXPECTED5 = "[\n" +
            "  [1, 105]\n" +
            "]";
    private static final String TEST_CASE6 = "[\n" +
            "    [89, 90],\n" +
            "    [-10, 20],\n" +
            "    [-50, 0],\n" +
            "    [70, 90],\n" +
            "    [90, 91],\n" +
            "    [90, 95]\n" +
            "  ]";
    private static final String EXPECTED6 = "[\n" +
            "  [-50, 20],\n" +
            "  [70, 95]\n" +
            "]";
    private static final String TEST_CASE7 = "[\n" +
            "    [-5, -4],\n" +
            "    [-4, -3],\n" +
            "    [-3, -2],\n" +
            "    [-2, -1],\n" +
            "    [-1, 0]\n" +
            "  ]";
    private static final String EXPECTED7 = "[\n" +
            "  [-5, 0]\n" +
            "]";
    private static final String TEST_CASE8 = "[\n" +
            "    [43, 49],\n" +
            "    [9, 12],\n" +
            "    [12, 54],\n" +
            "    [45, 90],\n" +
            "    [91, 93]\n" +
            "  ]";
    private static final String EXPECTED8 = "[\n" +
            "  [9, 90],\n" +
            "  [91, 93]\n" +
            "]";
    private static final String TEST_CASE9 = "[\n" +
            "    [0, 0],\n" +
            "    [0, 0],\n" +
            "    [0, 0],\n" +
            "    [0, 0],\n" +
            "    [0, 0],\n" +
            "    [0, 0],\n" +
            "    [0, 0]\n" +
            "  ]";
    private static final String EXPECTED9 = "[\n" +
            "  [0, 0]\n" +
            "]";
    private static final String TEST_CASE10 = "[\n" +
            "    [0, 0],\n" +
            "    [0, 0],\n" +
            "    [0, 0],\n" +
            "    [0, 0],\n" +
            "    [0, 0],\n" +
            "    [0, 0],\n" +
            "    [0, 1]\n" +
            "  ]";
    private static final String EXPECTED10 = "[\n" +
            "  [0, 1]\n" +
            "]";
    private static final String TEST_CASE11 = "[\n" +
            "    [1, 22],\n" +
            "    [-20, 30]\n" +
            "  ]";
    private static final String EXPECTED11 = "[\n" +
            "  [-20, 30]\n" +
            "]";
    private static final String TEST_CASE12 = "[\n" +
            "    [20, 21],\n" +
            "    [22, 23],\n" +
            "    [0, 1],\n" +
            "    [3, 4],\n" +
            "    [23, 24],\n" +
            "    [25, 27],\n" +
            "    [5, 6],\n" +
            "    [7, 19]\n" +
            "  ]";
    private static final String EXPECTED12 = "[\n" +
            "  [0, 1],\n" +
            "  [3, 4],\n" +
            "  [5, 6],\n" +
            "  [7, 19],\n" +
            "  [20, 21],\n" +
            "  [22, 24],\n" +
            "  [25, 27]\n" +
            "]";
    private static final String TEST_CASE13 = "[\n" +
            "    [2, 3],\n" +
            "    [4, 5],\n" +
            "    [6, 7],\n" +
            "    [8, 9],\n" +
            "    [1, 10]\n" +
            "  ]";
    private static final String EXPECTED13 = "[\n" +
            "  [1, 10]\n" +
            "]";

    @ParameterizedTest
    @MethodSource("params")
    void testCases(int[][] intervals, int[][] expected) {
        int[][] result = MergeOverlappingIntervals.mergeOverlappingIntervals(intervals);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertArrayEquals(expected[i], result[i]);
        }
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(parseDoubleArray(TEST_CASE1), parseDoubleArray(EXPECTED1)),
                Arguments.of(parseDoubleArray(TEST_CASE2), parseDoubleArray(EXPECTED2)),
                Arguments.of(parseDoubleArray(TEST_CASE3), parseDoubleArray(EXPECTED3)),
                Arguments.of(parseDoubleArray(TEST_CASE4), parseDoubleArray(EXPECTED4)),
                Arguments.of(parseDoubleArray(TEST_CASE5), parseDoubleArray(EXPECTED5)),
                Arguments.of(parseDoubleArray(TEST_CASE6), parseDoubleArray(EXPECTED6)),
                Arguments.of(parseDoubleArray(TEST_CASE7), parseDoubleArray(EXPECTED7)),
                Arguments.of(parseDoubleArray(TEST_CASE8), parseDoubleArray(EXPECTED8)),
                Arguments.of(parseDoubleArray(TEST_CASE9), parseDoubleArray(EXPECTED9)),
                Arguments.of(parseDoubleArray(TEST_CASE10), parseDoubleArray(EXPECTED10)),
                Arguments.of(parseDoubleArray(TEST_CASE11), parseDoubleArray(EXPECTED11)),
                Arguments.of(parseDoubleArray(TEST_CASE12), parseDoubleArray(EXPECTED12)),
                Arguments.of(parseDoubleArray(TEST_CASE13), parseDoubleArray(EXPECTED13))
        );
    }

    static int[][] parseDoubleArray(String json) {
        int[][] result;

        JsonArray array = new Gson().fromJson(json, JsonArray.class);
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
