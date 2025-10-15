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
    private static final String TEST_CASE2 = """
            {
              "tree": {
                "nodes": [
                  {"id": "1", "left": null, "right": null, "value": 1}
                ],
                "root": "1"
              },
              "expected": 0
            }
            """;
    private static final String TEST_CASE3 = """
            {
              "tree": {
                "nodes": [
                  {"id": "2", "left": "3", "right": "1", "value": 2},
                  {"id": "1", "left": null, "right": null, "value": 1},
                  {"id": "3", "left": null, "right": null, "value": 3}
                ],
                "root": "2"
              },
              "expected": 0
            }
            """;
    private static final String TEST_CASE4 = """
            {
              "tree": {
                "nodes": [
                  {"id": "10", "left": "5", "right": null, "value": 10},
                  {"id": "5", "left": "1", "right": null, "value": 5},
                  {"id": "1", "left": null, "right": null, "value": 1}
                ],
                "root": "10"
              },
              "expected": 16
            }
            """;
    private static final String TEST_CASE5 = """
            {
              "tree": {
                "nodes": [
                  {"id": "1", "left": null, "right": "5", "value": 1},
                  {"id": "5", "left": null, "right": "10", "value": 5},
                  {"id": "10", "left": null, "right": null, "value": 10}
                ],
                "root": "1"
              },
              "expected": 16
            }
            """;
    private static final String TEST_CASE6 = """
            {
              "tree": {
                "nodes": [
                  {"id": "1", "left": null, "right": "5", "value": 1},
                  {"id": "5", "left": null, "right": "10", "value": 5},
                  {"id": "10", "left": null, "right": "15", "value": 10},
                  {"id": "15", "left": null, "right": null, "value": 15}
                ],
                "root": "1"
              },
              "expected": 31
            }
            """;
    private static final String TEST_CASE7 = """
            {
              "tree": {
                "nodes": [
                  {"id": "20", "left": "7", "right": "10", "value": 20},
                  {"id": "10", "left": "5", "right": "15", "value": 10},
                  {"id": "15", "left": "13", "right": "22", "value": 15},
                  {"id": "22", "left": null, "right": null, "value": 22},
                  {"id": "13", "left": null, "right": "14", "value": 13},
                  {"id": "14", "left": null, "right": null, "value": 14},
                  {"id": "7", "left": "3", "right": "8", "value": 7},
                  {"id": "8", "left": "7-2", "right": "9", "value": 8},
                  {"id": "9", "left": null, "right": null, "value": 9},
                  {"id": "7-2", "left": null, "right": null, "value": 7},
                  {"id": "3", "left": null, "right": null, "value": 3},
                  {"id": "5", "left": "2", "right": "5-2", "value": 5},
                  {"id": "5-2", "left": null, "right": null, "value": 5},
                  {"id": "2", "left": "1", "right": null, "value": 2},
                  {"id": "1", "left": null, "right": null, "value": 1}
                ],
                "root": "20"
              },
              "expected": 121
            }
            """;
    private static final String TEST_CASE8 = """
            {
              "tree": {
                "nodes": [
                  {"id": "8", "left": "2", "right": null, "value": 8},
                  {"id": "2", "left": "1", "right": "-5", "value": 2},
                  {"id": "1", "left": null, "right": null, "value": 1},
                  {"id": "-5", "left": null, "right": null, "value": -5}
                ],
                "root": "8"
              },
              "expected": 0
            }
            """;
    private static final String TEST_CASE9 = """
            {
              "tree": {
                "nodes": [
                  {"id": "3", "left": "8", "right": "2", "value": 3},
                  {"id": "8", "left": "2-2", "right": "9", "value": 8},
                  {"id": "2", "left": "1", "right": "4", "value": 2},
                  {"id": "2-2", "left": "1-1", "right": null, "value": 2},
                  {"id": "9", "left": null, "right": null, "value": 9},
                  {"id": "1", "left": null, "right": null, "value": 1},
                  {"id": "4", "left": null, "right": null, "value": 4},
                  {"id": "1-1", "left": "-1", "right": null, "value": 1},
                  {"id": "-1", "left": "-5", "right": "20", "value": -1},
                  {"id": "-5", "left": null, "right": null, "value": -5},
                  {"id": "20", "left": null, "right": null, "value": 20}
                ],
                "root": "3"
              },
              "expected": 21
            }
            """;
    private static final String TEST_CASE10 = """
            {
              "tree": {
                "nodes": [
                  {"id": "3", "left": "8", "right": "2", "value": 3},
                  {"id": "8", "left": "2-2", "right": "9", "value": 8},
                  {"id": "2", "left": "1", "right": "4", "value": 2},
                  {"id": "2-2", "left": "1-1", "right": null, "value": 2},
                  {"id": "9", "left": null, "right": null, "value": 9},
                  {"id": "1", "left": null, "right": null, "value": 1},
                  {"id": "4", "left": null, "right": null, "value": 4},
                  {"id": "1-1", "left": "-1", "right": null, "value": 1},
                  {"id": "-1", "left": "-5", "right": "-4", "value": -1},
                  {"id": "-5", "left": null, "right": null, "value": -5},
                  {"id": "-4", "left": null, "right": null, "value": -4}
                ],
                "root": "3"
              },
              "expected": 7
            }
            """;
    private static final String TEST_CASE11 = """
            {
              "tree": {
                "nodes": [
                  {"id": "3", "left": "8", "right": "2", "value": 3},
                  {"id": "8", "left": "2-2", "right": "9", "value": 8},
                  {"id": "2", "left": "1", "right": "4", "value": 2},
                  {"id": "2-2", "left": "15", "right": null, "value": 2},
                  {"id": "9", "left": null, "right": null, "value": 9},
                  {"id": "1", "left": null, "right": null, "value": 1},
                  {"id": "4", "left": null, "right": null, "value": 4},
                  {"id": "15", "left": "18", "right": null, "value": 15},
                  {"id": "18", "left": "16", "right": "20", "value": 18},
                  {"id": "16", "left": null, "right": null, "value": 16},
                  {"id": "20", "left": null, "right": null, "value": 20}
                ],
                "root": "3"
              },
              "expected": 61
            }
            """;
    private static final String TEST_CASE12 = """
            {
              "tree": {
                "nodes": [
                  {"id": "3", "left": "8", "right": "2", "value": 3},
                  {"id": "8", "left": "2-2", "right": "9", "value": 8},
                  {"id": "2", "left": "1", "right": "4", "value": 2},
                  {"id": "2-2", "left": "-2", "right": "30", "value": 2},
                  {"id": "9", "left": null, "right": null, "value": 9},
                  {"id": "1", "left": null, "right": null, "value": 1},
                  {"id": "4", "left": null, "right": null, "value": 4},
                  {"id": "-2", "left": "18", "right": null, "value": -2},
                  {"id": "18", "left": "16", "right": "20", "value": 18},
                  {"id": "16", "left": null, "right": null, "value": 16},
                  {"id": "20", "left": null, "right": null, "value": 20},
                  {"id": "30", "left": null, "right": null, "value": 30}
                ],
                "root": "3"
              },
              "expected": 61
            }
            """;
    private static final String TEST_CASE13 = """
            {
              "tree": {
                "nodes": [
                  {"id": "3", "left": "8", "right": "2", "value": 3},
                  {"id": "8", "left": "2-2", "right": null, "value": 8},
                  {"id": "2", "left": "1", "right": "4", "value": 2},
                  {"id": "2-2", "left": "-2", "right": "30", "value": 2},
                  {"id": "1", "left": null, "right": null, "value": 1},
                  {"id": "4", "left": null, "right": null, "value": 4},
                  {"id": "-2", "left": "18", "right": null, "value": -2},
                  {"id": "18", "left": "16", "right": "20", "value": 18},
                  {"id": "16", "left": null, "right": null, "value": 16},
                  {"id": "20", "left": null, "right": null, "value": 20},
                  {"id": "30", "left": null, "right": null, "value": 30}
                ],
                "root": "3"
              },
              "expected": 61
            }
            """;
    private static final String TEST_CASE14 = """
            {
              "tree": {
                "nodes": [
                  {"id": "3", "left": "8", "right": "2", "value": 3},
                  {"id": "8", "left": "2-2", "right": "7", "value": 8},
                  {"id": "2", "left": "1", "right": "4", "value": 2},
                  {"id": "2-2", "left": "-2", "right": "30", "value": 2},
                  {"id": "7", "left": null, "right": null, "value": 7},
                  {"id": "1", "left": null, "right": null, "value": 1},
                  {"id": "4", "left": null, "right": null, "value": 4},
                  {"id": "-2", "left": "18", "right": null, "value": -2},
                  {"id": "18", "left": "16", "right": "20", "value": 18},
                  {"id": "16", "left": null, "right": null, "value": 16},
                  {"id": "20", "left": null, "right": null, "value": 20},
                  {"id": "30", "left": null, "right": null, "value": 30}
                ],
                "root": "3"
              },
              "expected": 61
            }
            """;
    private static final String TEST_CASE15 = """
            {
              "tree": {
                "nodes": [
                  {"id": "8", "left": "2", "right": "9", "value": 8},
                  {"id": "2", "left": "1", "right": "10", "value": 2},
                  {"id": "1", "left": null, "right": null, "value": 1},
                  {"id": "10", "left": null, "right": null, "value": 10},
                  {"id": "9", "left": null, "right": null, "value": 9}
                ],
                "root": "8"
              },
              "expected": 13
            }
            """;
    private static final String TEST_CASE16 = """
            {
              "tree": {
                "nodes": [
                  {"id": "8", "left": "2", "right": "9", "value": 8},
                  {"id": "2", "left": "1", "right": "-5", "value": 2},
                  {"id": "1", "left": null, "right": null, "value": 1},
                  {"id": "-5", "left": null, "right": null, "value": -5},
                  {"id": "9", "left": null, "right": "12", "value": 9},
                  {"id": "12", "left": null, "right": null, "value": 12}
                ],
                "root": "8"
              },
              "expected": 0
            }
            """;
    private static final String TEST_CASE17 = """
            {
              "tree": {
                "nodes": [
                  {"id": "1", "left": "-7", "right": "10", "value": 1},
                  {"id": "10", "left": "5", "right": "15", "value": 10},
                  {"id": "15", "left": "13", "right": "22", "value": 15},
                  {"id": "22", "left": null, "right": null, "value": 22},
                  {"id": "13", "left": null, "right": "14", "value": 13},
                  {"id": "14", "left": null, "right": null, "value": 14},
                  {"id": "-7", "left": "-8", "right": "0", "value": -7},
                  {"id": "-8", "left": "-9", "right": null, "value": -8},
                  {"id": "-9", "left": null, "right": null, "value": -9},
                  {"id": "0", "left": "-7-2", "right": "0-2", "value": 0},
                  {"id": "-7-2", "left": null, "right": null, "value": -7},
                  {"id": "0-2", "left": null, "right": null, "value": 0},
                  {"id": "5", "left": "2", "right": "5-2", "value": 5},
                  {"id": "5-2", "left": null, "right": null, "value": 5},
                  {"id": "2", "left": "1-2", "right": null, "value": 2},
                  {"id": "1-2", "left": null, "right": null, "value": 1}
                ],
                "root": "1"
              },
              "expected": 57
            }
            """;
    private static final String TEST_CASE18 = """
            {
              "tree": {
                "nodes": [
                  {"id": "1", "left": "-7", "right": "10", "value": 1},
                  {"id": "10", "left": "5", "right": "15", "value": 10},
                  {"id": "15", "left": "13", "right": "22", "value": 15},
                  {"id": "22", "left": null, "right": null, "value": 22},
                  {"id": "13", "left": null, "right": "14", "value": 13},
                  {"id": "14", "left": null, "right": null, "value": 14},
                  {"id": "-7", "left": "-8", "right": "0", "value": -7},
                  {"id": "-8", "left": "-9", "right": null, "value": -8},
                  {"id": "-9", "left": null, "right": null, "value": -9},
                  {"id": "0", "left": "-7-2", "right": "0-2", "value": 0},
                  {"id": "-7-2", "left": null, "right": null, "value": -7},
                  {"id": "0-2", "left": null, "right": null, "value": 0},
                  {"id": "5", "left": "6", "right": "5-2", "value": 5},
                  {"id": "5-2", "left": null, "right": null, "value": 5},
                  {"id": "6", "left": "1-2", "right": null, "value": 6},
                  {"id": "1-2", "left": null, "right": null, "value": 1}
                ],
                "root": "1"
              },
              "expected": 33
            }
            """;
    private static final String TEST_CASE19 = """
            {
              "tree": {
                "nodes": [
                  {"id": "1", "left": "3", "right": "10", "value": 1},
                  {"id": "10", "left": "5", "right": "15", "value": 10},
                  {"id": "15", "left": "13", "right": "22", "value": 15},
                  {"id": "22", "left": null, "right": null, "value": 22},
                  {"id": "13", "left": null, "right": "14", "value": 13},
                  {"id": "14", "left": null, "right": null, "value": 14},
                  {"id": "3", "left": "-8", "right": "0", "value": 3},
                  {"id": "-8", "left": "-9", "right": null, "value": -8},
                  {"id": "-9", "left": null, "right": null, "value": -9},
                  {"id": "0", "left": "-7", "right": "0-2", "value": 0},
                  {"id": "-7", "left": null, "right": null, "value": -7},
                  {"id": "0-2", "left": null, "right": null, "value": 0},
                  {"id": "5", "left": "6", "right": "5-2", "value": 5},
                  {"id": "5-2", "left": null, "right": null, "value": 5},
                  {"id": "6", "left": "1-2", "right": null, "value": 6},
                  {"id": "1-2", "left": null, "right": null, "value": 1}
                ],
                "root": "1"
              },
              "expected": 57
            }
            """;
    private static final String TEST_CASE20 = """
            {
              "tree": {
                "nodes": [
                  {"id": "1", "left": "3", "right": "10", "value": 1},
                  {"id": "10", "left": "5", "right": "23", "value": 10},
                  {"id": "23", "left": "13", "right": "22", "value": 23},
                  {"id": "22", "left": null, "right": null, "value": 22},
                  {"id": "13", "left": null, "right": "14", "value": 13},
                  {"id": "14", "left": null, "right": null, "value": 14},
                  {"id": "3", "left": "-8", "right": "0", "value": 3},
                  {"id": "-8", "left": "-9", "right": null, "value": -8},
                  {"id": "-9", "left": null, "right": null, "value": -9},
                  {"id": "0", "left": "-7", "right": "0-2", "value": 0},
                  {"id": "-7", "left": null, "right": null, "value": -7},
                  {"id": "0-2", "left": null, "right": null, "value": 0},
                  {"id": "5", "left": "6", "right": "5-2", "value": 5},
                  {"id": "5-2", "left": null, "right": null, "value": 5},
                  {"id": "6", "left": "1-2", "right": null, "value": 6},
                  {"id": "1-2", "left": null, "right": null, "value": 1}
                ],
                "root": "1"
              },
              "expected": -7
            }
            """;
    private static final String TEST_CASE21 = """
            {
              "tree": {
                "nodes": [
                  {"id": "1", "left": "3", "right": "10", "value": 1},
                  {"id": "10", "left": "5", "right": "23", "value": 10},
                  {"id": "23", "left": "13", "right": "22", "value": 23},
                  {"id": "22", "left": null, "right": null, "value": 22},
                  {"id": "13", "left": null, "right": "14", "value": 13},
                  {"id": "14", "left": null, "right": null, "value": 14},
                  {"id": "3", "left": "-8", "right": "0", "value": 3},
                  {"id": "-8", "left": "-9", "right": null, "value": -8},
                  {"id": "-9", "left": null, "right": null, "value": -9},
                  {"id": "0", "left": "-7", "right": "-5", "value": 0},
                  {"id": "-7", "left": null, "right": null, "value": -7},
                  {"id": "-5", "left": null, "right": null, "value": -5},
                  {"id": "5", "left": "6", "right": "5-2", "value": 5},
                  {"id": "5-2", "left": null, "right": null, "value": 5},
                  {"id": "6", "left": "1-2", "right": null, "value": 6},
                  {"id": "1-2", "left": null, "right": null, "value": 1}
                ],
                "root": "1"
              },
              "expected": 0
            }
            """;
    private static final String TEST_CASE22 = """
            {
              "tree": {
                "nodes": [
                  {"id": "1", "left": "3", "right": "10", "value": 1},
                  {"id": "10", "left": "5", "right": "23", "value": 10},
                  {"id": "23", "left": "19", "right": "22", "value": 23},
                  {"id": "22", "left": null, "right": null, "value": 22},
                  {"id": "19", "left": null, "right": "14", "value": 19},
                  {"id": "14", "left": null, "right": null, "value": 14},
                  {"id": "3", "left": "-8", "right": "0", "value": 3},
                  {"id": "-8", "left": "-3", "right": null, "value": -8},
                  {"id": "-3", "left": null, "right": null, "value": -3},
                  {"id": "0", "left": "-7", "right": "-5", "value": 0},
                  {"id": "-7", "left": null, "right": null, "value": -7},
                  {"id": "-5", "left": null, "right": null, "value": -5},
                  {"id": "5", "left": "6", "right": "5-2", "value": 5},
                  {"id": "5-2", "left": null, "right": null, "value": 5},
                  {"id": "6", "left": "99", "right": null, "value": 6},
                  {"id": "99", "left": null, "right": null, "value": 99}
                ],
                "root": "1"
              },
              "expected": 0
            }
            """;
    private static final String TEST_CASE23 = """
            {
              "tree": {
                "nodes": [
                  {"id": "100", "left": "1", "right": null, "value": 100},
                  {"id": "1", "left": "-7", "right": "10", "value": 1},
                  {"id": "10", "left": "5", "right": "15", "value": 10},
                  {"id": "15", "left": "13", "right": "22", "value": 15},
                  {"id": "22", "left": null, "right": null, "value": 22},
                  {"id": "13", "left": null, "right": "14", "value": 13},
                  {"id": "14", "left": null, "right": null, "value": 14},
                  {"id": "-7", "left": "-8", "right": "0", "value": -7},
                  {"id": "-8", "left": "-9", "right": null, "value": -8},
                  {"id": "-9", "left": null, "right": null, "value": -9},
                  {"id": "0", "left": "-7-2", "right": "0-2", "value": 0},
                  {"id": "-7-2", "left": null, "right": null, "value": -7},
                  {"id": "0-2", "left": null, "right": null, "value": 0},
                  {"id": "5", "left": "2", "right": "5-2", "value": 5},
                  {"id": "5-2", "left": null, "right": null, "value": 5},
                  {"id": "2", "left": "1-2", "right": null, "value": 2},
                  {"id": "1-2", "left": null, "right": null, "value": 1}
                ],
                "root": "100"
              },
              "expected": 157
            }
            """;
    private static final String TEST_CASE24 = """
            {
              "tree": {
                "nodes": [
                  {"id": "-100", "left": "1", "right": null, "value": -100},
                  {"id": "1", "left": "-7", "right": "10", "value": 1},
                  {"id": "10", "left": "5", "right": "15", "value": 10},
                  {"id": "15", "left": "13", "right": "22", "value": 15},
                  {"id": "22", "left": null, "right": null, "value": 22},
                  {"id": "13", "left": null, "right": "14", "value": 13},
                  {"id": "14", "left": null, "right": null, "value": 14},
                  {"id": "-7", "left": "-8", "right": "0", "value": -7},
                  {"id": "-8", "left": "-9", "right": null, "value": -8},
                  {"id": "-9", "left": null, "right": null, "value": -9},
                  {"id": "0", "left": "-7-2", "right": "0-2", "value": 0},
                  {"id": "-7-2", "left": null, "right": null, "value": -7},
                  {"id": "0-2", "left": null, "right": null, "value": 0},
                  {"id": "5", "left": "2", "right": "5-2", "value": 5},
                  {"id": "5-2", "left": null, "right": null, "value": 5},
                  {"id": "2", "left": "1-2", "right": null, "value": 2},
                  {"id": "1-2", "left": null, "right": null, "value": 1}
                ],
                "root": "-100"
              },
              "expected": 57
            }
            """;
    private static final String TEST_CASE25 = """
            {
              "tree": {
                "nodes": [
                  {"id": "-100", "left": null, "right": "1", "value": -100},
                  {"id": "1", "left": "-7", "right": "10", "value": 1},
                  {"id": "10", "left": "5", "right": "15", "value": 10},
                  {"id": "15", "left": "13", "right": "22", "value": 15},
                  {"id": "22", "left": null, "right": null, "value": 22},
                  {"id": "13", "left": null, "right": "14", "value": 13},
                  {"id": "14", "left": null, "right": null, "value": 14},
                  {"id": "-7", "left": "-8", "right": "0", "value": -7},
                  {"id": "-8", "left": "-9", "right": null, "value": -8},
                  {"id": "-9", "left": null, "right": null, "value": -9},
                  {"id": "0", "left": "-7-2", "right": "0-2", "value": 0},
                  {"id": "-7-2", "left": null, "right": null, "value": -7},
                  {"id": "0-2", "left": null, "right": null, "value": 0},
                  {"id": "5", "left": "2", "right": "5-2", "value": 5},
                  {"id": "5-2", "left": null, "right": null, "value": 5},
                  {"id": "2", "left": "1-2", "right": null, "value": 2},
                  {"id": "1-2", "left": null, "right": null, "value": 1}
                ],
                "root": "-100"
              },
              "expected": -43
            }
            """;
    private static final String TEST_CASE26 = """
            {
              "tree": {
                "nodes": [
                  {"id": "-100", "left": null, "right": "-99", "value": -100},
                  {"id": "-99", "left": null, "right": "-98", "value": -99},
                  {"id": "-98", "left": null, "right": "-97", "value": -98},
                  {"id": "-97", "left": null, "right": "1", "value": -97},
                  {"id": "1", "left": "-7", "right": "10", "value": 1},
                  {"id": "10", "left": "5", "right": "15", "value": 10},
                  {"id": "15", "left": "13", "right": "22", "value": 15},
                  {"id": "22", "left": null, "right": null, "value": 22},
                  {"id": "13", "left": null, "right": "14", "value": 13},
                  {"id": "14", "left": null, "right": null, "value": 14},
                  {"id": "-7", "left": "-8", "right": "0", "value": -7},
                  {"id": "-8", "left": "-9", "right": null, "value": -8},
                  {"id": "-9", "left": null, "right": null, "value": -9},
                  {"id": "0", "left": "-7-2", "right": "0-2", "value": 0},
                  {"id": "-7-2", "left": null, "right": null, "value": -7},
                  {"id": "0-2", "left": null, "right": null, "value": 0},
                  {"id": "5", "left": "2", "right": "5-2", "value": 5},
                  {"id": "5-2", "left": null, "right": null, "value": 5},
                  {"id": "2", "left": "1-2", "right": null, "value": 2},
                  {"id": "1-2", "left": null, "right": null, "value": 1}
                ],
                "root": "-100"
              },
              "expected": -337
            }
            """;
    private static final String TEST_CASE27 = """
            {
              "tree": {
                "nodes": [
                  {"id": "-100", "left": null, "right": "-99", "value": -100},
                  {"id": "-99", "left": null, "right": "-98", "value": -99},
                  {"id": "-98", "left": null, "right": "-97", "value": -98},
                  {"id": "-97", "left": null, "right": "-98-2", "value": -97},
                  {"id": "-98-2", "left": "-7", "right": "10", "value": -98},
                  {"id": "10", "left": "5", "right": "15", "value": 10},
                  {"id": "15", "left": "13", "right": "22", "value": 15},
                  {"id": "22", "left": null, "right": null, "value": 22},
                  {"id": "13", "left": null, "right": "14", "value": 13},
                  {"id": "14", "left": null, "right": null, "value": 14},
                  {"id": "-7", "left": "-8", "right": "0", "value": -7},
                  {"id": "-8", "left": "-9", "right": null, "value": -8},
                  {"id": "-9", "left": null, "right": null, "value": -9},
                  {"id": "0", "left": "-7-2", "right": "0-2", "value": 0},
                  {"id": "-7-2", "left": null, "right": null, "value": -7},
                  {"id": "0-2", "left": null, "right": null, "value": 0},
                  {"id": "5", "left": "2", "right": "5-2", "value": 5},
                  {"id": "5-2", "left": null, "right": null, "value": 5},
                  {"id": "2", "left": "1-2", "right": null, "value": 2},
                  {"id": "1-2", "left": null, "right": null, "value": 1}
                ],
                "root": "-100"
              },
              "expected": 56
            }
            """;
    private static final String TEST_CASE28 = """
            {
              "tree": {
                "nodes": [
                  {"id": "-100", "left": null, "right": "-99", "value": -100},
                  {"id": "-99", "left": null, "right": "-98", "value": -99},
                  {"id": "-98", "left": null, "right": "-97", "value": -98},
                  {"id": "-97", "left": null, "right": "1", "value": -97},
                  {"id": "1", "left": "-7", "right": "10", "value": 1},
                  {"id": "10", "left": "5", "right": "15", "value": 10},
                  {"id": "15", "left": "13", "right": "22", "value": 15},
                  {"id": "22", "left": null, "right": null, "value": 22},
                  {"id": "13", "left": null, "right": "12", "value": 13},
                  {"id": "12", "left": null, "right": null, "value": 12},
                  {"id": "-7", "left": "-8", "right": "0", "value": -7},
                  {"id": "-8", "left": "-9", "right": null, "value": -8},
                  {"id": "-9", "left": null, "right": null, "value": -9},
                  {"id": "0", "left": "-7-2", "right": "0-2", "value": 0},
                  {"id": "-7-2", "left": null, "right": null, "value": -7},
                  {"id": "0-2", "left": null, "right": null, "value": 0},
                  {"id": "5", "left": "2", "right": "5-2", "value": 5},
                  {"id": "5-2", "left": null, "right": null, "value": 5},
                  {"id": "2", "left": "1-2", "right": null, "value": 2},
                  {"id": "1-2", "left": null, "right": null, "value": 1}
                ],
                "root": "-100"
              },
              "expected": -18
            }
            """;
    private static final String TEST_CASE29 = """
            {
              "tree": {
                "nodes": [
                  {"id": "-100", "left": null, "right": "-99", "value": -100},
                  {"id": "-99", "left": null, "right": "-98", "value": -99},
                  {"id": "-98", "left": null, "right": "-97", "value": -98},
                  {"id": "-97", "left": null, "right": "1", "value": -97},
                  {"id": "1", "left": "-7", "right": "10", "value": 1},
                  {"id": "10", "left": "5", "right": "15", "value": 10},
                  {"id": "15", "left": "13", "right": "22", "value": 15},
                  {"id": "22", "left": null, "right": null, "value": 22},
                  {"id": "13", "left": null, "right": "12", "value": 13},
                  {"id": "12", "left": null, "right": null, "value": 12},
                  {"id": "-7", "left": "-8", "right": "0", "value": -7},
                  {"id": "-8", "left": "-9", "right": null, "value": -8},
                  {"id": "-9", "left": null, "right": null, "value": -9},
                  {"id": "0", "left": "-7-2", "right": "0-2", "value": 0},
                  {"id": "-7-2", "left": null, "right": null, "value": -7},
                  {"id": "0-2", "left": null, "right": null, "value": 0},
                  {"id": "5", "left": "2", "right": "5-2", "value": 5},
                  {"id": "5-2", "left": null, "right": null, "value": 5},
                  {"id": "2", "left": "1-2", "right": null, "value": 2},
                  {"id": "1-2", "left": null, "right": "1-3", "value": 1},
                  {"id": "1-3", "left": null, "right": "1-4", "value": 1},
                  {"id": "1-4", "left": null, "right": "1-5", "value": 1},
                  {"id": "1-5", "left": null, "right": null, "value": 1}
                ],
                "root": "-100"
              },
              "expected": -15
            }
            """;
    private static final String TEST_CASE30 = """
            {
              "tree": {
                "nodes": [
                  {"id": "-100", "left": null, "right": "-99", "value": -100},
                  {"id": "-99", "left": null, "right": "-98", "value": -99},
                  {"id": "-98", "left": null, "right": "-97", "value": -98},
                  {"id": "-97", "left": null, "right": "1", "value": -97},
                  {"id": "1", "left": "-7", "right": "10", "value": 1},
                  {"id": "10", "left": "5", "right": "15", "value": 10},
                  {"id": "15", "left": "13", "right": "22", "value": 15},
                  {"id": "22", "left": null, "right": null, "value": 22},
                  {"id": "13", "left": null, "right": "12", "value": 13},
                  {"id": "12", "left": null, "right": null, "value": 12},
                  {"id": "-7", "left": "-8", "right": "0", "value": -7},
                  {"id": "-8", "left": "-9", "right": null, "value": -8},
                  {"id": "-9", "left": null, "right": null, "value": -9},
                  {"id": "0", "left": "-7-2", "right": "0-2", "value": 0},
                  {"id": "-7-2", "left": null, "right": null, "value": -7},
                  {"id": "0-2", "left": null, "right": null, "value": 0},
                  {"id": "5", "left": "2", "right": "5-2", "value": 5},
                  {"id": "5-2", "left": null, "right": null, "value": 5},
                  {"id": "2", "left": "1-2", "right": null, "value": 2},
                  {"id": "1-2", "left": null, "right": "1-3", "value": 1},
                  {"id": "1-3", "left": null, "right": "1-4", "value": 1},
                  {"id": "1-4", "left": "1-5", "right": null, "value": 1},
                  {"id": "1-5", "left": null, "right": null, "value": 1}
                ],
                "root": "-100"
              },
              "expected": -31
            }
            """;
    private static final String TEST_CASE31 = """
            {
              "tree": {
                "nodes": [
                  {"id": "20", "left": "7", "right": "10", "value": 20},
                  {"id": "7", "left": "0", "right": "8", "value": 7},
                  {"id": "0", "left": null, "right": null, "value": 0},
                  {"id": "8", "left": "7-2", "right": "9", "value": 8},
                  {"id": "7-2", "left": null, "right": null, "value": 7},
                  {"id": "9", "left": null, "right": null, "value": 9},
                  {"id": "10", "left": "5", "right": "15", "value": 10},
                  {"id": "5", "left": "2", "right": "5-2", "value": 5},
                  {"id": "2", "left": "1", "right": null, "value": 2},
                  {"id": "1", "left": null, "right": null, "value": 1},
                  {"id": "5-2", "left": null, "right": null, "value": 5},
                  {"id": "15", "left": "13", "right": "22", "value": 15},
                  {"id": "13", "left": null, "right": "14", "value": 13},
                  {"id": "14", "left": null, "right": null, "value": 14},
                  {"id": "22", "left": null, "right": null, "value": 22}
                ],
                "root": "20"
              },
              "expected": 118
            }
            """;
    private static final String TEST_CASE32 = """
            {
              "tree": {
                "nodes": [
                  {"id": "20", "left": "9", "right": "10", "value": 20},
                  {"id": "9", "left": "0", "right": "8", "value": 9},
                  {"id": "0", "left": null, "right": null, "value": 0},
                  {"id": "8", "left": "7-2", "right": null, "value": 8},
                  {"id": "7-2", "left": null, "right": null, "value": 7},
                  {"id": "10", "left": "6", "right": "15", "value": 10},
                  {"id": "6", "left": "2", "right": "5", "value": 6},
                  {"id": "2", "left": "1", "right": null, "value": 2},
                  {"id": "1", "left": null, "right": null, "value": 1},
                  {"id": "5", "left": null, "right": null, "value": 5},
                  {"id": "15", "left": "17", "right": "22", "value": 15},
                  {"id": "17", "left": null, "right": "14", "value": 17},
                  {"id": "14", "left": null, "right": null, "value": 14},
                  {"id": "22", "left": null, "right": null, "value": 22}
                ],
                "root": "20"
              },
              "expected": 0
            }
            """;
    private static final String TEST_CASE33 = """
            {
              "tree": {
                "nodes": [
                  {"id": "20", "left": "7", "right": "10", "value": 20},
                  {"id": "7", "left": "2", "right": "8", "value": 7},
                  {"id": "2", "left": null, "right": null, "value": 2},
                  {"id": "8", "left": "7-2", "right": "9", "value": 8},
                  {"id": "7-2", "left": null, "right": null, "value": 7},
                  {"id": "9", "left": null, "right": null, "value": 9},
                  {"id": "10", "left": "5", "right": "15", "value": 10},
                  {"id": "5", "left": "2-2", "right": "5-2", "value": 5},
                  {"id": "2-2", "left": null, "right": null, "value": 2},
                  {"id": "5-2", "left": null, "right": null, "value": 5},
                  {"id": "15", "left": "13", "right": "8-2", "value": 15},
                  {"id": "13", "left": null, "right": "14", "value": 13},
                  {"id": "14", "left": null, "right": null, "value": 14},
                  {"id": "8-2", "left": null, "right": null, "value": 8}
                ],
                "root": "20"
              },
              "expected": 45
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
            parseArguments(TEST_CASE1),
            parseArguments(TEST_CASE2),
            parseArguments(TEST_CASE3),
            parseArguments(TEST_CASE4),
            parseArguments(TEST_CASE5),
            parseArguments(TEST_CASE6),
            parseArguments(TEST_CASE7),
            parseArguments(TEST_CASE8),
            parseArguments(TEST_CASE9),
            parseArguments(TEST_CASE10),
            parseArguments(TEST_CASE11),
            parseArguments(TEST_CASE12),
            parseArguments(TEST_CASE13),
            parseArguments(TEST_CASE14),
            parseArguments(TEST_CASE15),
            parseArguments(TEST_CASE16),
            parseArguments(TEST_CASE17),
            parseArguments(TEST_CASE18),
            parseArguments(TEST_CASE19),
            parseArguments(TEST_CASE20),
            parseArguments(TEST_CASE21),
            parseArguments(TEST_CASE22),
            parseArguments(TEST_CASE23),
            parseArguments(TEST_CASE24),
            parseArguments(TEST_CASE25),
            parseArguments(TEST_CASE26),
            parseArguments(TEST_CASE27),
            parseArguments(TEST_CASE28),
            parseArguments(TEST_CASE29),
            parseArguments(TEST_CASE30),
            parseArguments(TEST_CASE31),
            parseArguments(TEST_CASE32),
            parseArguments(TEST_CASE33)
        );
    }

    private static Arguments parseArguments(String json) {
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
        var expected = obj.get("expected").getAsInt();
        return Arguments.of(map.get(root), expected);
    }
}
