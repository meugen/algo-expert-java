package com.algo.expert.arrays;

import java.util.*;
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
            BusyResult busyResult = new BusyResult(calendar1, calendar2);
            while (busyResult.hasNext()) {
                busyResult.next();
            }

            List<StringMeeting> result = new ArrayList<>();
            String start = timeDifference(dailyBounds1.start, dailyBounds2.start) > 0
                    ? dailyBounds1.start : dailyBounds2.start;
            for (StringMeeting meeting : busyResult.result) {
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

        private List<StringMeeting> mergeMeetings(StringMeeting meeting1, StringMeeting meeting2) {
            int startDifference = timeDifference(meeting1.start, meeting2.start);
            if (startDifference < 0 && timeDifference(meeting1.end, meeting2.start) < 0) {
                return Arrays.asList(meeting1, meeting2);
            }
            if (startDifference > 0 && timeDifference(meeting1.start, meeting2.end) > 0) {
                return Arrays.asList(meeting2, meeting1);
            }
            if (startDifference < 0) {
                return Collections.singletonList(new StringMeeting(meeting1.start, meeting2.end));
            }
            return Collections.singletonList(new StringMeeting(meeting2.start, meeting1.end));
        }
    }
}

class BusyResult {
    private static final Pattern TIME = Pattern.compile("^(\\d+):(\\d+)$");

    final List<CalendarMatching.StringMeeting> result;
    final Iterator<CalendarMatching.StringMeeting> iterator1;
    final Iterator<CalendarMatching.StringMeeting> iterator2;
    private CalendarMatching.StringMeeting meeting1;
    private CalendarMatching.StringMeeting meeting2;

    BusyResult(List<CalendarMatching.StringMeeting> calendar1, List<CalendarMatching.StringMeeting> calendar2) {
        this.result = new ArrayList<>();
        this.iterator1 = calendar1.iterator();
        this.iterator2 = calendar2.iterator();

        meeting1 = iterator1.hasNext() ? iterator1.next() : null;
        meeting2 = iterator2.hasNext() ? iterator2.next() : null;
    }

    boolean hasNext() {
        return meeting1 != null || meeting2 != null;
    }

    void next() {
        if (meeting1 == null) {
            result.add(meeting2);
            meeting2 = iterator2.hasNext() ? iterator2.next() : null;
            return;
        }
        if (meeting2 == null) {
            result.add(meeting1);
            meeting1 = iterator1.hasNext() ? iterator1.next() : null;
            return;
        }

        int startDifference = timeDifference(meeting1.start, meeting2.start);
        if (startDifference < 0 && timeDifference(meeting1.end, meeting2.start) < 0) {
            result.add(meeting1);
            this.meeting1 = iterator1.hasNext() ? iterator1.next() : null;
            return;
        }
        if (startDifference > 0 && timeDifference(meeting1.start, meeting2.end) > 0) {
            result.add(meeting2);
            this.meeting2 = iterator2.hasNext() ? iterator2.next() : null;
            return;
        }
        if (startDifference < 0) {
            this.meeting2 = new CalendarMatching.StringMeeting(meeting1.start,
                    timeDifference(meeting2.end, meeting1.end) > 0 ? meeting2.end : meeting1.end
            );
            this.meeting1 = iterator1.hasNext() ? iterator1.next() : null;
            return;
        }
        this.meeting1 = new CalendarMatching.StringMeeting(meeting2.start,
                timeDifference(meeting2.end, meeting1.end) > 0 ? meeting2.end : meeting1.end
        );
        this.meeting2 = iterator2.hasNext() ? iterator2.next() : null;
    }

    private int timeDifference(String time1, String time2) {
        Matcher matcher1 = TIME.matcher(time1);
        Matcher matcher2 = TIME.matcher(time2);
        if (!matcher1.find() || !matcher2.find()) {
            throw new IllegalArgumentException("Invalid time");
        }
        int minutes1 = Integer.parseInt(matcher1.group(1)) * 60 + Integer.parseInt(matcher1.group(2));
        int minutes2 = Integer.parseInt(matcher2.group(1)) * 60 + Integer.parseInt(matcher2.group(2));
        return minutes1 - minutes2;
    }
}
