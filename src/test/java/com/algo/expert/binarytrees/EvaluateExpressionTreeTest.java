package com.algo.expert.binarytrees;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;

public class EvaluateExpressionTreeTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": -1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED1 = 5;

    private static final String TEST_CASE2 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": -2},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED2 = -1;

    private static final String TEST_CASE3 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"3\", \"right\": \"2\", \"value\": -2},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED3 = 1;

    private static final String TEST_CASE4 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": -3},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED4 = 0;

    private static final String TEST_CASE5 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"3\", \"right\": \"2\", \"value\": -3},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED5 = 1;

    private static final String TEST_CASE6 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": -4},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED6 = 6;

    private static final String TEST_CASE7 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": -1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"4\", \"right\": \"5\", \"value\": -2},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED7 = 1;

    private static final String TEST_CASE8 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"10\", \"right\": \"3\", \"value\": -3},\n" +
            "      {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"3\", \"left\": \"4\", \"right\": \"6\", \"value\": -2},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED8 = -5;

    private static final String TEST_CASE9 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"9\", \"right\": \"3\", \"value\": -3},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "      {\"id\": \"3\", \"left\": \"4\", \"right\": \"6\", \"value\": -2},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED9 = -4;

    private static final String TEST_CASE10 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"9\", \"right\": \"3\", \"value\": -3},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"4\", \"value\": -2},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED10 = 4;

    private static final String TEST_CASE11 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": -2},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": -1},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": -3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 12},\n" +
            "      {\"id\": \"7\", \"left\": \"8\", \"right\": \"9\", \"value\": -4},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 4}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED11 = 14;

    private static final String TEST_CASE12 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": -1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": -2},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": -4},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 12},\n" +
            "      {\"id\": \"7\", \"left\": \"8\", \"right\": \"9\", \"value\": -3},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 4}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED12 = 21;

    private static final String TEST_CASE13 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": -1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": -1},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": -1},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 12},\n" +
            "      {\"id\": \"7\", \"left\": \"8\", \"right\": \"9\", \"value\": -1},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 4}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED13 = 41;

    private static final String TEST_CASE14 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": -2},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": -2},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": -2},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 12},\n" +
            "      {\"id\": \"7\", \"left\": \"8\", \"right\": \"9\", \"value\": -2},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 4}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED14 = -11;

    private static final String TEST_CASE15 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": -3},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": -3},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": -3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 100},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"7\", \"left\": \"8\", \"right\": \"9\", \"value\": -3},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 4}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED15 = 5;

    private static final String TEST_CASE16 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": -4},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": -4},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": -4},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"7\", \"left\": \"8\", \"right\": \"9\", \"value\": -4},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED16 = 224;

    private static final String TEST_CASE17 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"9\", \"value\": -4},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"3\", \"value\": -1},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "      {\"id\": \"4\", \"left\": \"5\", \"right\": \"6\", \"value\": -1},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"6\", \"left\": \"7\", \"right\": \"8\", \"value\": -2},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"9\", \"left\": \"10\", \"right\": \"11\", \"value\": -3},\n" +
            "      {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 100},\n" +
            "      {\"id\": \"11\", \"left\": \"12\", \"right\": \"13\", \"value\": -2},\n" +
            "      {\"id\": \"12\", \"left\": null, \"right\": null, \"value\": 42},\n" +
            "      {\"id\": \"13\", \"left\": \"14\", \"right\": \"15\", \"value\": -3},\n" +
            "      {\"id\": \"14\", \"left\": \"16\", \"right\": \"17\", \"value\": -4},\n" +
            "      {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"16\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"17\", \"left\": null, \"right\": null, \"value\": 9}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED17 = 96;

    private static EvaluateExpressionTree.BinaryTree parseTree(String json) {
        var object = new Gson().fromJson(json, JsonObject.class).getAsJsonObject("tree");
        var nodes = object.getAsJsonArray("nodes");

        var map = new HashMap<String, EvaluateExpressionTree.BinaryTree>();
        for (var element : nodes) {
            var item = element.getAsJsonObject();
            var id = item.get("id").getAsString();
            var value = item.get("value").getAsInt();
            map.put(id, new EvaluateExpressionTree.BinaryTree(value));
        }
        for (var element : nodes) {
            var item = element.getAsJsonObject();
            var id = item.get("id").getAsString();
            var left = item.get("left");
            var right = item.get("right");
            var treeItem = map.get(id);
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

    private static void internalTestCase(EvaluateExpressionTree solution, EvaluateExpressionTree.BinaryTree tree, int expected) {
        int result = solution.evaluateExpressionTree(tree);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCase(EvaluateExpressionTree.BinaryTree tree, int expected) {
        internalTestCase(new EvaluateExpressionTree.Solution1(), tree, expected);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(parseTree(TEST_CASE1), EXPECTED1),
                Arguments.of(parseTree(TEST_CASE2), EXPECTED2),
                Arguments.of(parseTree(TEST_CASE3), EXPECTED3),
                Arguments.of(parseTree(TEST_CASE4), EXPECTED4),
                Arguments.of(parseTree(TEST_CASE5), EXPECTED5),
                Arguments.of(parseTree(TEST_CASE6), EXPECTED6),
                Arguments.of(parseTree(TEST_CASE7), EXPECTED7),
                Arguments.of(parseTree(TEST_CASE8), EXPECTED8),
                Arguments.of(parseTree(TEST_CASE9), EXPECTED9),
                Arguments.of(parseTree(TEST_CASE10), EXPECTED10),
                Arguments.of(parseTree(TEST_CASE11), EXPECTED11),
                Arguments.of(parseTree(TEST_CASE12), EXPECTED12),
                Arguments.of(parseTree(TEST_CASE13), EXPECTED13),
                Arguments.of(parseTree(TEST_CASE14), EXPECTED14),
                Arguments.of(parseTree(TEST_CASE15), EXPECTED15),
                Arguments.of(parseTree(TEST_CASE16), EXPECTED16),
                Arguments.of(parseTree(TEST_CASE17), EXPECTED17)
        );
    }
}
