package com.algo.expert.binarytrees;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;

public class InvertBinaryTreeTest {

    private static final String TEST_CASE1 = "{\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"8\", \"right\": \"9\", \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "}";
    private static final String EXPECTED1 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"1\", \"left\": \"3\", \"right\": \"2\", \"value\": 1},\n" +
            "    {\"id\": \"2\", \"left\": \"5\", \"right\": \"4\", \"value\": 2},\n" +
            "    {\"id\": \"4\", \"left\": \"9\", \"right\": \"8\", \"value\": 4},\n" +
            "    {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "    {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "    {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "    {\"id\": \"3\", \"left\": \"7\", \"right\": \"6\", \"value\": 3},\n" +
            "    {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "    {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7}\n" +
            "  ],\n" +
            "  \"root\": \"1\"\n" +
            "}";

    private static final String TEST_CASE2 = "{\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "}";
    private static final String EXPECTED2 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "  ],\n" +
            "  \"root\": \"1\"\n" +
            "}";

    private static final String TEST_CASE3 = "{\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "}";
    private static final String EXPECTED3 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "    {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "  ],\n" +
            "  \"root\": \"1\"\n" +
            "}";

    private static final String TEST_CASE4 = "{\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "}";
    private static final String EXPECTED4 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"1\", \"left\": \"3\", \"right\": \"2\", \"value\": 1},\n" +
            "    {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "    {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "  ],\n" +
            "  \"root\": \"1\"\n" +
            "}";

    private static final String TEST_CASE5 = "{\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "}";
    private static final String EXPECTED5 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"1\", \"left\": \"3\", \"right\": \"2\", \"value\": 1},\n" +
            "    {\"id\": \"2\", \"left\": null, \"right\": \"4\", \"value\": 2},\n" +
            "    {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "    {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "  ],\n" +
            "  \"root\": \"1\"\n" +
            "}";

    private static final String TEST_CASE6 = "{\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "}";
    private static final String EXPECTED6 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"1\", \"left\": \"3\", \"right\": \"2\", \"value\": 1},\n" +
            "    {\"id\": \"2\", \"left\": \"5\", \"right\": \"4\", \"value\": 2},\n" +
            "    {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "    {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "    {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "  ],\n" +
            "  \"root\": \"1\"\n" +
            "}";

    private static final String TEST_CASE7 = "{\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "}";
    private static final String EXPECTED7 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"1\", \"left\": \"3\", \"right\": \"2\", \"value\": 1},\n" +
            "    {\"id\": \"2\", \"left\": \"5\", \"right\": \"4\", \"value\": 2},\n" +
            "    {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "    {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "    {\"id\": \"3\", \"left\": null, \"right\": \"6\", \"value\": 3},\n" +
            "    {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6}\n" +
            "  ],\n" +
            "  \"root\": \"1\"\n" +
            "}";

    private static final String TEST_CASE8 = "{\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "}";
    private static final String EXPECTED8 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"1\", \"left\": \"3\", \"right\": \"2\", \"value\": 1},\n" +
            "    {\"id\": \"2\", \"left\": \"5\", \"right\": \"4\", \"value\": 2},\n" +
            "    {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "    {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "    {\"id\": \"3\", \"left\": \"7\", \"right\": \"6\", \"value\": 3},\n" +
            "    {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "    {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7}\n" +
            "  ],\n" +
            "  \"root\": \"1\"\n" +
            "}";

    private static final String TEST_CASE9 = "{\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"8\", \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "}";
    private static final String EXPECTED9 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"1\", \"left\": \"3\", \"right\": \"2\", \"value\": 1},\n" +
            "    {\"id\": \"2\", \"left\": \"5\", \"right\": \"4\", \"value\": 2},\n" +
            "    {\"id\": \"4\", \"left\": null, \"right\": \"8\", \"value\": 4},\n" +
            "    {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "    {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "    {\"id\": \"3\", \"left\": \"7\", \"right\": \"6\", \"value\": 3},\n" +
            "    {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "    {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7}\n" +
            "  ],\n" +
            "  \"root\": \"1\"\n" +
            "}";

    private static final String TEST_CASE10 = "{\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"8\", \"right\": \"9\", \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": \"10\", \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "      {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "}";
    private static final String EXPECTED10 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"1\", \"left\": \"3\", \"right\": \"2\", \"value\": 1},\n" +
            "    {\"id\": \"2\", \"left\": \"5\", \"right\": \"4\", \"value\": 2},\n" +
            "    {\"id\": \"4\", \"left\": \"9\", \"right\": \"8\", \"value\": 4},\n" +
            "    {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "    {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "    {\"id\": \"5\", \"left\": null, \"right\": \"10\", \"value\": 5},\n" +
            "    {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "    {\"id\": \"3\", \"left\": \"7\", \"right\": \"6\", \"value\": 3},\n" +
            "    {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "    {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7}\n" +
            "  ],\n" +
            "  \"root\": \"1\"\n" +
            "}";

    private static final String TEST_CASE11 = "{\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"8\", \"right\": \"9\", \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": \"10\", \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": \"11\", \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": \"12\", \"value\": 8},\n" +
            "      {\"id\": \"9\", \"left\": \"13\", \"right\": \"14\", \"value\": 9},\n" +
            "      {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"11\", \"left\": \"15\", \"right\": \"16\", \"value\": 11},\n" +
            "      {\"id\": \"12\", \"left\": null, \"right\": null, \"value\": 12},\n" +
            "      {\"id\": \"13\", \"left\": null, \"right\": null, \"value\": 13},\n" +
            "      {\"id\": \"14\", \"left\": null, \"right\": null, \"value\": 14},\n" +
            "      {\"id\": \"15\", \"left\": null, \"right\": \"17\", \"value\": 15},\n" +
            "      {\"id\": \"16\", \"left\": null, \"right\": null, \"value\": 16},\n" +
            "      {\"id\": \"17\", \"left\": null, \"right\": \"18\", \"value\": 17},\n" +
            "      {\"id\": \"18\", \"left\": null, \"right\": \"19\", \"value\": 18},\n" +
            "      {\"id\": \"19\", \"left\": \"20\", \"right\": null, \"value\": 19},\n" +
            "      {\"id\": \"20\", \"left\": \"21\", \"right\": null, \"value\": 20},\n" +
            "      {\"id\": \"21\", \"left\": null, \"right\": null, \"value\": 21}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "}";
    private static final String EXPECTED11 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"1\", \"left\": \"3\", \"right\": \"2\", \"value\": 1},\n" +
            "    {\"id\": \"2\", \"left\": \"5\", \"right\": \"4\", \"value\": 2},\n" +
            "    {\"id\": \"4\", \"left\": \"9\", \"right\": \"8\", \"value\": 4},\n" +
            "    {\"id\": \"8\", \"left\": \"12\", \"right\": null, \"value\": 8},\n" +
            "    {\"id\": \"12\", \"left\": null, \"right\": null, \"value\": 12},\n" +
            "    {\"id\": \"9\", \"left\": \"14\", \"right\": \"13\", \"value\": 9},\n" +
            "    {\"id\": \"13\", \"left\": null, \"right\": null, \"value\": 13},\n" +
            "    {\"id\": \"14\", \"left\": null, \"right\": null, \"value\": 14},\n" +
            "    {\"id\": \"5\", \"left\": null, \"right\": \"10\", \"value\": 5},\n" +
            "    {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "    {\"id\": \"3\", \"left\": \"7\", \"right\": \"6\", \"value\": 3},\n" +
            "    {\"id\": \"6\", \"left\": \"11\", \"right\": null, \"value\": 6},\n" +
            "    {\"id\": \"11\", \"left\": \"16\", \"right\": \"15\", \"value\": 11},\n" +
            "    {\"id\": \"15\", \"left\": \"17\", \"right\": null, \"value\": 15},\n" +
            "    {\"id\": \"17\", \"left\": \"18\", \"right\": null, \"value\": 17},\n" +
            "    {\"id\": \"18\", \"left\": \"19\", \"right\": null, \"value\": 18},\n" +
            "    {\"id\": \"19\", \"left\": null, \"right\": \"20\", \"value\": 19},\n" +
            "    {\"id\": \"20\", \"left\": null, \"right\": \"21\", \"value\": 20},\n" +
            "    {\"id\": \"21\", \"left\": null, \"right\": null, \"value\": 21},\n" +
            "    {\"id\": \"16\", \"left\": null, \"right\": null, \"value\": 16},\n" +
            "    {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7}\n" +
            "  ],\n" +
            "  \"root\": \"1\"\n" +
            "}";

    private static InvertBinaryTree.BinaryTree parseBinaryTree(String json) {
        var object = new Gson().fromJson(json, JsonObject.class);
        var nodes = object.getAsJsonArray("nodes");

        var map = new HashMap<String, InvertBinaryTree.BinaryTree>();
        for (var element : nodes) {
            var item = element.getAsJsonObject();
            var value = item.get("value").getAsInt();
            var id = item.get("id").getAsString();
            map.put(id, new InvertBinaryTree.BinaryTree(value));
        }
        for (var element : nodes) {
            var item = element.getAsJsonObject();
            var id = item.get("id").getAsString();
            var left = item.get("left");
            var right = item.get("right");
            var tree = map.get(id);
            if (!left.isJsonNull()) {
                tree.left = map.get(left.getAsString());
            }
            if (!right.isJsonNull()) {
                tree.right = map.get(right.getAsString());
            }
        }
        var root = object.get("root").getAsString();
        return map.get(root);
    }

    private static void internalTestCase(InvertBinaryTree solution, String testCase, String expected) {
        var inputTree = parseBinaryTree(testCase);
        solution.invertBinaryTree(inputTree);
        validateResult(inputTree, parseBinaryTree(expected));
    }

    private static void validateResult(InvertBinaryTree.BinaryTree result, InvertBinaryTree.BinaryTree expected) {
        Assertions.assertEquals(expected.value, result.value);
        if (result.left == null) {
            Assertions.assertNull(expected.left);
        } else {
            Assertions.assertNotNull(expected.left);
            validateResult(result.left, expected.left);
        }
        if (result.right == null) {
            Assertions.assertNull(expected.right);
        } else {
            Assertions.assertNotNull(expected.right);
            validateResult(result.right, expected.right);
        }
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCase(String testCase, String expected) {
        internalTestCase(new InvertBinaryTree.Solution1(), testCase, expected);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(TEST_CASE1, EXPECTED1),
                Arguments.of(TEST_CASE2, EXPECTED2),
                Arguments.of(TEST_CASE3, EXPECTED3),
                Arguments.of(TEST_CASE4, EXPECTED4),
                Arguments.of(TEST_CASE5, EXPECTED5),
                Arguments.of(TEST_CASE6, EXPECTED6),
                Arguments.of(TEST_CASE7, EXPECTED7),
                Arguments.of(TEST_CASE8, EXPECTED8),
                Arguments.of(TEST_CASE9, EXPECTED9),
                Arguments.of(TEST_CASE10, EXPECTED10),
                Arguments.of(TEST_CASE11, EXPECTED11)
        );
    }
}
