package com.algo.expert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public interface MergeOverlappingIntervals {

    int[][] mergeOverlappingIntervals(int[][] intervals);

    class Solution1 implements MergeOverlappingIntervals {

        @Override
        public int[][] mergeOverlappingIntervals(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
            int start = intervals[0][0];
            int end = intervals[0][1];

            List<int[]> merged = new ArrayList<>();
            for (int[] interval : intervals) {
                if (interval[0] > end) {
                    merged.add(new int[] {start, end});
                    start = interval[0];
                }
                end = Math.max(end, interval[1]);
            }
            merged.add(new int[] {start, end});
            return merged.toArray(new int[][] {});
        }
    }
}
