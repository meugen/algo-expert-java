package com.algo.expert.arrays;

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

public class ApartmentHuntingTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"blocks\": [\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": true,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": true,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": true\n" +
            "    }\n" +
            "  ],\n" +
            "  \"reqs\": [\"gym\", \"school\", \"store\"]\n" +
            "}";
    private static final String TEST_CASE2 = "{\n" +
            "  \"blocks\": [\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"office\": true,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": true,\n" +
            "      \"office\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": true,\n" +
            "      \"office\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"office\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"office\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": true\n" +
            "    }\n" +
            "  ],\n" +
            "  \"reqs\": [\"gym\", \"office\", \"school\", \"store\"]\n" +
            "}";
    private static final String TEST_CASE3 = "{\n" +
            "  \"blocks\": [\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"office\": true,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": true,\n" +
            "      \"office\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": true,\n" +
            "      \"office\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"office\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"office\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"office\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": true\n" +
            "    }\n" +
            "  ],\n" +
            "  \"reqs\": [\"gym\", \"office\", \"school\", \"store\"]\n" +
            "}";
    private static final String TEST_CASE4 = "{\n" +
            "  \"blocks\": [\n" +
            "    {\n" +
            "      \"foo\": true,\n" +
            "      \"gym\": false,\n" +
            "      \"kappa\": false,\n" +
            "      \"office\": true,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"foo\": true,\n" +
            "      \"gym\": true,\n" +
            "      \"kappa\": false,\n" +
            "      \"office\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"foo\": true,\n" +
            "      \"gym\": true,\n" +
            "      \"kappa\": false,\n" +
            "      \"office\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"foo\": true,\n" +
            "      \"gym\": false,\n" +
            "      \"kappa\": false,\n" +
            "      \"office\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"foo\": true,\n" +
            "      \"gym\": true,\n" +
            "      \"kappa\": false,\n" +
            "      \"office\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"foo\": true,\n" +
            "      \"gym\": false,\n" +
            "      \"kappa\": false,\n" +
            "      \"office\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": true\n" +
            "    }\n" +
            "  ],\n" +
            "  \"reqs\": [\"gym\", \"school\", \"store\"]\n" +
            "}";
    private static final String TEST_CASE5 = "{\n" +
            "  \"blocks\": [\n" +
            "    {\n" +
            "      \"gym\": true,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": true\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": true,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    }\n" +
            "  ],\n" +
            "  \"reqs\": [\"gym\", \"school\", \"store\"]\n" +
            "}";
    private static final String TEST_CASE6 = "{\n" +
            "  \"blocks\": [\n" +
            "    {\n" +
            "      \"gym\": true,\n" +
            "      \"pool\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"pool\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"pool\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"pool\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"pool\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": true\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": true,\n" +
            "      \"pool\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"pool\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"pool\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"pool\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"pool\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"pool\": true,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    }\n" +
            "  ],\n" +
            "  \"reqs\": [\"gym\", \"pool\", \"school\", \"store\"]\n" +
            "}";
    private static final String TEST_CASE7 = "{\n" +
            "  \"blocks\": [\n" +
            "    {\n" +
            "      \"gym\": true,\n" +
            "      \"office\": false,\n" +
            "      \"pool\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"office\": false,\n" +
            "      \"pool\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"office\": true,\n" +
            "      \"pool\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"office\": true,\n" +
            "      \"pool\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"office\": false,\n" +
            "      \"pool\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": true\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": true,\n" +
            "      \"office\": true,\n" +
            "      \"pool\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"office\": false,\n" +
            "      \"pool\": true,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"office\": false,\n" +
            "      \"pool\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"office\": false,\n" +
            "      \"pool\": false,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"office\": false,\n" +
            "      \"pool\": false,\n" +
            "      \"school\": true,\n" +
            "      \"store\": false\n" +
            "    },\n" +
            "    {\n" +
            "      \"gym\": false,\n" +
            "      \"office\": false,\n" +
            "      \"pool\": true,\n" +
            "      \"school\": false,\n" +
            "      \"store\": false\n" +
            "    }\n" +
            "  ],\n" +
            "  \"reqs\": [\"gym\", \"pool\", \"school\", \"store\"]\n" +
            "}";

    @ParameterizedTest
    @MethodSource("params")
    void testCasesSolution1(List<Map<String, Boolean>> blocks, String[] reqs, int expected) {
        implTestCases(new ApartmentHunting.Solution1(), blocks, reqs, expected);
    }

    private void implTestCases(ApartmentHunting impl, List<Map<String, Boolean>> blocks, String[] reqs, int expected) {
        int result = impl.apartmentHunting(blocks, reqs);
        Assertions.assertEquals(expected, result);
    }

    static List<Arguments> params() {
        return List.of(
                parseArguments(TEST_CASE1, 3),
                parseArguments(TEST_CASE2, 2),
                parseArguments(TEST_CASE3, 2),
                parseArguments(TEST_CASE4, 4),
                parseArguments(TEST_CASE5, 2),
                parseArguments(TEST_CASE6, 7),
                parseArguments(TEST_CASE7, 4)
        );
    }

    private static Arguments parseArguments(String json, int expected) {
        JsonObject object = new Gson().fromJson(json, JsonElement.class).getAsJsonObject();
        List<Map<String, Boolean>> blocks = new ArrayList<>();
        for (JsonElement element : object.getAsJsonArray("blocks")) {
            Map<String, Boolean> block = new HashMap<>();
            for (Map.Entry<String, JsonElement> entry : element.getAsJsonObject().entrySet()) {
                block.put(entry.getKey(), entry.getValue().getAsBoolean());
            }
            blocks.add(block);
        }
        JsonArray reqsArray = object.getAsJsonArray("reqs");
        String[] reqs = new String[reqsArray.size()];
        for (int i = 0; i < reqs.length; i++) {
            reqs[i] = reqsArray.get(i).getAsString();
        }
        return Arguments.of(blocks, reqs, expected);
    }
}
