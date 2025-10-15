package com.algo.expert.binarysearchtrees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.algo.expert.binarysearchtrees.SumBsts.BinaryTree;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class SumBstsTest {
    
    private static final String TEST_CASE1 = """
            {
              "tree": {
                "nodes": [
                  {"id": "2", "left": "1", "right": "3", "value": 2},
                  {"id": "1", "left": null, "right": null, "value": 1},
                  {"id": "3", "left": null, "right": null, "value": 3}
                ],
                "root": "2"
              },
              "expected": 6
            }
            """;

    private void internalTestCaseSolution(SumBsts solution, BinaryTree tree, int expected) {
        int result = solution.sumBsts(tree);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution(BinaryTree tree, int expected) {
        internalTestCaseSolution(new SumBsts.Solution(), tree, expected);
    }

    static List<Arguments> params() {
        return List.of(
            parseArguments(TEST_CASE1)
        );
    }

    private static Arguments parseAguments(String json) {
        var obj = new  Gson().fromJson(json, JsonElement.class).getAsJsonObject();
        var nodes = obj.get("tree").getAsJsonObject()
            .get("nodes").getAsJsonArray();
        var map = new HashMap<String, BinaryTree>();
        for (JsonElement element : nodes) {
            var node = element.getAsJsonObject();
            var id = node.get("id").getAsString();
            var value = node.get("value").getAsInt();
            map.put(id, new BinaryTree(value));
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
        var root = obj.get("tree").getAsJsonObject()
            .get("root").getAsString();
        
    }
}
