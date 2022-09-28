package com.algo.expert.binarytrees;

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

public class NodeDepthsTest {

    private static final String TEST_CASE1 = "{\n" +
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
    private static final String TEST_CASE2 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
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
    private static final String TEST_CASE4 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE5 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE6 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"3\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"4\", \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"5\", \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": \"6\", \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE7 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"8\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"3\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"4\", \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"5\", \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": \"6\", \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": \"9\", \"value\": 8},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": \"10\", \"value\": 9},\n" +
            "      {\"id\": \"10\", \"left\": null, \"right\": \"11\", \"value\": 10},\n" +
            "      {\"id\": \"11\", \"left\": null, \"right\": \"12\", \"value\": 11},\n" +
            "      {\"id\": \"12\", \"left\": \"13\", \"right\": null, \"value\": 12},\n" +
            "      {\"id\": \"13\", \"left\": null, \"right\": null, \"value\": 13}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE8 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"8\", \"right\": \"9\", \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": \"10\", \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "      {\"id\": \"10\", \"left\": null, \"right\": \"11\", \"value\": 10},\n" +
            "      {\"id\": \"11\", \"left\": \"12\", \"right\": \"13\", \"value\": 11},\n" +
            "      {\"id\": \"12\", \"left\": \"14\", \"right\": null, \"value\": 12},\n" +
            "      {\"id\": \"13\", \"left\": \"15\", \"right\": \"16\", \"value\": 13},\n" +
            "      {\"id\": \"14\", \"left\": null, \"right\": null, \"value\": 14},\n" +
            "      {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "      {\"id\": \"16\", \"left\": null, \"right\": null, \"value\": 16}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE9 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"3\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"4\", \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"5\", \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": \"6\", \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": \"7\", \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": \"8\", \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": \"9\", \"right\": null, \"value\": 8},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";

    private void internalTestCases(NodeDepths impl, NodeDepths.BinaryTree root, int expected) {
        int result = impl.nodeDepths(root);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCases(NodeDepths.BinaryTree root, int expected) {
        internalTestCases(new NodeDepths.Solution1(), root, expected);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(parseTestCase(TEST_CASE1), 16),
                Arguments.of(parseTestCase(TEST_CASE2), 0),
                Arguments.of(parseTestCase(TEST_CASE3), 1),
                Arguments.of(parseTestCase(TEST_CASE4), 2),
                Arguments.of(parseTestCase(TEST_CASE5), 4),
                Arguments.of(parseTestCase(TEST_CASE6), 21),
                Arguments.of(parseTestCase(TEST_CASE7), 42),
                Arguments.of(parseTestCase(TEST_CASE8), 51),
                Arguments.of(parseTestCase(TEST_CASE9), 36)
        );
    }

    static NodeDepths.BinaryTree parseTestCase(String json) {
        Map<String, NodeDepths.BinaryTree> map = new HashMap<>();

        JsonObject tree = new Gson().fromJson(json, JsonElement.class)
                .getAsJsonObject().getAsJsonObject("tree");
        for (JsonElement node : tree.getAsJsonArray("nodes")) {
            String id = node.getAsJsonObject().getAsJsonPrimitive("id").getAsString();
            int value = node.getAsJsonObject().getAsJsonPrimitive("value").getAsInt();
            map.put(id, new NodeDepths.BinaryTree(value));
        }
        for (JsonElement node : tree.getAsJsonArray("nodes")) {
            String id = node.getAsJsonObject().getAsJsonPrimitive("id").getAsString();
            JsonElement left = node.getAsJsonObject().get("left");
            JsonElement right = node.getAsJsonObject().get("right");
            if (!left.isJsonNull()) {
                map.get(id).left = map.get(left.getAsString());
            }
            if (!right.isJsonNull()) {
                map.get(id).right = map.get(right.getAsString());
            }
        }
        String root = tree.getAsJsonPrimitive("root").getAsString();
        return map.get(root);
    }
}
