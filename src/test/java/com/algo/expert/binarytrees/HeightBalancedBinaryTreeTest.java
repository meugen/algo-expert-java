package com.algo.expert.binarytrees;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;

public class HeightBalancedBinaryTreeTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": \"6\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": \"7\", \"right\": \"8\", \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final boolean EXPECTED1 = true;

    private static final String TEST_CASE2 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": \"6\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": \"7\", \"right\": \"8\", \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": \"9\", \"right\": \"10\", \"value\": 6},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "      {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final boolean EXPECTED2 = false;

    private static final String TEST_CASE3 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"11\", \"right\": \"6\", \"value\": 3},\n" +
            "      {\"id\": \"11\", \"left\": null, \"right\": null, \"value\": 11},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": \"7\", \"right\": \"8\", \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": \"9\", \"right\": \"10\", \"value\": 6},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "      {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final boolean EXPECTED3 = true;

    private static final String TEST_CASE4 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": \"5\", \"value\": 4},\n" +
            "      {\"id\": \"4\", \"left\": \"6\", \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final boolean EXPECTED4 = false;

    private static final String TEST_CASE5 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"7\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"8\", \"right\": \"5\", \"value\": 4},\n" +
            "      {\"id\": \"4\", \"left\": \"6\", \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final boolean EXPECTED5 = true;

    private static final String TEST_CASE6 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final boolean EXPECTED6 = true;

    private static final String TEST_CASE7 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"3\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final boolean EXPECTED7 = false;

    private static final String TEST_CASE8 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final boolean EXPECTED8 = true;

    private static final String TEST_CASE9 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"8\", \"right\": \"9\", \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": \"9\", \"right\": \"10\", \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": \"11\", \"right\": \"12\", \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": \"13\", \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "      {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"11\", \"left\": null, \"right\": null, \"value\": 11},\n" +
            "      {\"id\": \"12\", \"left\": null, \"right\": null, \"value\": 12},\n" +
            "      {\"id\": \"13\", \"left\": null, \"right\": null, \"value\": 13}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final boolean EXPECTED9 = true;

    private static final String TEST_CASE10 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"8\", \"right\": \"9\", \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": \"9\", \"right\": \"10\", \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": \"12\", \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "      {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"11\", \"left\": null, \"right\": null, \"value\": 11},\n" +
            "      {\"id\": \"12\", \"left\": null, \"right\": \"13\", \"value\": 12},\n" +
            "      {\"id\": \"13\", \"left\": null, \"right\": null, \"value\": 13}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final boolean EXPECTED10 = false;

    private static final String TEST_CASE11 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final boolean EXPECTED11 = false;

    private static final String TEST_CASE12 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"3\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final boolean EXPECTED12 = false;

    private static final String TEST_CASE13 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"8\", \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": \"12\", \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": \"9\", \"right\": \"10\", \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": \"11\", \"right\": null, \"value\": 8},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "      {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"11\", \"left\": null, \"right\": null, \"value\": 11},\n" +
            "      {\"id\": \"12\", \"left\": null, \"right\": null, \"value\": 12}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final boolean EXPECTED13 = false;

    private static final String TEST_CASE14 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"8\", \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": \"12\", \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": \"9\", \"right\": \"10\", \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "      {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"12\", \"left\": null, \"right\": null, \"value\": 12}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final boolean EXPECTED14 = true;

    private static HeightBalancedBinaryTree.BinaryTree parseTestCase(String testCase) {
        var object = new Gson().fromJson(testCase, JsonObject.class).getAsJsonObject("tree");
        var nodes = object.getAsJsonArray("nodes");

        var map = new HashMap<String, HeightBalancedBinaryTree.BinaryTree>();
        for (var element : nodes) {
            var item = element.getAsJsonObject();
            var id = item.get("id").getAsString();
            var value = item.get("value").getAsInt();
            map.put(id, new HeightBalancedBinaryTree.BinaryTree(value));
        }
        for (var element : nodes) {
            var item = element.getAsJsonObject();
            var id = item.get("id").getAsString();
            var treeItem = map.get(id);
            var left = item.get("left");
            var right = item.get("right");
            if (!left.isJsonNull()) {
                treeItem.left = map.get(left.getAsString());
            }
            if (!right.isJsonNull()) {
                treeItem.right = map.get(right.getAsString());
            }
        }
        var root = object.get("root").getAsString();
        return map.get(root);
    }

    private static void internalTestCase(
            HeightBalancedBinaryTree solution, String testCase, boolean expected
    ) {
        var tree = parseTestCase(testCase);
        var result = solution.heightBalancedBinaryTree(tree);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution1(String testCase, boolean expected) {
        internalTestCase(new HeightBalancedBinaryTree.Solution1(), testCase, expected);
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
                Arguments.of(TEST_CASE11, EXPECTED11),
                Arguments.of(TEST_CASE12, EXPECTED12),
                Arguments.of(TEST_CASE13, EXPECTED13),
                Arguments.of(TEST_CASE14, EXPECTED14)
        );
    }
}
