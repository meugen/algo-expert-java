package com.algo.expert.arrays;

import java.util.*;

public interface LargestRange {

    int[] largestRange(int[] array);

    class Solution1 implements LargestRange {

        @Override
        public int[] largestRange(int[] array) {
            // Write your code here.
            Arrays.sort(array);

            int[] result = null;
            int start = array[0];
            int end = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] > array[i - 1] + 1) {
                    if (result == null || end - start >= result[1] - result[0]) {
                        result = new int[] {start, end};
                    }
                    start = array[i];
                }
                end = array[i];
            }
            if (result == null || end - start >= result[1] - result[0]) {
                result = new int[] {start, end};
            }
            return result;
        }
    }

    class Solution2 implements LargestRange {

        @Override
        public int[] largestRange(int[] array) {
            Map<Integer, Boolean> map = new HashMap<>();

            for (int item : array) {
                map.put(item, false);
            }
            int[] result = null;
            for (int item : array) {
                if (map.get(item)) continue;
                map.put(item, true);
                int start = item;
                while (map.containsKey(start - 1)) {
                    start = start - 1;
                    map.put(start, true);
                }
                int end = item;
                while (map.containsKey(end + 1)) {
                    end = end + 1;
                    map.put(end, true);
                }
                if (result == null || end - start > result[1] - result[0]) {
                    result = new int[] {start, end};
                }
            }
            return result;
        }
    }

    class Solution3 implements LargestRange {

        @Override
        public int[] largestRange(int[] array) {
            SortedSet<Integer> set = new TreeSet<>();
            for (int item : array) {
                set.add(item);
            }

            Iterator<Integer> iterator = set.iterator();
            int[] result = null;
            int begin = iterator.next();
            int end = begin;
            while (iterator.hasNext()) {
                int current = iterator.next();
                if (current > end + 1) {
                    if (result == null || end - begin > result[1] - result[0]) {
                        result = new int[] {begin, end};
                    }
                    begin = current;
                }
                end = current;
            }
            if (result == null || end - begin > result[1] - result[0]) {
                result = new int[] {begin, end};
            }

            return result;
        }
    }
}
