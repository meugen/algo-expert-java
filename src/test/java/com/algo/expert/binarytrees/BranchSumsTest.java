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

public class BranchSumsTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"tree\": {\n" +
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
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE6 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": \"8\", \"right\": \"9\", \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": \"10\", \"right\": \"1-2\", \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": \"1-3\", \"right\": \"1-4\", \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "      {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"1-2\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"1-3\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"1-4\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE7 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"0\", \"left\": \"1\", \"right\": null, \"value\": 0},\n" +
            "      {\"id\": \"1\", \"left\": \"10\", \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"10\", \"left\": \"100\", \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"100\", \"left\": null, \"right\": null, \"value\": 100}\n" +
            "    ],\n" +
            "    \"root\": \"0\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE8 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"0\", \"left\": null, \"right\": \"1\", \"value\": 0},\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": \"10\", \"value\": 1},\n" +
            "      {\"id\": \"10\", \"left\": null, \"right\": \"100\", \"value\": 10},\n" +
            "      {\"id\": \"100\", \"left\": null, \"right\": null, \"value\": 100}\n" +
            "    ],\n" +
            "    \"root\": \"0\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE9 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"0\", \"left\": \"9\", \"right\": \"1\", \"value\": 0},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "      {\"id\": \"1\", \"left\": \"15\", \"right\": \"10\", \"value\": 1},\n" +
            "      {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "      {\"id\": \"10\", \"left\": \"100\", \"right\": \"200\", \"value\": 10},\n" +
            "      {\"id\": \"100\", \"left\": null, \"right\": null, \"value\": 100},\n" +
            "      {\"id\": \"200\", \"left\": null, \"right\": null, \"value\": 200}\n" +
            "    ],\n" +
            "    \"root\": \"0\"\n" +
            "  }\n" +
            "}";

    @ParameterizedTest
    @MethodSource("params")
    void testCases(BranchSums.BinaryTree root, List<Integer> expected) {
        List<Integer> result = BranchSums.branchSums(root);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(parseTestCase(TEST_CASE1), List.of(15, 16, 18, 10, 11)),
                Arguments.of(parseTestCase(TEST_CASE2), List.of(1)),
                Arguments.of(parseTestCase(TEST_CASE3), List.of(3)),
                Arguments.of(parseTestCase(TEST_CASE4), List.of(3, 4)),
                Arguments.of(parseTestCase(TEST_CASE5), List.of(7, 8, 4)),
                Arguments.of(parseTestCase(TEST_CASE6), List.of(15, 16, 18, 9, 11, 11, 11)),
                Arguments.of(parseTestCase(TEST_CASE7), List.of(111)),
                Arguments.of(parseTestCase(TEST_CASE8), List.of(111)),
                Arguments.of(parseTestCase(TEST_CASE9), List.of(9, 16, 111, 211))
        );
    }

    static BranchSums.BinaryTree parseTestCase(String json) {
        Map<String, BranchSums.BinaryTree> map = new HashMap<>();

        JsonObject tree = new Gson().fromJson(json, JsonElement.class)
                .getAsJsonObject().getAsJsonObject("tree");
        for (JsonElement node : tree.getAsJsonArray("nodes")) {
            String id = node.getAsJsonObject().getAsJsonPrimitive("id").getAsString();
            int value = node.getAsJsonObject().getAsJsonPrimitive("value").getAsInt();
            map.put(id, new BranchSums.BinaryTree(value));
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
