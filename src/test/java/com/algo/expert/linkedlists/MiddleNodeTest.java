package com.algo.expert.linkedlists;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;

public class MiddleNodeTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"linkedList\": {\n" +
            "    \"head\": \"1\",\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"next\": null, \"value\": 1}\n" +
            "    ]\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED1 = "{\n" +
            "  \"head\": \"1\",\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"1\", \"next\": null, \"value\": 1}\n" +
            "  ]\n" +
            "}";

    private static final String TEST_CASE2 = "{\n" +
            "  \"linkedList\": {\n" +
            "    \"head\": \"1\",\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"next\": \"2\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"next\": \"3\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"next\": null, \"value\": 3}\n" +
            "    ]\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED2 = "{\n" +
            "  \"head\": \"2\",\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"2\", \"next\": \"3\", \"value\": 2},\n" +
            "    {\"id\": \"3\", \"next\": null, \"value\": 3}\n" +
            "  ]\n" +
            "}";

    private static final String TEST_CASE3 = "{\n" +
            "  \"linkedList\": {\n" +
            "    \"head\": \"5\",\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"5\", \"next\": \"7\", \"value\": 5},\n" +
            "      {\"id\": \"7\", \"next\": \"9\", \"value\": 7},\n" +
            "      {\"id\": \"9\", \"next\": null, \"value\": 9}\n" +
            "    ]\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED3 = "{\n" +
            "  \"head\": \"7\",\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"7\", \"next\": \"9\", \"value\": 7},\n" +
            "    {\"id\": \"9\", \"next\": null, \"value\": 9}\n" +
            "  ]\n" +
            "}";

    private static final String TEST_CASE4 = "{\n" +
            "  \"linkedList\": {\n" +
            "    \"head\": \"1\",\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"next\": \"2\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"next\": \"3\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"next\": \"4\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"next\": null, \"value\": 4}\n" +
            "    ]\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED4 = "{\n" +
            "  \"head\": \"3\",\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"3\", \"next\": \"4\", \"value\": 3},\n" +
            "    {\"id\": \"4\", \"next\": null, \"value\": 4}\n" +
            "  ]\n" +
            "}";

    private static final String TEST_CASE5 = "{\n" +
            "  \"linkedList\": {\n" +
            "    \"head\": \"1\",\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"next\": \"2\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"next\": \"3\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"next\": \"4\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"next\": \"5\", \"value\": 4},\n" +
            "      {\"id\": \"5\", \"next\": \"6\", \"value\": 5},\n" +
            "      {\"id\": \"6\", \"next\": \"7\", \"value\": 6},\n" +
            "      {\"id\": \"7\", \"next\": \"8\", \"value\": 7},\n" +
            "      {\"id\": \"8\", \"next\": \"9\", \"value\": 8},\n" +
            "      {\"id\": \"9\", \"next\": null, \"value\": 9}\n" +
            "    ]\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED5 = "{\n" +
            "  \"head\": \"5\",\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"5\", \"next\": \"6\", \"value\": 5},\n" +
            "    {\"id\": \"6\", \"next\": \"7\", \"value\": 6},\n" +
            "    {\"id\": \"7\", \"next\": \"8\", \"value\": 7},\n" +
            "    {\"id\": \"8\", \"next\": \"9\", \"value\": 8},\n" +
            "    {\"id\": \"9\", \"next\": null, \"value\": 9}\n" +
            "  ]\n" +
            "}";

    private static final String TEST_CASE6 = "{\n" +
            "  \"linkedList\": {\n" +
            "    \"head\": \"1\",\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"next\": \"2\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"next\": \"3\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"next\": \"4\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"next\": \"5\", \"value\": 4},\n" +
            "      {\"id\": \"5\", \"next\": \"6\", \"value\": 5},\n" +
            "      {\"id\": \"6\", \"next\": \"7\", \"value\": 6},\n" +
            "      {\"id\": \"7\", \"next\": \"8\", \"value\": 7},\n" +
            "      {\"id\": \"8\", \"next\": \"9\", \"value\": 8},\n" +
            "      {\"id\": \"9\", \"next\": \"10\", \"value\": 9},\n" +
            "      {\"id\": \"10\", \"next\": null, \"value\": 10}\n" +
            "    ]\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED6 = "{\n" +
            "  \"head\": \"6\",\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"6\", \"next\": \"7\", \"value\": 6},\n" +
            "    {\"id\": \"7\", \"next\": \"8\", \"value\": 7},\n" +
            "    {\"id\": \"8\", \"next\": \"9\", \"value\": 8},\n" +
            "    {\"id\": \"9\", \"next\": \"10\", \"value\": 9},\n" +
            "    {\"id\": \"10\", \"next\": null, \"value\": 10}\n" +
            "  ]\n" +
            "}";

    private static final String TEST_CASE7 = "{\n" +
            "  \"linkedList\": {\n" +
            "    \"head\": \"1\",\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"next\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"3\", \"next\": \"4\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"next\": \"5\", \"value\": 4},\n" +
            "      {\"id\": \"5\", \"next\": \"9\", \"value\": 5},\n" +
            "      {\"id\": \"9\", \"next\": \"10\", \"value\": 9},\n" +
            "      {\"id\": \"10\", \"next\": null, \"value\": 10}\n" +
            "    ]\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED7 = "{\n" +
            "  \"head\": \"5\",\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"5\", \"next\": \"9\", \"value\": 5},\n" +
            "    {\"id\": \"9\", \"next\": \"10\", \"value\": 9},\n" +
            "    {\"id\": \"10\", \"next\": null, \"value\": 10}\n" +
            "  ]\n" +
            "}";

    private static final String TEST_CASE8 = "{\n" +
            "  \"linkedList\": {\n" +
            "    \"head\": \"1\",\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"next\": \"1-2\", \"value\": 1},\n" +
            "      {\"id\": \"1-2\", \"next\": \"1-3\", \"value\": 1},\n" +
            "      {\"id\": \"1-3\", \"next\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"3\", \"next\": \"4\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"next\": \"5\", \"value\": 4},\n" +
            "      {\"id\": \"5\", \"next\": \"5-2\", \"value\": 5},\n" +
            "      {\"id\": \"5-2\", \"next\": \"5-3\", \"value\": 5},\n" +
            "      {\"id\": \"5-3\", \"next\": \"5-4\", \"value\": 5},\n" +
            "      {\"id\": \"5-4\", \"next\": \"10\", \"value\": 5},\n" +
            "      {\"id\": \"10\", \"next\": null, \"value\": 10}\n" +
            "    ]\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED8 = "{\n" +
            "  \"head\": \"5\",\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"5\", \"next\": \"5-2\", \"value\": 5},\n" +
            "    {\"id\": \"5-2\", \"next\": \"5-3\", \"value\": 5},\n" +
            "    {\"id\": \"5-3\", \"next\": \"5-4\", \"value\": 5},\n" +
            "    {\"id\": \"5-4\", \"next\": \"10\", \"value\": 5},\n" +
            "    {\"id\": \"10\", \"next\": null, \"value\": 10}\n" +
            "  ]\n" +
            "}";

    private static final String TEST_CASE9 = "{\n" +
            "  \"linkedList\": {\n" +
            "    \"head\": \"1\",\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"next\": \"2\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"next\": \"1-2\", \"value\": 2},\n" +
            "      {\"id\": \"1-2\", \"next\": \"4\", \"value\": 1},\n" +
            "      {\"id\": \"4\", \"next\": \"5\", \"value\": 4},\n" +
            "      {\"id\": \"5\", \"next\": \"5-2\", \"value\": 5},\n" +
            "      {\"id\": \"5-2\", \"next\": \"7\", \"value\": 5},\n" +
            "      {\"id\": \"7\", \"next\": \"10\", \"value\": 7},\n" +
            "      {\"id\": \"10\", \"next\": null, \"value\": 10}\n" +
            "    ]\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED9 = "{\n" +
            "  \"head\": \"5\",\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"5\", \"next\": \"5-2\", \"value\": 5},\n" +
            "    {\"id\": \"5-2\", \"next\": \"7\", \"value\": 5},\n" +
            "    {\"id\": \"7\", \"next\": \"10\", \"value\": 7},\n" +
            "    {\"id\": \"10\", \"next\": null, \"value\": 10}\n" +
            "  ]\n" +
            "}";

    private static final String TEST_CASE10 = "{\n" +
            "  \"linkedList\": {\n" +
            "    \"head\": \"1\",\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"next\": \"1-2\", \"value\": 1},\n" +
            "      {\"id\": \"1-2\", \"next\": \"1-3\", \"value\": 1},\n" +
            "      {\"id\": \"1-3\", \"next\": \"1-4\", \"value\": 1},\n" +
            "      {\"id\": \"1-4\", \"next\": \"2\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"next\": \"3\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"next\": \"4\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"next\": \"5\", \"value\": 4},\n" +
            "      {\"id\": \"5\", \"next\": \"5-2\", \"value\": 5},\n" +
            "      {\"id\": \"5-2\", \"next\": \"7\", \"value\": 5},\n" +
            "      {\"id\": \"7\", \"next\": \"10\", \"value\": 7},\n" +
            "      {\"id\": \"10\", \"next\": null, \"value\": 10}\n" +
            "    ]\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED10 = "{\n" +
            "  \"head\": \"3\",\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"3\", \"next\": \"4\", \"value\": 3},\n" +
            "    {\"id\": \"4\", \"next\": \"5\", \"value\": 4},\n" +
            "    {\"id\": \"5\", \"next\": \"5-2\", \"value\": 5},\n" +
            "    {\"id\": \"5-2\", \"next\": \"7\", \"value\": 5},\n" +
            "    {\"id\": \"7\", \"next\": \"10\", \"value\": 7},\n" +
            "    {\"id\": \"10\", \"next\": null, \"value\": 10}\n" +
            "  ]\n" +
            "}";

    private static MiddleNode.LinkedList parseLinkedList(JsonObject object) {
        var nodes = object.getAsJsonArray("nodes");

        var map = new HashMap<String, MiddleNode.LinkedList>();
        for (var element : nodes) {
            var item = element.getAsJsonObject();
            var id = item.get("id").getAsString();
            var value = item.get("value").getAsInt();
            map.put(id, new MiddleNode.LinkedList(value));
        }
        for (var element : nodes) {
            var item = element.getAsJsonObject();
            var id = item.get("id").getAsString();
            var next = item.get("next");
            var listItem = map.get(id);
            if (!next.isJsonNull()) {
                listItem.next = map.get(next.getAsString());
            }
        }
        var head = object.get("head").getAsString();
        return map.get(head);
    }

    private static Arguments parseArguments(String testCaseJson, String expectedJson) {
        var testCase = parseLinkedList(new Gson().fromJson(testCaseJson, JsonObject.class).getAsJsonObject("linkedList"));
        var expected = parseLinkedList(new Gson().fromJson(expectedJson, JsonObject.class));
        return Arguments.of(testCase, expected);
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

    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution1(MiddleNode.LinkedList linkedList, MiddleNode.LinkedList expected) {
        internalTestCase(new MiddleNode.Solution1(), linkedList, expected);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution2(MiddleNode.LinkedList linkedList, MiddleNode.LinkedList expected) {
        internalTestCase(new MiddleNode.Solution2(), linkedList, expected);
    }

    private static void internalTestCase(MiddleNode solution, MiddleNode.LinkedList linkedList, MiddleNode.LinkedList expected) {
        var result = solution.middleNode(linkedList);
        compareLinkedLists(expected, result);
    }

    private static void compareLinkedLists(MiddleNode.LinkedList expected, MiddleNode.LinkedList actual) {
        var internalExpected = expected;
        var internalActual = actual;
        while (internalExpected != null || internalActual != null) {
            Assertions.assertNotNull(internalActual);
            Assertions.assertNotNull(internalExpected);
            Assertions.assertEquals(internalExpected.value, internalActual.value);

            internalActual = internalActual.next;
            internalExpected = internalExpected.next;
        }
    }
}
