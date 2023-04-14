package com.algo.expert.binarysearchtrees;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindClosestValueBstTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"10\", \"left\": \"5\", \"right\": \"15\", \"value\": 10},\n" +
            "    {\"id\": \"15\", \"left\": \"13\", \"right\": \"22\", \"value\": 15},\n" +
            "    {\"id\": \"22\", \"left\": null, \"right\": null, \"value\": 22},\n" +
            "    {\"id\": \"13\", \"left\": null, \"right\": \"14\", \"value\": 13},\n" +
            "    {\"id\": \"14\", \"left\": null, \"right\": null, \"value\": 14},\n" +
            "    {\"id\": \"5\", \"left\": \"2\", \"right\": \"5-2\", \"value\": 5},\n" +
            "    {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "    {\"id\": \"2\", \"left\": \"1\", \"right\": null, \"value\": 2},\n" +
            "    {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "  ],\n" +
            "  \"root\": \"10\"\n" +
            "}";
    private static final String TEST_CASE2 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"100\", \"left\": \"5\", \"right\": \"502\", \"value\": 100},\n" +
            "    {\"id\": \"502\", \"left\": \"204\", \"right\": \"55000\", \"value\": 502},\n" +
            "    {\"id\": \"55000\", \"left\": \"1001\", \"right\": null, \"value\": 55000},\n" +
            "    {\"id\": \"1001\", \"left\": null, \"right\": \"4500\", \"value\": 1001},\n" +
            "    {\"id\": \"4500\", \"left\": null, \"right\": null, \"value\": 4500},\n" +
            "    {\"id\": \"204\", \"left\": \"203\", \"right\": \"205\", \"value\": 204},\n" +
            "    {\"id\": \"205\", \"left\": null, \"right\": \"207\", \"value\": 205},\n" +
            "    {\"id\": \"207\", \"left\": \"206\", \"right\": \"208\", \"value\": 207},\n" +
            "    {\"id\": \"208\", \"left\": null, \"right\": null, \"value\": 208},\n" +
            "    {\"id\": \"206\", \"left\": null, \"right\": null, \"value\": 206},\n" +
            "    {\"id\": \"203\", \"left\": null, \"right\": null, \"value\": 203},\n" +
            "    {\"id\": \"5\", \"left\": \"2\", \"right\": \"15\", \"value\": 5},\n" +
            "    {\"id\": \"15\", \"left\": \"5-2\", \"right\": \"22\", \"value\": 15},\n" +
            "    {\"id\": \"22\", \"left\": null, \"right\": \"57\", \"value\": 22},\n" +
            "    {\"id\": \"57\", \"left\": null, \"right\": \"60\", \"value\": 57},\n" +
            "    {\"id\": \"60\", \"left\": null, \"right\": null, \"value\": 60},\n" +
            "    {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "    {\"id\": \"2\", \"left\": \"1\", \"right\": \"3\", \"value\": 2},\n" +
            "    {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "    {\"id\": \"1\", \"left\": \"-51\", \"right\": \"1-2\", \"value\": 1},\n" +
            "    {\"id\": \"1-2\", \"left\": null, \"right\": \"1-3\", \"value\": 1},\n" +
            "    {\"id\": \"1-3\", \"left\": null, \"right\": \"1-4\", \"value\": 1},\n" +
            "    {\"id\": \"1-4\", \"left\": null, \"right\": \"1-5\", \"value\": 1},\n" +
            "    {\"id\": \"1-5\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "    {\"id\": \"-51\", \"left\": \"-403\", \"right\": null, \"value\": -51},\n" +
            "    {\"id\": \"-403\", \"left\": null, \"right\": null, \"value\": -403}\n" +
            "  ],\n" +
            "  \"root\": \"100\"\n" +
            "}";
    private static final String TEST_CASE3 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"100\", \"left\": \"5\", \"right\": \"502\", \"value\": 100},\n" +
            "    {\"id\": \"502\", \"left\": \"204\", \"right\": \"55000\", \"value\": 502},\n" +
            "    {\"id\": \"55000\", \"left\": \"1001\", \"right\": null, \"value\": 55000},\n" +
            "    {\"id\": \"1001\", \"left\": null, \"right\": \"4500\", \"value\": 1001},\n" +
            "    {\"id\": \"4500\", \"left\": null, \"right\": null, \"value\": 4500},\n" +
            "    {\"id\": \"204\", \"left\": \"203\", \"right\": \"205\", \"value\": 204},\n" +
            "    {\"id\": \"205\", \"left\": null, \"right\": \"207\", \"value\": 205},\n" +
            "    {\"id\": \"207\", \"left\": \"206\", \"right\": \"208\", \"value\": 207},\n" +
            "    {\"id\": \"208\", \"left\": null, \"right\": null, \"value\": 208},\n" +
            "    {\"id\": \"206\", \"left\": null, \"right\": null, \"value\": 206},\n" +
            "    {\"id\": \"203\", \"left\": null, \"right\": null, \"value\": 203},\n" +
            "    {\"id\": \"5\", \"left\": \"2\", \"right\": \"15\", \"value\": 5},\n" +
            "    {\"id\": \"15\", \"left\": \"5-2\", \"right\": \"22\", \"value\": 15},\n" +
            "    {\"id\": \"22\", \"left\": null, \"right\": \"57\", \"value\": 22},\n" +
            "    {\"id\": \"57\", \"left\": null, \"right\": \"60\", \"value\": 57},\n" +
            "    {\"id\": \"60\", \"left\": null, \"right\": null, \"value\": 60},\n" +
            "    {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "    {\"id\": \"2\", \"left\": \"1\", \"right\": \"3\", \"value\": 2},\n" +
            "    {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "    {\"id\": \"1\", \"left\": \"-51\", \"right\": \"1-2\", \"value\": 1},\n" +
            "    {\"id\": \"1-2\", \"left\": null, \"right\": \"1-3\", \"value\": 1},\n" +
            "    {\"id\": \"1-3\", \"left\": null, \"right\": \"1-4\", \"value\": 1},\n" +
            "    {\"id\": \"1-4\", \"left\": null, \"right\": \"1-5\", \"value\": 1},\n" +
            "    {\"id\": \"1-5\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "    {\"id\": \"-51\", \"left\": \"-403\", \"right\": null, \"value\": -51},\n" +
            "    {\"id\": \"-403\", \"left\": null, \"right\": null, \"value\": -403}\n" +
            "  ],\n" +
            "  \"root\": \"100\"\n" +
            "}";
    private static final String TEST_CASE4 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"100\", \"left\": \"5\", \"right\": \"502\", \"value\": 100},\n" +
            "    {\"id\": \"502\", \"left\": \"204\", \"right\": \"55000\", \"value\": 502},\n" +
            "    {\"id\": \"55000\", \"left\": \"1001\", \"right\": null, \"value\": 55000},\n" +
            "    {\"id\": \"1001\", \"left\": null, \"right\": \"4500\", \"value\": 1001},\n" +
            "    {\"id\": \"4500\", \"left\": null, \"right\": null, \"value\": 4500},\n" +
            "    {\"id\": \"204\", \"left\": \"203\", \"right\": \"205\", \"value\": 204},\n" +
            "    {\"id\": \"205\", \"left\": null, \"right\": \"207\", \"value\": 205},\n" +
            "    {\"id\": \"207\", \"left\": \"206\", \"right\": \"208\", \"value\": 207},\n" +
            "    {\"id\": \"208\", \"left\": null, \"right\": null, \"value\": 208},\n" +
            "    {\"id\": \"206\", \"left\": null, \"right\": null, \"value\": 206},\n" +
            "    {\"id\": \"203\", \"left\": null, \"right\": null, \"value\": 203},\n" +
            "    {\"id\": \"5\", \"left\": \"2\", \"right\": \"15\", \"value\": 5},\n" +
            "    {\"id\": \"15\", \"left\": \"5-2\", \"right\": \"22\", \"value\": 15},\n" +
            "    {\"id\": \"22\", \"left\": null, \"right\": \"57\", \"value\": 22},\n" +
            "    {\"id\": \"57\", \"left\": null, \"right\": \"60\", \"value\": 57},\n" +
            "    {\"id\": \"60\", \"left\": null, \"right\": null, \"value\": 60},\n" +
            "    {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "    {\"id\": \"2\", \"left\": \"1\", \"right\": \"3\", \"value\": 2},\n" +
            "    {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "    {\"id\": \"1\", \"left\": \"-51\", \"right\": \"1-2\", \"value\": 1},\n" +
            "    {\"id\": \"1-2\", \"left\": null, \"right\": \"1-3\", \"value\": 1},\n" +
            "    {\"id\": \"1-3\", \"left\": null, \"right\": \"1-4\", \"value\": 1},\n" +
            "    {\"id\": \"1-4\", \"left\": null, \"right\": \"1-5\", \"value\": 1},\n" +
            "    {\"id\": \"1-5\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "    {\"id\": \"-51\", \"left\": \"-403\", \"right\": null, \"value\": -51},\n" +
            "    {\"id\": \"-403\", \"left\": null, \"right\": null, \"value\": -403}\n" +
            "  ],\n" +
            "  \"root\": \"100\"\n" +
            "}";
    private static final String TEST_CASE5 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"100\", \"left\": \"5\", \"right\": \"502\", \"value\": 100},\n" +
            "    {\"id\": \"502\", \"left\": \"204\", \"right\": \"55000\", \"value\": 502},\n" +
            "    {\"id\": \"55000\", \"left\": \"1001\", \"right\": null, \"value\": 55000},\n" +
            "    {\"id\": \"1001\", \"left\": null, \"right\": \"4500\", \"value\": 1001},\n" +
            "    {\"id\": \"4500\", \"left\": null, \"right\": null, \"value\": 4500},\n" +
            "    {\"id\": \"204\", \"left\": \"203\", \"right\": \"205\", \"value\": 204},\n" +
            "    {\"id\": \"205\", \"left\": null, \"right\": \"207\", \"value\": 205},\n" +
            "    {\"id\": \"207\", \"left\": \"206\", \"right\": \"208\", \"value\": 207},\n" +
            "    {\"id\": \"208\", \"left\": null, \"right\": null, \"value\": 208},\n" +
            "    {\"id\": \"206\", \"left\": null, \"right\": null, \"value\": 206},\n" +
            "    {\"id\": \"203\", \"left\": null, \"right\": null, \"value\": 203},\n" +
            "    {\"id\": \"5\", \"left\": \"2\", \"right\": \"15\", \"value\": 5},\n" +
            "    {\"id\": \"15\", \"left\": \"5-2\", \"right\": \"22\", \"value\": 15},\n" +
            "    {\"id\": \"22\", \"left\": null, \"right\": \"57\", \"value\": 22},\n" +
            "    {\"id\": \"57\", \"left\": null, \"right\": \"60\", \"value\": 57},\n" +
            "    {\"id\": \"60\", \"left\": null, \"right\": null, \"value\": 60},\n" +
            "    {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "    {\"id\": \"2\", \"left\": \"1\", \"right\": \"3\", \"value\": 2},\n" +
            "    {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "    {\"id\": \"1\", \"left\": \"-51\", \"right\": \"1-2\", \"value\": 1},\n" +
            "    {\"id\": \"1-2\", \"left\": null, \"right\": \"1-3\", \"value\": 1},\n" +
            "    {\"id\": \"1-3\", \"left\": null, \"right\": \"1-4\", \"value\": 1},\n" +
            "    {\"id\": \"1-4\", \"left\": null, \"right\": \"1-5\", \"value\": 1},\n" +
            "    {\"id\": \"1-5\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "    {\"id\": \"-51\", \"left\": \"-403\", \"right\": null, \"value\": -51},\n" +
            "    {\"id\": \"-403\", \"left\": null, \"right\": null, \"value\": -403}\n" +
            "  ],\n" +
            "  \"root\": \"100\"\n" +
            "}";
    private static final String TEST_CASE6 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"100\", \"left\": \"5\", \"right\": \"502\", \"value\": 100},\n" +
            "    {\"id\": \"502\", \"left\": \"204\", \"right\": \"55000\", \"value\": 502},\n" +
            "    {\"id\": \"55000\", \"left\": \"1001\", \"right\": null, \"value\": 55000},\n" +
            "    {\"id\": \"1001\", \"left\": null, \"right\": \"4500\", \"value\": 1001},\n" +
            "    {\"id\": \"4500\", \"left\": null, \"right\": null, \"value\": 4500},\n" +
            "    {\"id\": \"204\", \"left\": \"203\", \"right\": \"205\", \"value\": 204},\n" +
            "    {\"id\": \"205\", \"left\": null, \"right\": \"207\", \"value\": 205},\n" +
            "    {\"id\": \"207\", \"left\": \"206\", \"right\": \"208\", \"value\": 207},\n" +
            "    {\"id\": \"208\", \"left\": null, \"right\": null, \"value\": 208},\n" +
            "    {\"id\": \"206\", \"left\": null, \"right\": null, \"value\": 206},\n" +
            "    {\"id\": \"203\", \"left\": null, \"right\": null, \"value\": 203},\n" +
            "    {\"id\": \"5\", \"left\": \"2\", \"right\": \"15\", \"value\": 5},\n" +
            "    {\"id\": \"15\", \"left\": \"5-2\", \"right\": \"22\", \"value\": 15},\n" +
            "    {\"id\": \"22\", \"left\": null, \"right\": \"57\", \"value\": 22},\n" +
            "    {\"id\": \"57\", \"left\": null, \"right\": \"60\", \"value\": 57},\n" +
            "    {\"id\": \"60\", \"left\": null, \"right\": null, \"value\": 60},\n" +
            "    {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "    {\"id\": \"2\", \"left\": \"1\", \"right\": \"3\", \"value\": 2},\n" +
            "    {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "    {\"id\": \"1\", \"left\": \"-51\", \"right\": \"1-2\", \"value\": 1},\n" +
            "    {\"id\": \"1-2\", \"left\": null, \"right\": \"1-3\", \"value\": 1},\n" +
            "    {\"id\": \"1-3\", \"left\": null, \"right\": \"1-4\", \"value\": 1},\n" +
            "    {\"id\": \"1-4\", \"left\": null, \"right\": \"1-5\", \"value\": 1},\n" +
            "    {\"id\": \"1-5\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "    {\"id\": \"-51\", \"left\": \"-403\", \"right\": null, \"value\": -51},\n" +
            "    {\"id\": \"-403\", \"left\": null, \"right\": null, \"value\": -403}\n" +
            "  ],\n" +
            "  \"root\": \"100\"\n" +
            "}";
    private static final String TEST_CASE7 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"100\", \"left\": \"5\", \"right\": \"502\", \"value\": 100},\n" +
            "    {\"id\": \"502\", \"left\": \"204\", \"right\": \"55000\", \"value\": 502},\n" +
            "    {\"id\": \"55000\", \"left\": \"1001\", \"right\": null, \"value\": 55000},\n" +
            "    {\"id\": \"1001\", \"left\": null, \"right\": \"4500\", \"value\": 1001},\n" +
            "    {\"id\": \"4500\", \"left\": null, \"right\": null, \"value\": 4500},\n" +
            "    {\"id\": \"204\", \"left\": \"203\", \"right\": \"205\", \"value\": 204},\n" +
            "    {\"id\": \"205\", \"left\": null, \"right\": \"207\", \"value\": 205},\n" +
            "    {\"id\": \"207\", \"left\": \"206\", \"right\": \"208\", \"value\": 207},\n" +
            "    {\"id\": \"208\", \"left\": null, \"right\": null, \"value\": 208},\n" +
            "    {\"id\": \"206\", \"left\": null, \"right\": null, \"value\": 206},\n" +
            "    {\"id\": \"203\", \"left\": null, \"right\": null, \"value\": 203},\n" +
            "    {\"id\": \"5\", \"left\": \"2\", \"right\": \"15\", \"value\": 5},\n" +
            "    {\"id\": \"15\", \"left\": \"5-2\", \"right\": \"22\", \"value\": 15},\n" +
            "    {\"id\": \"22\", \"left\": null, \"right\": \"57\", \"value\": 22},\n" +
            "    {\"id\": \"57\", \"left\": null, \"right\": \"60\", \"value\": 57},\n" +
            "    {\"id\": \"60\", \"left\": null, \"right\": null, \"value\": 60},\n" +
            "    {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "    {\"id\": \"2\", \"left\": \"1\", \"right\": \"3\", \"value\": 2},\n" +
            "    {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "    {\"id\": \"1\", \"left\": \"-51\", \"right\": \"1-2\", \"value\": 1},\n" +
            "    {\"id\": \"1-2\", \"left\": null, \"right\": \"1-3\", \"value\": 1},\n" +
            "    {\"id\": \"1-3\", \"left\": null, \"right\": \"1-4\", \"value\": 1},\n" +
            "    {\"id\": \"1-4\", \"left\": null, \"right\": \"1-5\", \"value\": 1},\n" +
            "    {\"id\": \"1-5\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "    {\"id\": \"-51\", \"left\": \"-403\", \"right\": null, \"value\": -51},\n" +
            "    {\"id\": \"-403\", \"left\": null, \"right\": null, \"value\": -403}\n" +
            "  ],\n" +
            "  \"root\": \"100\"\n" +
            "}";
    private static final String TEST_CASE8 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"100\", \"left\": \"5\", \"right\": \"502\", \"value\": 100},\n" +
            "    {\"id\": \"502\", \"left\": \"204\", \"right\": \"55000\", \"value\": 502},\n" +
            "    {\"id\": \"55000\", \"left\": \"1001\", \"right\": null, \"value\": 55000},\n" +
            "    {\"id\": \"1001\", \"left\": null, \"right\": \"4500\", \"value\": 1001},\n" +
            "    {\"id\": \"4500\", \"left\": null, \"right\": null, \"value\": 4500},\n" +
            "    {\"id\": \"204\", \"left\": \"203\", \"right\": \"205\", \"value\": 204},\n" +
            "    {\"id\": \"205\", \"left\": null, \"right\": \"207\", \"value\": 205},\n" +
            "    {\"id\": \"207\", \"left\": \"206\", \"right\": \"208\", \"value\": 207},\n" +
            "    {\"id\": \"208\", \"left\": null, \"right\": null, \"value\": 208},\n" +
            "    {\"id\": \"206\", \"left\": null, \"right\": null, \"value\": 206},\n" +
            "    {\"id\": \"203\", \"left\": null, \"right\": null, \"value\": 203},\n" +
            "    {\"id\": \"5\", \"left\": \"2\", \"right\": \"15\", \"value\": 5},\n" +
            "    {\"id\": \"15\", \"left\": \"5-2\", \"right\": \"22\", \"value\": 15},\n" +
            "    {\"id\": \"22\", \"left\": null, \"right\": \"57\", \"value\": 22},\n" +
            "    {\"id\": \"57\", \"left\": null, \"right\": \"60\", \"value\": 57},\n" +
            "    {\"id\": \"60\", \"left\": null, \"right\": null, \"value\": 60},\n" +
            "    {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "    {\"id\": \"2\", \"left\": \"1\", \"right\": \"3\", \"value\": 2},\n" +
            "    {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "    {\"id\": \"1\", \"left\": \"-51\", \"right\": \"1-2\", \"value\": 1},\n" +
            "    {\"id\": \"1-2\", \"left\": null, \"right\": \"1-3\", \"value\": 1},\n" +
            "    {\"id\": \"1-3\", \"left\": null, \"right\": \"1-4\", \"value\": 1},\n" +
            "    {\"id\": \"1-4\", \"left\": null, \"right\": \"1-5\", \"value\": 1},\n" +
            "    {\"id\": \"1-5\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "    {\"id\": \"-51\", \"left\": \"-403\", \"right\": null, \"value\": -51},\n" +
            "    {\"id\": \"-403\", \"left\": null, \"right\": null, \"value\": -403}\n" +
            "  ],\n" +
            "  \"root\": \"100\"\n" +
            "}";
    private static final String TEST_CASE9 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"100\", \"left\": \"5\", \"right\": \"502\", \"value\": 100},\n" +
            "    {\"id\": \"502\", \"left\": \"204\", \"right\": \"55000\", \"value\": 502},\n" +
            "    {\"id\": \"55000\", \"left\": \"1001\", \"right\": null, \"value\": 55000},\n" +
            "    {\"id\": \"1001\", \"left\": null, \"right\": \"4500\", \"value\": 1001},\n" +
            "    {\"id\": \"4500\", \"left\": null, \"right\": null, \"value\": 4500},\n" +
            "    {\"id\": \"204\", \"left\": \"203\", \"right\": \"205\", \"value\": 204},\n" +
            "    {\"id\": \"205\", \"left\": null, \"right\": \"207\", \"value\": 205},\n" +
            "    {\"id\": \"207\", \"left\": \"206\", \"right\": \"208\", \"value\": 207},\n" +
            "    {\"id\": \"208\", \"left\": null, \"right\": null, \"value\": 208},\n" +
            "    {\"id\": \"206\", \"left\": null, \"right\": null, \"value\": 206},\n" +
            "    {\"id\": \"203\", \"left\": null, \"right\": null, \"value\": 203},\n" +
            "    {\"id\": \"5\", \"left\": \"2\", \"right\": \"15\", \"value\": 5},\n" +
            "    {\"id\": \"15\", \"left\": \"5-2\", \"right\": \"22\", \"value\": 15},\n" +
            "    {\"id\": \"22\", \"left\": null, \"right\": \"57\", \"value\": 22},\n" +
            "    {\"id\": \"57\", \"left\": null, \"right\": \"60\", \"value\": 57},\n" +
            "    {\"id\": \"60\", \"left\": null, \"right\": null, \"value\": 60},\n" +
            "    {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "    {\"id\": \"2\", \"left\": \"1\", \"right\": \"3\", \"value\": 2},\n" +
            "    {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "    {\"id\": \"1\", \"left\": \"-51\", \"right\": \"1-2\", \"value\": 1},\n" +
            "    {\"id\": \"1-2\", \"left\": null, \"right\": \"1-3\", \"value\": 1},\n" +
            "    {\"id\": \"1-3\", \"left\": null, \"right\": \"1-4\", \"value\": 1},\n" +
            "    {\"id\": \"1-4\", \"left\": null, \"right\": \"1-5\", \"value\": 1},\n" +
            "    {\"id\": \"1-5\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "    {\"id\": \"-51\", \"left\": \"-403\", \"right\": null, \"value\": -51},\n" +
            "    {\"id\": \"-403\", \"left\": null, \"right\": null, \"value\": -403}\n" +
            "  ],\n" +
            "  \"root\": \"100\"\n" +
            "}";
    private static final String TEST_CASE10 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"100\", \"left\": \"5\", \"right\": \"502\", \"value\": 100},\n" +
            "    {\"id\": \"502\", \"left\": \"204\", \"right\": \"55000\", \"value\": 502},\n" +
            "    {\"id\": \"55000\", \"left\": \"1001\", \"right\": null, \"value\": 55000},\n" +
            "    {\"id\": \"1001\", \"left\": null, \"right\": \"4500\", \"value\": 1001},\n" +
            "    {\"id\": \"4500\", \"left\": null, \"right\": null, \"value\": 4500},\n" +
            "    {\"id\": \"204\", \"left\": \"203\", \"right\": \"205\", \"value\": 204},\n" +
            "    {\"id\": \"205\", \"left\": null, \"right\": \"207\", \"value\": 205},\n" +
            "    {\"id\": \"207\", \"left\": \"206\", \"right\": \"208\", \"value\": 207},\n" +
            "    {\"id\": \"208\", \"left\": null, \"right\": null, \"value\": 208},\n" +
            "    {\"id\": \"206\", \"left\": null, \"right\": null, \"value\": 206},\n" +
            "    {\"id\": \"203\", \"left\": null, \"right\": null, \"value\": 203},\n" +
            "    {\"id\": \"5\", \"left\": \"2\", \"right\": \"15\", \"value\": 5},\n" +
            "    {\"id\": \"15\", \"left\": \"5-2\", \"right\": \"22\", \"value\": 15},\n" +
            "    {\"id\": \"22\", \"left\": null, \"right\": \"57\", \"value\": 22},\n" +
            "    {\"id\": \"57\", \"left\": null, \"right\": \"60\", \"value\": 57},\n" +
            "    {\"id\": \"60\", \"left\": null, \"right\": null, \"value\": 60},\n" +
            "    {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "    {\"id\": \"2\", \"left\": \"1\", \"right\": \"3\", \"value\": 2},\n" +
            "    {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "    {\"id\": \"1\", \"left\": \"-51\", \"right\": \"1-2\", \"value\": 1},\n" +
            "    {\"id\": \"1-2\", \"left\": null, \"right\": \"1-3\", \"value\": 1},\n" +
            "    {\"id\": \"1-3\", \"left\": null, \"right\": \"1-4\", \"value\": 1},\n" +
            "    {\"id\": \"1-4\", \"left\": null, \"right\": \"1-5\", \"value\": 1},\n" +
            "    {\"id\": \"1-5\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "    {\"id\": \"-51\", \"left\": \"-403\", \"right\": null, \"value\": -51},\n" +
            "    {\"id\": \"-403\", \"left\": null, \"right\": null, \"value\": -403}\n" +
            "  ],\n" +
            "  \"root\": \"100\"\n" +
            "}";
    private static final String TEST_CASE11 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"100\", \"left\": \"5\", \"right\": \"502\", \"value\": 100},\n" +
            "    {\"id\": \"502\", \"left\": \"204\", \"right\": \"55000\", \"value\": 502},\n" +
            "    {\"id\": \"55000\", \"left\": \"1001\", \"right\": null, \"value\": 55000},\n" +
            "    {\"id\": \"1001\", \"left\": null, \"right\": \"4500\", \"value\": 1001},\n" +
            "    {\"id\": \"4500\", \"left\": null, \"right\": null, \"value\": 4500},\n" +
            "    {\"id\": \"204\", \"left\": \"203\", \"right\": \"205\", \"value\": 204},\n" +
            "    {\"id\": \"205\", \"left\": null, \"right\": \"207\", \"value\": 205},\n" +
            "    {\"id\": \"207\", \"left\": \"206\", \"right\": \"208\", \"value\": 207},\n" +
            "    {\"id\": \"208\", \"left\": null, \"right\": null, \"value\": 208},\n" +
            "    {\"id\": \"206\", \"left\": null, \"right\": null, \"value\": 206},\n" +
            "    {\"id\": \"203\", \"left\": null, \"right\": null, \"value\": 203},\n" +
            "    {\"id\": \"5\", \"left\": \"2\", \"right\": \"15\", \"value\": 5},\n" +
            "    {\"id\": \"15\", \"left\": \"5-2\", \"right\": \"22\", \"value\": 15},\n" +
            "    {\"id\": \"22\", \"left\": null, \"right\": \"57\", \"value\": 22},\n" +
            "    {\"id\": \"57\", \"left\": null, \"right\": \"60\", \"value\": 57},\n" +
            "    {\"id\": \"60\", \"left\": null, \"right\": null, \"value\": 60},\n" +
            "    {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "    {\"id\": \"2\", \"left\": \"1\", \"right\": \"3\", \"value\": 2},\n" +
            "    {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "    {\"id\": \"1\", \"left\": \"-51\", \"right\": \"1-2\", \"value\": 1},\n" +
            "    {\"id\": \"1-2\", \"left\": null, \"right\": \"1-3\", \"value\": 1},\n" +
            "    {\"id\": \"1-3\", \"left\": null, \"right\": \"1-4\", \"value\": 1},\n" +
            "    {\"id\": \"1-4\", \"left\": null, \"right\": \"1-5\", \"value\": 1},\n" +
            "    {\"id\": \"1-5\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "    {\"id\": \"-51\", \"left\": \"-403\", \"right\": null, \"value\": -51},\n" +
            "    {\"id\": \"-403\", \"left\": null, \"right\": null, \"value\": -403}\n" +
            "  ],\n" +
            "  \"root\": \"100\"\n" +
            "}";
    private static final String TEST_CASE12 = "{\n" +
            "  \"nodes\": [\n" +
            "    {\"id\": \"100\", \"left\": \"5\", \"right\": \"502\", \"value\": 100},\n" +
            "    {\"id\": \"502\", \"left\": \"204\", \"right\": \"55000\", \"value\": 502},\n" +
            "    {\"id\": \"55000\", \"left\": \"1001\", \"right\": null, \"value\": 55000},\n" +
            "    {\"id\": \"1001\", \"left\": null, \"right\": \"4500\", \"value\": 1001},\n" +
            "    {\"id\": \"4500\", \"left\": null, \"right\": null, \"value\": 4500},\n" +
            "    {\"id\": \"204\", \"left\": \"203\", \"right\": \"205\", \"value\": 204},\n" +
            "    {\"id\": \"205\", \"left\": null, \"right\": \"207\", \"value\": 205},\n" +
            "    {\"id\": \"207\", \"left\": \"206\", \"right\": \"208\", \"value\": 207},\n" +
            "    {\"id\": \"208\", \"left\": null, \"right\": null, \"value\": 208},\n" +
            "    {\"id\": \"206\", \"left\": null, \"right\": null, \"value\": 206},\n" +
            "    {\"id\": \"203\", \"left\": null, \"right\": null, \"value\": 203},\n" +
            "    {\"id\": \"5\", \"left\": \"2\", \"right\": \"15\", \"value\": 5},\n" +
            "    {\"id\": \"15\", \"left\": \"5-2\", \"right\": \"22\", \"value\": 15},\n" +
            "    {\"id\": \"22\", \"left\": null, \"right\": \"57\", \"value\": 22},\n" +
            "    {\"id\": \"57\", \"left\": null, \"right\": \"60\", \"value\": 57},\n" +
            "    {\"id\": \"60\", \"left\": null, \"right\": null, \"value\": 60},\n" +
            "    {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "    {\"id\": \"2\", \"left\": \"1\", \"right\": \"3\", \"value\": 2},\n" +
            "    {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "    {\"id\": \"1\", \"left\": \"-51\", \"right\": \"1-2\", \"value\": 1},\n" +
            "    {\"id\": \"1-2\", \"left\": null, \"right\": \"1-3\", \"value\": 1},\n" +
            "    {\"id\": \"1-3\", \"left\": null, \"right\": \"1-4\", \"value\": 1},\n" +
            "    {\"id\": \"1-4\", \"left\": null, \"right\": \"1-5\", \"value\": 1},\n" +
            "    {\"id\": \"1-5\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "    {\"id\": \"-51\", \"left\": \"-403\", \"right\": null, \"value\": -51},\n" +
            "    {\"id\": \"-403\", \"left\": null, \"right\": null, \"value\": -403}\n" +
            "  ],\n" +
            "  \"root\": \"100\"\n" +
            "}";

    private void internalTestCases(FindClosestValueBst impl, FindClosestValueBst.BST tree, int target, int expected) {
        int result = impl.findClosestValueInBst(tree, target);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCasesSolution1(FindClosestValueBst.BST tree, int target, int expected) {
        internalTestCases(new FindClosestValueBst.Solution1(), tree, target, expected);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(parseTestCase(TEST_CASE1), 12, 13),
                Arguments.of(parseTestCase(TEST_CASE2), 100, 100),
                Arguments.of(parseTestCase(TEST_CASE3), 208, 208),
                Arguments.of(parseTestCase(TEST_CASE4), 4500, 4500),
                Arguments.of(parseTestCase(TEST_CASE5), 4501, 4500),
                Arguments.of(parseTestCase(TEST_CASE6), -70, -51),
                Arguments.of(parseTestCase(TEST_CASE7), 2000, 1001),
                Arguments.of(parseTestCase(TEST_CASE8), 6, 5),
                Arguments.of(parseTestCase(TEST_CASE9), 30000, 55000),
                Arguments.of(parseTestCase(TEST_CASE10), -1, 1),
                Arguments.of(parseTestCase(TEST_CASE11), 29751, 55000),
                Arguments.of(parseTestCase(TEST_CASE12), 29749, 4500)
        );
    }

    static FindClosestValueBst.BST parseTestCase(String json) {
        JsonElement element = new Gson().fromJson(json, JsonElement.class);
        JsonArray nodes = element.getAsJsonObject().getAsJsonArray("nodes");

        Map<String, FindClosestValueBst.BST> map = new HashMap<>();
        for (JsonElement node : nodes) {
            JsonObject object = node.getAsJsonObject();
            map.put(
                    object.getAsJsonPrimitive("id").getAsString(),
                    new FindClosestValueBst.BST(object.getAsJsonPrimitive("value").getAsInt())
            );
        }
        for (JsonElement node : nodes) {
            JsonObject object = node.getAsJsonObject();
            JsonElement left = object.get("left");
            if (!left.isJsonNull()) {
                map.get(object.getAsJsonPrimitive("id").getAsString()).left = map.get(left.getAsString());
            }
            JsonElement right = object.get("right");
            if (!right.isJsonNull()) {
                map.get(object.getAsJsonPrimitive("id").getAsString()).right = map.get(right.getAsString());
            }
        }
        return map.get(element.getAsJsonObject().getAsJsonPrimitive("root").getAsString());
    }
}
