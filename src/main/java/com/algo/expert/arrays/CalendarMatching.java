package com.algo.expert.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface CalendarMatching {

    List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration);

    class StringMeeting {
        public final String start;
        public final String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StringMeeting that = (StringMeeting) o;
            return Objects.equals(start, that.start) && Objects.equals(end, that.end);
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public String toString() {
            return "StringMeeting{" +
                    "start='" + start + '\'' +
                    ", end='" + end + '\'' +
                    '}';
        }
    }

    class Solution1 implements CalendarMatching {

        private static final Pattern time = Pattern.compile("^(\\d+):(\\d+)$");

        @Override
        public List<StringMeeting> calendarMatching(
                List<StringMeeting> calendar1,
                StringMeeting dailyBounds1,
                List<StringMeeting> calendar2,
                StringMeeting dailyBounds2,
                int meetingDuration) {
            // Write your code here.

            List<StringMeeting> bothBusyCalendar = new ArrayList<>();
            int index1 = 0;
            int index2 = 0;
            while (index1 < calendar1.size() || index2 < calendar2.size()) {
                if (index1 == calendar1.size()) {
                    bothBusyCalendar.add(calendar2.get(index2));
                    index2++;
                    continue;
                }
                StringMeeting meeting1 = calendar1.get(index1);
                if (index2 == calendar2.size()) {
                    bothBusyCalendar.add(calendar1.get(index1));
                    index1++;
                    continue;
                }
                StringMeeting meeting2 = calendar2.get(index2);
                if (timeDifference(meeting1.end, meeting2.start) < 0) {
                    bothBusyCalendar.add(meeting1);
                    index1++;
                    continue;
                }
                if (timeDifference(meeting2.end, meeting1.start) < 0) {
                    bothBusyCalendar.add(calendar2.get(index2));
                    index2++;
                    continue;
                }
                String start = timeDifference(meeting1.start, meeting2.start) < 0
                        ? meeting1.start : meeting2.start;
                String end = timeDifference(meeting1.end, meeting2.end) > 0
                        ? meeting1.end : meeting2.end;
                bothBusyCalendar.add(new StringMeeting(start, end));
                index1++;
                index2++;
            }

            List<StringMeeting> result = new ArrayList<>();
            String start = timeDifference(dailyBounds1.start, dailyBounds2.start) > 0
                    ? dailyBounds1.start : dailyBounds2.start;
            for (StringMeeting meeting : bothBusyCalendar) {
                if (timeDifference(meeting.start, start) >= meetingDuration) {
                    result.add(new StringMeeting(start, meeting.start));
                }
                start = meeting.end;
            }
            String end = timeDifference(dailyBounds1.end, dailyBounds2.end) < 0
                    ? dailyBounds1.end : dailyBounds2.end;
            if (timeDifference(end, start) >= meetingDuration) {
                result.add(new StringMeeting(start, end));
            }
            return result;
        }

        private int timeDifference(String time1, String time2) {
            Matcher matcher1 = time.matcher(time1);
            Matcher matcher2 = time.matcher(time2);
            if (!matcher1.find() || !matcher2.find()) {
                throw new IllegalArgumentException("Invalid time");
            }
            int minutes1 = Integer.parseInt(matcher1.group(1)) * 60 + Integer.parseInt(matcher1.group(2));
            int minutes2 = Integer.parseInt(matcher2.group(1)) * 60 + Integer.parseInt(matcher2.group(2));
            return minutes1 - minutes2;
        }
    }
}
