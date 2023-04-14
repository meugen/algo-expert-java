package com.algo.expert.binarytrees;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;

public class MergeBinaryTreesTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"tree1\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7}\n" +
            "    ],\n" +
            "    \"root\": \"7\"\n" +
            "  },\n" +
            "  \"tree2\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"2\", \"left\": \"3\", \"right\": \"6\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7}\n" +
            "    ],\n" +
            "    \"root\": \"2\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED1 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"9\", \"left\": \"3\", \"right\": \"6\", \"value\": 9},\n" +
            "    {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "    {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "    {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "    {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4}\n" +
            "  ],\n" +
            "  \"root\": \"9\"\n" +
            "}";

    private static final String TEST_CASE2 = "{\n" +
            "  \"tree1\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"3\", \"right\": \"2\", \"value\": 1},\n" +
            "      {\"id\": \"3\", \"left\": \"5\", \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"tree2\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"2\", \"left\": \"3\", \"right\": \"6\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7}\n" +
            "    ],\n" +
            "    \"root\": \"2\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED2 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"3\", \"left\": \"6\", \"right\": \"8\", \"value\": 3},\n" +
            "    {\"id\": \"8\", \"left\": null, \"right\": \"7\", \"value\": 8},\n" +
            "    {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "    {\"id\": \"6\", \"left\": \"5\", \"right\": \"4\", \"value\": 6},\n" +
            "    {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "    {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "  ],\n" +
            "  \"root\": \"3\"\n" +
            "}";

    private static final String TEST_CASE3 = "{\n" +
            "  \"tree1\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"3\", \"right\": \"2\", \"value\": 1},\n" +
            "      {\"id\": \"3\", \"left\": \"7\", \"right\": \"4\", \"value\": 3},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"tree2\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"5\", \"right\": \"9\", \"value\": 1},\n" +
            "      {\"id\": \"5\", \"left\": \"2\", \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"9\", \"left\": \"7\", \"right\": \"6\", \"value\": 9},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED3 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"2\", \"left\": \"8\", \"right\": \"11\", \"value\": 2},\n" +
            "    {\"id\": \"11\", \"left\": \"7\", \"right\": \"6\", \"value\": 11},\n" +
            "    {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "    {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "    {\"id\": \"8\", \"left\": \"9\", \"right\": \"4\", \"value\": 8},\n" +
            "    {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "    {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9}\n" +
            "  ],\n" +
            "  \"root\": \"2\"\n" +
            "}";

    private static final String TEST_CASE4 = "{\n" +
            "  \"tree1\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"tree2\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"4\", \"left\": \"5\", \"right\": \"6\", \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6}\n" +
            "    ],\n" +
            "    \"root\": \"4\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED4 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"5\", \"left\": \"7\", \"right\": \"9\", \"value\": 5},\n" +
            "    {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "    {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7}\n" +
            "  ],\n" +
            "  \"root\": \"5\"\n" +
            "}";

    private static final String TEST_CASE5 = "{\n" +
            "  \"tree1\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"tree2\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"4\", \"left\": \"5\", \"right\": \"6\", \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": \"1\", \"right\": \"8\", \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8}\n" +
            "    ],\n" +
            "    \"root\": \"4\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED5 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"5\", \"left\": \"7\", \"right\": \"9\", \"value\": 5},\n" +
            "    {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "    {\"id\": \"7\", \"left\": \"1\", \"right\": \"8\", \"value\": 7},\n" +
            "    {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "    {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "  ],\n" +
            "  \"root\": \"5\"\n" +
            "}";

    private static final String TEST_CASE6 = "{\n" +
            "  \"tree1\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"tree2\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"4\", \"left\": \"5\", \"right\": \"6\", \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": \"1\", \"right\": \"8\", \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": \"10\", \"right\": \"15\", \"value\": 6},\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "      {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15}\n" +
            "    ],\n" +
            "    \"root\": \"4\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED6 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"5\", \"left\": \"7\", \"right\": \"9\", \"value\": 5},\n" +
            "    {\"id\": \"9\", \"left\": \"10\", \"right\": \"15\", \"value\": 9},\n" +
            "    {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "    {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "    {\"id\": \"7\", \"left\": \"1\", \"right\": \"8\", \"value\": 7},\n" +
            "    {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "    {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "  ],\n" +
            "  \"root\": \"5\"\n" +
            "}";

    private static final String TEST_CASE7 = "{\n" +
            "  \"tree1\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"5\", \"right\": \"8\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"tree2\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"4\", \"left\": \"5\", \"right\": \"6\", \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6}\n" +
            "    ],\n" +
            "    \"root\": \"4\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED7 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"5\", \"left\": \"7\", \"right\": \"9\", \"value\": 5},\n" +
            "    {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "    {\"id\": \"7\", \"left\": \"5-2\", \"right\": \"8\", \"value\": 7},\n" +
            "    {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "    {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "  ],\n" +
            "  \"root\": \"5\"\n" +
            "}";

    private static final String TEST_CASE8 = "{\n" +
            "  \"tree1\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"1\", \"value\": 2},\n" +
            "      {\"id\": \"4\", \"left\": \"6\", \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6}\n" +
            "    ],\n" +
            "    \"root\": \"2\"\n" +
            "  },\n" +
            "  \"tree2\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"3\", \"left\": \"1\", \"right\": \"6\", \"value\": 3},\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": \"9\", \"value\": 1},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": \"8\", \"value\": 6},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8}\n" +
            "    ],\n" +
            "    \"root\": \"3\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED8 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"5\", \"left\": \"5-2\", \"right\": \"7\", \"value\": 5},\n" +
            "    {\"id\": \"7\", \"left\": null, \"right\": \"8\", \"value\": 7},\n" +
            "    {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "    {\"id\": \"5-2\", \"left\": \"6\", \"right\": \"9\", \"value\": 5},\n" +
            "    {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "    {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6}\n" +
            "  ],\n" +
            "  \"root\": \"5\"\n" +
            "}";

    private static final String TEST_CASE9 = "{\n" +
            "  \"tree1\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"tree2\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED9 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"2\", \"left\": \"4\", \"right\": \"6\", \"value\": 2},\n" +
            "    {\"id\": \"6\", \"left\": \"12\", \"right\": \"14\", \"value\": 6},\n" +
            "    {\"id\": \"14\", \"left\": null, \"right\": null, \"value\": 14},\n" +
            "    {\"id\": \"12\", \"left\": null, \"right\": null, \"value\": 12},\n" +
            "    {\"id\": \"4\", \"left\": \"8\", \"right\": \"10\", \"value\": 4},\n" +
            "    {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "    {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8}\n" +
            "  ],\n" +
            "  \"root\": \"2\"\n" +
            "}";

    private static final String TEST_CASE10 = "{\n" +
            "  \"tree1\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"tree2\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED10 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "  ],\n" +
            "  \"root\": \"2\"\n" +
            "}";

    private static final String TEST_CASE11 = "{\n" +
            "  \"tree1\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"3\", \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"tree2\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": \"4\", \"value\": 1},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED11 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"2\", \"left\": \"3\", \"right\": \"4\", \"value\": 2},\n" +
            "    {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "    {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "  ],\n" +
            "  \"root\": \"2\"\n" +
            "}";

    private static final String TEST_CASE12 = "{\n" +
            "  \"tree1\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"4\", \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  },\n" +
            "  \"tree2\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final String EXPECTED12 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"2\", \"left\": \"4\", \"right\": \"3\", \"value\": 2},\n" +
            "    {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "    {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4}\n" +
            "  ],\n" +
            "  \"root\": \"2\"\n" +
            "}";

    private static MergeBinaryTrees.BinaryTree parseTree(JsonObject tree) {
        var nodes = tree.getAsJsonArray("nodes");

        var map = new HashMap<String, MergeBinaryTrees.BinaryTree>();
        for (var element : nodes) {
            var item = element.getAsJsonObject();
            var id = item.get("id").getAsString();
            var value = item.get("value").getAsInt();
            map.put(id, new MergeBinaryTrees.BinaryTree(value));
        }
        for (var element : nodes) {
            var item = element.getAsJsonObject();
            var id = item.get("id").getAsString();
            var treeItem = map.get(id);
            var left = item.get("left");
            var right = item.get("right");
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

    private static Arguments parseArguments(String testCase, String expected) {
        var object = new Gson().fromJson(testCase, JsonObject.class);
        var tree1 = parseTree(object.getAsJsonObject("tree1"));
        var tree2 = parseTree(object.getAsJsonObject("tree2"));
        var expectedTree = parseTree(new Gson().fromJson(expected, JsonObject.class));
        return Arguments.of(tree1, tree2, expectedTree);
    }

    private static void internalTestCase(
            MergeBinaryTrees solution, MergeBinaryTrees.BinaryTree tree1,
            MergeBinaryTrees.BinaryTree tree2, MergeBinaryTrees.BinaryTree expected
    ) {
        var result = solution.mergeBinaryTrees(tree1, tree2);
        verifyResult(expected, result);
    }

    private static void verifyResult(
            MergeBinaryTrees.BinaryTree expected,
            MergeBinaryTrees.BinaryTree result
    ) {
        if (expected == null) {
            Assertions.assertNull(result);
            return;
        }
        Assertions.assertNotNull(result);
        Assertions.assertEquals(expected.value, result.value);
        verifyResult(expected.left, result.left);
        verifyResult(expected.right, result.right);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution1(
            MergeBinaryTrees.BinaryTree tree1,
            MergeBinaryTrees.BinaryTree tree2,
            MergeBinaryTrees.BinaryTree expected
    ) {
        internalTestCase(new MergeBinaryTrees.Solution1(), tree1, tree2, expected);
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
                parseArguments(TEST_CASE10, EXPECTED10),
                parseArguments(TEST_CASE11, EXPECTED11),
                parseArguments(TEST_CASE12, EXPECTED12)
        );
    }
}
