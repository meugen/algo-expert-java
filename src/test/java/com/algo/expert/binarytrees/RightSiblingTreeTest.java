package com.algo.expert.binarytrees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.algo.expert.binarytrees.RightSiblingTree.BinaryTree;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class RightSiblingTreeTest {
    private static final String TEST_CASE1 = """
            {
              "nodes": [
                {"id": "1", "left": "2", "right": "3", "value": 1},
                {"id": "3", "left": "6", "right": "7", "value": 3},
                {"id": "7", "left": "12", "right": "13", "value": 7},
                {"id": "13", "left": null, "right": null, "value": 13},
                {"id": "12", "left": null, "right": null, "value": 12},
                {"id": "6", "left": "11", "right": null, "value": 6},
                {"id": "11", "left": "14", "right": null, "value": 11},
                {"id": "14", "left": null, "right": null, "value": 14},
                {"id": "2", "left": "4", "right": "5", "value": 2},
                {"id": "5", "left": null, "right": "10", "value": 5},
                {"id": "10", "left": null, "right": null, "value": 10},
                {"id": "4", "left": "8", "right": "9", "value": 4},
                {"id": "9", "left": null, "right": null, "value": 9},
                {"id": "8", "left": null, "right": null, "value": 8}
              ],
              "root": "1"
            }
            """;
    private static final String EXPECTED1 = """
            {
              "nodes": [
                {"id": "1", "left": "2", "right": null, "value": 1},
                {"id": "3", "left": "6", "right": null, "value": 3},
                {"id": "7", "left": "12", "right": null, "value": 7},
                {"id": "13", "left": null, "right": null, "value": 13},
                {"id": "12", "left": null, "right": "13", "value": 12},
                {"id": "6", "left": "11", "right": "7", "value": 6},
                {"id": "11", "left": "14", "right": null, "value": 11},
                {"id": "14", "left": null, "right": null, "value": 14},
                {"id": "2", "left": "4", "right": "3", "value": 2},
                {"id": "5", "left": null, "right": "6", "value": 5},
                {"id": "10", "left": null, "right": "11", "value": 10},
                {"id": "4", "left": "8", "right": "5", "value": 4},
                {"id": "9", "left": null, "right": null, "value": 9},
                {"id": "8", "left": null, "right": "9", "value": 8}
              ],
              "root": "1"
            }
            """;
    private static final String TEST_CASE2 = """
            {
              "nodes": [
                {"id": "1", "left": null, "right": null, "value": 1}
              ],
              "root": "1"
            }
            """;
    private static final String EXPECTED2 = """
            {
              "nodes": [
                {"id": "1", "left": null, "right": null, "value": 1}
              ],
              "root": "1"
            }
            """;
    private static final String TEST_CASE3 = """
            {
              "nodes": [
                {"id": "1", "left": "2", "right": null, "value": 1},
                {"id": "2", "left": null, "right": null, "value": 2}
              ],
              "root": "1"
            }
            """;
    private static final String EXPECTED3 = """
            {
              "nodes": [
                {"id": "1", "left": "2", "right": null, "value": 1},
                {"id": "2", "left": null, "right": null, "value": 2}
              ],
              "root": "1"
            }
            """;
    private static final String TEST_CASE4 = """
            {
              "nodes": [
                {"id": "1", "left": "2", "right": "3", "value": 1},
                {"id": "3", "left": null, "right": null, "value": 3},
                {"id": "2", "left": null, "right": null, "value": 2}
              ],
              "root": "1"
            }
            """;
    private static final String EXPECTED4 = """
            {
              "nodes": [
                {"id": "1", "left": "2", "right": null, "value": 1},
                {"id": "3", "left": null, "right": null, "value": 3},
                {"id": "2", "left": null, "right": "3", "value": 2}
              ],
              "root": "1"
            }
            """;
    private static final String TEST_CASE5 = """
            {
              "nodes": [
                {"id": "1", "left": "2", "right": "3", "value": 1},
                {"id": "3", "left": null, "right": null, "value": 3},
                {"id": "2", "left": "4", "right": null, "value": 2},
                {"id": "4", "left": null, "right": null, "value": 4}
              ],
              "root": "1"
            }
            """;
    private static final String EXPECTED5 = """
            {
              "nodes": [
                {"id": "1", "left": "2", "right": null, "value": 1},
                {"id": "3", "left": null, "right": null, "value": 3},
                {"id": "2", "left": "4", "right": "3", "value": 2},
                {"id": "4", "left": null, "right": null, "value": 4}
              ],
              "root": "1"
            }
            """;
    private static final String TEST_CASE6 = """
            {
              "nodes": [
                {"id": "1", "left": "2", "right": "3", "value": 1},
                {"id": "3", "left": null, "right": null, "value": 3},
                {"id": "2", "left": "4", "right": "5", "value": 2},
                {"id": "5", "left": null, "right": null, "value": 5},
                {"id": "4", "left": null, "right": null, "value": 4}
              ],
              "root": "1"
            }
            """;
    private static final String EXPECTED6 = """
            {
              "nodes": [
                {"id": "1", "left": "2", "right": null, "value": 1},
                {"id": "3", "left": null, "right": null, "value": 3},
                {"id": "2", "left": "4", "right": "3", "value": 2},
                {"id": "5", "left": null, "right": null, "value": 5},
                {"id": "4", "left": null, "right": "5", "value": 4}
              ],
              "root": "1"
            }
            """;
    private static final String TEST_CASE7 = """
            {
              "nodes": [
                {"id": "1", "left": "2", "right": "3", "value": 1},
                {"id": "3", "left": "6", "right": null, "value": 3},
                {"id": "6", "left": null, "right": null, "value": 6},
                {"id": "2", "left": "4", "right": "5", "value": 2},
                {"id": "5", "left": null, "right": null, "value": 5},
                {"id": "4", "left": null, "right": null, "value": 4}
              ],
              "root": "1"
            }
            """;
    private static final String EXPECTED7 = """
            {
              "nodes": [
                {"id": "1", "left": "2", "right": null, "value": 1},
                {"id": "3", "left": "6", "right": null, "value": 3},
                {"id": "6", "left": null, "right": null, "value": 6},
                {"id": "2", "left": "4", "right": "3", "value": 2},
                {"id": "5", "left": null, "right": "6", "value": 5},
                {"id": "4", "left": null, "right": "5", "value": 4}
              ],
              "root": "1"
            }
            """;
    private static final String TEST_CASE8 = """
            {
              "nodes": [
                {"id": "1", "left": "2", "right": "3", "value": 1},
                {"id": "3", "left": "6", "right": null, "value": 3},
                {"id": "6", "left": null, "right": null, "value": 6},
                {"id": "2", "left": "4", "right": "5", "value": 2},
                {"id": "5", "left": "7", "right": "8", "value": 5},
                {"id": "8", "left": null, "right": null, "value": 8},
                {"id": "7", "left": null, "right": null, "value": 7},
                {"id": "4", "left": null, "right": null, "value": 4}
              ],
              "root": "1"
            }
            """;
    private static final String EXPECTED8 = """
            {
              "nodes": [
                {"id": "1", "left": "2", "right": null, "value": 1},
                {"id": "3", "left": "6", "right": null, "value": 3},
                {"id": "6", "left": null, "right": null, "value": 6},
                {"id": "2", "left": "4", "right": "3", "value": 2},
                {"id": "5", "left": "7", "right": "6", "value": 5},
                {"id": "8", "left": null, "right": null, "value": 8},
                {"id": "7", "left": null, "right": "8", "value": 7},
                {"id": "4", "left": null, "right": "5", "value": 4}
              ],
              "root": "1"
            }
            """;
    private static final String TEST_CASE9 = """
            {
              "nodes": [
                {"id": "1", "left": "2", "right": "3", "value": 1},
                {"id": "3", "left": "6", "right": "7", "value": 3},
                {"id": "7", "left": "14", "right": "15", "value": 7},
                {"id": "15", "left": null, "right": null, "value": 15},
                {"id": "14", "left": null, "right": null, "value": 14},
                {"id": "6", "left": "12", "right": "13", "value": 6},
                {"id": "13", "left": null, "right": null, "value": 13},
                {"id": "12", "left": null, "right": null, "value": 12},
                {"id": "2", "left": "4", "right": "5", "value": 2},
                {"id": "5", "left": "10", "right": "11", "value": 5},
                {"id": "11", "left": null, "right": null, "value": 11},
                {"id": "10", "left": null, "right": null, "value": 10},
                {"id": "4", "left": "8", "right": "9", "value": 4},
                {"id": "9", "left": null, "right": null, "value": 9},
                {"id": "8", "left": null, "right": null, "value": 8}
              ],
              "root": "1"
            }
            """;
    private static final String EXPECTED9 = """
            {
              "nodes": [
                {"id": "1", "left": "2", "right": null, "value": 1},
                {"id": "3", "left": "6", "right": null, "value": 3},
                {"id": "7", "left": "14", "right": null, "value": 7},
                {"id": "15", "left": null, "right": null, "value": 15},
                {"id": "14", "left": null, "right": "15", "value": 14},
                {"id": "6", "left": "12", "right": "7", "value": 6},
                {"id": "13", "left": null, "right": "14", "value": 13},
                {"id": "12", "left": null, "right": "13", "value": 12},
                {"id": "2", "left": "4", "right": "3", "value": 2},
                {"id": "5", "left": "10", "right": "6", "value": 5},
                {"id": "11", "left": null, "right": "12", "value": 11},
                {"id": "10", "left": null, "right": "11", "value": 10},
                {"id": "4", "left": "8", "right": "5", "value": 4},
                {"id": "9", "left": null, "right": "10", "value": 9},
                {"id": "8", "left": null, "right": "9", "value": 8}
              ],
              "root": "1"
            }
            """;

    private void internalTestCaseSolution(RightSiblingTree solution, BinaryTree tree, BinaryTree expected) {
        BinaryTree result = solution.rightSiblingTree(tree);
        assertTree(expected, result);
    }

    private void assertTree(BinaryTree expected, BinaryTree actual) {
        if (expected == null && actual == null) return;
        assertNotNull(expected);
        assertNotNull(actual);
        assertEquals(expected.value, actual.value);
        assertTree(expected.left, actual.left);
        assertTree(expected.right, actual.right);
    } 

    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution(BinaryTree tree, BinaryTree expected) {
        internalTestCaseSolution(new RightSiblingTree.Solution1(), tree, expected);
    }

    static List<Arguments> params() {
        return List.of(
            Arguments.of(parseBinaryTree(TEST_CASE1), parseBinaryTree(EXPECTED1)),
            Arguments.of(parseBinaryTree(TEST_CASE2), parseBinaryTree(EXPECTED2)),
            Arguments.of(parseBinaryTree(TEST_CASE3), parseBinaryTree(EXPECTED3)),
            Arguments.of(parseBinaryTree(TEST_CASE4), parseBinaryTree(EXPECTED4)),
            Arguments.of(parseBinaryTree(TEST_CASE5), parseBinaryTree(EXPECTED5)),
            Arguments.of(parseBinaryTree(TEST_CASE6), parseBinaryTree(EXPECTED6)),
            Arguments.of(parseBinaryTree(TEST_CASE7), parseBinaryTree(EXPECTED7)),
            Arguments.of(parseBinaryTree(TEST_CASE8), parseBinaryTree(EXPECTED8)),
            Arguments.of(parseBinaryTree(TEST_CASE9), parseBinaryTree(EXPECTED9))
            );
    }

    private static BinaryTree parseBinaryTree(String json) {
        var tree = new Gson().fromJson(json, JsonElement.class).getAsJsonObject();
        var nodes = tree.get("nodes").getAsJsonArray();
        var elements = new HashMap<String, BinaryTree>();
        for (JsonElement rowElement : nodes) {
            var row = rowElement.getAsJsonObject();
            var id = row.get("id").getAsString();
            var value = row.get("value").getAsInt();
            elements.put(id, new BinaryTree(value));
        }
        for (JsonElement rowElement : nodes) {
            var row = rowElement.getAsJsonObject();
            var id = row.get("id").getAsString();
            var left = row.get("left");
            var right = row.get("right");
            if (!left.isJsonNull()) {
                elements.get(id).left = elements.get(left.getAsString());
            }
            if (!right.isJsonNull()) {
                elements.get(id).right = elements.get(right.getAsString());
            }
        }
        var root = tree.get("root").getAsString();
        return elements.get(root);
    }
}
