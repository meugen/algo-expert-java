package com.algo.expert.recurtion;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ProductSumTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"array\": [5, 2, [7, -1], 3, [6, [-13, 8], 4]]\n" +
            "}";
    private static final String TEST_CASE2 = "{\n" +
            "  \"array\": [1, 2, 3, 4, 5]\n" +
            "}";
    private static final String TEST_CASE3 = "{\n" +
            "  \"array\": [1, 2, [3], 4, 5]\n" +
            "}";
    private static final String TEST_CASE4 = "{\n" +
            "  \"array\": [\n" +
            "    [1, 2],\n" +
            "    3,\n" +
            "    [4, 5]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE5 = "{\n" +
            "  \"array\": [\n" +
            "    [\n" +
            "      [\n" +
            "        [\n" +
            "          [5]\n" +
            "        ]\n" +
            "      ]\n" +
            "    ]\n" +
            "  ]\n" +
            "}";
    private static final String TEST_CASE6 = "{\n" +
            "  \"array\": [9, [2, -3, 4], 1, [1, 1, [1, 1, 1]], [[[[3, 4, 1]]], 8], [1, 2, 3, 4, 5, [6, 7], -7], [1, [2, 3, [4, 5]], [6, 0, [7, 0, -8]], -7], [1, -3, 2, [1, -3, 2, [1, -3, 2], [1, -3, 2, [1, -3, 2]], [1, -3, 2]]], -3]\n" +
            "}";

    @ParameterizedTest
    @MethodSource("params")
    void testCases(List<Object> array, int expected) {
        int result = ProductSum.productSum(array);
        Assertions.assertEquals(expected, result);
    }

    static List<Arguments> params() {
        return List.of(
                Arguments.of(parseArray(TEST_CASE1), 12),
                Arguments.of(parseArray(TEST_CASE2), 15),
                Arguments.of(parseArray(TEST_CASE3), 18),
                Arguments.of(parseArray(TEST_CASE4), 27),
                Arguments.of(parseArray(TEST_CASE5), 600),
                Arguments.of(parseArray(TEST_CASE6), 1351)
        );
    }

    static List<Object> parseArray(String json) {
        JsonObject object = new Gson().fromJson(json, JsonElement.class).getAsJsonObject();
        return (List<Object>) buildArrayFromJson(object.get("array"));
    }

    static Object buildArrayFromJson(JsonElement element) {
        if (element.isJsonPrimitive()) {
            return element.getAsInt();
        }
        List<Object> result = new ArrayList<>();
        for (JsonElement child : element.getAsJsonArray()) {
            result.add(buildArrayFromJson(child));
        }
        return result;
    }
}
