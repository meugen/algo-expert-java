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
import java.util.List;

public class CalendarMatchingTest {

    private static final String TEST_CASE1 = "{\n" +
            "  \"calendar1\": [\n" +
            "    [\"9:00\", \"10:30\"],\n" +
            "    [\"12:00\", \"13:00\"],\n" +
            "    [\"16:00\", \"18:00\"]\n" +
            "  ],\n" +
            "  \"calendar2\": [\n" +
            "    [\"10:00\", \"11:30\"],\n" +
            "    [\"12:30\", \"14:30\"],\n" +
            "    [\"14:30\", \"15:00\"],\n" +
            "    [\"16:00\", \"17:00\"]\n" +
            "  ],\n" +
            "  \"dailyBounds1\": [\"9:00\", \"20:00\"],\n" +
            "  \"dailyBounds2\": [\"10:00\", \"18:30\"],\n" +
            "  \"meetingDuration\": 30\n" +
            "}";
    private static final String EXPECTED1 = "[\n" +
            "  [\"11:30\", \"12:00\"],\n" +
            "  [\"15:00\", \"16:00\"],\n" +
            "  [\"18:00\", \"18:30\"]\n" +
            "]";
    private static final String TEST_CASE2 = "{\n" +
            "  \"calendar1\": [\n" +
            "    [\"9:00\", \"10:30\"],\n" +
            "    [\"12:00\", \"13:00\"],\n" +
            "    [\"16:00\", \"18:00\"]\n" +
            "  ],\n" +
            "  \"calendar2\": [\n" +
            "    [\"10:00\", \"11:30\"],\n" +
            "    [\"12:30\", \"14:30\"],\n" +
            "    [\"14:30\", \"15:00\"],\n" +
            "    [\"16:00\", \"17:00\"]\n" +
            "  ],\n" +
            "  \"dailyBounds1\": [\"9:00\", \"20:00\"],\n" +
            "  \"dailyBounds2\": [\"10:00\", \"18:30\"],\n" +
            "  \"meetingDuration\": 30\n" +
            "}";
    private static final String EXPECTED2 = "[\n" +
            "  [\"11:30\", \"12:00\"],\n" +
            "  [\"15:00\", \"16:00\"],\n" +
            "  [\"18:00\", \"18:30\"]\n" +
            "]";
    private static final String TEST_CASE3 = "{\n" +
            "  \"calendar1\": [\n" +
            "    [\"9:00\", \"10:30\"],\n" +
            "    [\"12:00\", \"13:00\"],\n" +
            "    [\"16:00\", \"18:00\"]\n" +
            "  ],\n" +
            "  \"calendar2\": [\n" +
            "    [\"10:00\", \"11:30\"],\n" +
            "    [\"12:30\", \"14:30\"],\n" +
            "    [\"14:30\", \"15:00\"],\n" +
            "    [\"16:00\", \"17:00\"]\n" +
            "  ],\n" +
            "  \"dailyBounds1\": [\"9:00\", \"20:00\"],\n" +
            "  \"dailyBounds2\": [\"10:00\", \"18:30\"],\n" +
            "  \"meetingDuration\": 45\n" +
            "}";
    private static final String EXPECTED3 = "[\n" +
            "  [\"15:00\", \"16:00\"]\n" +
            "]";
    private static final String TEST_CASE4 = "{\n" +
            "  \"calendar1\": [\n" +
            "    [\"9:00\", \"10:30\"],\n" +
            "    [\"12:00\", \"13:00\"],\n" +
            "    [\"16:00\", \"18:00\"]\n" +
            "  ],\n" +
            "  \"calendar2\": [\n" +
            "    [\"10:00\", \"11:30\"],\n" +
            "    [\"12:30\", \"14:30\"],\n" +
            "    [\"14:30\", \"15:00\"],\n" +
            "    [\"16:00\", \"17:00\"]\n" +
            "  ],\n" +
            "  \"dailyBounds1\": [\"8:00\", \"20:00\"],\n" +
            "  \"dailyBounds2\": [\"7:00\", \"18:30\"],\n" +
            "  \"meetingDuration\": 45\n" +
            "}";
    private static final String EXPECTED4 = "[\n" +
            "  [\"8:00\", \"9:00\"],\n" +
            "  [\"15:00\", \"16:00\"]\n" +
            "]";
    private static final String TEST_CASE5 = "{\n" +
            "  \"calendar1\": [\n" +
            "    [\"8:00\", \"10:30\"],\n" +
            "    [\"11:30\", \"13:00\"],\n" +
            "    [\"14:00\", \"16:00\"],\n" +
            "    [\"16:00\", \"18:00\"]\n" +
            "  ],\n" +
            "  \"calendar2\": [\n" +
            "    [\"10:00\", \"11:30\"],\n" +
            "    [\"12:30\", \"14:30\"],\n" +
            "    [\"14:30\", \"15:00\"],\n" +
            "    [\"16:00\", \"17:00\"]\n" +
            "  ],\n" +
            "  \"dailyBounds1\": [\"8:00\", \"18:00\"],\n" +
            "  \"dailyBounds2\": [\"7:00\", \"18:30\"],\n" +
            "  \"meetingDuration\": 15\n" +
            "}";
    private static final String EXPECTED5 = "[]";
    private static final String TEST_CASE6 = "{\n" +
            "  \"calendar1\": [\n" +
            "    [\"10:00\", \"10:30\"],\n" +
            "    [\"10:45\", \"11:15\"],\n" +
            "    [\"11:30\", \"13:00\"],\n" +
            "    [\"14:15\", \"16:00\"],\n" +
            "    [\"16:00\", \"18:00\"]\n" +
            "  ],\n" +
            "  \"calendar2\": [\n" +
            "    [\"10:00\", \"11:00\"],\n" +
            "    [\"12:30\", \"13:30\"],\n" +
            "    [\"14:30\", \"15:00\"],\n" +
            "    [\"16:00\", \"17:00\"]\n" +
            "  ],\n" +
            "  \"dailyBounds1\": [\"9:30\", \"20:00\"],\n" +
            "  \"dailyBounds2\": [\"9:00\", \"18:30\"],\n" +
            "  \"meetingDuration\": 15\n" +
            "}";
    private static final String EXPECTED6 = "[\n" +
            "  [\"9:30\", \"10:00\"],\n" +
            "  [\"11:15\", \"11:30\"],\n" +
            "  [\"13:30\", \"14:15\"],\n" +
            "  [\"18:00\", \"18:30\"]\n" +
            "]";
    private static final String TEST_CASE7 = "{\n" +
            "  \"calendar1\": [\n" +
            "    [\"10:00\", \"10:30\"],\n" +
            "    [\"10:45\", \"11:15\"],\n" +
            "    [\"11:30\", \"13:00\"],\n" +
            "    [\"14:15\", \"16:00\"],\n" +
            "    [\"16:00\", \"18:00\"]\n" +
            "  ],\n" +
            "  \"calendar2\": [\n" +
            "    [\"10:00\", \"11:00\"],\n" +
            "    [\"10:30\", \"20:30\"]\n" +
            "  ],\n" +
            "  \"dailyBounds1\": [\"9:30\", \"20:00\"],\n" +
            "  \"dailyBounds2\": [\"9:00\", \"22:30\"],\n" +
            "  \"meetingDuration\": 60\n" +
            "}";
    private static final String EXPECTED7 = "[]";
    private static final String TEST_CASE8 = "{\n" +
            "  \"calendar1\": [\n" +
            "    [\"10:00\", \"10:30\"],\n" +
            "    [\"10:45\", \"11:15\"],\n" +
            "    [\"11:30\", \"13:00\"],\n" +
            "    [\"14:15\", \"16:00\"],\n" +
            "    [\"16:00\", \"18:00\"]\n" +
            "  ],\n" +
            "  \"calendar2\": [\n" +
            "    [\"10:00\", \"11:00\"],\n" +
            "    [\"10:30\", \"16:30\"]\n" +
            "  ],\n" +
            "  \"dailyBounds1\": [\"9:30\", \"20:00\"],\n" +
            "  \"dailyBounds2\": [\"9:00\", \"22:30\"],\n" +
            "  \"meetingDuration\": 60\n" +
            "}";
    private static final String EXPECTED8 = "[\n" +
            "  [\"18:00\", \"20:00\"]\n" +
            "]";
    private static final String TEST_CASE9 = "{\n" +
            "  \"calendar1\": [],\n" +
            "  \"calendar2\": [],\n" +
            "  \"dailyBounds1\": [\"9:30\", \"20:00\"],\n" +
            "  \"dailyBounds2\": [\"9:00\", \"16:30\"],\n" +
            "  \"meetingDuration\": 60\n" +
            "}";
    private static final String EXPECTED9 = "[\n" +
            "  [\"9:30\", \"16:30\"]\n" +
            "]";
    private static final String TEST_CASE10 = "{\n" +
            "  \"calendar1\": [],\n" +
            "  \"calendar2\": [],\n" +
            "  \"dailyBounds1\": [\"9:00\", \"16:30\"],\n" +
            "  \"dailyBounds2\": [\"9:30\", \"20:00\"],\n" +
            "  \"meetingDuration\": 60\n" +
            "}";
    private static final String EXPECTED10 = "[\n" +
            "  [\"9:30\", \"16:30\"]\n" +
            "]";
    private static final String TEST_CASE11 = "{\n" +
            "  \"calendar1\": [],\n" +
            "  \"calendar2\": [],\n" +
            "  \"dailyBounds1\": [\"9:30\", \"16:30\"],\n" +
            "  \"dailyBounds2\": [\"9:30\", \"16:30\"],\n" +
            "  \"meetingDuration\": 60\n" +
            "}";
    private static final String EXPECTED11 = "[\n" +
            "  [\"9:30\", \"16:30\"]\n" +
            "]";
    private static final String TEST_CASE12 = "{\n" +
            "  \"calendar1\": [\n" +
            "    [\"7:00\", \"7:45\"],\n" +
            "    [\"8:15\", \"8:30\"],\n" +
            "    [\"9:00\", \"10:30\"],\n" +
            "    [\"12:00\", \"14:00\"],\n" +
            "    [\"14:00\", \"15:00\"],\n" +
            "    [\"15:15\", \"15:30\"],\n" +
            "    [\"16:30\", \"18:30\"],\n" +
            "    [\"20:00\", \"21:00\"]\n" +
            "  ],\n" +
            "  \"calendar2\": [\n" +
            "    [\"9:00\", \"10:00\"],\n" +
            "    [\"11:15\", \"11:30\"],\n" +
            "    [\"11:45\", \"17:00\"],\n" +
            "    [\"17:30\", \"19:00\"],\n" +
            "    [\"20:00\", \"22:15\"]\n" +
            "  ],\n" +
            "  \"dailyBounds1\": [\"6:30\", \"22:00\"],\n" +
            "  \"dailyBounds2\": [\"8:00\", \"22:30\"],\n" +
            "  \"meetingDuration\": 30\n" +
            "}";
    private static final String EXPECTED12 = "[\n" +
            "  [\"8:30\", \"9:00\"],\n" +
            "  [\"10:30\", \"11:15\"],\n" +
            "  [\"19:00\", \"20:00\"]\n" +
            "]";

    @ParameterizedTest
    @MethodSource("params")
    void testCases(List<CalendarMatching.StringMeeting> calendar1,
                   CalendarMatching.StringMeeting dailyBounds1,
                   List<CalendarMatching.StringMeeting> calendar2,
                   CalendarMatching.StringMeeting dailyBounds2,
                   int meetingDuration,
                   List<CalendarMatching.StringMeeting> expected) {
        implTestCases(new CalendarMatching.Solution1(), calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration, expected);
    }

    private void implTestCases(CalendarMatching impl,
                               List<CalendarMatching.StringMeeting> calendar1,
                               CalendarMatching.StringMeeting dailyBounds1,
                               List<CalendarMatching.StringMeeting> calendar2,
                               CalendarMatching.StringMeeting dailyBounds2,
                               int meetingDuration,
                               List<CalendarMatching.StringMeeting> expected) {
        List<CalendarMatching.StringMeeting> result = impl.calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    static List<Arguments> params() {
        return List.of(
//                parseArguments(TEST_CASE1, EXPECTED1),
//                parseArguments(TEST_CASE2, EXPECTED2),
//                parseArguments(TEST_CASE3, EXPECTED3),
//                parseArguments(TEST_CASE4, EXPECTED4),
//                parseArguments(TEST_CASE5, EXPECTED5),
//                parseArguments(TEST_CASE6, EXPECTED6),
                parseArguments(TEST_CASE7, EXPECTED7),
                parseArguments(TEST_CASE8, EXPECTED8),
                parseArguments(TEST_CASE9, EXPECTED9),
                parseArguments(TEST_CASE10, EXPECTED10),
                parseArguments(TEST_CASE11, EXPECTED11),
                parseArguments(TEST_CASE12, EXPECTED12)
        );
    }

    static Arguments parseArguments(String testCaseJson, String expectedJson) {
        JsonObject object = new Gson().fromJson(testCaseJson, JsonElement.class).getAsJsonObject();
        List<CalendarMatching.StringMeeting> calendar1 = parseCalendar(object.getAsJsonArray("calendar1"));
        List<CalendarMatching.StringMeeting> calendar2 = parseCalendar(object.getAsJsonArray("calendar2"));
        CalendarMatching.StringMeeting dailyBounds1 = parseMeeting(object.getAsJsonArray("dailyBounds1"));
        CalendarMatching.StringMeeting dailyBounds2 = parseMeeting(object.getAsJsonArray("dailyBounds2"));
        int meetingDuration = object.get("meetingDuration").getAsInt();
        List<CalendarMatching.StringMeeting> expected = parseCalendar(
                new Gson().fromJson(expectedJson, JsonElement.class).getAsJsonArray()
        );
        return Arguments.of(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration, expected);
    }

    static List<CalendarMatching.StringMeeting> parseCalendar(JsonArray jsonArray) {
        List<CalendarMatching.StringMeeting> result = new ArrayList<>();
        for (JsonElement element : jsonArray) {
            result.add(parseMeeting(element.getAsJsonArray()));
        }
        return result;
    }

    static CalendarMatching.StringMeeting parseMeeting(JsonArray jsonArray) {
        String start = jsonArray.get(0).getAsString();
        String end = jsonArray.get(1).getAsString();
        return new CalendarMatching.StringMeeting(start, end);
    }
}
