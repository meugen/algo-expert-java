package com.algo.expert.binarytrees;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;

public class FlattenBinaryTreeTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"5\", \"left\": \"7\", \"right\": \"8\", \"value\": 5},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED1 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"4\", \"left\": null, \"right\": \"2\", \"value\": 4},\n" +
            "    {\"id\": \"2\", \"left\": \"4\", \"right\": \"7\", \"value\": 2},\n" +
            "    {\"id\": \"7\", \"left\": \"2\", \"right\": \"5\", \"value\": 7},\n" +
            "    {\"id\": \"5\", \"left\": \"7\", \"right\": \"8\", \"value\": 5},\n" +
            "    {\"id\": \"8\", \"left\": \"5\", \"right\": \"1\", \"value\": 8},\n" +
            "    {\"id\": \"1\", \"left\": \"8\", \"right\": \"6\", \"value\": 1},\n" +
            "    {\"id\": \"6\", \"left\": \"1\", \"right\": \"3\", \"value\": 6},\n" +
            "    {\"id\": \"3\", \"left\": \"6\", \"right\": null, \"value\": 3}\n" +
            "  ],\n" +
            "  \"root\": \"4\"\n" +
            "}";

    private static final String TEST_CASE2 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED2 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "  ],\n" +
            "  \"root\": \"1\"\n" +
            "}";

    private static final String TEST_CASE3 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED3 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"2\", \"left\": null, \"right\": \"1\", \"value\": 2},\n" +
            "    {\"id\": \"1\", \"left\": \"2\", \"right\": null, \"value\": 1}\n" +
            "  ],\n" +
            "  \"root\": \"2\"\n" +
            "}";

    private static final String TEST_CASE4 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED4 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"2\", \"left\": null, \"right\": \"1\", \"value\": 2},\n" +
            "    {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "    {\"id\": \"3\", \"left\": \"1\", \"right\": null, \"value\": 3}\n" +
            "  ],\n" +
            "  \"root\": \"2\"\n" +
            "}";

    private static final String TEST_CASE5 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED5 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"4\", \"left\": null, \"right\": \"2\", \"value\": 4},\n" +
            "    {\"id\": \"2\", \"left\": \"4\", \"right\": \"1\", \"value\": 2},\n" +
            "    {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "    {\"id\": \"3\", \"left\": \"1\", \"right\": null, \"value\": 3}\n" +
            "  ],\n" +
            "  \"root\": \"4\"\n" +
            "}";

    private static final String TEST_CASE6 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED6 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"4\", \"left\": null, \"right\": \"2\", \"value\": 4},\n" +
            "    {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "    {\"id\": \"5\", \"left\": \"2\", \"right\": \"1\", \"value\": 5},\n" +
            "    {\"id\": \"1\", \"left\": \"5\", \"right\": \"3\", \"value\": 1},\n" +
            "    {\"id\": \"3\", \"left\": \"1\", \"right\": null, \"value\": 3}\n" +
            "  ],\n" +
            "  \"root\": \"4\"\n" +
            "}";

    private static final String TEST_CASE7 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED7 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"4\", \"left\": null, \"right\": \"2\", \"value\": 4},\n" +
            "    {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "    {\"id\": \"5\", \"left\": \"2\", \"right\": \"1\", \"value\": 5},\n" +
            "    {\"id\": \"1\", \"left\": \"5\", \"right\": \"6\", \"value\": 1},\n" +
            "    {\"id\": \"6\", \"left\": \"1\", \"right\": \"3\", \"value\": 6},\n" +
            "    {\"id\": \"3\", \"left\": \"6\", \"right\": null, \"value\": 3}\n" +
            "  ],\n" +
            "  \"root\": \"4\"\n" +
            "}";

    private static final String TEST_CASE8 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": 3},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"6\", \"left\": \"12\", \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"12\", \"left\": null, \"right\": null, \"value\": 12},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"5\", \"left\": \"10\", \"right\": \"11\", \"value\": 5},\n" +
            "      {\"id\": \"11\", \"left\": null, \"right\": null, \"value\": 11},\n" +
            "      {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"4\", \"left\": \"8\", \"right\": \"9\", \"value\": 4},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED8 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"8\", \"left\": null, \"right\": \"4\", \"value\": 8},\n" +
            "    {\"id\": \"4\", \"left\": \"8\", \"right\": \"9\", \"value\": 4},\n" +
            "    {\"id\": \"9\", \"left\": \"4\", \"right\": \"2\", \"value\": 9},\n" +
            "    {\"id\": \"2\", \"left\": \"9\", \"right\": \"10\", \"value\": 2},\n" +
            "    {\"id\": \"10\", \"left\": \"2\", \"right\": \"5\", \"value\": 10},\n" +
            "    {\"id\": \"5\", \"left\": \"10\", \"right\": \"11\", \"value\": 5},\n" +
            "    {\"id\": \"11\", \"left\": \"5\", \"right\": \"1\", \"value\": 11},\n" +
            "    {\"id\": \"1\", \"left\": \"11\", \"right\": \"12\", \"value\": 1},\n" +
            "    {\"id\": \"12\", \"left\": \"1\", \"right\": \"6\", \"value\": 12},\n" +
            "    {\"id\": \"6\", \"left\": \"12\", \"right\": \"3\", \"value\": 6},\n" +
            "    {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": 3},\n" +
            "    {\"id\": \"7\", \"left\": \"3\", \"right\": null, \"value\": 7}\n" +
            "  ],\n" +
            "  \"root\": \"8\"\n" +
            "}";

    private static FlattenBinaryTree.BinaryTree parseTree(JsonObject tree) {
        var nodes = tree.getAsJsonArray("nodes");

        var map = new HashMap<String, FlattenBinaryTree.BinaryTree>();
        for (var element : nodes) {
            var item = element.getAsJsonObject();
            var id = item.get("id").getAsString();
            var value = item.get("value").getAsInt();
            map.put(id, new FlattenBinaryTree.BinaryTree(value));
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
        return map.get(root);
    }

    private static Arguments parseArguments(String testCaseJson, String expectedJson) {
        var root = parseTree(new Gson().fromJson(testCaseJson, JsonObject.class).getAsJsonObject("tree"));
        var expected = parseTree(new Gson().fromJson(expectedJson, JsonObject.class));
        return Arguments.of(root, expected);
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
                parseArguments(TEST_CASE8, EXPECTED8)
        );
    }

    private static void internalTestCase(FlattenBinaryTree solution, FlattenBinaryTree.BinaryTree root, FlattenBinaryTree.BinaryTree expected) {
        var result = solution.flattenBinaryTree(root);

        Assertions.assertNull(result.left);
        while (result != null) {
            Assertions.assertNotNull(result);
            Assertions.assertEquals(expected.value, result.value);
            if (expected.right == null) {
                Assertions.assertNull(result.right);
            } else {
                Assertions.assertNotNull(result.right);
                assert result.right.left == result;
            }

            expected = expected.right;
            result = result.right;
        }
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution1(FlattenBinaryTree.BinaryTree root, FlattenBinaryTree.BinaryTree expected) {
        internalTestCase(new FlattenBinaryTree.Solution1(), root, expected);
    }
}
