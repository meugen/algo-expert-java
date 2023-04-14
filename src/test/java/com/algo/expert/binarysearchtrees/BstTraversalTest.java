package com.algo.expert.binarysearchtrees;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BstTraversalTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "      {\"id\": \"15\", \"left\": null, \"right\": \"22\", \"value\": 15},\n" +
            "      {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "      {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "      {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "    ],\n" +
            "    \"root\": \"10\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED1 = "{\n" +
            "  \"inOrderArray\": [1, 2, 5, 5, 10, 15, 22],\n" +
            "  \"postOrderArray\": [1, 2, 5, 5, 22, 15, 10],\n" +
            "  \"preOrderArray\": [10, 5, 2, 1, 5, 15, 22]\n" +
            "}";
    private static final String TEST_CASE2 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"100\", \"left\": \"5\", \"right\": \"502\", \"value\": 100},\n" +
            "      {\"id\": \"502\", \"left\": \"204\", \"right\": \"55000\", \"value\": 502},\n" +
            "      {\"id\": \"55000\", \"left\": \"1001\", \"right\": null, \"value\": 55000},\n" +
            "      {\"id\": \"1001\", \"left\": null, \"right\": \"4500\", \"value\": 1001},\n" +
            "      {\"id\": \"4500\", \"left\": null, \"right\": null, \"value\": 4500},\n" +
            "      {\"id\": \"204\", \"left\": \"203\", \"right\": \"205\", \"value\": 204},\n" +
            "      {\"id\": \"205\", \"left\": null, \"right\": \"207\", \"value\": 205},\n" +
            "      {\"id\": \"207\", \"left\": \"206\", \"right\": \"208\", \"value\": 207},\n" +
            "      {\"id\": \"208\", \"left\": null, \"right\": null, \"value\": 208},\n" +
            "      {\"id\": \"206\", \"left\": null, \"right\": null, \"value\": 206},\n" +
            "      {\"id\": \"203\", \"left\": null, \"right\": null, \"value\": 203},\n" +
            "      {\"id\": \"5\", \"left\": \"2\", \"right\": \"15\", \"value\": 5},\n" +
            "      {\"id\": \"15\", \"left\": \"5-2\", \"right\": \"22\", \"value\": 15},\n" +
            "      {\"id\": \"22\", \"left\": null, \"right\": \"57\", \"value\": 22},\n" +
            "      {\"id\": \"57\", \"left\": null, \"right\": \"60\", \"value\": 57},\n" +
            "      {\"id\": \"60\", \"left\": null, \"right\": null, \"value\": 60},\n" +
            "      {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"2\", \"left\": \"1\", \"right\": \"3\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"1\", \"left\": \"-51\", \"right\": \"1-2\", \"value\": 1},\n" +
            "      {\"id\": \"1-2\", \"left\": null, \"right\": \"1-3\", \"value\": 1},\n" +
            "      {\"id\": \"1-3\", \"left\": null, \"right\": \"1-4\", \"value\": 1},\n" +
            "      {\"id\": \"1-4\", \"left\": null, \"right\": \"1-5\", \"value\": 1},\n" +
            "      {\"id\": \"1-5\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"-51\", \"left\": \"-403\", \"right\": null, \"value\": -51},\n" +
            "      {\"id\": \"-403\", \"left\": null, \"right\": null, \"value\": -403}\n" +
            "    ],\n" +
            "    \"root\": \"100\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED2 = "{\n" +
            "  \"inOrderArray\": [-403, -51, 1, 1, 1, 1, 1, 2, 3, 5, 5, 15, 22, 57, 60, 100, 203, 204, 205, 206, 207, 208, 502, 1001, 4500, 55000],\n" +
            "  \"postOrderArray\": [-403, -51, 1, 1, 1, 1, 1, 3, 2, 5, 60, 57, 22, 15, 5, 203, 206, 208, 207, 205, 204, 4500, 1001, 55000, 502, 100],\n" +
            "  \"preOrderArray\": [100, 5, 2, 1, -51, -403, 1, 1, 1, 1, 3, 15, 5, 22, 57, 60, 502, 204, 203, 205, 207, 206, 208, 55000, 1001, 4500]\n" +
            "}";
    private static final String TEST_CASE3 = "{\n" +
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
    private static final String EXPECTED3 = "{\n" +
            "  \"inOrderArray\": [-22, -15, -5, -5, -2, -1, 1, 2, 5, 5, 10, 15, 22],\n" +
            "  \"postOrderArray\": [-22, -15, -1, -2, -5, -5, 1, 2, 5, 5, 22, 15, 10],\n" +
            "  \"preOrderArray\": [10, 5, 2, 1, -5, -15, -22, -5, -2, -1, 5, 15, 22]\n" +
            "}";
    private static final String TEST_CASE4 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10}\n" +
            "    ],\n" +
            "    \"root\": \"10\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED4 = "{\n" +
            "  \"inOrderArray\": [10],\n" +
            "  \"postOrderArray\": [10],\n" +
            "  \"preOrderArray\": [10]\n" +
            "}";
    private static final String TEST_CASE5 = "{\n" +
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
    private static final String EXPECTED5 = "{\n" +
            "  \"inOrderArray\": [1, 2, 5, 5, 10, 15, 22, 50, 200, 500, 1500, 2200, 10000],\n" +
            "  \"postOrderArray\": [1, 2, 5, 5, 200, 50, 2200, 10000, 1500, 500, 22, 15, 10],\n" +
            "  \"preOrderArray\": [10, 5, 2, 1, 5, 15, 22, 500, 50, 200, 1500, 10000, 2200]\n" +
            "}";
    private static final String TEST_CASE6 = "{\n" +
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
    private static final String EXPECTED6 = "{\n" +
            "  \"inOrderArray\": [1, 1, 1, 1, 1, 2, 3, 5, 5, 15, 22, 203, 204, 205, 206, 207, 208, 502, 5000, 55000],\n" +
            "  \"postOrderArray\": [1, 1, 1, 1, 1, 3, 2, 5, 203, 206, 208, 207, 205, 204, 502, 22, 15, 5, 55000, 5000],\n" +
            "  \"preOrderArray\": [5000, 5, 2, 1, 1, 1, 1, 1, 3, 15, 5, 22, 502, 204, 203, 205, 207, 206, 208, 55000]\n" +
            "}";

    private void internalTestCases(BstTraversal impl, BstTraversal.BST tree, Expected expected) {
        List<Integer> result = impl.inOrderTraverse(tree, new ArrayList<>());
        assertListEquals(expected.inOrder, result);
        result = impl.postOrderTraverse(tree, new ArrayList<>());
        assertListEquals(expected.postOrder, result);
        result = impl.preOrderTraverse(tree, new ArrayList<>());
        assertListEquals(expected.preOrder, result);
    }

    private void assertListEquals(List<Integer> expected, List<Integer> actual) {
        Assertions.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), actual.get(i));
        }
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCasesSolution1(BstTraversal.BST tree, Expected expected) {
        internalTestCases(new BstTraversal.Solution1(), tree, expected);
    }

    static List<Arguments> params() {
        return List.of(
                parseArguments(TEST_CASE1, EXPECTED1),
                parseArguments(TEST_CASE2, EXPECTED2),
                parseArguments(TEST_CASE3, EXPECTED3),
                parseArguments(TEST_CASE4, EXPECTED4),
                parseArguments(TEST_CASE5, EXPECTED5),
                parseArguments(TEST_CASE6, EXPECTED6)
        );
    }

    private static Arguments parseArguments(String testCase, String expected) {
        JsonObject treeObject = new Gson().fromJson(testCase, JsonElement.class)
                .getAsJsonObject().getAsJsonObject("tree");
        Map<String, BstTraversal.BST> map = new HashMap<>();
        for (JsonElement node : treeObject.getAsJsonArray("nodes")) {
            String id = node.getAsJsonObject().get("id").getAsString();
            int value = node.getAsJsonObject().get("value").getAsInt();
            map.put(id, new BstTraversal.BST(value));
        }
        for (JsonElement node : treeObject.getAsJsonArray("nodes")) {
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
        BstTraversal.BST tree = map.get(treeObject.get("root").getAsString());

        JsonObject expectedObject = new Gson().fromJson(expected, JsonElement.class).getAsJsonObject();
        List<Integer> inOrder = parseArray(expectedObject.getAsJsonArray("inOrderArray"));
        List<Integer> postOrder = parseArray(expectedObject.getAsJsonArray("postOrderArray"));
        List<Integer> preOrder = parseArray(expectedObject.getAsJsonArray("preOrderArray"));
        return Arguments.of(tree, new Expected(inOrder, postOrder, preOrder));
    }

    private static List<Integer> parseArray(JsonArray array) {
        List<Integer> result = new ArrayList<>();
        for (JsonElement item : array) {
            result.add(item.getAsInt());
        }
        return result;
    }

    static class Expected {
        final List<Integer> inOrder;
        final List<Integer> postOrder;
        final List<Integer> preOrder;

        public Expected(List<Integer> inOrder, List<Integer> postOrder, List<Integer> preOrder) {
            this.inOrder = inOrder;
            this.postOrder = postOrder;
            this.preOrder = preOrder;
        }
    }
}
