package com.algo.expert.greedyalgorithms;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class PhotosTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"blueShirtHeights\": [6, 9, 2, 4, 5],\n" +
            "  \"redShirtHeights\": [5, 8, 1, 3, 4]\n" +
            "}";
    private static final String TEST_CASE2 = "{\n" +
            "  \"blueShirtHeights\": [5, 8, 1, 3, 4],\n" +
            "  \"redShirtHeights\": [6, 9, 2, 4, 5]\n" +
            "}";
    private static final String TEST_CASE3 = "{\n" +
            "  \"blueShirtHeights\": [5, 8, 1, 3, 4, 9],\n" +
            "  \"redShirtHeights\": [6, 9, 2, 4, 5, 1]\n" +
            "}";
    private static final String TEST_CASE4 = "{\n" +
            "  \"blueShirtHeights\": [6],\n" +
            "  \"redShirtHeights\": [6]\n" +
            "}";
    private static final String TEST_CASE5 = "{\n" +
            "  \"blueShirtHeights\": [125],\n" +
            "  \"redShirtHeights\": [126]\n" +
            "}";
    private static final String TEST_CASE6 = "{\n" +
            "  \"blueShirtHeights\": [2, 3, 4, 5, 6],\n" +
            "  \"redShirtHeights\": [1, 2, 3, 4, 5]\n" +
            "}";
    private static final String TEST_CASE7 = "{\n" +
            "  \"blueShirtHeights\": [5, 6, 7, 2, 3, 1, 2, 3],\n" +
            "  \"redShirtHeights\": [1, 1, 1, 1, 1, 1, 1, 1]\n" +
            "}";
    private static final String TEST_CASE8 = "{\n" +
            "  \"blueShirtHeights\": [2, 2, 2, 2, 2, 2, 2, 2],\n" +
            "  \"redShirtHeights\": [1, 1, 1, 1, 1, 1, 1, 1]\n" +
            "}";
    private static final String TEST_CASE9 = "{\n" +
            "  \"blueShirtHeights\": [126],\n" +
            "  \"redShirtHeights\": [125]\n" +
            "}";
    private static final String TEST_CASE10 = "{\n" +
            "  \"blueShirtHeights\": [21, 5, 4, 4, 4, 4, 4, 4, 4],\n" +
            "  \"redShirtHeights\": [19, 2, 4, 6, 2, 3, 1, 1, 4]\n" +
            "}";
    private static final String TEST_CASE11 = "{\n" +
            "  \"blueShirtHeights\": [20, 5, 4, 4, 4, 4, 4, 4],\n" +
            "  \"redShirtHeights\": [19, 19, 21, 1, 1, 1, 1, 1]\n" +
            "}";
    private static final String TEST_CASE12 = "{\n" +
            "  \"blueShirtHeights\": [2, 4, 7, 5, 1],\n" +
            "  \"redShirtHeights\": [3, 5, 6, 8, 2]\n" +
            "}";
    private static final String TEST_CASE13 = "{\n" +
            "  \"blueShirtHeights\": [2, 4, 7, 5, 1, 6],\n" +
            "  \"redShirtHeights\": [3, 5, 6, 8, 2, 1]\n" +
            "}";
    private static final String TEST_CASE14 = "{\n" +
            "  \"blueShirtHeights\": [5, 4],\n" +
            "  \"redShirtHeights\": [4, 5]\n" +
            "}";
    private static final String TEST_CASE15 = "{\n" +
            "  \"blueShirtHeights\": [5, 4],\n" +
            "  \"redShirtHeights\": [5, 6]\n" +
            "}";

    @ParameterizedTest
    @MethodSource("params")
    void testCases(ArrayList<Integer> red, ArrayList<Integer> blue, boolean expected) {
        boolean result = Photos.classPhotos(red, blue);
        Assertions.assertEquals(expected, result);
    }

    static List<Arguments> params() {
        return List.of(
                parseArguments(TEST_CASE1, true),
                parseArguments(TEST_CASE2, true),
                parseArguments(TEST_CASE3, false),
                parseArguments(TEST_CASE4, false),
                parseArguments(TEST_CASE5, true),
                parseArguments(TEST_CASE6, true),
                parseArguments(TEST_CASE7, false),
                parseArguments(TEST_CASE8, true),
                parseArguments(TEST_CASE9, true),
                parseArguments(TEST_CASE10, false),
                parseArguments(TEST_CASE11, false),
                parseArguments(TEST_CASE12, true),
                parseArguments(TEST_CASE13, false),
                parseArguments(TEST_CASE14, false),
                parseArguments(TEST_CASE15, true)
        );
    }

    static Arguments parseArguments(String json, boolean expected) {
        JsonObject object = new Gson().fromJson(json, JsonElement.class).getAsJsonObject();
        ArrayList<Integer> red = new ArrayList<>();
        for (JsonElement element : object.getAsJsonArray("redShirtHeights")) {
            red.add(element.getAsInt());
        }
        ArrayList<Integer> blue = new ArrayList<>();
        for (JsonElement element : object.getAsJsonArray("blueShirtHeights")) {
            blue.add(element.getAsInt());
        }
        return Arguments.of(red, blue, expected);
    }
}
