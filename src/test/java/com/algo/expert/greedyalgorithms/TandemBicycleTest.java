package com.algo.expert.greedyalgorithms;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class TandemBicycleTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"blueShirtSpeeds\": [3, 6, 7, 2, 1],\n" +
            "  \"fastest\": true,\n" +
            "  \"redShirtSpeeds\": [5, 5, 3, 9, 2]\n" +
            "}";
    private static final String TEST_CASE2 = "{\n" +
            "  \"blueShirtSpeeds\": [3, 6, 7, 2, 1],\n" +
            "  \"fastest\": false,\n" +
            "  \"redShirtSpeeds\": [5, 5, 3, 9, 2]\n" +
            "}";
    private static final String TEST_CASE3 = "{\n" +
            "  \"blueShirtSpeeds\": [3, 3, 4, 6, 1, 2],\n" +
            "  \"fastest\": false,\n" +
            "  \"redShirtSpeeds\": [1, 2, 1, 9, 12, 3]\n" +
            "}";
    private static final String TEST_CASE4 = "{\n" +
            "  \"blueShirtSpeeds\": [3, 3, 4, 6, 1, 2],\n" +
            "  \"fastest\": true,\n" +
            "  \"redShirtSpeeds\": [1, 2, 1, 9, 12, 3]\n" +
            "}";
    private static final String TEST_CASE5 = "{\n" +
            "  \"blueShirtSpeeds\": [3, 3, 4, 6, 1, 2, 5, 6, 34, 256, 123, 32],\n" +
            "  \"fastest\": true,\n" +
            "  \"redShirtSpeeds\": [1, 2, 1, 9, 12, 3, 1, 54, 21, 231, 32, 1]\n" +
            "}";
    private static final String TEST_CASE6 = "{\n" +
            "  \"blueShirtSpeeds\": [3, 3, 4, 6, 1, 2, 5, 6, 34, 256, 123, 32],\n" +
            "  \"fastest\": false,\n" +
            "  \"redShirtSpeeds\": [1, 2, 1, 9, 12, 3, 1, 54, 21, 231, 32, 1]\n" +
            "}";
    private static final String TEST_CASE7 = "{\n" +
            "  \"blueShirtSpeeds\": [5],\n" +
            "  \"fastest\": true,\n" +
            "  \"redShirtSpeeds\": [1]\n" +
            "}";
    private static final String TEST_CASE8 = "{\n" +
            "  \"blueShirtSpeeds\": [5],\n" +
            "  \"fastest\": false,\n" +
            "  \"redShirtSpeeds\": [1]\n" +
            "}";
    private static final String TEST_CASE9 = "{\n" +
            "  \"blueShirtSpeeds\": [1, 1, 1, 1],\n" +
            "  \"fastest\": true,\n" +
            "  \"redShirtSpeeds\": [1, 1, 1, 1]\n" +
            "}";
    private static final String TEST_CASE10 = "{\n" +
            "  \"blueShirtSpeeds\": [1, 1, 1, 1],\n" +
            "  \"fastest\": false,\n" +
            "  \"redShirtSpeeds\": [1, 1, 1, 1]\n" +
            "}";
    private static final String TEST_CASE11 = "{\n" +
            "  \"blueShirtSpeeds\": [1, 1, 1, 1, 3, 3, 3, 3, 5, 7],\n" +
            "  \"fastest\": true,\n" +
            "  \"redShirtSpeeds\": [1, 1, 1, 1, 2, 2, 2, 2, 9, 11]\n" +
            "}";
    private static final String TEST_CASE12 = "{\n" +
            "  \"blueShirtSpeeds\": [1, 1, 1, 1, 3, 3, 3, 3, 5, 7],\n" +
            "  \"fastest\": false,\n" +
            "  \"redShirtSpeeds\": [1, 1, 1, 1, 2, 2, 2, 2, 9, 11]\n" +
            "}";
    private static final String TEST_CASE13 = "{\n" +
            "  \"blueShirtSpeeds\": [3, 4, 4, 1, 1, 8, 9],\n" +
            "  \"fastest\": true,\n" +
            "  \"redShirtSpeeds\": [9, 8, 2, 2, 3, 5, 6]\n" +
            "}";
    private static final String TEST_CASE14 = "{\n" +
            "  \"blueShirtSpeeds\": [3, 4, 4, 1, 1, 8, 9],\n" +
            "  \"fastest\": false,\n" +
            "  \"redShirtSpeeds\": [9, 8, 2, 2, 3, 5, 6]\n" +
            "}";
    private static final String TEST_CASE15 = "{\n" +
            "  \"blueShirtSpeeds\": [1, 2, 3, 4, 5],\n" +
            "  \"fastest\": false,\n" +
            "  \"redShirtSpeeds\": [5, 4, 3, 2, 1]\n" +
            "}";
    private static final String TEST_CASE16 = "{\n" +
            "  \"blueShirtSpeeds\": [1, 2, 3, 4, 5],\n" +
            "  \"fastest\": true,\n" +
            "  \"redShirtSpeeds\": [5, 4, 3, 2, 1]\n" +
            "}";
    private static final String TEST_CASE17 = "{\n" +
            "  \"blueShirtSpeeds\": [],\n" +
            "  \"fastest\": true,\n" +
            "  \"redShirtSpeeds\": []\n" +
            "}";

    private void internalTestCases(TandemBicycle impl, int[] red, int[] blue, boolean fastest, int expected) {
        int result = impl.tandemBicycle(red, blue, fastest);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCasesSolution1(int[] red, int[] blue, boolean fastest, int expected) {
        internalTestCases(new TandemBicycle.Solution1(), red, blue, fastest, expected);
    }

    static List<Arguments> params() {
        return List.of(
                parseArguments(TEST_CASE1, 32),
                parseArguments(TEST_CASE2, 25),
                parseArguments(TEST_CASE3, 30),
                parseArguments(TEST_CASE4, 37),
                parseArguments(TEST_CASE5, 816),
                parseArguments(TEST_CASE6, 484),
                parseArguments(TEST_CASE7, 5),
                parseArguments(TEST_CASE8, 5),
                parseArguments(TEST_CASE9, 4),
                parseArguments(TEST_CASE10, 4),
                parseArguments(TEST_CASE11, 48),
                parseArguments(TEST_CASE12, 36),
                parseArguments(TEST_CASE13, 49),
                parseArguments(TEST_CASE14, 35),
                parseArguments(TEST_CASE15, 15),
                parseArguments(TEST_CASE16, 21),
                parseArguments(TEST_CASE17, 0)
        );
    }

    static Arguments parseArguments(String json, int expected) {
        JsonObject object = new Gson().fromJson(json, JsonElement.class).getAsJsonObject();
        JsonArray blueArray = object.getAsJsonArray("blueShirtSpeeds");
        int[] blue = new int[blueArray.size()];
        for (int i = 0; i < blue.length; i++) {
            blue[i] = blueArray.get(i).getAsInt();
        }
        JsonArray redArray = object.getAsJsonArray("redShirtSpeeds");
        int[] red = new int[redArray.size()];
        for (int i = 0; i < red.length; i++) {
            red[i] = redArray.get(i).getAsInt();
        }
        boolean fastest = object.get("fastest").getAsBoolean();
        return Arguments.of(red, blue, fastest, expected);
    }
}
