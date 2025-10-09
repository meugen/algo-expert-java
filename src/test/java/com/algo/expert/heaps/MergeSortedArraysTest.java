package com.algo.expert.heaps;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedArraysTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"arrays\": [\n" +
            "    [1, 5, 9, 21],\n" +
            "    [-1, 0],\n" +
            "    [-124, 81, 121],\n" +
            "    [3, 6, 12, 20, 150]\n" +
            "  ]\n" +
            "}";
    private static final String EXPECTED1 = "[-124, -1, 0, 1, 3, 5, 6, 9, 12, 20, 21, 81, 121, 150]";

    private static final String TEST_CASE2 = "{\n" +
            "  \"arrays\": [\n" +
            "    [-92, -78, -68, 43, 46, 46, 79, 79],\n" +
            "    [-66, -49, -26, -16, 21, 28, 33, 50],\n" +
            "    [-40, -8, 12, 20, 36, 38, 81],\n" +
            "    [-76, -74, -62, -46, -23, 33, 42, 48, 55, 94]\n" +
            "  ]\n" +
            "}";
    private static final String EXPECTED2 = "[-92, -78, -76, -74, -68, -66, -62, -49, -46, -40, -26, -23, -16, -8, 12, 20, 21, 28, 33, 33, 36, 38, 42, 43, 46, 46, 48, 50, 55, 79, 79, 81, 94]";

    private static final String TEST_CASE3 = "{\n" +
            "  \"arrays\": [\n" +
            "    [-95, -74, 1],\n" +
            "    [-28, 28, 95],\n" +
            "    [-89, -78, -67, -66, -25, -22, 2, 38],\n" +
            "    [-86, -35, -25, -13, 41],\n" +
            "    [-85, -77, -21, 72],\n" +
            "    [-55, 4, 84, 98],\n" +
            "    [-75, -73, 22]\n" +
            "  ]\n" +
            "}";
    private static final String EXPECTED3 = "[-95, -89, -86, -85, -78, -77, -75, -74, -73, -67, -66, -55, -35, -28, -25, -25, -22, -21, -13, 1, 2, 4, 22, 28, 38, 41, 72, 84, 95, 98]";

    private static final String TEST_CASE4 = "{\n" +
            "  \"arrays\": [\n" +
            "    [-79, -43, -15, 89],\n" +
            "    [-48, 13, 20],\n" +
            "    [-33, -19, -8, 12, 40, 44, 50, 52, 91, 95],\n" +
            "    [-100, -43, -8, 17],\n" +
            "    [-15, 81]\n" +
            "  ]\n" +
            "}";
    private static final String EXPECTED4 = "[-100, -79, -48, -43, -43, -33, -19, -15, -15, -8, -8, 12, 13, 17, 20, 40, 44, 50, 52, 81, 89, 91, 95]";

    private static final String TEST_CASE5 = "{\n" +
            "  \"arrays\": [\n" +
            "    [-88, -56, -43, -41, -13, -8, 82],\n" +
            "    [-38, 53],\n" +
            "    [-75, -48, -42, -27, 20, 35, 55],\n" +
            "    [-55, -50, -48, -45, 62, 69, 77],\n" +
            "    [-90, -27, -22, -19, -6, -3, 4, 6, 91],\n" +
            "    [-86, -67, -66, 2, 8, 8, 39, 74],\n" +
            "    [-62, 34, 40, 42, 47, 48, 55, 56, 68, 87]\n" +
            "  ]\n" +
            "}";
    private static final String EXPECTED5 = "[-90, -88, -86, -75, -67, -66, -62, -56, -55, -50, -48, -48, -45, -43, -42, -41, -38, -27, -27, -22, -19, -13, -8, -6, -3, 2, 4, 6, 8, 8, 20, 34, 35, 39, 40, 42, 47, 48, 53, 55, 55, 56, 62, 68, 69, 74, 77, 82, 87, 91]";

    private static final String TEST_CASE6 = "{\n" +
            "  \"arrays\": [\n" +
            "    [-93, -83, -43, -32, -32, -15, -14, 12, 78, 80],\n" +
            "    [-83],\n" +
            "    [-82, -51, -29, 40, 60, 76, 80],\n" +
            "    [50],\n" +
            "    [-33, -16],\n" +
            "    [-100],\n" +
            "    [-33, -11, 23, 29, 29, 43],\n" +
            "    [0, 70],\n" +
            "    [-57, -43, -41, -18, -5, 74]\n" +
            "  ]\n" +
            "}";
    private static final String EXPECTED6 = "[-100, -93, -83, -83, -82, -57, -51, -43, -43, -41, -33, -33, -32, -32, -29, -18, -16, -15, -14, -11, -5, 0, 12, 23, 29, 29, 40, 43, 50, 60, 70, 74, 76, 78, 80, 80]";

    private static final String TEST_CASE7 = "{\n" +
            "  \"arrays\": [\n" +
            "    [98],\n" +
            "    [-87, -79, -56, -33, -20, -10, -5, 19, 49, 86],\n" +
            "    [-73, -49],\n" +
            "    [-98, -63, -47, -4, 21],\n" +
            "    [-56, -43, -24, 8, 34, 80, 83],\n" +
            "    [-83, -65, -61, -30, -26, -16, 16, 19],\n" +
            "    [-91, -42, -21, 91],\n" +
            "    [-73, -62, -56, -30, 11, 67],\n" +
            "    [-91, -90, -40, 32, 94]\n" +
            "  ]\n" +
            "}";
    private static final String EXPECTED7 = "[-98, -91, -91, -90, -87, -83, -79, -73, -73, -65, -63, -62, -61, -56, -56, -56, -49, -47, -43, -42, -40, -33, -30, -30, -26, -24, -21, -20, -16, -10, -5, -4, 8, 11, 16, 19, 19, 21, 32, 34, 49, 67, 80, 83, 86, 91, 94, 98]";

    private static final String TEST_CASE8 = "{\n" +
            "  \"arrays\": [\n" +
            "    [-81, 36, 57, 59],\n" +
            "    [-65, -58, -47, -39, 29, 53, 66, 75, 88, 92],\n" +
            "    [-67, -54, -40, -25, 9, 17, 55, 75, 94],\n" +
            "    [-35, -3, 24, 82],\n" +
            "    [-86, 32, 95]\n" +
            "  ]\n" +
            "}";
    private static final String EXPECTED8 = "[-86, -81, -67, -65, -58, -54, -47, -40, -39, -35, -25, -3, 9, 17, 24, 29, 32, 36, 53, 55, 57, 59, 66, 75, 75, 82, 88, 92, 94, 95]";

    private static final String TEST_CASE9 = "{\n" +
            "  \"arrays\": [\n" +
            "    [-93, -83, -78, -75, -40, -32, 48],\n" +
            "    [-90, -75, -57, 7, 11, 21, 53, 84, 89],\n" +
            "    [-50, -40, -20, 71, 96],\n" +
            "    [-49, 13, 18, 61, 97],\n" +
            "    [42, 96]\n" +
            "  ]\n" +
            "}";
    private static final String EXPECTED9 = "[-93, -90, -83, -78, -75, -75, -57, -50, -49, -40, -40, -32, -20, 7, 11, 13, 18, 21, 42, 48, 53, 61, 71, 84, 89, 96, 96, 97]";

    private static final String TEST_CASE10 = "{\n" +
            "  \"arrays\": [\n" +
            "    [-63, -55, -9, 37, 86, 97],\n" +
            "    [-62, -48, -37, -16, 11, 33, 80, 97],\n" +
            "    [-51, 5, 34],\n" +
            "    [-24, -24, -19, 32, 46, 97],\n" +
            "    [-98, -56, -12, -2, -1, 11, 47, 79],\n" +
            "    [-59, 64, 93, 96],\n" +
            "    [-96, -51, -21, -18, 29, 57, 87, 90, 92],\n" +
            "    [-89, -85, -55, -12, 27],\n" +
            "    [-96, -96, -95, -95, -71, -45, -28, 8, 19, 100]\n" +
            "  ]\n" +
            "}";
    private static final String EXPECTED10 = "[-98, -96, -96, -96, -95, -95, -89, -85, -71, -63, -62, -59, -56, -55, -55, -51, -51, -48, -45, -37, -28, -24, -24, -21, -19, -18, -16, -12, -12, -9, -2, -1, 5, 8, 11, 11, 19, 27, 29, 32, 33, 34, 37, 46, 47, 57, 64, 79, 80, 86, 87, 90, 92, 93, 96, 97, 97, 97, 100]";

    private static final String TEST_CASE11 = "{\n" +
            "  \"arrays\": [\n" +
            "    [49, 72],\n" +
            "    [-95, -49, -18, -16, 1, 16, 36, 40, 75, 92],\n" +
            "    [-77, 11, 65, 91]\n" +
            "  ]\n" +
            "}";
    private static final String EXPECTED11 = "[-95, -77, -49, -18, -16, 1, 11, 16, 36, 40, 49, 65, 72, 75, 91, 92]";

    private static final String TEST_CASE12 = "{\n" +
            "  \"arrays\": [\n" +
            "    [-94, -93, -25, -2, 67, 85],\n" +
            "    [-83, -74, 64],\n" +
            "    [-83, 10, 46, 64],\n" +
            "    [-94, -54, -40, 9, 22, 49]\n" +
            "  ]\n" +
            "}";
    private static final String EXPECTED12 = "[-94, -94, -93, -83, -83, -74, -54, -40, -25, -2, 9, 10, 22, 46, 49, 64, 64, 67, 85]";

    private static final String TEST_CASE13 = "{\n" +
            "  \"arrays\": [\n" +
            "    [-87, -67, -56, -15, 67],\n" +
            "    [-98, -90, -85, -3, 5, 43, 44],\n" +
            "    [-97, -78, -73, -65, -17, 27, 66, 77, 78, 92],\n" +
            "    [-99, -62, 11, 15, 50]\n" +
            "  ]\n" +
            "}";
    private static final String EXPECTED13 = "[-99, -98, -97, -90, -87, -85, -78, -73, -67, -65, -62, -56, -17, -15, -3, 5, 11, 15, 27, 43, 44, 50, 66, 67, 77, 78, 92]";

    private static final String TEST_CASE14 = "{\n" +
            "  \"arrays\": [\n" +
            "    [-79, -77, -48, -39, -27, 10, 39, 61, 83, 99],\n" +
            "    [-93, 10],\n" +
            "    [-98, -90, -44, -33, -5, 40, 69, 90, 96],\n" +
            "    [-93],\n" +
            "    [-32, 9, 14, 20, 85]\n" +
            "  ]\n" +
            "}";
    private static final String EXPECTED14 = "[-98, -93, -93, -90, -79, -77, -48, -44, -39, -33, -32, -27, -5, 9, 10, 10, 14, 20, 39, 40, 61, 69, 83, 85, 90, 96, 99]";

    private static final String TEST_CASE15 = "{\n" +
            "  \"arrays\": [\n" +
            "    [14],\n" +
            "    [-88, -16, 26, 38, 51, 62, 84, 88]\n" +
            "  ]\n" +
            "}";
    private static final String EXPECTED15 = "[-88, -16, 14, 26, 38, 51, 62, 84, 88]";

    private static final String TEST_CASE16 = "{\n" +
            "  \"arrays\": [\n" +
            "    [-62, -54, -54, 31, 34, 51],\n" +
            "    [-41],\n" +
            "    [33, 34],\n" +
            "    [-98, 68, 83],\n" +
            "    [-25, -14]\n" +
            "  ]\n" +
            "}";
    private static final String EXPECTED16 = "[-98, -62, -54, -54, -41, -25, -14, 31, 33, 34, 34, 51, 68, 83]";

    private static final String TEST_CASE17 = "{\n" +
            "  \"arrays\": [\n" +
            "    [-53, -16, -13, -11, -6, 21, 26, 35],\n" +
            "    [-99, -93, -62, -47, -16, 4, 55, 59, 64, 76],\n" +
            "    [-96, -41, -8],\n" +
            "    [-39, -28, -4],\n" +
            "    [-95, -48, -45, -25, 63, 64, 98],\n" +
            "    [-38, -32, -7, 82],\n" +
            "    [-42, 25, 49, 79, 86],\n" +
            "    [-88, -65, 7, 8, 44]\n" +
            "  ]\n" +
            "}";
    private static final String EXPECTED17 = "[-99, -96, -95, -93, -88, -65, -62, -53, -48, -47, -45, -42, -41, -39, -38, -32, -28, -25, -16, -16, -13, -11, -8, -7, -6, -4, 4, 7, 8, 21, 25, 26, 35, 44, 49, 55, 59, 63, 64, 64, 76, 79, 82, 86, 98]";

    private static final String TEST_CASE18 = "{\n" +
            "  \"arrays\": [\n" +
            "    [-33, 57, 74],\n" +
            "    [-76, -72, -46, -21, -16, -10, 16, 21, 47, 67],\n" +
            "    [-59, -55, -47, -46, -35, 38],\n" +
            "    [-62, -25, 3, 30, 46, 71],\n" +
            "    [-91, -37, -26, -12, -8, 2, 9, 46, 56, 93],\n" +
            "    [-58, 82, 97]\n" +
            "  ]\n" +
            "}";
    private static final String EXPECTED18 = "[-91, -76, -72, -62, -59, -58, -55, -47, -46, -46, -37, -35, -33, -26, -25, -21, -16, -12, -10, -8, 2, 3, 9, 16, 21, 30, 38, 46, 46, 47, 56, 57, 67, 71, 74, 82, 93, 97]";

    private static final String TEST_CASE19 = "{\n" +
            "  \"arrays\": [\n" +
            "    [-64, -51, -5, 1, 6, 12, 27, 32, 62, 88],\n" +
            "    [-66, -65, -60, 17, 22],\n" +
            "    [-57, -7, 13, 70, 79],\n" +
            "    [-88, -86, -73, -59, -36, -12, 11, 48, 58, 99],\n" +
            "    [-71, -28],\n" +
            "    [21, 38],\n" +
            "    [-55, -44, -27],\n" +
            "    [-96, -93, -5, 13],\n" +
            "    [-19, -11, 27, 36, 43, 79, 87],\n" +
            "    [-72, -53, -10, 1, 27, 77, 88]\n" +
            "  ]\n" +
            "}";
    private static final String EXPECTED19 = "[-96, -93, -88, -86, -73, -72, -71, -66, -65, -64, -60, -59, -57, -55, -53, -51, -44, -36, -28, -27, -19, -12, -11, -10, -7, -5, -5, 1, 1, 6, 11, 12, 13, 13, 17, 21, 22, 27, 27, 27, 32, 36, 38, 43, 48, 58, 62, 70, 77, 79, 79, 87, 88, 88, 99]";

    private static final String TEST_CASE20 = "{\n" +
            "  \"arrays\": [\n" +
            "    [-19, 33, 34],\n" +
            "    [-94, -53, -10, -3, 44, 73],\n" +
            "    [27, 42, 70, 86],\n" +
            "    [-28, 91],\n" +
            "    [-53, -27, 31, 77, 96, 99]\n" +
            "  ]\n" +
            "}";
    private static final String EXPECTED20 = "[-94, -53, -53, -28, -27, -19, -10, -3, 27, 31, 33, 34, 42, 44, 70, 73, 77, 86, 91, 96, 99]";

    private static List<Integer> parseArray(JsonArray array) {
        var result = new ArrayList<Integer>(array.size());
        for (var element : array) {
            result.add(element.getAsInt());
        }
        return result;
    }

    private static Arguments parseArguments(String testCaseJson, String expectedJson) {
        var gson = new Gson();
        var testCaseObject = gson.fromJson(testCaseJson, JsonObject.class);

        var arrays = new ArrayList<List<Integer>>();
        for (var array : testCaseObject.getAsJsonArray("arrays")) {
            arrays.add(parseArray(array.getAsJsonArray()));
        }

        var expectedArray = gson.fromJson(expectedJson, JsonArray.class);
        return Arguments.of(arrays, parseArray(expectedArray));
    }

    private static void internalTestCase(MergeSortedArrays solution, List<List<Integer>> arrays, List<Integer> expected) {
        var result = solution.mergeSortedArrays(arrays);

        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    static List<Arguments> params() {
        return List.of(
                parseArguments(TEST_CASE1, EXPECTED1),
                parseArguments(TEST_CASE2, EXPECTED2),
                parseArguments(TEST_CASE3, EXPECTED3),
                parseArguments(TEST_CASE4, EXPECTED4),
                parseArguments(TEST_CASE5, EXPECTED5),
                parseArguments(TEST_CASE6, EXPECTED6),
                parseArguments(TEST_CASE7, EXPECTED7),
                parseArguments(TEST_CASE8, EXPECTED8),
                parseArguments(TEST_CASE9, EXPECTED9),
                parseArguments(TEST_CASE10, EXPECTED10),
                parseArguments(TEST_CASE11, EXPECTED11),
                parseArguments(TEST_CASE12, EXPECTED12),
                parseArguments(TEST_CASE13, EXPECTED13),
                parseArguments(TEST_CASE14, EXPECTED14),
                parseArguments(TEST_CASE15, EXPECTED15),
                parseArguments(TEST_CASE16, EXPECTED16),
                parseArguments(TEST_CASE17, EXPECTED17),
                parseArguments(TEST_CASE18, EXPECTED18),
                parseArguments(TEST_CASE19, EXPECTED19),
                parseArguments(TEST_CASE20, EXPECTED20)
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution1(List<List<Integer>> arrays, List<Integer> expected) {
        internalTestCase(new MergeSortedArrays.Solution1(), arrays, expected);
    }
}
