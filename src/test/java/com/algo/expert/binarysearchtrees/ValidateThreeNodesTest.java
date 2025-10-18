package com.algo.expert.binarysearchtrees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.algo.expert.binarysearchtrees.ValidateThreeNodes.BST;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class ValidateThreeNodesTest {

    private static final String TEST_CASE1 = """
            {
              "tree": {
                "nodes": [
                  {"id": "0", "left": null, "right": null, "value": 0},
                  {"id": "1", "left": "0", "right": null, "value": 1},
                  {"id": "2", "left": "1", "right": "4", "value": 2},
                  {"id": "3", "left": null, "right": null, "value": 3},
                  {"id": "4", "left": "3", "right": null, "value": 4},
                  {"id": "5", "left": "2", "right": "7", "value": 5},
                  {"id": "6", "left": null, "right": null, "value": 6},
                  {"id": "7", "left": "6", "right": "8", "value": 7},
                  {"id": "8", "left": null, "right": null, "value": 8}
                ],
                "root": "5"
              },
              "nodeOne": "5",
              "nodeTwo": "2",
              "nodeThree": "3"
            }
            """;
    private static final String TEST_CASE2 = """
            {
              "tree": {
                "nodes": [
                  {"id": "0", "left": null, "right": null, "value": 0},
                  {"id": "1", "left": "0", "right": null, "value": 1},
                  {"id": "2", "left": "1", "right": null, "value": 2},
                  {"id": "3", "left": "2", "right": "4", "value": 3},
                  {"id": "4", "left": null, "right": null, "value": 4},
                  {"id": "5", "left": "3", "right": "7", "value": 5},
                  {"id": "6", "left": null, "right": null, "value": 6},
                  {"id": "7", "left": "6", "right": "8", "value": 7},
                  {"id": "8", "left": null, "right": null, "value": 8}
                ],
                "root": "5"
              },
              "nodeOne": "5",
              "nodeTwo": "8",
              "nodeThree": "1"
            }
            """;
    private static final String TEST_CASE3 = """
            {
              "tree": {
                "nodes": [
                  {"id": "0", "left": null, "right": null, "value": 0},
                  {"id": "1", "left": "0", "right": null, "value": 1},
                  {"id": "2", "left": "1", "right": null, "value": 2},
                  {"id": "3", "left": "2", "right": "4", "value": 3},
                  {"id": "4", "left": null, "right": null, "value": 4},
                  {"id": "5", "left": "3", "right": "7", "value": 5},
                  {"id": "6", "left": null, "right": null, "value": 6},
                  {"id": "7", "left": "6", "right": "8", "value": 7},
                  {"id": "8", "left": null, "right": null, "value": 8}
                ],
                "root": "5"
              },
              "nodeOne": "8",
              "nodeTwo": "5",
              "nodeThree": "2"
            }
            """;
    private static final String TEST_CASE4 = """
            {
              "tree": {
                "nodes": [
                  {"id": "1", "left": null, "right": null, "value": 1},
                  {"id": "2", "left": "1", "right": "3", "value": 2},
                  {"id": "3", "left": null, "right": "4", "value": 3},
                  {"id": "4", "left": null, "right": "5", "value": 4},
                  {"id": "5", "left": null, "right": "6", "value": 5},
                  {"id": "6", "left": null, "right": "7", "value": 6},
                  {"id": "7", "left": null, "right": "8", "value": 7},
                  {"id": "8", "left": null, "right": "9", "value": 8},
                  {"id": "9", "left": null, "right": null, "value": 9}
                ],
                "root": "2"
              },
              "nodeOne": "2",
              "nodeTwo": "5",
              "nodeThree": "8"
            }
            """;
    private static final String TEST_CASE5 = """
            {
              "tree": {
                "nodes": [
                  {"id": "1", "left": null, "right": "2", "value": 1},
                  {"id": "2", "left": null, "right": null, "value": 2},
                  {"id": "3", "left": "1", "right": null, "value": 3},
                  {"id": "4", "left": "3", "right": null, "value": 4},
                  {"id": "5", "left": null, "right": "5", "value": 5},
                  {"id": "6", "left": "4", "right": "8", "value": 6},
                  {"id": "7", "left": null, "right": null, "value": 7},
                  {"id": "8", "left": "7", "right": "9", "value": 8},
                  {"id": "9", "left": null, "right": null, "value": 9}
                ],
                "root": "6"
              },
              "nodeOne": "4",
              "nodeTwo": "1",
              "nodeThree": "2"
            }
            """;
        private static final String TEST_CASE6 = """
                {
                  "tree": {
                    "nodes": [
                      {"id": "1", "left": null, "right": null, "value": 1},
                      {"id": "2", "left": "1", "right": "3", "value": 2},
                      {"id": "3", "left": null, "right": "4", "value": 3},
                      {"id": "4", "left": null, "right": null, "value": 4}
                    ],
                    "root": "2"
                  },
                  "nodeOne": "1",
                  "nodeTwo": "2",
                  "nodeThree": "3"
                }
                """;
        private static final String TEST_CASE7 = """
                {
                  "tree": {
                    "nodes": [
                      {"id": "1", "left": null, "right": null, "value": 1},
                      {"id": "2", "left": "1", "right": null, "value": 2},
                      {"id": "3", "left": "2", "right": null, "value": 3},
                      {"id": "4", "left": "3", "right": "5", "value": 4},
                      {"id": "5", "left": null, "right": "7", "value": 5},
                      {"id": "6", "left": null, "right": null, "value": 6},
                      {"id": "7", "left": "6", "right": null, "value": 7},
                      {"id": "8", "left": "4", "right": "10", "value": 8},
                      {"id": "9", "left": null, "right": null, "value": 9},
                      {"id": "10", "left": "9", "right": "14", "value": 10},
                      {"id": "11", "left": null, "right": null, "value": 11},
                      {"id": "12", "left": "11", "right": "13", "value": 12},
                      {"id": "13", "left": null, "right": null, "value": 13},
                      {"id": "14", "left": "12", "right": null, "value": 14}
                    ],
                    "root": "8"
                  },
                  "nodeOne": "2",
                  "nodeTwo": "4",
                  "nodeThree": "13"
                }
                """;
        private static final String TEST_CASE8 = """
                {
                  "tree": {
                    "nodes": [
                      {"id": "1", "left": null, "right": null, "value": 1},
                      {"id": "2", "left": "1", "right": null, "value": 2},
                      {"id": "3", "left": "2", "right": null, "value": 3},
                      {"id": "4", "left": "3", "right": null, "value": 4},
                      {"id": "5", "left": "4", "right": null, "value": 5},
                      {"id": "6", "left": "5", "right": null, "value": 6},
                      {"id": "7", "left": "6", "right": null, "value": 7},
                      {"id": "8", "left": "7", "right": "9", "value": 8},
                      {"id": "9", "left": null, "right": null, "value": 9}
                    ],
                    "root": "8"
                  },
                  "nodeOne": "8",
                  "nodeTwo": "7",
                  "nodeThree": "1"
                }
                """;
        private static final String TEST_CASE9 = """
                {
                  "tree": {
                    "nodes": [
                      {"id": "1", "left": null, "right": null, "value": 1},
                      {"id": "2", "left": "1", "right": null, "value": 2},
                      {"id": "3", "left": "2", "right": null, "value": 3}
                    ],
                    "root": "3"
                  },
                  "nodeOne": "2",
                  "nodeTwo": "1",
                  "nodeThree": "3"
                }
                """;
        private static final String TEST_CASE10 = """
                {
                  "tree": {
                    "nodes": [
                      {"id": "1", "left": null, "right": null, "value": 1},
                      {"id": "2", "left": "1", "right": null, "value": 2},
                      {"id": "3", "left": "2", "right": null, "value": 3}
                    ],
                    "root": "3"
                  },
                  "nodeOne": "1",
                  "nodeTwo": "2",
                  "nodeThree": "3"
                }
                """;
        private static final String TEST_CASE11 = """
                {
                  "tree": {
                    "nodes": [
                      {"id": "1", "left": null, "right": null, "value": 1},
                      {"id": "2", "left": "1", "right": "3", "value": 2},
                      {"id": "3", "left": null, "right": null, "value": 3},
                      {"id": "4", "left": "2", "right": "5", "value": 4},
                      {"id": "5", "left": null, "right": null, "value": 5},
                      {"id": "6", "left": "4", "right": "8", "value": 6},
                      {"id": "7", "left": null, "right": null, "value": 7},
                      {"id": "8", "left": "7", "right": "9", "value": 8},
                      {"id": "9", "left": null, "right": null, "value": 9}
                    ],
                    "root": "6"
                  },
                  "nodeOne": "9",
                  "nodeTwo": "8",
                  "nodeThree": "6"
                }
                """;
        private static final String TEST_CASE12 = """
                {
                  "tree": {
                    "nodes": [
                      {"id": "1", "left": null, "right": "2", "value": 1},
                      {"id": "2", "left": null, "right": null, "value": 2},
                      {"id": "3", "left": "1", "right": "4", "value": 3},
                      {"id": "4", "left": null, "right": null, "value": 4},
                      {"id": "5", "left": "3", "right": null, "value": 5},
                      {"id": "6", "left": "5", "right": "8", "value": 6},
                      {"id": "7", "left": null, "right": null, "value": 7},
                      {"id": "8", "left": "7", "right": "9", "value": 8},
                      {"id": "9", "left": null, "right": null, "value": 9},
                      {"id": "10", "left": "6", "right": "15", "value": 10},
                      {"id": "11", "left": null, "right": "12", "value": 11},
                      {"id": "12", "left": null, "right": null, "value": 12},
                      {"id": "13", "left": "11", "right": null, "value": 13},
                      {"id": "14", "left": "13", "right": null, "value": 14},
                      {"id": "15", "left": "14", "right": "18", "value": 15},
                      {"id": "16", "left": null, "right": null, "value": 16},
                      {"id": "17", "left": "16", "right": null, "value": 17},
                      {"id": "18", "left": "17", "right": null, "value": 18}
                    ],
                    "root": "10"
                  },
                  "nodeOne": "12",
                  "nodeTwo": "13",
                  "nodeThree": "15"
                }
                """;
        private static final String TEST_CASE13 = """
                {
                  "tree": {
                    "nodes": [
                      {"id": "1", "left": null, "right": "2", "value": 1},
                      {"id": "2", "left": null, "right": null, "value": 2},
                      {"id": "3", "left": "1", "right": "4", "value": 3},
                      {"id": "4", "left": null, "right": null, "value": 4},
                      {"id": "5", "left": "3", "right": null, "value": 5},
                      {"id": "6", "left": "5", "right": "8", "value": 6},
                      {"id": "7", "left": null, "right": null, "value": 7},
                      {"id": "8", "left": "7", "right": "9", "value": 8},
                      {"id": "9", "left": null, "right": null, "value": 9},
                      {"id": "10", "left": "6", "right": "15", "value": 10},
                      {"id": "11", "left": null, "right": "12", "value": 11},
                      {"id": "12", "left": null, "right": null, "value": 12},
                      {"id": "13", "left": "11", "right": null, "value": 13},
                      {"id": "14", "left": "13", "right": null, "value": 14},
                      {"id": "15", "left": "14", "right": "18", "value": 15},
                      {"id": "16", "left": null, "right": null, "value": 16},
                      {"id": "17", "left": "16", "right": null, "value": 17},
                      {"id": "18", "left": "17", "right": null, "value": 18}
                    ],
                    "root": "10"
                  },
                  "nodeOne": "5",
                  "nodeTwo": "10",
                  "nodeThree": "15"
                }
                """;
        private static final String TEST_CASE14 = """
                {
                  "tree": {
                    "nodes": [
                      {"id": "0", "left": null, "right": null, "value": 0},
                      {"id": "1", "left": "0", "right": null, "value": 1},
                      {"id": "2", "left": "1", "right": null, "value": 2},
                      {"id": "3", "left": "2", "right": "4", "value": 3},
                      {"id": "4", "left": null, "right": null, "value": 4},
                      {"id": "5", "left": "3", "right": "7", "value": 5},
                      {"id": "6", "left": null, "right": null, "value": 6},
                      {"id": "7", "left": "6", "right": "8", "value": 7},
                      {"id": "8", "left": null, "right": null, "value": 8}
                    ],
                    "root": "5"
                  },
                  "nodeOne": "5",
                  "nodeTwo": "3",
                  "nodeThree": "4"
                }
                """;
        private static final String TEST_CASE15 = """
                {
                  "tree": {
                    "nodes": [
                      {"id": "0", "left": null, "right": null, "value": 0},
                      {"id": "1", "left": "0", "right": null, "value": 1},
                      {"id": "2", "left": "1", "right": null, "value": 2},
                      {"id": "3", "left": "2", "right": "4", "value": 3},
                      {"id": "4", "left": null, "right": null, "value": 4},
                      {"id": "5", "left": "3", "right": "7", "value": 5},
                      {"id": "6", "left": null, "right": null, "value": 6},
                      {"id": "7", "left": "6", "right": "8", "value": 7},
                      {"id": "8", "left": null, "right": null, "value": 8}
                    ],
                    "root": "5"
                  },
                  "nodeOne": "5",
                  "nodeTwo": "3",
                  "nodeThree": "1"
                }
                """;

    private void internalTestCaseSolution(ValidateThreeNodes solution, BST nodeOne, BST nodeTwo, BST nodeThree, boolean  expected) {
        var result = solution.validateThreeNodes(nodeOne, nodeTwo, nodeThree);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution(BST nodeOne, BST nodeTwo, BST nodeThree, boolean expected) {
        internalTestCaseSolution(new ValidateThreeNodes.Solution1(), nodeOne, nodeTwo, nodeThree, expected);
    }

    static List<Arguments> params() {
        return List.of(
            parseArguments(TEST_CASE1, true),
            parseArguments(TEST_CASE2, false),
            parseArguments(TEST_CASE3, false),
            parseArguments(TEST_CASE4, true),
            parseArguments(TEST_CASE5, true),
            parseArguments(TEST_CASE6, false),
            parseArguments(TEST_CASE7, false),
            parseArguments(TEST_CASE8, true),
            parseArguments(TEST_CASE9, false),
            parseArguments(TEST_CASE10, true),
            parseArguments(TEST_CASE11, true),
            parseArguments(TEST_CASE12, true),
            parseArguments(TEST_CASE13, false),
            parseArguments(TEST_CASE14, true),
            parseArguments(TEST_CASE15, true)
        );
    }

    private static Arguments parseArguments(String json, boolean expected) {
        var obj = new Gson().fromJson(json, JsonElement.class).getAsJsonObject();
        var nodes = obj.get("tree").getAsJsonObject()
            .get("nodes").getAsJsonArray();
        var map = new HashMap<String, BST>();
        for (JsonElement element : nodes) {
            var node = element.getAsJsonObject();
            var id = node.get("id").getAsString();
            var value = node.get("value").getAsInt();
            map.put(id, new BST(value));
        }
        for (JsonElement element : nodes) {
            var node = element.getAsJsonObject();
            var id = node.get("id").getAsString();
            var left = node.get("left");
            var right = node.get("right");
            if (!left.isJsonNull()) {
                map.get(id).left = map.get(left.getAsString());
            }
            if (!right.isJsonNull()) {
                map.get(id).right = map.get(right.getAsString());
            }
        }
        return Arguments.of(
            map.get(obj.get("nodeOne").getAsString()),
            map.get(obj.get("nodeTwo").getAsString()),
            map.get(obj.get("nodeThree").getAsString()),
            expected
        );
    }
}
