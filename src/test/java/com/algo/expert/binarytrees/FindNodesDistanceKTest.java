package com.algo.expert.binarytrees;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;

public class FindNodesDistanceKTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"k\": 2,\n" +
            "  \"target\": 3,\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": \"6\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": \"7\", \"right\": \"8\", \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final List<Integer> EXPECTED1 = Arrays.asList(7, 8, 2);

    private static final String TEST_CASE2 = "{\n" +
            "  \"k\": 3,\n" +
            "  \"target\": 2,\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"3\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"4\", \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"5\", \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final List<Integer> EXPECTED2 = Collections.singletonList(5);

    private static final String TEST_CASE3 = "{\n" +
            "  \"k\": 6,\n" +
            "  \"target\": 8,\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"5\", \"right\": \"6\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final List<Integer> EXPECTED3 = Collections.singletonList(4);

    private static final String TEST_CASE4 = "{\n" +
            "  \"k\": 1,\n" +
            "  \"target\": 3,\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"5\", \"right\": \"6\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final List<Integer> EXPECTED4 = Arrays.asList(5, 6, 1);

    private static final String TEST_CASE5 = "{\n" +
            "  \"k\": 2,\n" +
            "  \"target\": 1,\n" +
            "  \"tree\": {\n" +
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
            "  }\n" +
            "}";
    private static final List<Integer> EXPECTED5 = Arrays.asList(4, 5, 6, 7);

    private static final String TEST_CASE6 = "{\n" +
            "  \"k\": 2,\n" +
            "  \"target\": 8,\n" +
            "  \"tree\": {\n" +
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
            "  }\n" +
            "}";
    private static final List<Integer> EXPECTED6 = Arrays.asList(9, 2);

    private static final String TEST_CASE7 = "{\n" +
            "  \"k\": 6,\n" +
            "  \"target\": 6,\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": \"5\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"6\", \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": \"7\", \"right\": \"8\", \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final List<Integer> EXPECTED7 = Arrays.asList(7, 8);

    private static final String TEST_CASE8 = "{\n" +
            "  \"k\": 1,\n" +
            "  \"target\": 1,\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final List<Integer> EXPECTED8 = Collections.emptyList();

    private static final String TEST_CASE9 = "{\n" +
            "  \"k\": 17,\n" +
            "  \"target\": 6,\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": \"5\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"6\", \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": \"7\", \"right\": \"8\", \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final List<Integer> EXPECTED9 = Collections.emptyList();

    private static final String TEST_CASE10 = "{\n" +
            "  \"k\": 2,\n" +
            "  \"target\": 2,\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"8\", \"right\": \"9\", \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": \"10\", \"right\": \"11\", \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": \"12\", \"right\": \"13\", \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
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
    private static final List<Integer> EXPECTED10 = Arrays.asList(8,9,10,11,3);

    private static Arguments parseArguments(String json, List<Integer> expected) {
        var object = new Gson().fromJson(json, JsonObject.class);
        var tree = object.getAsJsonObject("tree");
        var nodes = tree.getAsJsonArray("nodes");

        var map = new HashMap<String, FindNodesDistanceK.BinaryTree>();
        for (var element : nodes) {
            var item = element.getAsJsonObject();
            var id = item.get("id").getAsString();
            var value = item.get("value").getAsInt();
            map.put(id, new FindNodesDistanceK.BinaryTree(value));
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
        var root = tree.get("root").getAsString();
        var k = object.get("k").getAsInt();
        var target = object.get("target").getAsInt();
        return Arguments.of(map.get(root), target, k, expected);
    }

    private static void internalTestCase(FindNodesDistanceK solution, FindNodesDistanceK.BinaryTree tree, int target, int k, List<Integer> expected) {
        var result = solution.findNodesDistanceK(tree, target, k);
        var sortedResult = result.stream().sorted().toArray();
        var sortedExpected = expected.stream().sorted().toArray();
        Assertions.assertArrayEquals(sortedExpected, sortedResult);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCase(FindNodesDistanceK.BinaryTree tree, int target, int k, List<Integer> expected) {
        internalTestCase(new FindNodesDistanceK.Solution1(), tree, target, k, expected);
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
                parseArguments(TEST_CASE10, EXPECTED10)
        );
    }
}
