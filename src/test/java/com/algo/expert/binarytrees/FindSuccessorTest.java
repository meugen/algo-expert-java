package com.algo.expert.binarytrees;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;

public class FindSuccessorTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"parent\": null, \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"parent\": \"1\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"parent\": \"1\", \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"6\", \"parent\": \"2\", \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"parent\": \"2\", \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"parent\": \"4\", \"right\": null, \"value\": 6}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"node\": \"5\"\n" +
            "}";
    private static final String EXPECTED1 = "1";

    private static final String TEST_CASE2 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"parent\": null, \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"parent\": \"1\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"parent\": \"1\", \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"parent\": \"2\", \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": \"6\", \"parent\": \"2\", \"right\": \"7\", \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"parent\": \"5\", \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": \"8\", \"parent\": \"5\", \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"parent\": \"7\", \"right\": null, \"value\": 8}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"node\": \"5\"\n" +
            "}";
    private static final String EXPECTED2 = "8";

    private static final String TEST_CASE3 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"parent\": null, \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"parent\": \"1\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"parent\": \"1\", \"right\": \"7\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"parent\": \"2\", \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"parent\": \"2\", \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"parent\": \"3\", \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"parent\": \"3\", \"right\": null, \"value\": 7}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"node\": \"6\"\n" +
            "}";
    private static final String EXPECTED3 = "3";

    private static final String TEST_CASE4 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"parent\": null, \"right\": \"2\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"parent\": \"1\", \"right\": null, \"value\": 2}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"node\": \"2\"\n" +
            "}";
    private static final String EXPECTED4 = null;

    private static final String TEST_CASE5 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"parent\": null, \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"parent\": \"1\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"4\", \"parent\": \"1\", \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"5\", \"parent\": \"3\", \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": \"6\", \"parent\": \"4\", \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": \"7\", \"parent\": \"5\", \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"parent\": \"6\", \"right\": null, \"value\": 7}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"node\": \"1\"\n" +
            "}";
    private static final String EXPECTED5 = "7";

    private static final String TEST_CASE6 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"parent\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"3\", \"parent\": \"1\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"4\", \"parent\": \"2\", \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"5\", \"parent\": \"3\", \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"parent\": \"4\", \"right\": null, \"value\": 5}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"node\": \"3\"\n" +
            "}";
    private static final String EXPECTED6 = "2";

    private static final String TEST_CASE7 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"parent\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"3\", \"parent\": \"1\", \"right\": \"6\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"4\", \"parent\": \"2\", \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"5\", \"parent\": \"3\", \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"parent\": \"4\", \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": \"7\", \"parent\": \"2\", \"right\": \"8\", \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"parent\": \"6\", \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"parent\": \"6\", \"right\": null, \"value\": 8}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"node\": \"2\"\n" +
            "}";
    private static final String EXPECTED7 = "7";

    private static final String TEST_CASE8 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"parent\": null, \"right\": null, \"value\": 1}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"node\": \"1\"\n" +
            "}";
    private static final String EXPECTED8 = null;

    private static final String TEST_CASE9 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"parent\": null, \"right\": \"2\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"parent\": \"1\", \"right\": null, \"value\": 2}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"node\": \"1\"\n" +
            "}";
    private static final String EXPECTED9 = "2";

    private static final String TEST_CASE10 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"parent\": null, \"right\": \"5\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"parent\": \"1\", \"right\": \"3\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"parent\": \"2\", \"right\": \"4\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"parent\": \"3\", \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"parent\": \"1\", \"right\": \"6\", \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": \"7\", \"parent\": \"5\", \"right\": \"8\", \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"parent\": \"6\", \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"parent\": \"6\", \"right\": null, \"value\": 8}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"node\": \"1\"\n" +
            "}";
    private static final String EXPECTED10 = "5";

    private static final String TEST_CASE11 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"parent\": null, \"right\": \"5\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"parent\": \"1\", \"right\": \"3\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"parent\": \"2\", \"right\": \"4\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"parent\": \"3\", \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": \"9\", \"parent\": \"1\", \"right\": \"6\", \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": \"7\", \"parent\": \"5\", \"right\": \"8\", \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"parent\": \"6\", \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"parent\": \"6\", \"right\": null, \"value\": 8},\n" +
            "      {\"id\": \"9\", \"left\": \"10\", \"parent\": \"5\", \"right\": null, \"value\": 9},\n" +
            "      {\"id\": \"10\", \"left\": \"11\", \"parent\": \"9\", \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"11\", \"left\": null, \"parent\": \"10\", \"right\": null, \"value\": 11}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"node\": \"1\"\n" +
            "}";
    private static final String EXPECTED11 = "11";

    private static final String TEST_CASE12 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"parent\": null, \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"parent\": \"1\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"parent\": \"1\", \"right\": \"7\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"6\", \"parent\": \"2\", \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"parent\": \"2\", \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"parent\": \"4\", \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"parent\": \"3\", \"right\": \"8\", \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"parent\": \"7\", \"right\": null, \"value\": 8}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"node\": \"1\"\n" +
            "}";
    private static final String EXPECTED12 = "3";

    private static Arguments parseArguments(String testCase, String expected) {
        var object = new Gson().fromJson(testCase, JsonObject.class);
        var tree = object.getAsJsonObject("tree");
        var nodes = tree.getAsJsonArray("nodes");

        var map = new HashMap<String, FindSuccessor.BinaryTree>();
        for (var element : nodes) {
            var item = element.getAsJsonObject();
            var id = item.get("id").getAsString();
            var value = item.get("value").getAsInt();
            map.put(id, new FindSuccessor.BinaryTree(value));
        }
        for (var element : nodes) {
            var item = element.getAsJsonObject();
            var id = item.get("id").getAsString();
            var treeItem = map.get(id);
            var left = item.get("left");
            var parent = item.get("parent");
            var right = item.get("right");
            if (!left.isJsonNull()) {
                treeItem.left = map.get(left.getAsString());
            }
            if (!parent.isJsonNull()) {
                treeItem.parent = map.get(parent.getAsString());
            }
            if (!right.isJsonNull()) {
                treeItem.right = map.get(right.getAsString());
            }
        }
        var root = tree.get("root").getAsString();
        var node = object.get("node").getAsString();
        return Arguments.of(map.get(root), map.get(node), expected);
    }

    private static void internalTestCase(
            FindSuccessor solution, FindSuccessor.BinaryTree tree,
            FindSuccessor.BinaryTree node, String expected
    ) {
        var result = solution.findSuccessor(tree, node);
        String nodeId = result == null ? null : Integer.toString(result.value);
        Assertions.assertEquals(expected, nodeId);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution1(FindSuccessor.BinaryTree tree, FindSuccessor.BinaryTree node, String expected) {
        internalTestCase(new FindSuccessor.Solution1(), tree, node, expected);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution2(FindSuccessor.BinaryTree tree, FindSuccessor.BinaryTree node, String expected) {
        internalTestCase(new FindSuccessor.Solution2(), tree, node, expected);
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
                parseArguments(TEST_CASE12, EXPECTED12)
        );
    }
}
