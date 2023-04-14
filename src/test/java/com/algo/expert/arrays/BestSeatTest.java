package com.algo.expert.arrays;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class BestSeatTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"seats\": [1]\n" +
            "}";
    private static final int EXPECTED1 = -1;

    private static final String TEST_CASE2 = "{\n" +
            "  \"seats\": [1, 0, 1, 0, 0, 0, 1]\n" +
            "}";
    private static final int EXPECTED2 = 4;

    private static final String TEST_CASE3 = "{\n" +
            "  \"seats\": [1, 0, 1]\n" +
            "}";
    private static final int EXPECTED3 = 1;

    private static final String TEST_CASE4 = "{\n" +
            "  \"seats\": [1, 0, 0, 1]\n" +
            "}";
    private static final int EXPECTED4 = 1;

    private static final String TEST_CASE5 = "{\n" +
            "  \"seats\": [1, 1, 1]\n" +
            "}";
    private static final int EXPECTED5 = -1;

    private static final String TEST_CASE6 = "{\n" +
            "  \"seats\": [1, 0, 0, 1, 0, 0, 1]\n" +
            "}";
    private static final int EXPECTED6 = 1;

    private static final String TEST_CASE7 = "{\n" +
            "  \"seats\": [1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1]\n" +
            "}";
    private static final int EXPECTED7 = 3;

    private static final String TEST_CASE8 = "{\n" +
            "  \"seats\": [1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1]\n" +
            "}";
    private static final int EXPECTED8 = 4;

    private static final String TEST_CASE9 = "{\n" +
            "  \"seats\": [1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1]\n" +
            "}";
    private static final int EXPECTED9 = 4;

    private static final String TEST_CASE10 = "{\n" +
            "  \"seats\": [1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1]\n" +
            "}";
    private static final int EXPECTED10 = 13;

    private static final String TEST_CASE11 = "{\n" +
            "  \"seats\": [1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1]\n" +
            "}";
    private static final int EXPECTED11 = 13;

    private static final String TEST_CASE12 = "{\n" +
            "  \"seats\": [1, 0, 0, 0, 1, 0, 0, 0, 0, 1]\n" +
            "}";
    private static final int EXPECTED12 = 6;

    private static final String TEST_CASE13 = "{\n" +
            "  \"seats\": [1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1]\n" +
            "}";
    private static final int EXPECTED13 = 3;

    private static final String TEST_CASE14 = "{\n" +
            "  \"seats\": [1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1]\n" +
            "}";
    private static final int EXPECTED14 = 5;

    private static int[] parseSeats(String json) {
        var object = new Gson().fromJson(json, JsonObject.class);
        var seats = object.getAsJsonArray("seats");

        var result = new int[seats.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = seats.get(i).getAsInt();
        }
        return result;
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(parseSeats(TEST_CASE1), EXPECTED1),
                Arguments.of(parseSeats(TEST_CASE2), EXPECTED2),
                Arguments.of(parseSeats(TEST_CASE3), EXPECTED3),
                Arguments.of(parseSeats(TEST_CASE4), EXPECTED4),
                Arguments.of(parseSeats(TEST_CASE5), EXPECTED5),
                Arguments.of(parseSeats(TEST_CASE6), EXPECTED6),
                Arguments.of(parseSeats(TEST_CASE7), EXPECTED7),
                Arguments.of(parseSeats(TEST_CASE8), EXPECTED8),
                Arguments.of(parseSeats(TEST_CASE9), EXPECTED9),
                Arguments.of(parseSeats(TEST_CASE10), EXPECTED10),
                Arguments.of(parseSeats(TEST_CASE11), EXPECTED11),
                Arguments.of(parseSeats(TEST_CASE12), EXPECTED12),
                Arguments.of(parseSeats(TEST_CASE13), EXPECTED13),
                Arguments.of(parseSeats(TEST_CASE14), EXPECTED14)
        );
    }

    private static void internalTestCase(BestSeat solution, int[] seats, int expected) {
        var result = solution.bestSeat(seats);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution1(int[] seats, int expected) {
        internalTestCase(new BestSeat.Solution1(), seats, expected);
    }
}
