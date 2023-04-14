package com.algo.expert.binarytrees;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;

public class SplitBinaryTreeTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 0}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED1 = 0;

    private static final String TEST_CASE2 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED2 = 0;

    private static final String TEST_CASE3 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED3 = 0;

    private static final String TEST_CASE4 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": null, \"value\": -2}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED4 = 0;

    private static final String TEST_CASE5 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 2},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED5 = 2;

    private static final String TEST_CASE6 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED6 = 1;

    private static final String TEST_CASE7 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED7 = 3;

    private static final String TEST_CASE8 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"4\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED8 = 0;

    private static final String TEST_CASE9 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 1},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 1}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED9 = 0;

    private static final String TEST_CASE10 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 1},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED10 = 3;

    private static final String TEST_CASE11 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 2}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED11 = 6;

    private static final String TEST_CASE12 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"5\", \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 10},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 6}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED12 = 13;

    private static final String TEST_CASE13 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"5\", \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 6}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED13 = 12;

    private static final String TEST_CASE14 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"5\", \"right\": null, \"value\": 6},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 6}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED14 = 0;

    private static final String TEST_CASE15 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"2\", \"right\": \"3\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": \"4\", \"right\": \"5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": \"7\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": null, \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED15 = 11;

    private static final String TEST_CASE16 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"9\", \"right\": \"2\", \"value\": 1},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "      {\"id\": \"2\", \"left\": \"15\", \"right\": \"10\", \"value\": 2},\n" +
            "      {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15},\n" +
            "      {\"id\": \"10\", \"left\": \"100\", \"right\": \"200\", \"value\": 10},\n" +
            "      {\"id\": \"100\", \"left\": null, \"right\": null, \"value\": 100},\n" +
            "      {\"id\": \"200\", \"left\": null, \"right\": null, \"value\": 200}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED16 = 0;

    private static final String TEST_CASE17 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"9\", \"right\": \"20\", \"value\": 1},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "      {\"id\": \"20\", \"left\": \"30\", \"right\": \"10\", \"value\": 20},\n" +
            "      {\"id\": \"30\", \"left\": null, \"right\": null, \"value\": 30},\n" +
            "      {\"id\": \"10\", \"left\": \"35\", \"right\": \"15\", \"value\": 10},\n" +
            "      {\"id\": \"35\", \"left\": null, \"right\": null, \"value\": 35},\n" +
            "      {\"id\": \"15\", \"left\": null, \"right\": null, \"value\": 15}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED17 = 60;

    private static final String TEST_CASE18 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"9\", \"right\": \"20\", \"value\": 1},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9},\n" +
            "      {\"id\": \"20\", \"left\": \"30\", \"right\": \"10\", \"value\": 20},\n" +
            "      {\"id\": \"30\", \"left\": null, \"right\": null, \"value\": 30},\n" +
            "      {\"id\": \"10\", \"left\": \"35\", \"right\": \"25\", \"value\": 10},\n" +
            "      {\"id\": \"35\", \"left\": null, \"right\": null, \"value\": 35},\n" +
            "      {\"id\": \"25\", \"left\": null, \"right\": null, \"value\": 25}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED18 = 0;

    private static final String TEST_CASE19 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"9\", \"right\": \"20\", \"value\": 1},\n" +
            "      {\"id\": \"9\", \"left\": \"5\", \"right\": \"2\", \"value\": 9},\n" +
            "      {\"id\": \"20\", \"left\": \"30\", \"right\": \"10\", \"value\": 20},\n" +
            "      {\"id\": \"30\", \"left\": null, \"right\": null, \"value\": 30},\n" +
            "      {\"id\": \"10\", \"left\": \"35\", \"right\": \"25\", \"value\": 10},\n" +
            "      {\"id\": \"35\", \"left\": null, \"right\": null, \"value\": 35},\n" +
            "      {\"id\": \"25\", \"left\": null, \"right\": null, \"value\": 25},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"2\", \"left\": \"3\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED19 = 70;

    private static final String TEST_CASE20 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"9\", \"right\": \"20\", \"value\": 1},\n" +
            "      {\"id\": \"9\", \"left\": \"5\", \"right\": \"2\", \"value\": 9},\n" +
            "      {\"id\": \"20\", \"left\": \"30\", \"right\": \"10\", \"value\": 20},\n" +
            "      {\"id\": \"30\", \"left\": null, \"right\": null, \"value\": 30},\n" +
            "      {\"id\": \"10\", \"left\": \"35\", \"right\": \"25\", \"value\": 10},\n" +
            "      {\"id\": \"35\", \"left\": \"3\", \"right\": null, \"value\": 35},\n" +
            "      {\"id\": \"25\", \"left\": null, \"right\": null, \"value\": 25},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED20 = 0;

    private static final String TEST_CASE21 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"9\", \"right\": \"20\", \"value\": 1},\n" +
            "      {\"id\": \"9\", \"left\": \"5\", \"right\": \"2\", \"value\": 9},\n" +
            "      {\"id\": \"20\", \"left\": \"30\", \"right\": \"10\", \"value\": 20},\n" +
            "      {\"id\": \"30\", \"left\": null, \"right\": null, \"value\": 30},\n" +
            "      {\"id\": \"10\", \"left\": \"35\", \"right\": \"25\", \"value\": 10},\n" +
            "      {\"id\": \"35\", \"left\": null, \"right\": null, \"value\": 35},\n" +
            "      {\"id\": \"25\", \"left\": null, \"right\": null, \"value\": 25},\n" +
            "      {\"id\": \"5\", \"left\": \"102\", \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"2\", \"left\": \"3\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"102\", \"left\": null, \"right\": null, \"value\": 102}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED21 = 121;

    private static final String TEST_CASE22 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"20\", \"right\": \"9\", \"value\": 1},\n" +
            "      {\"id\": \"9\", \"left\": \"5\", \"right\": \"2\", \"value\": 9},\n" +
            "      {\"id\": \"20\", \"left\": \"30\", \"right\": \"10\", \"value\": 20},\n" +
            "      {\"id\": \"30\", \"left\": null, \"right\": null, \"value\": 30},\n" +
            "      {\"id\": \"10\", \"left\": \"35\", \"right\": \"25\", \"value\": 10},\n" +
            "      {\"id\": \"35\", \"left\": null, \"right\": null, \"value\": 35},\n" +
            "      {\"id\": \"25\", \"left\": null, \"right\": null, \"value\": 25},\n" +
            "      {\"id\": \"5\", \"left\": \"102\", \"right\": null, \"value\": 5},\n" +
            "      {\"id\": \"2\", \"left\": \"3\", \"right\": null, \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"102\", \"left\": null, \"right\": null, \"value\": 102}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED22 = 121;

    private static final String TEST_CASE23 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": \"5\", \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": \"7\", \"value\": 6},\n" +
            "      {\"id\": \"7\", \"left\": null, \"right\": null, \"value\": 7}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED23 = 0;

    private static final String TEST_CASE24 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": \"4\", \"value\": 3},\n" +
            "      {\"id\": \"4\", \"left\": null, \"right\": \"5\", \"value\": 4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": \"9\", \"value\": 6},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED24 = 15;

    private static final String TEST_CASE25 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"-2\", \"left\": null, \"right\": \"-2-2\", \"value\": -2},\n" +
            "      {\"id\": \"-2-2\", \"left\": null, \"right\": null, \"value\": -2}\n" +
            "    ],\n" +
            "    \"root\": \"-2\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED25 = -2;

    private static final String TEST_CASE26 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"-2\", \"left\": null, \"right\": \"0\", \"value\": -2},\n" +
            "      {\"id\": \"0\", \"left\": null, \"right\": null, \"value\": 0}\n" +
            "    ],\n" +
            "    \"root\": \"-2\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED26 = 0;

    private static final String TEST_CASE27 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"3\", \"right\": \"2\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": \"-5\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": \"12\", \"right\": null, \"value\": 1},\n" +
            "      {\"id\": \"12\", \"left\": null, \"right\": \"-21\", \"value\": 12},\n" +
            "      {\"id\": \"-21\", \"left\": null, \"right\": null, \"value\": -21},\n" +
            "      {\"id\": \"-5\", \"left\": null, \"right\": null, \"value\": -5}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED27 = -5;

    private static final String TEST_CASE28 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": \"-4\", \"value\": 3},\n" +
            "      {\"id\": \"-4\", \"left\": null, \"right\": \"5\", \"value\": -4},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": \"9\", \"value\": 6},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": null, \"value\": 9}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED28 = 0;

    private static final String TEST_CASE29 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": null, \"right\": \"2\", \"value\": 1},\n" +
            "      {\"id\": \"2\", \"left\": null, \"right\": \"3\", \"value\": 2},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": \"-4\", \"value\": 3},\n" +
            "      {\"id\": \"-4\", \"left\": null, \"right\": \"9\", \"value\": -4},\n" +
            "      {\"id\": \"9\", \"left\": null, \"right\": \"5\", \"value\": 9},\n" +
            "      {\"id\": \"5\", \"left\": null, \"right\": \"6\", \"value\": 5},\n" +
            "      {\"id\": \"6\", \"left\": null, \"right\": null, \"value\": 6}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED29 = 11;

    private static final String TEST_CASE30 = "{\n" +
            "  \"tree\": {\n" +
            "    \"nodes\": [\n" +
            "      {\"id\": \"1\", \"left\": \"-20\", \"right\": \"9\", \"value\": 1},\n" +
            "      {\"id\": \"9\", \"left\": \"-13\", \"right\": \"4\", \"value\": 9},\n" +
            "      {\"id\": \"-20\", \"left\": \"-30\", \"right\": \"17\", \"value\": -20},\n" +
            "      {\"id\": \"-30\", \"left\": \"8\", \"right\": null, \"value\": -30},\n" +
            "      {\"id\": \"17\", \"left\": \"-26\", \"right\": \"-17\", \"value\": 17},\n" +
            "      {\"id\": \"-26\", \"left\": \"19\", \"right\": null, \"value\": -26},\n" +
            "      {\"id\": \"-17\", \"left\": null, \"right\": null, \"value\": -17},\n" +
            "      {\"id\": \"-13\", \"left\": \"42\", \"right\": null, \"value\": -13},\n" +
            "      {\"id\": \"4\", \"left\": \"3\", \"right\": \"-11\", \"value\": 4},\n" +
            "      {\"id\": \"3\", \"left\": null, \"right\": null, \"value\": 3},\n" +
            "      {\"id\": \"42\", \"left\": null, \"right\": null, \"value\": 42},\n" +
            "      {\"id\": \"19\", \"left\": null, \"right\": null, \"value\": 19},\n" +
            "      {\"id\": \"8\", \"left\": null, \"right\": null, \"value\": 8},\n" +
            "      {\"id\": \"-11\", \"left\": null, \"right\": null, \"value\": -11}\n" +
            "    ],\n" +
            "    \"root\": \"1\"\n" +
            "  }\n" +
            "}";
    private static final int EXPECTED30 = -7;

    private static SplitBinaryTree.BinaryTree parseTree(String json) {
        var object = new Gson().fromJson(json, JsonObject.class).getAsJsonObject("tree");
        var nodes = object.getAsJsonArray("nodes");

        var map = new HashMap<String, SplitBinaryTree.BinaryTree>();
        for (var element : nodes) {
            var item = element.getAsJsonObject();
            var id = item.get("id").getAsString();
            var value = item.get("value").getAsInt();
            map.put(id, new SplitBinaryTree.BinaryTree(value));
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

    static List<Arguments> params() {
        return List.of(
                Arguments.of(parseTree(TEST_CASE1), EXPECTED1),
                Arguments.of(parseTree(TEST_CASE2), EXPECTED2),
                Arguments.of(parseTree(TEST_CASE3), EXPECTED3),
                Arguments.of(parseTree(TEST_CASE4), EXPECTED4),
                Arguments.of(parseTree(TEST_CASE5), EXPECTED5),
                Arguments.of(parseTree(TEST_CASE6), EXPECTED6),
                Arguments.of(parseTree(TEST_CASE7), EXPECTED7),
                Arguments.of(parseTree(TEST_CASE8), EXPECTED8),
                Arguments.of(parseTree(TEST_CASE9), EXPECTED9),
                Arguments.of(parseTree(TEST_CASE10), EXPECTED10),
                Arguments.of(parseTree(TEST_CASE11), EXPECTED11),
                Arguments.of(parseTree(TEST_CASE12), EXPECTED12),
                Arguments.of(parseTree(TEST_CASE13), EXPECTED13),
                Arguments.of(parseTree(TEST_CASE14), EXPECTED14),
                Arguments.of(parseTree(TEST_CASE15), EXPECTED15),
                Arguments.of(parseTree(TEST_CASE16), EXPECTED16),
                Arguments.of(parseTree(TEST_CASE17), EXPECTED17),
                Arguments.of(parseTree(TEST_CASE18), EXPECTED18),
                Arguments.of(parseTree(TEST_CASE19), EXPECTED19),
                Arguments.of(parseTree(TEST_CASE20), EXPECTED20),
                Arguments.of(parseTree(TEST_CASE21), EXPECTED21),
                Arguments.of(parseTree(TEST_CASE22), EXPECTED22),
                Arguments.of(parseTree(TEST_CASE23), EXPECTED23),
                Arguments.of(parseTree(TEST_CASE24), EXPECTED24),
                Arguments.of(parseTree(TEST_CASE25), EXPECTED25),
                Arguments.of(parseTree(TEST_CASE26), EXPECTED26),
                Arguments.of(parseTree(TEST_CASE27), EXPECTED27),
                Arguments.of(parseTree(TEST_CASE28), EXPECTED28),
                Arguments.of(parseTree(TEST_CASE29), EXPECTED29),
                Arguments.of(parseTree(TEST_CASE30), EXPECTED30)
        );
    }

    private static void internalTestCase(SplitBinaryTree solution, SplitBinaryTree.BinaryTree tree, int expected) {
        int result = solution.splitBinaryTree(tree);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution1(SplitBinaryTree.BinaryTree tree, int expected) {
        internalTestCase(new SplitBinaryTree.Solution1(), tree, expected);
    }
}
