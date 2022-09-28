package com.algo.expert.arrays;

public interface SubarraySort {

    int[] subarraySort(int[] array);

    class Solution1 implements SubarraySort {
        @Override
        public int[] subarraySort(int[] array) {
            int max = Integer.MIN_VALUE;
            int unsortedStart = -1;
            int unsortedEnd = -1;

            for (int i = 0; i < array.length; i++) {
                if (array[i] < max) {
                    unsortedEnd = i;
                    unsortedStart = unsortedStart == -1
                            ? binarySearch(array, 0, i - 1, array[i])
                            : binarySearch(array, 0, unsortedStart, array[i]);
                } else {
                    max = array[i];
                }
            }

            return new int[] {unsortedStart, unsortedEnd};
        }

        private int binarySearch(int[] array, int start, int end, int value) {
            if (start >= end) return start;
            if (start == end - 1) {
                return value < array[start] ? start : end;
            }
            int middle = (start + end) / 2;
            if (value < array[middle]) return binarySearch(array, start, middle, value);
            return binarySearch(array, middle, end, value);
        }
    }
}
