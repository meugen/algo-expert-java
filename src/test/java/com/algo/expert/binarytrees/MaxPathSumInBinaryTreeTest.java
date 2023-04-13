package com.algo.expert.binarytrees;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;

public class MaxPathSumInBinaryTreeTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"3\", \"left\": \"6\", \"right\": \"7\", \"value\": 3},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED1 = 18;

    private static final String TEST_CASE2 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED2 = 6;

    private static final String TEST_CASE3 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"-1\", \"value\": 1},\n" +
            "      {\"id\": \"-1\", \"left\": null, \"right\": null, \"value\": -1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED3 = 3;

    private static final String TEST_CASE4 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"-5\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"-5\", \"left\": \"6\", \"right\": null, \"value\": -5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED4 = 6;

    private static final String TEST_CASE5 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"-10\", \"right\": \"-5\", \"value\": 1},\n" +
            "      {\"id\": \"-5\", \"left\": \"-20\", \"right\": \"-21\", \"value\": -5},\n" +
            "      {\"id\": \"-21\", \"left\": \"100-2\", \"right\": \"1-3\", \"value\": -21},\n" +
            "      {\"id\": \"1-3\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"100-2\", \"left\": null, \"right\": null, \"value\": 100},\n" +
            "      {\"id\": \"-20\", \"left\": \"100\", \"right\": \"2\", \"value\": -20},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"100\", \"left\": null, \"right\": null, \"value\": 100},\n" +
            "      {\"id\": \"-10\", \"left\": \"30\", \"right\": \"45\", \"value\": -10},\n" +
            "      {\"id\": \"45\", \"left\": \"3\", \"right\": \"-3\", \"value\": 45},\n" +
            "      {\"id\": \"-3\", \"left\": null, \"right\": null, \"value\": -3},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"30\", \"left\": \"5\", \"right\": \"1-2\", \"value\": 30},\n" +
            "      {\"id\": \"1-2\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED5 = 154;

    private static final String TEST_CASE6 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"-10\", \"right\": \"-5\", \"value\": 1},\n" +
            "      {\"id\": \"-5\", \"left\": \"-20\", \"right\": \"-21\", \"value\": -5},\n" +
            "      {\"id\": \"-21\", \"left\": \"100-3\", \"right\": \"1-3\", \"value\": -21},\n" +
            "      {\"id\": \"1-3\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"100-3\", \"left\": null, \"right\": null, \"value\": 100},\n" +
            "      {\"id\": \"-20\", \"left\": \"100-2\", \"right\": \"2\", \"value\": -20},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"100-2\", \"left\": null, \"right\": null, \"value\": 100},\n" +
            "      {\"id\": \"-10\", \"left\": \"30\", \"right\": \"45\", \"value\": -10},\n" +
            "      {\"id\": \"45\", \"left\": \"3\", \"right\": \"-3\", \"value\": 45},\n" +
            "      {\"id\": \"-3\", \"left\": null, \"right\": null, \"value\": -3},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"30\", \"left\": \"5\", \"right\": \"1-2\", \"value\": 30},\n" +
            "      {\"id\": \"1-2\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"5\", \"left\": \"100\", \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"100\", \"left\": null, \"right\": null, \"value\": 100}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED6 = 201;

    private static final String TEST_CASE7 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"-10\", \"right\": \"-5\", \"value\": 1},\n" +
            "      {\"id\": \"-5\", \"left\": \"-20\", \"right\": \"-21\", \"value\": -5},\n" +
            "      {\"id\": \"-21\", \"left\": \"100-3\", \"right\": \"1-3\", \"value\": -21},\n" +
            "      {\"id\": \"1-3\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"100-3\", \"left\": null, \"right\": null, \"value\": 100},\n" +
            "      {\"id\": \"-20\", \"left\": \"100-2\", \"right\": \"2\", \"value\": -20},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"100-2\", \"left\": null, \"right\": null, \"value\": 100},\n" +
            "      {\"id\": \"-10\", \"left\": \"30\", \"right\": \"75\", \"value\": -10},\n" +
            "      {\"id\": \"75\", \"left\": \"3\", \"right\": \"-3\", \"value\": 75},\n" +
            "      {\"id\": \"-3\", \"left\": null, \"right\": null, \"value\": -3},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"30\", \"left\": \"5\", \"right\": \"1-2\", \"value\": 30},\n" +
            "      {\"id\": \"1-2\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"5\", \"left\": \"100\", \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"100\", \"left\": null, \"right\": null, \"value\": 100}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED7 = 203;

    private static final String TEST_CASE8 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"-150\", \"right\": \"-5\", \"value\": 1},\n" +
            "      {\"id\": \"-5\", \"left\": \"-20\", \"right\": \"-21\", \"value\": -5},\n" +
            "      {\"id\": \"-21\", \"left\": \"100-4\", \"right\": \"1-3\", \"value\": -21},\n" +
            "      {\"id\": \"1-3\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"100-4\", \"left\": null, \"right\": null, \"value\": 100},\n" +
            "      {\"id\": \"-20\", \"left\": \"100-3\", \"right\": \"2\", \"value\": -20},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"100-3\", \"left\": null, \"right\": null, \"value\": 100},\n" +
            "      {\"id\": \"-150\", \"left\": \"30\", \"right\": \"75\", \"value\": -150},\n" +
            "      {\"id\": \"75\", \"left\": \"3\", \"right\": \"-3\", \"value\": 75},\n" +
            "      {\"id\": \"-3\", \"left\": null, \"right\": null, \"value\": -3},\n" +
            "      {\"id\": \"3\", \"left\": \"150\", \"right\": \"-8\", \"value\": 3},\n" +
            "      {\"id\": \"-8\", \"left\": null, \"right\": null, \"value\": -8},\n" +
            "      {\"id\": \"150\", \"left\": null, \"right\": null, \"value\": 150},\n" +
            "      {\"id\": \"30\", \"left\": \"5\", \"right\": \"1-2\", \"value\": 30},\n" +
            "      {\"id\": \"1-2\", \"left\": \"5-2\", \"right\": \"10\", \"value\": 1},\n" +
            "      {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"5\", \"left\": \"100\", \"right\": \"100-2\", \"value\": 5},\n" +
            "      {\"id\": \"100-2\", \"left\": null, \"right\": null, \"value\": 100},\n" +
            "      {\"id\": \"100\", \"left\": null, \"right\": null, \"value\": 100}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED8 = 228;

    private static final String TEST_CASE9 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"-150\", \"right\": \"-5\", \"value\": 1},\n" +
            "      {\"id\": \"-5\", \"left\": \"-20\", \"right\": \"-21\", \"value\": -5},\n" +
            "      {\"id\": \"-21\", \"left\": \"100-4\", \"right\": \"1-3\", \"value\": -21},\n" +
            "      {\"id\": \"1-3\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"100-4\", \"left\": null, \"right\": null, \"value\": 100},\n" +
            "      {\"id\": \"-20\", \"left\": \"100-3\", \"right\": \"2\", \"value\": -20},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"100-3\", \"left\": null, \"right\": null, \"value\": 100},\n" +
            "      {\"id\": \"-150\", \"left\": \"30\", \"right\": \"75\", \"value\": -150},\n" +
            "      {\"id\": \"75\", \"left\": \"3\", \"right\": \"-3\", \"value\": 75},\n" +
            "      {\"id\": \"-3\", \"left\": null, \"right\": null, \"value\": -3},\n" +
            "      {\"id\": \"3\", \"left\": \"150\", \"right\": \"151\", \"value\": 3},\n" +
            "      {\"id\": \"151\", \"left\": null, \"right\": null, \"value\": 151},\n" +
            "      {\"id\": \"150\", \"left\": null, \"right\": null, \"value\": 150},\n" +
            "      {\"id\": \"30\", \"left\": \"5\", \"right\": \"1-2\", \"value\": 30},\n" +
            "      {\"id\": \"1-2\", \"left\": \"5-2\", \"right\": \"10\", \"value\": 1},\n" +
            "      {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"5\", \"left\": \"100\", \"right\": \"100-2\", \"value\": 5},\n" +
            "      {\"id\": \"100-2\", \"left\": null, \"right\": null, \"value\": 100},\n" +
            "      {\"id\": \"100\", \"left\": null, \"right\": null, \"value\": 100}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED9 = 304;

    private static final String TEST_CASE10 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"-5\", \"right\": \"-3-2\", \"value\": 1},\n" +
            "      {\"id\": \"-3-2\", \"left\": \"2-2\", \"right\": \"1-7\", \"value\": -3},\n" +
            "      {\"id\": \"1-7\", \"left\": \"1-8\", \"right\": \"1-10\", \"value\": 1},\n" +
            "      {\"id\": \"1-10\", \"left\": \"-5-2\", \"right\": \"0-5\", \"value\": 1},\n" +
            "      {\"id\": \"0-5\", \"left\": null, \"right\": null, \"value\": 0},\n" +
            "      {\"id\": \"-5-2\", \"left\": null, \"right\": null, \"value\": -5},\n" +
            "      {\"id\": \"1-8\", \"left\": \"0-4\", \"right\": \"1-9\", \"value\": 1},\n" +
            "      {\"id\": \"1-9\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"0-4\", \"left\": null, \"right\": null, \"value\": 0},\n" +
            "      {\"id\": \"2-2\", \"left\": \"0-3\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"5\", \"left\": \"2-3\", \"right\": \"1-6\", \"value\": 5},\n" +
            "      {\"id\": \"1-6\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"2-3\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"0-3\", \"left\": \"-9\", \"right\": \"-91\", \"value\": 0},\n" +
            "      {\"id\": \"-91\", \"left\": null, \"right\": null, \"value\": -91},\n" +
            "      {\"id\": \"-9\", \"left\": null, \"right\": null, \"value\": -9},\n" +
            "      {\"id\": \"-5\", \"left\": \"0\", \"right\": \"2\", \"value\": -5},\n" +
            "      {\"id\": \"2\", \"left\": \"1-4\", \"right\": \"1-5\", \"value\": 2},\n" +
            "      {\"id\": \"1-5\", \"left\": \"-1-3\", \"right\": \"-100\", \"value\": 1},\n" +
            "      {\"id\": \"-100\", \"left\": null, \"right\": null, \"value\": -100},\n" +
            "      {\"id\": \"-1-3\", \"left\": null, \"right\": null, \"value\": -1},\n" +
            "      {\"id\": \"1-4\", \"left\": \"-1-2\", \"right\": \"-6\", \"value\": 1},\n" +
            "      {\"id\": \"-6\", \"left\": null, \"right\": null, \"value\": -6},\n" +
            "      {\"id\": \"-1-2\", \"left\": null, \"right\": null, \"value\": -1},\n" +
            "      {\"id\": \"0\", \"left\": \"-3\", \"right\": \"3\", \"value\": 0},\n" +
            "      {\"id\": \"3\", \"left\": \"1-3\", \"right\": \"-1\", \"value\": 3},\n" +
            "      {\"id\": \"-1\", \"left\": null, \"right\": null, \"value\": -1},\n" +
            "      {\"id\": \"1-3\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"-3\", \"left\": \"0-2\", \"right\": \"1-2\", \"value\": -3},\n" +
            "      {\"id\": \"1-2\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"0-2\", \"left\": null, \"right\": null, \"value\": 0}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED10 = 9;

    private static final String TEST_CASE11 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"-5\", \"right\": \"-3-2\", \"value\": 1},\n" +
            "      {\"id\": \"-3-2\", \"left\": \"2-2\", \"right\": \"1-6\", \"value\": -3},\n" +
            "      {\"id\": \"1-6\", \"left\": \"1-7\", \"right\": \"1-9\", \"value\": 1},\n" +
            "      {\"id\": \"1-9\", \"left\": \"-5-2\", \"right\": \"0-5\", \"value\": 1},\n" +
            "      {\"id\": \"0-5\", \"left\": null, \"right\": null, \"value\": 0},\n" +
            "      {\"id\": \"-5-2\", \"left\": null, \"right\": null, \"value\": -5},\n" +
            "      {\"id\": \"1-7\", \"left\": \"0-4\", \"right\": \"1-8\", \"value\": 1},\n" +
            "      {\"id\": \"1-8\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"0-4\", \"left\": null, \"right\": null, \"value\": 0},\n" +
            "      {\"id\": \"2-2\", \"left\": \"0-3\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"5\", \"left\": \"2-3\", \"right\": \"1-5\", \"value\": 5},\n" +
            "      {\"id\": \"1-5\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"2-3\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"0-3\", \"left\": \"-9\", \"right\": \"-91\", \"value\": 0},\n" +
            "      {\"id\": \"-91\", \"left\": null, \"right\": null, \"value\": -91},\n" +
            "      {\"id\": \"-9\", \"left\": null, \"right\": null, \"value\": -9},\n" +
            "      {\"id\": \"-5\", \"left\": \"0\", \"right\": \"2\", \"value\": -5},\n" +
            "      {\"id\": \"2\", \"left\": \"1-3\", \"right\": \"1-4\", \"value\": 2},\n" +
            "      {\"id\": \"1-4\", \"left\": \"-1-3\", \"right\": \"-100\", \"value\": 1},\n" +
            "      {\"id\": \"-100\", \"left\": null, \"right\": null, \"value\": -100},\n" +
            "      {\"id\": \"-1-3\", \"left\": null, \"right\": null, \"value\": -1},\n" +
            "      {\"id\": \"1-3\", \"left\": \"-1-2\", \"right\": \"-6\", \"value\": 1},\n" +
            "      {\"id\": \"-6\", \"left\": null, \"right\": null, \"value\": -6},\n" +
            "      {\"id\": \"-1-2\", \"left\": null, \"right\": null, \"value\": -1},\n" +
            "      {\"id\": \"0\", \"left\": \"-3\", \"right\": \"-4\", \"value\": 0},\n" +
            "      {\"id\": \"-4\", \"left\": \"10\", \"right\": \"-1\", \"value\": -4},\n" +
            "      {\"id\": \"-1\", \"left\": null, \"right\": null, \"value\": -1},\n" +
            "      {\"id\": \"10\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"-3\", \"left\": \"0-2\", \"right\": \"1-2\", \"value\": -3},\n" +
            "      {\"id\": \"1-2\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"0-2\", \"left\": null, \"right\": null, \"value\": 0}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED11 = 10;

    private static final String TEST_CASE12 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"-5\", \"right\": \"-3-2\", \"value\": 1},\n" +
            "      {\"id\": \"-3-2\", \"left\": \"2-4\", \"right\": \"1-7\", \"value\": -3},\n" +
            "      {\"id\": \"1-7\", \"left\": \"1-8\", \"right\": \"1-10\", \"value\": 1},\n" +
            "      {\"id\": \"1-10\", \"left\": \"-5-3\", \"right\": \"0-5\", \"value\": 1},\n" +
            "      {\"id\": \"0-5\", \"left\": null, \"right\": null, \"value\": 0},\n" +
            "      {\"id\": \"-5-3\", \"left\": null, \"right\": null, \"value\": -5},\n" +
            "      {\"id\": \"1-8\", \"left\": \"0-4\", \"right\": \"1-9\", \"value\": 1},\n" +
            "      {\"id\": \"1-9\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"0-4\", \"left\": null, \"right\": null, \"value\": 0},\n" +
            "      {\"id\": \"2-4\", \"left\": \"0-3\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"5\", \"left\": \"2-5\", \"right\": \"1-6\", \"value\": 5},\n" +
            "      {\"id\": \"1-6\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"2-5\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"0-3\", \"left\": \"-9\", \"right\": \"-91\", \"value\": 0},\n" +
            "      {\"id\": \"-91\", \"left\": null, \"right\": null, \"value\": -91},\n" +
            "      {\"id\": \"-9\", \"left\": null, \"right\": null, \"value\": -9},\n" +
            "      {\"id\": \"-5\", \"left\": \"0\", \"right\": \"2-3\", \"value\": -5},\n" +
            "      {\"id\": \"2-3\", \"left\": \"1-4\", \"right\": \"1-5\", \"value\": 2},\n" +
            "      {\"id\": \"1-5\", \"left\": \"-1-3\", \"right\": \"-100\", \"value\": 1},\n" +
            "      {\"id\": \"-100\", \"left\": null, \"right\": null, \"value\": -100},\n" +
            "      {\"id\": \"-1-3\", \"left\": null, \"right\": null, \"value\": -1},\n" +
            "      {\"id\": \"1-4\", \"left\": \"-1-2\", \"right\": \"-6\", \"value\": 1},\n" +
            "      {\"id\": \"-6\", \"left\": null, \"right\": null, \"value\": -6},\n" +
            "      {\"id\": \"-1-2\", \"left\": null, \"right\": null, \"value\": -1},\n" +
            "      {\"id\": \"0\", \"left\": \"-3\", \"right\": \"-4\", \"value\": 0},\n" +
            "      {\"id\": \"-4\", \"left\": \"3-2\", \"right\": \"-1\", \"value\": -4},\n" +
            "      {\"id\": \"-1\", \"left\": null, \"right\": null, \"value\": -1},\n" +
            "      {\"id\": \"3-2\", \"left\": \"7\", \"right\": \"-5-2\", \"value\": 3},\n" +
            "      {\"id\": \"-5-2\", \"left\": null, \"right\": null, \"value\": -5},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7},\n" +
            "      {\"id\": \"-3\", \"left\": \"0-2\", \"right\": \"1-3\", \"value\": -3},\n" +
            "      {\"id\": \"1-3\", \"left\": \"2\", \"right\": \"2-2\", \"value\": 1},\n" +
            "      {\"id\": \"2-2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"0-2\", \"left\": \"3\", \"right\": \"1-2\", \"value\": 0},\n" +
            "      {\"id\": \"1-2\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED12 = 10;

    private static final String TEST_CASE13 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"-5\", \"right\": \"-3-2\", \"value\": 1},\n" +
            "      {\"id\": \"-3-2\", \"left\": \"2-2\", \"right\": \"1-7\", \"value\": -3},\n" +
            "      {\"id\": \"1-7\", \"left\": \"1-8\", \"right\": \"1-10\", \"value\": 1},\n" +
            "      {\"id\": \"1-10\", \"left\": \"5-2\", \"right\": \"0-5\", \"value\": 1},\n" +
            "      {\"id\": \"0-5\", \"left\": null, \"right\": null, \"value\": 0},\n" +
            "      {\"id\": \"5-2\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"1-8\", \"left\": \"0-4\", \"right\": \"1-9\", \"value\": 1},\n" +
            "      {\"id\": \"1-9\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"0-4\", \"left\": null, \"right\": null, \"value\": 0},\n" +
            "      {\"id\": \"2-2\", \"left\": \"0-3\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"5\", \"left\": \"2-3\", \"right\": \"1-6\", \"value\": 5},\n" +
            "      {\"id\": \"1-6\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"2-3\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"0-3\", \"left\": \"-9\", \"right\": \"-91\", \"value\": 0},\n" +
            "      {\"id\": \"-91\", \"left\": null, \"right\": null, \"value\": -91},\n" +
            "      {\"id\": \"-9\", \"left\": null, \"right\": null, \"value\": -9},\n" +
            "      {\"id\": \"-5\", \"left\": \"0\", \"right\": \"2\", \"value\": -5},\n" +
            "      {\"id\": \"2\", \"left\": \"1-4\", \"right\": \"1-5\", \"value\": 2},\n" +
            "      {\"id\": \"1-5\", \"left\": \"-1-3\", \"right\": \"-100\", \"value\": 1},\n" +
            "      {\"id\": \"-100\", \"left\": null, \"right\": null, \"value\": -100},\n" +
            "      {\"id\": \"-1-3\", \"left\": null, \"right\": null, \"value\": -1},\n" +
            "      {\"id\": \"1-4\", \"left\": \"-1-2\", \"right\": \"-6\", \"value\": 1},\n" +
            "      {\"id\": \"-6\", \"left\": null, \"right\": null, \"value\": -6},\n" +
            "      {\"id\": \"-1-2\", \"left\": null, \"right\": null, \"value\": -1},\n" +
            "      {\"id\": \"0\", \"left\": \"-3\", \"right\": \"3\", \"value\": 0},\n" +
            "      {\"id\": \"3\", \"left\": \"1-3\", \"right\": \"-1\", \"value\": 3},\n" +
            "      {\"id\": \"-1\", \"left\": null, \"right\": null, \"value\": -1},\n" +
            "      {\"id\": \"1-3\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"-3\", \"left\": \"0-2\", \"right\": \"1-2\", \"value\": -3},\n" +
            "      {\"id\": \"1-2\", \"left\": null, \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"0-2\", \"left\": null, \"right\": null, \"value\": 0}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED13 = 13;

    private static final String TEST_CASE14 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"-2\", \"left\": null, \"right\": null, \"value\": -2}\n" +
            "    ],\n" +
            "    \"root\": \"-2\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED14 = -2;

    private static final String TEST_CASE15 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"-2\", \"left\": \"-1\", \"right\": null, \"value\": -2},\n" +
            "      {\"id\": \"-1\", \"left\": null, \"right\": null, \"value\": -1}\n" +
            "    ],\n" +
            "    \"root\": \"-2\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED15 = -1;

    private static final String TEST_CASE16 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"-2\", \"left\": \"-1\", \"right\": null, \"value\": -2},\n" +
            "      {\"id\": \"-1\", \"left\": \"2\", \"right\": \"3\", \"value\": -1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "    ],\n" +
            "    \"root\": \"-2\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED16 = 4;

    private static MaxPathSumInBinaryTree.BinaryTree parseTestCase(String json) {
        var object = new Gson().fromJson(json, JsonObject.class).getAsJsonObject("tree");
        var nodes = object.getAsJsonArray("nodes");

        var map = new HashMap<String, MaxPathSumInBinaryTree.BinaryTree>();
        for (var element : nodes) {
            var item = element.getAsJsonObject();
            var id = item.get("id").getAsString();
            var value = item.get("value").getAsInt();
            map.put(id, new MaxPathSumInBinaryTree.BinaryTree(value));
        }
        for (var element : nodes) {
            var item = element.getAsJsonObject();
            var id = item.get("id").getAsString();
            var left = item.get("left");
            var right = item.get("right");
            var treeItem = map.get(id);
            if (!left.isJsonNull()) {
                treeItem.left = map.get(left.getAsString());
            }
            if (!right.isJsonNull()) {
                treeItem.right = map.get(right.getAsString());
            }
        }
        var root = object.get("root").getAsString();
        return map.get(root);
    }

    private static void internalTestCase(MaxPathSumInBinaryTree solution, String json, int expected) {
        var tree = parseTestCase(json);
        var result = solution.maxPathSum(tree);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution1(String json, int expected) {
        internalTestCase(new MaxPathSumInBinaryTree.Solution1(), json, expected);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(TEST_CASE1, EXPECTED1),
                Arguments.of(TEST_CASE2, EXPECTED2),
                Arguments.of(TEST_CASE3, EXPECTED3),
                Arguments.of(TEST_CASE4, EXPECTED4),
                Arguments.of(TEST_CASE5, EXPECTED5),
                Arguments.of(TEST_CASE6, EXPECTED6),
                Arguments.of(TEST_CASE7, EXPECTED7),
                Arguments.of(TEST_CASE8, EXPECTED8),
                Arguments.of(TEST_CASE9, EXPECTED9),
                Arguments.of(TEST_CASE10, EXPECTED10),
                Arguments.of(TEST_CASE11, EXPECTED11),
                Arguments.of(TEST_CASE12, EXPECTED12),
                Arguments.of(TEST_CASE13, EXPECTED13),
                Arguments.of(TEST_CASE14, EXPECTED14),
                Arguments.of(TEST_CASE15, EXPECTED15),
                Arguments.of(TEST_CASE16, EXPECTED16)
        );
    }
}
