package com.algo.expert.tries;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class StringsMadeUpOfStringsTest {
    
    private static final String TEST_CASE1 =  """
            {
              "strings": ["foobar"],
              "substrings": ["foo", "bar"],
              "expected": ["foobar"]
            }
            """;
    private static final String TEST_CASE2 = """
            {
              "strings": ["foo"],
              "substrings": ["foo"],
              "expected": ["foo"]
            }
            """;
    private static final String TEST_CASE3 = """
            {
              "strings": ["foobar"],
              "substrings": ["foo", "baz"],
              "expected": []
            }
            """;
    private static final String TEST_CASE4 = """
            {
              "strings": ["baz"],
              "substrings": ["b", "a", "z"],
              "expected": ["baz"]
            }
            """;
    private static final String TEST_CASE5 = """
            {
              "strings": ["algoexpert"],
              "substrings": ["algo", "pert", "ex"],
              "expected": ["algoexpert"]
            }
            """;
    private static final String TEST_CASE6 = """
            {
              "strings": ["bar"],
              "substrings": ["barely"],
              "expected": []
            }
            """;
    private static final String TEST_CASE7 = """
            {
              "strings": ["bar"],
              "substrings": ["b", "a", "r", "ba", "ar"],
              "expected": ["bar"]
            }
            """;
    private static final String TEST_CASE8 = """
            {
              "strings": ["bar"],
              "substrings": ["b", "a", "r", "ba", "ar", "bar"],
              "expected": ["bar"]
            }
            """;
    private static final String TEST_CASE9 = """
            {
              "strings": ["bar", "are", "foo", "ba", "b", "barely"],
              "substrings": ["b", "a", "r", "ba", "ar", "bar"],
              "expected": ["bar", "ba", "b"]
            }
            """;
    private static final String TEST_CASE10 = """
            {
              "strings": ["barbar", "algoexpert", "frontendexpert"],
              "substrings": ["algo", "bar", "expert", "end", "front"],
              "expected": ["barbar", "algoexpert", "frontendexpert"]
            }
            """;
    private static final String TEST_CASE11 = """
            {
              "strings": ["foo123", "bar$%"],
              "substrings": ["foo", "123", "bar", "$%"],
              "expected": ["foo123", "bar$%"]
            }
            """;
    private static final String TEST_CASE12 = """
            {
              "strings": ["foo123", "bar$%"],
              "substrings": ["123", "foo", "bar"],
              "expected": ["foo123"]
            }
            """;
    private static final String TEST_CASE13 = """
            {
              "strings": ["foobarfoobar"],
              "substrings": ["foo", "bar"],
              "expected": ["foobarfoobar"]
            }
            """;
    private static final String TEST_CASE14 = """
            {
              "strings": ["foobarfoobar", "foo", "bar", "barfoobar", "fobaro", "foobaro"],
              "substrings": ["foo", "bar"],
              "expected": ["foobarfoobar", "foo", "bar", "barfoobar"]
            }
            """;
    private static final String TEST_CASE15 = """
            {
              "strings": ["foo", "bar", "baz", "qux", "quux"],
              "substrings": ["foo", "ba", "qu", "ux"],
              "expected": ["foo", "quux"]
            }
            """;
    private static final String TEST_CASE16 = """
            {
              "strings": ["foofoo", "barbar", "bazbaz", "foobaz"],
              "substrings": ["foo", "bar", "baz"],
              "expected": ["foofoo", "barbar", "bazbaz", "foobaz"]
            }
            """;
    private static final String TEST_CASE17 = """
            {
              "strings": ["foo", "bar", "baz", "qux", "quux", "foobar"],
              "substrings": ["foo", "ba", "qux"],
              "expected": ["foo", "qux"]
            }
            """;
    private static final String TEST_CASE18 = """
            {
              "strings": ["foobarbaz", "bazbarfoo", "foobaz", "quxquux", "quuxqux"],
              "substrings": ["foo", "ba", "bar", "baz", "qux", "qu"],
              "expected": ["foobarbaz", "bazbarfoo", "foobaz"]
            }
            """;
    private static final String TEST_CASE19 = """
            {
              "strings": ["java", "javascript", "python", "ruby", "c", "cplusplus", "assembly"],
              "substrings": ["ja", "script", "py", "thon", "ruby", "c", "plus", "va", "assembly"],
              "expected": ["java", "javascript", "python", "ruby", "c", "cplusplus", "assembly"]
            }
            """;
    private static final String TEST_CASE20 = """
            {
              "strings": ["java", "javascript", "python", "ruby", "c", "cplusplus", "assembly"],
              "substrings": ["ja", "py", "thone", "ruby", "c", "minus", "va", "assembler"],
              "expected": ["java", "ruby", "c"]
            }
            """;
    private static final String TEST_CASE21 = """
            {
              "strings": ["linkedlist", "binarysearchtree", "depthfirstsearch", "breadthfirstsearch", "quicksort"],
              "substrings": ["linked", "list", "binary", "search", "tree", "depth", "first", "breadth", "quick", "sort"],
              "expected": ["linkedlist", "binarysearchtree", "depthfirstsearch", "breadthfirstsearch", "quicksort"]
            }
            """;
    private static final String TEST_CASE22 = """
            {
              "strings": ["linkedlist", "binarysearchtree", "depthfirstsearch", "breadthfirstsearch", "quicksort"],
              "substrings": ["so", "se", "rt", "arch", "tre", "e", "binary", "depth", "link", "ed", "list", "first"],
              "expected": ["linkedlist", "binarysearchtree", "depthfirstsearch"]
            }
            """;
    private static final String TEST_CASE23 = """
            {
              "strings": ["linkedlist", "binarysearchtree", "depthfirstsearch", "breadthfirstsearch", "quicksort"],
              "substrings": ["so", "se", "rt", "arch", "tre", "binary", "depth", "link", "list", "first"],
              "expected": ["depthfirstsearch"]
            }
            """;

    private void internalTestCaseSolution(StringsMadeUpOfStrings solution, String[] strings, String[] substrings, String[] expected) {
        var result =  solution.stringsMadeUpOfStrings(strings, substrings);
        assertArrayEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCaseSolution1(String[] strings, String[] substrings, String[] expected) {
        internalTestCaseSolution(new StringsMadeUpOfStrings.Solution1(), strings, substrings, expected);
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
            parseArguments(TEST_CASE23)
        );
    }

    private static Arguments parseArguments(String json) {
        var obj = new Gson().fromJson(json, JsonElement.class).getAsJsonObject();
        return Arguments.of(
            parseArray(obj.get("strings").getAsJsonArray()),
            parseArray(obj.get("substrings").getAsJsonArray()),
            parseArray(obj.get("expected").getAsJsonArray())
        );
    }

    private static String[]  parseArray(JsonArray array) {
        var result = new String[array.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = array.get(i).getAsString();
        }
        return result;
    }
}
