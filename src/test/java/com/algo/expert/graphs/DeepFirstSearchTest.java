package com.algo.expert.graphs;

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

public class DeepFirstSearchTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"graph\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"children\": [\"B\", \"C\", \"D\"], \"id\": \"A\", \"value\": \"A\"},\n" +
            "      {\"children\": [\"E\", \"F\"], \"id\": \"B\", \"value\": \"B\"},\n" +
            "      {\"children\": [], \"id\": \"C\", \"value\": \"C\"},\n" +
            "      {\"children\": [\"G\", \"H\"], \"id\": \"D\", \"value\": \"D\"},\n" +
            "      {\"children\": [], \"id\": \"E\", \"value\": \"E\"},\n" +
            "      {\"children\": [\"I\", \"J\"], \"id\": \"F\", \"value\": \"F\"},\n" +
            "      {\"children\": [\"K\"], \"id\": \"G\", \"value\": \"G\"},\n" +
            "      {\"children\": [], \"id\": \"H\", \"value\": \"H\"},\n" +
            "      {\"children\": [], \"id\": \"I\", \"value\": \"I\"},\n" +
            "      {\"children\": [], \"id\": \"J\", \"value\": \"J\"},\n" +
            "      {\"children\": [], \"id\": \"K\", \"value\": \"K\"}\n" +
            "    ],\n" +
            "    \"startNode\": \"A\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE2 = "{\n" +
            "  \"graph\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"children\": [\"B\", \"C\"], \"id\": \"A\", \"value\": \"A\"},\n" +
            "      {\"children\": [\"D\"], \"id\": \"B\", \"value\": \"B\"},\n" +
            "      {\"children\": [], \"id\": \"C\", \"value\": \"C\"},\n" +
            "      {\"children\": [], \"id\": \"D\", \"value\": \"D\"}\n" +
            "    ],\n" +
            "    \"startNode\": \"A\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE3 = "{\n" +
            "  \"graph\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"children\": [\"B\", \"C\", \"D\", \"E\"], \"id\": \"A\", \"value\": \"A\"},\n" +
            "      {\"children\": [], \"id\": \"B\", \"value\": \"B\"},\n" +
            "      {\"children\": [\"F\"], \"id\": \"C\", \"value\": \"C\"},\n" +
            "      {\"children\": [], \"id\": \"D\", \"value\": \"D\"},\n" +
            "      {\"children\": [], \"id\": \"E\", \"value\": \"E\"},\n" +
            "      {\"children\": [], \"id\": \"F\", \"value\": \"F\"}\n" +
            "    ],\n" +
            "    \"startNode\": \"A\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE4 = "{\n" +
            "  \"graph\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"children\": [\"B\"], \"id\": \"A\", \"value\": \"A\"},\n" +
            "      {\"children\": [\"C\"], \"id\": \"B\", \"value\": \"B\"},\n" +
            "      {\"children\": [\"D\", \"E\"], \"id\": \"C\", \"value\": \"C\"},\n" +
            "      {\"children\": [\"F\"], \"id\": \"D\", \"value\": \"D\"},\n" +
            "      {\"children\": [], \"id\": \"E\", \"value\": \"E\"},\n" +
            "      {\"children\": [], \"id\": \"F\", \"value\": \"F\"}\n" +
            "    ],\n" +
            "    \"startNode\": \"A\"\n" +
            "  }\n" +
            "}";
    private static final String TEST_CASE5 = "{\n" +
            "  \"graph\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"children\": [\"B\", \"C\", \"D\", \"E\", \"F\"], \"id\": \"A\", \"value\": \"A\"},\n" +
            "      {\"children\": [\"G\", \"H\", \"I\"], \"id\": \"B\", \"value\": \"B\"},\n" +
            "      {\"children\": [\"J\"], \"id\": \"C\", \"value\": \"C\"},\n" +
            "      {\"children\": [\"K\", \"L\"], \"id\": \"D\", \"value\": \"D\"},\n" +
            "      {\"children\": [], \"id\": \"E\", \"value\": \"E\"},\n" +
            "      {\"children\": [\"M\", \"N\"], \"id\": \"F\", \"value\": \"F\"},\n" +
            "      {\"children\": [], \"id\": \"G\", \"value\": \"G\"},\n" +
            "      {\"children\": [\"O\", \"P\", \"Q\", \"R\"], \"id\": \"H\", \"value\": \"H\"},\n" +
            "      {\"children\": [], \"id\": \"I\", \"value\": \"I\"},\n" +
            "      {\"children\": [], \"id\": \"J\", \"value\": \"J\"},\n" +
            "      {\"children\": [\"S\"], \"id\": \"K\", \"value\": \"K\"},\n" +
            "      {\"children\": [], \"id\": \"L\", \"value\": \"L\"},\n" +
            "      {\"children\": [], \"id\": \"M\", \"value\": \"M\"},\n" +
            "      {\"children\": [], \"id\": \"N\", \"value\": \"N\"},\n" +
            "      {\"children\": [], \"id\": \"O\", \"value\": \"O\"},\n" +
            "      {\"children\": [\"T\", \"U\"], \"id\": \"P\", \"value\": \"P\"},\n" +
            "      {\"children\": [], \"id\": \"Q\", \"value\": \"Q\"},\n" +
            "      {\"children\": [\"V\"], \"id\": \"R\", \"value\": \"R\"},\n" +
            "      {\"children\": [], \"id\": \"S\", \"value\": \"S\"},\n" +
            "      {\"children\": [], \"id\": \"T\", \"value\": \"T\"},\n" +
            "      {\"children\": [], \"id\": \"U\", \"value\": \"U\"},\n" +
            "      {\"children\": [\"W\", \"X\", \"Y\"], \"id\": \"V\", \"value\": \"V\"},\n" +
            "      {\"children\": [], \"id\": \"W\", \"value\": \"W\"},\n" +
            "      {\"children\": [\"Z\"], \"id\": \"X\", \"value\": \"X\"},\n" +
            "      {\"children\": [], \"id\": \"Y\", \"value\": \"Y\"},\n" +
            "      {\"children\": [], \"id\": \"Z\", \"value\": \"Z\"}\n" +
            "    ],\n" +
            "    \"startNode\": \"A\"\n" +
            "  }\n" +
            "}";

    @ParameterizedTest
    @MethodSource("params")
    void testCases(DepthFirstSearch.Node node, List<String> expected) {
        List<String> result = node.depthFirstSearch(new ArrayList<>());
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(parseTestCase(TEST_CASE1), List.of("A", "B", "E", "F", "I", "J", "C", "D", "G", "K", "H")),
                Arguments.of(parseTestCase(TEST_CASE2), List.of("A", "B", "D", "C")),
                Arguments.of(parseTestCase(TEST_CASE3), List.of("A", "B", "C", "F", "D", "E")),
                Arguments.of(parseTestCase(TEST_CASE4), List.of("A", "B", "C", "D", "F", "E")),
                Arguments.of(parseTestCase(TEST_CASE5), List.of("A", "B", "G", "H", "O", "P", "T", "U", "Q", "R", "V", "W", "X", "Z", "Y", "I", "C", "J", "D", "K", "S", "L", "E", "F", "M", "N"))
        );
    }

    private static DepthFirstSearch.Node parseTestCase(String json) {
        Map<String, DepthFirstSearch.Node> map = new HashMap<>();

        JsonObject graph = new Gson().fromJson(json, JsonElement.class)
                .getAsJsonObject().getAsJsonObject("graph");
        for (JsonElement node : graph.getAsJsonArray("nodes")) {
            String id = node.getAsJsonObject().getAsJsonPrimitive("id").getAsString();
            String value = node.getAsJsonObject().getAsJsonPrimitive("value").getAsString();
            map.put(id, new DepthFirstSearch.Node(value));
        }
        for (JsonElement node : graph.getAsJsonArray("nodes")) {
            String id = node.getAsJsonObject().getAsJsonPrimitive("id").getAsString();
            JsonArray children = node.getAsJsonObject().getAsJsonArray("children");
            for (JsonElement child : children) {
                map.get(id).children.add(map.get(child.getAsString()));
            }
        }
        String startNode = graph.getAsJsonPrimitive("startNode").getAsString();
        return map.get(startNode);
    }
}
