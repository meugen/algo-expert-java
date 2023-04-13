package com.algo.expert.binarysearchtrees;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateBstTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "      {\"id\": \"15\", \"left\": \"13\", \"right\": \"22\", \"value\": 15},\n" +
            "      {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "      {\"id\": \"13\", \"left\": null, \"right\": \"14\", \"value\": 13},\n" +
            "      {\"id\": \"14\", \"left\": null, \"right\": null, \"value\": 14},\n" +
            "      {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "      {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "    ],\n" +
            "    \"root\": \"10\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE2 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "      {\"id\": \"15\", \"left\": null, \"right\": \"22\", \"value\": 15},\n" +
            "      {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "      {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "      {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"1\", \"left\": \"-5\", \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"-5\", \"left\": \"-15\", \"right\": \"-5-2\", \"value\": -5},\n" +
            "      {\"id\": \"-5-2\", \"left\": null, \"right\": \"-2\", \"value\": -5},\n" +
            "      {\"id\": \"-2\", \"left\": null, \"right\": \"-1\", \"value\": -2},\n" +
            "      {\"id\": \"-1\", \"left\": null, \"right\": null, \"value\": -1},\n" +
            "      {\"id\": \"-15\", \"left\": \"-22\", \"right\": null, \"value\": -15},\n" +
            "      {\"id\": \"-22\", \"left\": null, \"right\": null, \"value\": -22}\n" +
            "    ],\n" +
            "    \"root\": \"10\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE3 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10}\n" +
            "    ],\n" +
            "    \"root\": \"10\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE4 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "      {\"id\": \"15\", \"left\": null, \"right\": \"22\", \"value\": 15},\n" +
            "      {\"id\": \"22\", \"left\": null, \"right\": \"500\", \"value\": 22},\n" +
            "      {\"id\": \"500\", \"left\": \"50\", \"right\": \"1500\", \"value\": 500},\n" +
            "      {\"id\": \"1500\", \"left\": null, \"right\": \"10000\", \"value\": 1500},\n" +
            "      {\"id\": \"10000\", \"left\": \"2200\", \"right\": null, \"value\": 10000},\n" +
            "      {\"id\": \"2200\", \"left\": null, \"right\": null, \"value\": 2200},\n" +
            "      {\"id\": \"50\", \"left\": null, \"right\": \"200\", \"value\": 50},\n" +
            "      {\"id\": \"200\", \"left\": null, \"right\": null, \"value\": 200},\n" +
            "      {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "      {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "    ],\n" +
            "    \"root\": \"10\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE5 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"5000\", \"left\": \"5\", \"right\": \"55000\", \"value\": 5000},\n" +
            "      {\"id\": \"55000\", \"left\": null, \"right\": null, \"value\": 55000},\n" +
            "      {\"id\": \"5\", \"left\": \"2\", \"right\": \"15\", \"value\": 5},\n" +
            "      {\"id\": \"15\", \"left\": \"5-2\", \"right\": \"22\", \"value\": 15},\n" +
            "      {\"id\": \"22\", \"left\": null, \"right\": \"502\", \"value\": 22},\n" +
            "      {\"id\": \"502\", \"left\": \"204\", \"right\": null, \"value\": 502},\n" +
            "      {\"id\": \"204\", \"left\": \"203\", \"right\": \"205\", \"value\": 204},\n" +
            "      {\"id\": \"205\", \"left\": null, \"right\": \"207\", \"value\": 205},\n" +
            "      {\"id\": \"207\", \"left\": \"206\", \"right\": \"208\", \"value\": 207},\n" +
            "      {\"id\": \"208\", \"left\": null, \"right\": null, \"value\": 208},\n" +
            "      {\"id\": \"206\", \"left\": null, \"right\": null, \"value\": 206},\n" +
            "      {\"id\": \"203\", \"left\": null, \"right\": null, \"value\": 203},\n" +
            "      {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"2\", \"left\": \"1\", \"right\": \"3\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": \"1-2\", \"value\": 1},\n" +
            "      {\"id\": \"1-2\", \"left\": null, \"right\": \"1-3\", \"value\": 1},\n" +
            "      {\"id\": \"1-3\", \"left\": null, \"right\": \"1-4\", \"value\": 1},\n" +
            "      {\"id\": \"1-4\", \"left\": null, \"right\": \"1-5\", \"value\": 1},\n" +
            "      {\"id\": \"1-5\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "    ],\n" +
            "    \"root\": \"5000\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE6 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "      {\"id\": \"15\", \"left\": null, \"right\": \"22\", \"value\": 15},\n" +
            "      {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "      {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "      {\"id\": \"5-2\", \"left\": null, \"right\": \"11\", \"value\": 5},\n" +
            "      {\"id\": \"11\", \"left\": null, \"right\": null, \"value\": 11},\n" +
            "      {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "    ],\n" +
            "    \"root\": \"10\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE7 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "      {\"id\": \"15\", \"left\": null, \"right\": \"22\", \"value\": 15},\n" +
            "      {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "      {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "      {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"1\", \"left\": \"-5\", \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"-5\", \"left\": \"-15\", \"right\": \"-5-2\", \"value\": -5},\n" +
            "      {\"id\": \"-5-2\", \"left\": null, \"right\": \"-2\", \"value\": -5},\n" +
            "      {\"id\": \"-2\", \"left\": null, \"right\": \"-1\", \"value\": -2},\n" +
            "      {\"id\": \"-1\", \"left\": null, \"right\": null, \"value\": -1},\n" +
            "      {\"id\": \"-15\", \"left\": \"-22\", \"right\": null, \"value\": -15},\n" +
            "      {\"id\": \"-22\", \"left\": \"11\", \"right\": null, \"value\": -22},\n" +
            "      {\"id\": \"11\", \"left\": null, \"right\": null, \"value\": 11}\n" +
            "    ],\n" +
            "    \"root\": \"10\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE8 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"10\", \"left\": \"11\", \"right\": \"12\", \"value\": 10},\n" +
            "      {\"id\": \"12\", \"left\": null, \"right\": null, \"value\": 12},\n" +
            "      {\"id\": \"11\", \"left\": null, \"right\": null, \"value\": 11}\n" +
            "    ],\n" +
            "    \"root\": \"10\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE9 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "      {\"id\": \"15\", \"left\": null, \"right\": \"22\", \"value\": 15},\n" +
            "      {\"id\": \"22\", \"left\": null, \"right\": \"500\", \"value\": 22},\n" +
            "      {\"id\": \"500\", \"left\": \"50\", \"right\": \"1500\", \"value\": 500},\n" +
            "      {\"id\": \"1500\", \"left\": null, \"right\": \"10000\", \"value\": 1500},\n" +
            "      {\"id\": \"10000\", \"left\": \"2200\", \"right\": \"9999\", \"value\": 10000},\n" +
            "      {\"id\": \"9999\", \"left\": null, \"right\": null, \"value\": 9999},\n" +
            "      {\"id\": \"2200\", \"left\": null, \"right\": null, \"value\": 2200},\n" +
            "      {\"id\": \"50\", \"left\": null, \"right\": \"200\", \"value\": 50},\n" +
            "      {\"id\": \"200\", \"left\": null, \"right\": null, \"value\": 200},\n" +
            "      {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "      {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "    ],\n" +
            "    \"root\": \"10\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE10 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"100\", \"left\": \"5\", \"right\": \"502\", \"value\": 100},\n" +
            "      {\"id\": \"502\", \"left\": \"204\", \"right\": \"55000\", \"value\": 502},\n" +
            "      {\"id\": \"55000\", \"left\": null, \"right\": null, \"value\": 55000},\n" +
            "      {\"id\": \"204\", \"left\": \"203\", \"right\": \"205\", \"value\": 204},\n" +
            "      {\"id\": \"205\", \"left\": \"300\", \"right\": \"207\", \"value\": 205},\n" +
            "      {\"id\": \"207\", \"left\": \"206\", \"right\": \"208\", \"value\": 207},\n" +
            "      {\"id\": \"208\", \"left\": null, \"right\": null, \"value\": 208},\n" +
            "      {\"id\": \"206\", \"left\": null, \"right\": null, \"value\": 206},\n" +
            "      {\"id\": \"300\", \"left\": null, \"right\": null, \"value\": 300},\n" +
            "      {\"id\": \"203\", \"left\": null, \"right\": null, \"value\": 203},\n" +
            "      {\"id\": \"5\", \"left\": \"2\", \"right\": \"15\", \"value\": 5},\n" +
            "      {\"id\": \"15\", \"left\": \"5-2\", \"right\": \"22\", \"value\": 15},\n" +
            "      {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "      {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"2\", \"left\": \"1\", \"right\": \"3\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": \"1-2\", \"value\": 1},\n" +
            "      {\"id\": \"1-2\", \"left\": null, \"right\": \"1-3\", \"value\": 1},\n" +
            "      {\"id\": \"1-3\", \"left\": null, \"right\": \"1-4\", \"value\": 1},\n" +
            "      {\"id\": \"1-4\", \"left\": null, \"right\": \"1-5\", \"value\": 1},\n" +
            "      {\"id\": \"1-5\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "    ],\n" +
            "    \"root\": \"100\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE11 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "      {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": \"10-2\", \"value\": 5},\n" +
            "      {\"id\": \"10-2\", \"left\": null, \"right\": null, \"value\": 10}\n" +
            "    ],\n" +
            "    \"root\": \"10\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE12 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "      {\"id\": \"15\", \"left\": \"13\", \"right\": \"22\", \"value\": 15},\n" +
            "      {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "      {\"id\": \"13\", \"left\": null, \"right\": \"16\", \"value\": 13},\n" +
            "      {\"id\": \"16\", \"left\": null, \"right\": null, \"value\": 16},\n" +
            "      {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "      {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "    ],\n" +
            "    \"root\": \"10\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE13 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "      {\"id\": \"15\", \"left\": \"13\", \"right\": \"22\", \"value\": 15},\n" +
            "      {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "      {\"id\": \"13\", \"left\": null, \"right\": \"14\", \"value\": 5},\n" +
            "      {\"id\": \"14\", \"left\": null, \"right\": null, \"value\": 14},\n" +
            "      {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "      {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "    ],\n" +
            "    \"root\": \"10\"\n" +
            "  }\n" +
            "}";

    private void internalTestCases(ValidateBst impl, ValidateBst.BST tree, boolean expected) {
        boolean result = impl.validateBst(tree);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCasesSolution1(ValidateBst.BST tree, boolean expected) {
        internalTestCases(new ValidateBst.Solution1(), tree, expected);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(parseTree(TEST_CASE1), true),
                Arguments.of(parseTree(TEST_CASE2), true),
                Arguments.of(parseTree(TEST_CASE3), true),
                Arguments.of(parseTree(TEST_CASE4), true),
                Arguments.of(parseTree(TEST_CASE5), true),
                Arguments.of(parseTree(TEST_CASE6), false),
                Arguments.of(parseTree(TEST_CASE7), false),
                Arguments.of(parseTree(TEST_CASE8), false),
                Arguments.of(parseTree(TEST_CASE9), false),
                Arguments.of(parseTree(TEST_CASE10), false),
                Arguments.of(parseTree(TEST_CASE11), false),
                Arguments.of(parseTree(TEST_CASE12), false),
                Arguments.of(parseTree(TEST_CASE13), false)
        );
    }

    private static ValidateBst.BST parseTree(String json) {
        JsonObject object = new Gson().fromJson(json, JsonElement.class)
                .getAsJsonObject().getAsJsonObject("tree");
        Map<String, ValidateBst.BST> map = new HashMap<>();
        for (JsonElement node : object.getAsJsonArray("nodes")) {
            String id = node.getAsJsonObject().get("id").getAsString();
            int value = node.getAsJsonObject().get("value").getAsInt();
            map.put(id, new ValidateBst.BST(value));
        }
        for (JsonElement node : object.getAsJsonArray("nodes")) {
            String id = node.getAsJsonObject().get("id").getAsString();
            JsonElement left = node.getAsJsonObject().get("left");
            JsonElement right = node.getAsJsonObject().get("right");
            if (!left.isJsonNull()) {
                map.get(id).left = map.get(left.getAsString());
            }
            if (!right.isJsonNull()) {
                map.get(id).right = map.get(right.getAsString());
            }
        }
        return map.get(object.get("root").getAsString());
    }
}
