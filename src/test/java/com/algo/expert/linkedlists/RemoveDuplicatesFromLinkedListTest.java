package com.algo.expert.linkedlists;

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

public class RemoveDuplicatesFromLinkedListTest {

    private static final String TEST_CASE1 = "{\n" +
            "    \"head\": \"1\",\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"next\": \"1-2\", \"value\": 1},\n" +
            "      {\"id\": \"1-2\", \"next\": \"1-3\", \"value\": 1},\n" +
            "      {\"id\": \"1-3\", \"next\": \"2\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"next\": \"3\", \"value\": 3},\n" +
            "      {\"id\": \"3\", \"next\": \"3-2\", \"value\": 4},\n" +
            "      {\"id\": \"3-2\", \"next\": \"3-3\", \"value\": 4},\n" +
            "      {\"id\": \"3-3\", \"next\": \"4\", \"value\": 4},\n" +
            "      {\"id\": \"4\", \"next\": \"5\", \"value\": 5},\n" +
            "      {\"id\": \"5\", \"next\": \"5-2\", \"value\": 6},\n" +
            "      {\"id\": \"5-2\", \"next\": null, \"value\": 6}\n" +
            "    ]\n" +
            "  }";
    private static final String EXPECTED1 = "{\n" +
            "  \"head\": \"1\",\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"1\", \"next\": \"3\", \"value\": 1},\n" +
            "    {\"id\": \"3\", \"next\": \"4\", \"value\": 3},\n" +
            "    {\"id\": \"4\", \"next\": \"5\", \"value\": 4},\n" +
            "    {\"id\": \"5\", \"next\": \"6\", \"value\": 5},\n" +
            "    {\"id\": \"6\", \"next\": null, \"value\": 6}\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE2 = "{\n" +
            "    \"head\": \"1\",\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"next\": \"1-2\", \"value\": 1},\n" +
            "      {\"id\": \"1-2\", \"next\": \"1-3\", \"value\": 1},\n" +
            "      {\"id\": \"1-3\", \"next\": \"1-4\", \"value\": 1},\n" +
            "      {\"id\": \"1-4\", \"next\": \"1-5\", \"value\": 1},\n" +
            "      {\"id\": \"1-5\", \"next\": \"4\", \"value\": 1},\n" +
            "      {\"id\": \"4\", \"next\": \"4-2\", \"value\": 4},\n" +
            "      {\"id\": \"4-2\", \"next\": \"5\", \"value\": 4},\n" +
            "      {\"id\": \"5\", \"next\": \"6\", \"value\": 5},\n" +
            "      {\"id\": \"6\", \"next\": \"6-2\", \"value\": 6},\n" +
            "      {\"id\": \"6-2\", \"next\": null, \"value\": 6}\n" +
            "    ]\n" +
            "  }";
    private static final String EXPECTED2 = "{\n" +
            "  \"head\": \"1\",\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"1\", \"next\": \"4\", \"value\": 1},\n" +
            "    {\"id\": \"4\", \"next\": \"5\", \"value\": 4},\n" +
            "    {\"id\": \"5\", \"next\": \"6\", \"value\": 5},\n" +
            "    {\"id\": \"6\", \"next\": null, \"value\": 6}\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE3 = "{\n" +
            "    \"head\": \"1\",\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"next\": \"1-2\", \"value\": 1},\n" +
            "      {\"id\": \"1-2\", \"next\": \"1-3\", \"value\": 1},\n" +
            "      {\"id\": \"1-3\", \"next\": \"1-4\", \"value\": 1},\n" +
            "      {\"id\": \"1-4\", \"next\": \"1-5\", \"value\": 1},\n" +
            "      {\"id\": \"1-5\", \"next\": \"1-6\", \"value\": 1},\n" +
            "      {\"id\": \"1-6\", \"next\": \"1-7\", \"value\": 1},\n" +
            "      {\"id\": \"1-7\", \"next\": null, \"value\": 1}\n" +
            "    ]\n" +
            "  }";
    private static final String EXPECTED3 = "{\n" +
            "  \"head\": \"1\",\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"1\", \"next\": null, \"value\": 1}\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE4 = "{\n" +
            "    \"head\": \"1\",\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"next\": \"9\", \"value\": 1},\n" +
            "      {\"id\": \"9\", \"next\": \"11\", \"value\": 9},\n" +
            "      {\"id\": \"11\", \"next\": \"15\", \"value\": 11},\n" +
            "      {\"id\": \"15\", \"next\": \"15-2\", \"value\": 15},\n" +
            "      {\"id\": \"15-2\", \"next\": \"16\", \"value\": 15},\n" +
            "      {\"id\": \"16\", \"next\": \"17\", \"value\": 16},\n" +
            "      {\"id\": \"17\", \"next\": null, \"value\": 17}\n" +
            "    ]\n" +
            "  }";
    private static final String EXPECTED4 = "{\n" +
            "  \"head\": \"1\",\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"1\", \"next\": \"9\", \"value\": 1},\n" +
            "    {\"id\": \"9\", \"next\": \"11\", \"value\": 9},\n" +
            "    {\"id\": \"11\", \"next\": \"15\", \"value\": 11},\n" +
            "    {\"id\": \"15\", \"next\": \"16\", \"value\": 15},\n" +
            "    {\"id\": \"16\", \"next\": \"17\", \"value\": 16},\n" +
            "    {\"id\": \"17\", \"next\": null, \"value\": 17}\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE5 = "{\n" +
            "    \"head\": \"1\",\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"next\": null, \"value\": 1}\n" +
            "    ]\n" +
            "  }";
    private static final String EXPECTED5 = "{\n" +
            "  \"head\": \"1\",\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"1\", \"next\": null, \"value\": 1}\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE6 = "{\n" +
            "    \"head\": \"-5\",\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"-5\", \"next\": \"-1\", \"value\": -5},\n" +
            "      {\"id\": \"-1\", \"next\": \"-1-2\", \"value\": -1},\n" +
            "      {\"id\": \"-1-2\", \"next\": \"-1-3\", \"value\": -1},\n" +
            "      {\"id\": \"-1-3\", \"next\": \"5\", \"value\": -1},\n" +
            "      {\"id\": \"5\", \"next\": \"5-2\", \"value\": 5},\n" +
            "      {\"id\": \"5-2\", \"next\": \"5-3\", \"value\": 5},\n" +
            "      {\"id\": \"5-3\", \"next\": \"8\", \"value\": 5},\n" +
            "      {\"id\": \"8\", \"next\": \"8-2\", \"value\": 8},\n" +
            "      {\"id\": \"8-2\", \"next\": \"9\", \"value\": 8},\n" +
            "      {\"id\": \"9\", \"next\": \"10\", \"value\": 9},\n" +
            "      {\"id\": \"10\", \"next\": \"11\", \"value\": 10},\n" +
            "      {\"id\": \"11\", \"next\": \"11-2\", \"value\": 11},\n" +
            "      {\"id\": \"11-2\", \"next\": null, \"value\": 11}\n" +
            "    ]\n" +
            "  }";
    private static final String EXPECTED6 = "{\n" +
            "  \"head\": \"-5\",\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"-5\", \"next\": \"-1\", \"value\": -5},\n" +
            "    {\"id\": \"-1\", \"next\": \"5\", \"value\": -1},\n" +
            "    {\"id\": \"5\", \"next\": \"8\", \"value\": 5},\n" +
            "    {\"id\": \"8\", \"next\": \"9\", \"value\": 8},\n" +
            "    {\"id\": \"9\", \"next\": \"10\", \"value\": 9},\n" +
            "    {\"id\": \"10\", \"next\": \"11\", \"value\": 10},\n" +
            "    {\"id\": \"11\", \"next\": null, \"value\": 11}\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE7 = "{\n" +
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
            "      {\"id\": \"10\", \"next\": \"11\", \"value\": 10},\n" +
            "      {\"id\": \"11\", \"next\": \"12\", \"value\": 11},\n" +
            "      {\"id\": \"12\", \"next\": \"12-2\", \"value\": 12},\n" +
            "      {\"id\": \"12-2\", \"next\": null, \"value\": 12}\n" +
            "    ]\n" +
            "  }";
    private static final String EXPECTED7 = "{\n" +
            "  \"head\": \"1\",\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"1\", \"next\": \"2\", \"value\": 1},\n" +
            "    {\"id\": \"2\", \"next\": \"3\", \"value\": 2},\n" +
            "    {\"id\": \"3\", \"next\": \"4\", \"value\": 3},\n" +
            "    {\"id\": \"4\", \"next\": \"5\", \"value\": 4},\n" +
            "    {\"id\": \"5\", \"next\": \"6\", \"value\": 5},\n" +
            "    {\"id\": \"6\", \"next\": \"7\", \"value\": 6},\n" +
            "    {\"id\": \"7\", \"next\": \"8\", \"value\": 7},\n" +
            "    {\"id\": \"8\", \"next\": \"9\", \"value\": 8},\n" +
            "    {\"id\": \"9\", \"next\": \"10\", \"value\": 9},\n" +
            "    {\"id\": \"10\", \"next\": \"11\", \"value\": 10},\n" +
            "    {\"id\": \"11\", \"next\": \"12\", \"value\": 11},\n" +
            "    {\"id\": \"12\", \"next\": null, \"value\": 12}\n" +
            "  ]\n" +
            "}";

    private void internalTestCases(RemoveDuplicatesFromLinkedList impl, RemoveDuplicatesFromLinkedList.LinkedList linkedList, RemoveDuplicatesFromLinkedList.LinkedList expected) {
        RemoveDuplicatesFromLinkedList.LinkedList result = impl.removeDuplicatesFromLinkedList(linkedList);
        RemoveDuplicatesFromLinkedList.LinkedList current = expected;
        while (true) {
            if (current == null) {
                Assertions.assertNull(result);
                break;
            }
            Assertions.assertNotNull(result);
            Assertions.assertEquals(current.value, result.value);
            result = result.next;
            current = current.next;
        }
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCasesSolution1(RemoveDuplicatesFromLinkedList.LinkedList linkedList, RemoveDuplicatesFromLinkedList.LinkedList expected) {
        internalTestCases(new RemoveDuplicatesFromLinkedList.Solution1(), linkedList, expected);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(parseLinkedList(TEST_CASE1), parseLinkedList(EXPECTED1)),
                Arguments.of(parseLinkedList(TEST_CASE2), parseLinkedList(EXPECTED2)),
                Arguments.of(parseLinkedList(TEST_CASE3), parseLinkedList(EXPECTED3)),
                Arguments.of(parseLinkedList(TEST_CASE4), parseLinkedList(EXPECTED4)),
                Arguments.of(parseLinkedList(TEST_CASE5), parseLinkedList(EXPECTED5)),
                Arguments.of(parseLinkedList(TEST_CASE6), parseLinkedList(EXPECTED6)),
                Arguments.of(parseLinkedList(TEST_CASE7), parseLinkedList(EXPECTED7))
        );
    }

    static RemoveDuplicatesFromLinkedList.LinkedList parseLinkedList(String json) {
        Map<String, RemoveDuplicatesFromLinkedList.LinkedList> map = new HashMap<>();

        JsonObject object = new Gson().fromJson(json, JsonElement.class).getAsJsonObject();
        for (JsonElement node : object.getAsJsonArray("nodes")) {
            String id = node.getAsJsonObject().get("id").getAsString();
            int value = node.getAsJsonObject().get("value").getAsInt();
            map.put(id, new RemoveDuplicatesFromLinkedList.LinkedList(value));
        }
        for (JsonElement node : object.getAsJsonArray("nodes")) {
            String id = node.getAsJsonObject().get("id").getAsString();
            JsonElement next = node.getAsJsonObject().get("next");
            if (!next.isJsonNull()) {
                map.get(id).next = map.get(next.getAsString());
            }
        }
        String head = object.get("head").getAsString();
        return map.get(head);
    }
}
