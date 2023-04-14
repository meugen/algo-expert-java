package com.algo.expert.arrays;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class TournamentWinnerTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"competitions\": [\n" +
            "    [\"HTML\", \"C#\"],\n" +
            "    [\"C#\", \"Python\"],\n" +
            "    [\"Python\", \"HTML\"]\n" +
            "  ],\n" +
            "  \"results\": [0, 0, 1]\n" +
            "}";
    private static final String TEST_CASE2 = "{\n" +
            "  \"competitions\": [\n" +
            "    [\"HTML\", \"Java\"],\n" +
            "    [\"Java\", \"Python\"],\n" +
            "    [\"Python\", \"HTML\"]\n" +
            "  ],\n" +
            "  \"results\": [0, 1, 1]\n" +
            "}";
    private static final String TEST_CASE3 = "{\n" +
            "  \"competitions\": [\n" +
            "    [\"HTML\", \"Java\"],\n" +
            "    [\"Java\", \"Python\"],\n" +
            "    [\"Python\", \"HTML\"],\n" +
            "    [\"C#\", \"Python\"],\n" +
            "    [\"Java\", \"C#\"],\n" +
            "    [\"C#\", \"HTML\"]\n" +
            "  ],\n" +
            "  \"results\": [0, 1, 1, 1, 0, 1]\n" +
            "}";
    private static final String TEST_CASE4 = "{\n" +
            "  \"competitions\": [\n" +
            "    [\"HTML\", \"Java\"],\n" +
            "    [\"Java\", \"Python\"],\n" +
            "    [\"Python\", \"HTML\"],\n" +
            "    [\"C#\", \"Python\"],\n" +
            "    [\"Java\", \"C#\"],\n" +
            "    [\"C#\", \"HTML\"],\n" +
            "    [\"SQL\", \"C#\"],\n" +
            "    [\"HTML\", \"SQL\"],\n" +
            "    [\"SQL\", \"Python\"],\n" +
            "    [\"SQL\", \"Java\"]\n" +
            "  ],\n" +
            "  \"results\": [0, 1, 1, 1, 0, 1, 0, 1, 1, 0]\n" +
            "}";
    private static final String TEST_CASE5 = "{\n" +
            "  \"competitions\": [\n" +
            "    [\"Bulls\", \"Eagles\"]\n" +
            "  ],\n" +
            "  \"results\": [1]\n" +
            "}";
    private static final String TEST_CASE6 = "{\n" +
            "  \"competitions\": [\n" +
            "    [\"Bulls\", \"Eagles\"],\n" +
            "    [\"Bulls\", \"Bears\"],\n" +
            "    [\"Bears\", \"Eagles\"]\n" +
            "  ],\n" +
            "  \"results\": [0, 0, 0]\n" +
            "}";
    private static final String TEST_CASE7 = "{\n" +
            "  \"competitions\": [\n" +
            "    [\"Bulls\", \"Eagles\"],\n" +
            "    [\"Bulls\", \"Bears\"],\n" +
            "    [\"Bulls\", \"Monkeys\"],\n" +
            "    [\"Eagles\", \"Bears\"],\n" +
            "    [\"Eagles\", \"Monkeys\"],\n" +
            "    [\"Bears\", \"Monkeys\"]\n" +
            "  ],\n" +
            "  \"results\": [1, 1, 1, 1, 1, 1]\n" +
            "}";
    private static final String TEST_CASE8 = "{\n" +
            "  \"competitions\": [\n" +
            "    [\"AlgoMasters\", \"FrontPage Freebirds\"],\n" +
            "    [\"Runtime Terror\", \"Static Startup\"],\n" +
            "    [\"WeC#\", \"Hypertext Assassins\"],\n" +
            "    [\"AlgoMasters\", \"WeC#\"],\n" +
            "    [\"Static Startup\", \"Hypertext Assassins\"],\n" +
            "    [\"Runtime Terror\", \"FrontPage Freebirds\"],\n" +
            "    [\"AlgoMasters\", \"Runtime Terror\"],\n" +
            "    [\"Hypertext Assassins\", \"FrontPage Freebirds\"],\n" +
            "    [\"Static Startup\", \"WeC#\"],\n" +
            "    [\"AlgoMasters\", \"Static Startup\"],\n" +
            "    [\"FrontPage Freebirds\", \"WeC#\"],\n" +
            "    [\"Hypertext Assassins\", \"Runtime Terror\"],\n" +
            "    [\"AlgoMasters\", \"Hypertext Assassins\"],\n" +
            "    [\"WeC#\", \"Runtime Terror\"],\n" +
            "    [\"FrontPage Freebirds\", \"Static Startup\"]\n" +
            "  ],\n" +
            "  \"results\": [1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0]\n" +
            "}";
    private static final String TEST_CASE9 = "{\n" +
            "  \"competitions\": [\n" +
            "    [\"HTML\", \"Java\"],\n" +
            "    [\"Java\", \"Python\"],\n" +
            "    [\"Python\", \"HTML\"],\n" +
            "    [\"C#\", \"Python\"],\n" +
            "    [\"Java\", \"C#\"],\n" +
            "    [\"C#\", \"HTML\"],\n" +
            "    [\"SQL\", \"C#\"],\n" +
            "    [\"HTML\", \"SQL\"],\n" +
            "    [\"SQL\", \"Python\"],\n" +
            "    [\"SQL\", \"Java\"]\n" +
            "  ],\n" +
            "  \"results\": [0, 0, 0, 0, 0, 0, 1, 0, 1, 1]\n" +
            "}";
    private static final String TEST_CASE10 = "{\n" +
            "  \"competitions\": [\n" +
            "    [\"A\", \"B\"]\n" +
            "  ],\n" +
            "  \"results\": [0]\n" +
            "}";

    private void internalTestCases(TournamentWinner impl, TestCase testCase, String expected) {
        String result = impl.tournamentWinner(testCase.competitions, testCase.results);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testCasesSolution1(TestCase testCase, String expected) {
        internalTestCases(new TournamentWinner.Solution1(), testCase, expected);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(parseTestCase(TEST_CASE1), "Python"),
                Arguments.of(parseTestCase(TEST_CASE2), "Java"),
                Arguments.of(parseTestCase(TEST_CASE3), "C#"),
                Arguments.of(parseTestCase(TEST_CASE4), "C#"),
                Arguments.of(parseTestCase(TEST_CASE5), "Bulls"),
                Arguments.of(parseTestCase(TEST_CASE6), "Eagles"),
                Arguments.of(parseTestCase(TEST_CASE7), "Bulls"),
                Arguments.of(parseTestCase(TEST_CASE8), "AlgoMasters"),
                Arguments.of(parseTestCase(TEST_CASE9), "SQL"),
                Arguments.of(parseTestCase(TEST_CASE10), "B")
        );
    }

    static TestCase parseTestCase(String json) {
        JsonObject object = new Gson().fromJson(json, JsonElement.class).getAsJsonObject();

        List<List<String>> competitions = new ArrayList<>();
        for (JsonElement element : object.getAsJsonArray("competitions")) {
            ArrayList<String> competition = new ArrayList<>();
            for (JsonElement item : element.getAsJsonArray()) {
                competition.add(item.getAsString());
            }
            competitions.add(competition);
        }

        ArrayList<Integer> results = new ArrayList<>();
        for (JsonElement element : object.getAsJsonArray("results")) {
            results.add(element.getAsInt());
        }

        return new TestCase(competitions, results);
    }

    static class TestCase {
        final List<List<String>> competitions;
        final List<Integer> results;

        public TestCase(List<List<String>> competitions, List<Integer> results) {
            this.competitions = competitions;
            this.results = results;
        }
    }
}
